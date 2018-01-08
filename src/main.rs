extern crate zeps;

use zeps::data::world::World;

fn main() {
    let u: World = zeps::config::read_world_from_file("./tests/fixtures/example.json").unwrap().into();
    //println!("World: {:#?}", u);
    let s: Vec<_> = u.stations().collect();
    println!("Stations: {:#?}", s);
}
