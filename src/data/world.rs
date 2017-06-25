use data::network::Network;

use std::collections::HashMap;

pub struct World {
    display_name: String,
    networks: HashMap<String, Network>,
    network_connections: HashMap<String, Network>,
}

impl From<::config::World> for World {
    fn from(world: ::config::World) -> World {
        World {
            display_name: world.name,
            networks: world.networks.into_iter().map(|(k,v)| (k, v.into())).collect(),
            network_connections: HashMap::new(),
        }
    }
}

