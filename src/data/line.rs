use data::coordinates::Coordinates;
use data::station::Station;
use std::rc::Rc;

#[derive(Debug, Copy, Clone)]
pub enum PathType {
    Rail,
    Walk
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
}