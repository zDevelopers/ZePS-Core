
#[derive(Debug, Fail)]
pub enum InvalidConfigurationError {
    #[fail(display = "Network '{}' does not exist", name)]
    NetworkNotFound { name: String }
}
