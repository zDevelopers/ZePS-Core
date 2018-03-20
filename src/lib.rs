extern crate serde;
extern crate serde_json;
extern crate failure;

#[macro_use] extern crate serde_derive;
#[macro_use] extern crate failure_derive;

pub mod config;
pub mod data;

pub use data::Universe;

use std::fs::File;
use std::io::Read;
use std::path::Path;

use failure::Error;
use failure::ResultExt;

pub fn read_universe<R: Read>(reader: R) -> Result<Universe, Error> {
    Ok(Universe::from_config(config::read_universe(reader)?)?)
}

pub fn read_universe_from_file<P: AsRef<Path>>(path: P) -> Result<Universe, Error> {
    let file = File::open(&path).with_context(|_| format!("Unable to open universe data file '{}'", path.as_ref().to_string_lossy()))?;
    Ok(read_universe(file).with_context(|_| format!("Unable to load universe data file '{}'", path.as_ref().to_string_lossy()))?)
}
