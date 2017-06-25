use data::station::Station;

use std::collections::HashMap;

pub struct Network {
    minecraft_world_name: String,
    display_name: String,
    coordinates_factor: f64,

    stations: HashMap<String, Station>,
}

impl From<::config::Network> for Network {
    fn from(network: ::config::Network) -> Network {
        let stations = network.stations.into_iter().map(|(k,v)| (k, v.into())).collect();
        Network {
            minecraft_world_name: network.world,
            display_name: network.name,
            stations: stations,

            coordinates_factor: network.coordinates_factor
                .or(network.is_nether.map(|is_nether| if is_nether { 0.125 } else { 1.0 }))
                .unwrap_or(1.0)
        }
    }
}
