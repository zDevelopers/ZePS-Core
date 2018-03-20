use std::collections::HashMap;
use std::io::Read;

use failure::Error;
use failure::ResultExt;

use serde_json;

#[derive(Serialize, Deserialize, Debug, Clone)]
#[serde(untagged)]
pub enum Coordinates {
    Simple(i64,i64),
    Complete(i64,i64,i64),
}

#[derive(Serialize, Deserialize, Debug)]
#[serde(untagged)]
pub enum LinePoint {
    Simple(String),
    WithMetadata {
        station: String,
        path_type: Option<String>,
        path_secure: Option<bool>,
        path_to_next: Option<Vec<Coordinates>>,
    }
}

#[derive(Serialize, Deserialize, Debug)]
pub struct Line {
    pub name: String,
    pub color: String,
    pub path: Vec<LinePoint>,
}

#[derive(Serialize, Deserialize, Debug)]
pub struct Station {
    pub name: String,
    pub sub_name: String,
    pub description: String,
    pub coordinates: Coordinates,
    pub real_coordinates: Option<Coordinates>,

    pub is_main: bool,
    pub has_fast_access: bool,
    pub fast_access_time: f64,
    pub is_hidden: Option<bool>,
}

#[derive(Serialize, Deserialize, Debug)]
pub struct Network {
    pub name: String,
    pub world: String,
    pub is_nether: Option<bool>,
    pub coordinates_factor: Option<f64>,
    pub stations: HashMap<String, Station>,
    pub lines: Vec<Line>,
}

#[derive(Serialize, Deserialize, Debug)]
pub struct NetworkConnection {
    pub networks: (String, String),
    pub autoconnect_by_name: Option<bool>,
    pub autoconnect_by_proximity: Option<u64>,
    pub connections: Option<Vec<(String,String)>>,
}

#[derive(Serialize, Deserialize, Debug)]
pub struct Universe {
    pub name: String,
    pub networks: HashMap<String, Network>,
    pub networks_connections: Vec<NetworkConnection>,
}

pub fn read_universe<R: Read>(reader: R) -> Result<Universe, Error> {
    Ok(serde_json::from_reader(reader).context("Unable to parse universe data")?)
}
