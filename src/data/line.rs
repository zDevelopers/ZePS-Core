use data::coordinates::Coordinates;
use data::error::InvalidConfigurationError;
use data::station::Station;

use std::rc::Rc;
use std::collections::HashMap;

#[derive(Debug, Copy, Clone)]
pub enum PathType {
    Rail,
    Walk
}

impl PathType {
    fn from_config(path_type: Option<String>) -> Result<PathType, InvalidConfigurationError> {
        Ok(match path_type.as_ref().map(|s| &s[..]) {
            Some("rail") => PathType::Rail,
            Some("walk") => PathType::Walk,
            Some(other) => Err(InvalidConfigurationError::InvalidPathType { name: other.to_string() })?,
            None => PathType::Rail
        })
    }
}

#[derive(Debug, Clone)]
pub struct LinePoint {
    station: Rc<Station>,
    path_type: PathType,
    path_secure: bool,
    path_to_next: Vec<Coordinates>,
}

impl LinePoint {
    pub fn station(&self) -> &Station {
        &self.station
    }

    pub fn path_type(&self) -> PathType {
        self.path_type
    }

    pub fn path_secure(&self) -> bool {
        self.path_secure
    }

    pub fn path_to_next(&self) -> &[Coordinates] {
        &self.path_to_next
    }

    pub fn from_config(line_point: ::config::LinePoint, stations: &HashMap<String, Rc<Station>>) -> Result<LinePoint, InvalidConfigurationError> {
        Ok(match line_point {
            ::config::LinePoint::Simple(station) => LinePoint {
                station: stations.get(&station).cloned().ok_or(InvalidConfigurationError::StationNotFound { name: station })?,
                path_type: PathType::Rail,
                path_secure: true,
                path_to_next: Vec::new(),
            },
            ::config::LinePoint::WithMetadata { station, path_type, path_secure, path_to_next } => LinePoint {
                station: stations.get(&station).cloned().ok_or(InvalidConfigurationError::StationNotFound { name: station })?,
                path_type: PathType::from_config(path_type)?,
                path_secure: path_secure.unwrap_or(true),
                path_to_next: match path_to_next {
                    Some(vec_coordinates) => vec_coordinates.into_iter().map(|c| c.into()).collect(),
                    None => Vec::new()
                }
            }
        })
    }
}

#[derive(Debug, Clone)]
pub struct Line {
    name: String,
    color: String,
    path: Vec<LinePoint>,
}

impl Line {
    pub fn name(&self) -> &str {
        &self.name
    }

    pub fn color(&self) -> &str {
        &self.color
    }

    pub fn path(&self) -> &[LinePoint] {
        &self.path
    }

    pub fn from_config(line: ::config::Line, stations: &HashMap<String, Rc<Station>>) -> Result<Line, InvalidConfigurationError> {
        let path = line.path.into_iter().map(|p| LinePoint::from_config(p, stations)).collect::<Result<_,_>>()?;

        Ok(Line {
            name: line.name,
            color: line.color,
            path
        })
    }
}
