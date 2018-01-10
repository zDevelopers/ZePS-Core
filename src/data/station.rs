use data::coordinates::Coordinates;

#[derive(Debug)]
pub struct Station {
    name: String,
    subname: String,
    description: String,
    coordinates: Coordinates,
    real_coordinates: Coordinates,
    is_main: bool,
    has_fast_access: bool,
    fast_access_time: f64,
    is_hidden: bool,
}

impl From<::config::Station> for Station {
    fn from(station: ::config::Station) -> Station {
        Station {
            name: station.name,
            subname: station.subname,
            description: station.description,
            coordinates: station.coordinates.clone().into(),
            real_coordinates: station.real_coordinates.unwrap_or(station.coordinates).into(),
            is_main: station.is_main,
            has_fast_access: station.has_fast_access,
            fast_access_time: station.fast_access_time,
            is_hidden: station.is_hidden.unwrap_or(false)
        }
    }
}
