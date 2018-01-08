use data::network::Network;

use std::collections::HashMap;
use std::collections::hash_map::Values;
use std::iter::FlatMap;
use data::station::Station;

pub struct World {
    display_name: String,
    networks: HashMap<String, Network>,
    network_connections: HashMap<String, Network>,
}

impl World {
    pub fn stations(&self) -> Stations {
        Stations {
            iter: self.networks.values(),
            inner_iter: None,
        }
    }
}

pub struct Stations<'a> {
    iter: Values<'a, String, Network>,
    inner_iter: Option<::data::network::Stations<'a>>,
}

impl<'a> Iterator for Stations<'a> {
    type Item = &'a Station;

    fn next(&mut self) -> Option<Self::Item> {
        loop {
            if let Some(ref mut inner) = self.inner_iter {
                if let Some(x) = inner.by_ref().next() {
                    return Some(x)
                }
            }
            match self.iter.next().map(Network::stations) {
                None => return None,
                next => self.inner_iter = next,
            }
        }
    }
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

