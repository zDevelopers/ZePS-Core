extern crate zeps;

const EXAMPLE_CONFIG: &[u8] = include_bytes!("fixtures/example.json");

#[test]
fn it_loads() {
    let _ = zeps::config::read_universe(EXAMPLE_CONFIG).unwrap();
}
