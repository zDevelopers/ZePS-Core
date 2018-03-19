
#[derive(Debug, Fail)]
pub enum InvalidConfigurationError {
    #[fail(display = "Network '{}' does not exist", name)]
    NetworkNotFound { name: String },

    #[fail(display= "Station '{}' does not exist", name)]
    StationNotFound { name: String },

    #[fail(display= "Path type '{}' is not recognized", name)]
    InvalidPathType { name: String }
}
