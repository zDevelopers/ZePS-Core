use data::station::Station;
use data::line::Line;
use data::error::InvalidConfigurationError;

use std::collections::HashMap;
use std::collections::hash_map::Values;
use std::rc::Rc;

#[derive(Debug)]
pub struct Network {
    minecraft_world_name: String,
    display_name: String,
    coordinates_factor: f64,

    stations: HashMap<String, Rc<Station>>,

    lines: Vec<Line>
}

impl Network {
    pub fn stations(&self) -> Stations {
        Stations { iter: self.stations.values() }
    }

    pub fn display_name(&self) -> &str {
        &self.display_name
    }

    pub fn world_name(&self) -> &str {
        &self.minecraft_world_name
    }

    pub fn coordinates_factor(&self) -> f64 {
        self.coordinates_factor
    }

    pub fn from_config(network: ::config::Network) -> Result<Network, InvalidConfigurationError> {
        let stations = network.stations.into_iter().map(|(k, v)| (k, Rc::new(v.into()))).collect();
        let lines = network.lines.into_iter().map(|l| Line::from_config(l, &stations)).collect::<Result<_,_>>()?;

        Ok(Network {
            minecraft_world_name: network.world,
            display_name: network.name,

            stations,
            lines,

            coordinates_factor: network.coordinates_factor
                .or(network.is_nether.map(|is_nether| if is_nether { 0.125 } else { 1.0 }))
                .unwrap_or(1.0)
        })
    }
}

pub struct Stations<'a> {
    iter: Values<'a, String, Rc<Station>>
}

impl<'a> Iterator for Stations<'a> {
    type Item = &'a Rc<Station>;

    fn next(&mut self) -> Option<Self::Item> {
        self.iter.next()
    }
}
