
#[derive(Copy, Clone, Default, Debug)]
pub struct Coordinates {
    x: u64,
    y: u64,
    z: u64
}

impl Coordinates {
    pub fn new(x: u64, y: u64, z: u64) -> Coordinates {
        Coordinates {
            x: x,
            y: y,
            z: z,
        }
    }

    pub fn new_2d(x: u64, z: u64) -> Coordinates {
        Coordinates {
            x: x,
            y: 0,
            z: z,
        }
    }
}


impl From<::config::Coordinates> for Coordinates {
    fn from(coord: ::config::Coordinates) -> Self {
        match coord {
            ::config::Coordinates::Simple(x, z) => Coordinates::new_2d(x, z),
            ::config::Coordinates::Complete(x, y, z) => Coordinates::new(x, y, z),
        }
    }
}
