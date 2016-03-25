package me.cassayre.florian.netherrail;

/**
 * This exception should be thrown when no valid path has been found.
 */
public class PathImpossibleException extends Exception
{
    public PathImpossibleException()
    {
        super();
    }

    public PathImpossibleException(String ex)
    {
        super(ex);
    }

    public PathImpossibleException(String ex, Throwable throwable)
    {
        super(ex, throwable);
    }
}
