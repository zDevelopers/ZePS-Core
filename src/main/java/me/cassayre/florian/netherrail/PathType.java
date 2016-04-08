package me.cassayre.florian.netherrail;

/**
 * Represents a path type between two stations.
 */
public enum PathType
{
    OFFICIAL_RAIL,
    OFFICIAL_WALKING,
    UNOFFICIAL_RAIL,
    UNOFFICIAL_WALKING;

    public boolean isRail()
    {
        return this == OFFICIAL_RAIL || this == UNOFFICIAL_RAIL;
    }

    public boolean isOfficial()
    {
        return this == OFFICIAL_RAIL || this == OFFICIAL_WALKING;
    }
}