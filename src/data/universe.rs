use std::collections::HashMap;
use std::collections::hash_map::Values;
use std::rc::Rc;

use data::station::Station;
use data::network::Network;
use data::network_connection::NetworkConnection;
use data::error::InvalidConfigurationError;

pub struct Universe {
    display_name: String,
    networks: HashMap<String, Rc<Network>>,
    network_connections: Vec<NetworkConnection>,
}

impl Universe {
    pub fn stations(&self) -> Stations {
        Stations {
            iter: self.networks.values(),
            inner_iter: None,
        }
    }

    pub fn display_name(&self) -> &str {
        &self.display_name
    }

    pub fn get_network(&self, connection_name: &str) -> Option<&Network> {
        self.networks.get(connection_name).map(|x| x.as_ref())
    }

    pub fn get_network_handle(&self, connection_name: &str) -> Option<Rc<Network>> {
        self.networks.get(connection_name).cloned()
    }

    pub fn get_connections(&self) -> &[NetworkConnection] {
        &self.network_connections
    }

    pub fn from_config(universe: ::config::Universe) -> Result<Universe, InvalidConfigurationError> {
        let mut networks: HashMap<String, Rc<Network>> = HashMap::new();

        for network in universe.networks.into_iter().map(|(k, v)| (k, Network::from_config(v))) {
            match network.1 {
                Ok(n) => networks.insert(network.0, Rc::new(n)),
                Err(e) => return Err(e)
            };
        }

        let networks = networks;

        let network_connections = universe.networks_connections.into_iter()
            .map(|c| NetworkConnection::from_config(c, &networks)).collect::<Result<_,_>>()?;

        Ok(Universe {
            display_name: universe.name,
            networks,
            network_connections,
        })

    }
}

pub struct Stations<'a> {
    iter: Values<'a, String, Rc<Network>>,
    inner_iter: Option<::data::network::Stations<'a>>,
}

impl<'a> Iterator for Stations<'a> {
    type Item = &'a Rc<Station>;

    fn next(&mut self) -> Option<Self::Item> {
        loop {
            if let Some(ref mut inner) = self.inner_iter {
                if let Some(x) = inner.by_ref().next() {
                    return Some(x)
                }
            }
            match self.iter.next().map(|x| x.as_ref()).map(Network::stations) {
                None => return None,
                next => self.inner_iter = next,
            }
        }
    }
}
