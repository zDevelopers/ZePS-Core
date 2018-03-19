package me.cassayre.florian.netherrail;

/**
 * Represents a cardinal direction.
 */
public enum Direction
{
    NORTH(0, "Nord"),
    EAST(1, "Est"),
    SOUTH(2, "Sud"),
    WEST(3, "Ouest");

    private final int INDEX;
    private final String NAME;

    private Direction(final int index, final String name)
    {
        INDEX = index;
        NAME = name;
    }

    /**
     * Get the opposite side of this direction.
     * @return the opposite direction
     */
    public Direction opposite()
    {
        if(this == NORTH)
            return SOUTH;
        if(this == EAST)
            return WEST;
        if(this == SOUTH)
            return NORTH;
        if(this == WEST)
            return EAST;

        throw new IllegalStateException("No opposite found!");
    }

    /**
     * Get the index of this direction.
     * @return the index
     */
    public int getIndex()
    {
        return INDEX;
    }

    /**
     * Get the french name for this direction, begining with a capital.
     * @return the name of the direction
     */
    @Override
    public String toString()
    {
        return NAME;
    }
}
