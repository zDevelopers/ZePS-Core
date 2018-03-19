extern crate zeps;
extern crate failure;

use zeps::data::universe::Universe;
use failure::Error;

fn load_from_fixture(fixture: &str) -> Result<Universe, Error> {
    zeps::read_universe_from_file(format!("./tests/fixtures/{}.json", fixture))
}

#[test]
fn it_fails_from_nothing() {
    assert!(load_from_fixture("empty").is_err());
}

#[test]
fn it_loads_without_data() {
    let universe = load_from_fixture("no_data").unwrap();
    assert_eq!(universe.stations().into_iter().fold(0, |acc, _| acc + 1), 0);
}

#[test]
fn it_loads_with_data() {
    let _ = load_from_fixture("with_data").unwrap();
}

#[test]
fn stations_are_all_there() {
    let universe = load_from_fixture("with_data").unwrap();
    assert_eq!(universe.stations().into_iter().fold(0, |acc, _| acc + 1), 5);
    assert_eq!(universe.get_network("netherrail").unwrap().stations().into_iter().fold(0, |acc, _| acc + 1), 3);
    assert_eq!(universe.get_network("overworld").unwrap().stations().into_iter().fold(0, |acc, _| acc + 1), 2);
}


// TODO for the following reference tests: test if the correct error is returned too.

#[test]
fn it_fails_if_a_line_references_an_unknown_station() {
    assert!(load_from_fixture("lines_invalid_ref").is_err());
}

#[test]
fn it_fails_if_a_line_references_an_unknown_station_in_expanded_mode() {
    assert!(load_from_fixture("lines_invalid_ref_expanded").is_err());
}

#[test]
fn it_fails_if_a_connection_references_an_unknown_network() {
    assert!(load_from_fixture("connections_invalid_ref_network").is_err());
}

#[test]
fn it_fails_if_a_connection_references_an_unknown_station() {
    assert!(load_from_fixture("connections_invalid_ref_station").is_err());
}

#[test]
fn it_fails_if_a_connection_references_an_unknown_station_valid_in_the_other_network() {
    assert!(load_from_fixture("connections_invalid_ref_station_but_exists_in_other_network").is_err());
}


#[test]
fn the_coordinates_factor_defaults_to_one() {
    let universe = load_from_fixture("coordinates_factor_default").unwrap();
    let network = universe.get_network("netherrail").unwrap();
    assert_eq!(network.coordinates_factor(), 1.0);
}

#[test]
fn the_coordinates_factor_defaults_to_point_125_if_nether() {
    let universe = load_from_fixture("coordinates_factor_default_nether").unwrap();
    let network = universe.get_network("netherrail").unwrap();
    assert_eq!(network.coordinates_factor(), 0.125);
}

#[test]
fn the_coordinates_factor_overrides_is_nether_if_explicit() {
    let universe = load_from_fixture("coordinates_factor_overridden").unwrap();
    let network = universe.get_network("netherrail").unwrap();
    assert_eq!(network.coordinates_factor(), 1.84);
}
