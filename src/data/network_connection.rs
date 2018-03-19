use std::collections::HashMap;
use std::rc::Rc;

use data::network::Network;
use data::error::InvalidConfigurationError;

#[derive(Debug)]
pub struct NetworkConnection {
    network_1: Rc<Network>,
    network_2: Rc<Network>,
    autoconnect_by_name: bool,
    autoconnect_by_proximity: u64,
    connections: Vec<(String,String)>,
}

impl NetworkConnection {
    pub fn from_config(connection: ::config::NetworkConnection, networks_map: &HashMap<String, Rc<Network>>) -> Result<NetworkConnection, InvalidConfigurationError> {
        let network_1 = networks_map.get(&connection.networks.0).cloned()
            .ok_or(InvalidConfigurationError::NetworkNotFound {name: connection.networks.0})?;
        let network_2 = networks_map.get(&connection.networks.1).cloned()
            .ok_or(InvalidConfigurationError::NetworkNotFound {name: connection.networks.1})?;

        let mut connections: Vec<(String,String)> = Vec::new();

        if connection.connections.is_some() {
            for conn in connection.connections.unwrap() {
                // Checks if the references are valid
                network_1.station(&conn.0).ok_or(InvalidConfigurationError::StationNotFound { name: conn.0.clone() })?;
                network_2.station(&conn.1).ok_or(InvalidConfigurationError::StationNotFound { name: conn.1.clone() })?;

                connections.push((conn.0.clone(), conn.1.clone()));
            }
        }

        let connections = connections;

        Ok(NetworkConnection {
            network_1,
            network_2,

            autoconnect_by_name: connection.autoconnect_by_name.unwrap_or(false),
            autoconnect_by_proximity: connection.autoconnect_by_proximity.unwrap_or(0),

            connections
        })
    }
}
