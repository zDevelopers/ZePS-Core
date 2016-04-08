package me.cassayre.florian.netherrail;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;

import java.util.*;

public class PathFinder
{
    private final Station BEGIN, END;
    private final boolean LEGAL, ACCESSIBLE;

    private final Map<Station, Integer> weights = new HashMap<Station, Integer>();
    private final Map<Station, Station> before = new HashMap<Station, Station>();
    private final Set<Station> went = new HashSet<Station>();

    private final static double WALKING_SPEED = 1.35;
    private final static int DIRECTION_CHANGE_TIME = 15;
    private final static int INTERSECTION_TIME = 30;

    /**
     * Creates a new pathfinder object.
     * @param begin the station to begin at
     * @param end the station to go to
     * @param legal if official stations only should be used
     * @param accessible if safe stations only should be used
     */
    public PathFinder(Station begin, Station end, final boolean legal, final boolean accessible)
    {
        BEGIN = begin;
        END = end;

        LEGAL = legal;
        ACCESSIBLE = accessible;
    }

    /**
     * Finds the shorter path with the given parameters.
     * @return the path to follow
     * @throws PathImpossibleException if no path has been found
     */
    public JsonObject find() throws PathImpossibleException
    {
        long t1 = System.currentTimeMillis();

        weights.put(BEGIN, 0);

        for(Station minWeight = getMinWeight(); minWeight != END; minWeight = getMinWeight())
        {
            for(Direction direction : Direction.values())
            {
                if(minWeight == null)
                    throw new PathImpossibleException("Cannot find a valid path for " + BEGIN + " to " + END);

                Station sub = minWeight.getSubStation(direction);

                if(sub == null)
                    continue;

                if(went.contains(sub))
                    continue;


                if((weights.get(sub) == null || weights.get(minWeight) + minWeight.getDistanceFrom(sub) < weights.get(sub)) && (!LEGAL || minWeight.getPathType(sub) == PathType.OFFICIAL_RAIL) && (!ACCESSIBLE || !sub.isDangerous()))
                {

                    weights.put(sub, (int) (weights.get(minWeight) + minWeight.getDistanceFrom(sub)));
                    before.put(sub, minWeight);

                    if(minWeight.getPathType(sub) == PathType.UNOFFICIAL_WALKING)
                    {
                        weights.put(sub, (int) (weights.get(sub) * WALKING_SPEED));
                    }

                    Station ant = before.get(minWeight);
                    if(ant != null)
                    {
                        Direction dir1 = ant.getDirection(minWeight);
                        Direction dir2 = minWeight.getDirection(sub);

                        if(dir1 != dir2)
                            weights.put(sub, weights.get(sub) + DIRECTION_CHANGE_TIME);
                    }

                    if(sub.isIntersection())
                        weights.put(sub, weights.get(sub) + INTERSECTION_TIME);
                }

            }

            went.add(minWeight);
        }


        final List<Station> path = createPath();


        JsonObject object = new JsonObject();

        long t2 = System.currentTimeMillis();

        object.add("result", new JsonPrimitive("success"));

        object.add("time", new JsonPrimitive(t2 - t1));

        object.add("begin", new JsonPrimitive(BEGIN.name().toLowerCase()));

        object.add("end", new JsonPrimitive(END.name().toLowerCase()));

        object.add("travel_time", new JsonPrimitive((int) Math.ceil(weights.get(END) / 7)));


        JsonArray array = new JsonArray();

        // Old stuff
        int distance = 0;

        for(int i = 0; i < path.size(); i++)
        {
            boolean hasNext = i < path.size() - 1;

            JsonObject objectStation = buildStationObject(path.get(i), hasNext ? path.get(i + 1) : null);

            if(hasNext)
                distance += path.get(i).getDistanceFrom(path.get(i + 1));

            array.add(objectStation);
        }

        object.add("path", array);

        return object;
    }

    /**
     * Creates a json object representing this station and its path. The last station does not have any path.
     * @param station the station
     * @param next the next station
     * @return a json object
     */
    public JsonObject buildStationObject(Station station, Station next)
    {
        JsonObject object = new JsonObject();

        JsonObject objectStation = station.toJson(false);

        object.add("station", objectStation);

        if(next != null)
        {
            JsonObject objectNext = new JsonObject();

            int distanceToNext = (int) station.getDistanceFrom(next);
            Direction direction = station.getDirection(next);
            PathType type = station.getPathType(direction);

            // (old) distance += distanceToNext;

            objectNext.add("direction", new JsonPrimitive(direction.name().toLowerCase()));
            objectNext.add("length", new JsonPrimitive(distanceToNext));
            objectNext.add("type", new JsonPrimitive(type.name().toLowerCase()));

            object.add("connection", objectNext);
        }

        return object;
    }

    /**
     * Get the station with the lowest weight that has not been explored yet.
     * Can return <code>null</code> if no station was found.
     * @return the station with the lowest weight
     */
    public Station getMinWeight()
    {
        Station min = null;

        for(Station station : weights.keySet())
        {
            if(!went.contains(station) && (min == null || weights.get(station) < weights.get(min)))
            {
                min = station;
            }
        }

        return min;
    }

    /**
     * Creates a list representing the path to follow.
     * @return a list of stations
     */
    public List<Station> createPath()
    {
        List<Station> path = new ArrayList<Station>();

        Station current = END;

        path.add(current);

        while(current != BEGIN)
        {
            current = before.get(current);
            path.add(current);
        }

        Collections.reverse(path);

        return path;
    }
}
