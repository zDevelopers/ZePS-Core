
#[derive(Copy, Clone, Default, Debug)]
pub struct Coordinates {
    x: i64,
    y: i64,
    z: i64
}

impl Coordinates {
    pub fn new(x: i64, y: i64, z: i64) -> Coordinates {
        Coordinates {
            x,
            y,
            z,
        }
    }

    pub fn new_2d(x: i64, z: i64) -> Coordinates {
        Coordinates {
            x,
            y: 0,
            z,
        }
    }

    pub fn x(&self) -> i64 {
        self.x
    }

    pub fn y(&self) -> i64 {
        self.y
    }

    pub fn z(&self) -> i64 {
        self.z
    }

    /// Calculates the distance between this point and another.
    ///
    /// # Example
    ///
    /// ```
    /// # use zeps::data::Coordinates;
    /// let c1 = Coordinates::new(0, 0, 0);
    /// let c2 = Coordinates::new(3, 4, 0);
    ///
    /// assert_eq!(c1.distance(&c2), 5.0);
    /// ```
    pub fn distance(&self, other: &Coordinates) -> f64 {
        let x = self.x - other.x;
        let y = self.y - other.y;
        let z = self.z - other.z;

        ((x * x + y * y + z * z) as f64).sqrt()
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
