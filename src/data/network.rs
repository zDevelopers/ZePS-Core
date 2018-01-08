use data::station::Station;

use std::collections::HashMap;
use std::collections::hash_map::Values;

pub struct Network {
    minecraft_world_name: String,
    display_name: String,
    coordinates_factor: f64,

    stations: HashMap<String, Station>,
}

impl Network {
    pub fn stations(&self) -> Stations {
        Stations { iter: self.stations.values() }
    }
}

pub struct Stations<'a> {
    iter: Values<'a, String, Station>
}

impl<'a> Iterator for Stations<'a> {
    type Item = &'a Station;

    fn next(&mut self) -> Option<Self::Item> {
        self.iter.next()
    }
}

impl From<::config::Network> for Network {
    fn from(network: ::config::Network) -> Network {
        let stations = network.stations.into_iter().map(|(k,v)| (k, v.into())).collect();
        Network {
            minecraft_world_name: network.world,
            display_name: network.name,
            stations,

            coordinates_factor: network.coordinates_factor
                .or(network.is_nether.map(|is_nether| if is_nether { 0.125 } else { 1.0 }))
                .unwrap_or(1.0)
        }
    }
}

