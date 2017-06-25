extern crate serde;
extern crate serde_json;

#[macro_use]
extern crate serde_derive;

mod config;
mod data;

fn main() {
    let u = config::read_world_from_file("../vessinque.json").unwrap();
    println!("World: {:#?}", u);
}
