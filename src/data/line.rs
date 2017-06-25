use data::coordinates::Coordinates;
use data::station::Station;
use std::rc::Rc;

pub enum PathType {
    Rail,
    Walk
}

pub struct LinePoint {
    station: Rc<Station>,
    path_type: PathType,
    path_secure: bool,
    path_to_next: Vec<Coordinates>,
}

pub struct Line {
    name: String,
    color: String,
    path: Vec<LinePoint>,
}

