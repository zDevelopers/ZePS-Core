package me.cassayre.florian.netherrail;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;

import java.awt.Color;
import java.util.*;

public class NetworkAreas
{
    private final static List<Area> areas = new ArrayList<>();

    static
    {
        registerX(-714, new Color(255, 236, 39));
        registerX(-529, new Color(255, 189, 206));
        registerX(-341, new Color(94, 116, 255));
        registerX(-234, new Color(110, 244, 5));
        registerX(30, new Color(165, 178, 255));
        registerX(540, new Color(64, 168, 186));

        registerY(539, new Color(110, 176, 86));
        registerY(47, new Color(221, 72, 70));
        registerY(-301, new Color(0, 0, 0));
        registerY(-702, new Color(255, 170, 20));
        registerY(-1069, new Color(119, 98, 40));
        registerY(-1436, new Color(255, 122, 238));
    }

    public static void registerX(int coordinate, Color color)
    {
        register(Area.Orientation.VERTICAL, coordinate, color);
    }

    public static void registerY(int coordinate, Color color)
    {
        register(Area.Orientation.HORIZONTAL, coordinate, color);
    }

    private static void register(Area.Orientation orientation, int coordinate, Color color)
    {
        if(orientation == null)
            throw new IllegalArgumentException("Orientation cannot be null.");

        if(color == null)
            throw new IllegalArgumentException("Color cannot be null.");

        areas.add(new Area(orientation, coordinate, color));
    }

    public static List<Area> getAreas(Area.Orientation orientation)
    {
        List<Area> list = new ArrayList<>();

        for(Area area : areas)
        {
            if(area.ORIENTATION == orientation)
                list.add(area);
        }

        return list;
    }

    public static JsonObject toJson()
    {
        JsonObject object = new JsonObject();

        JsonArray arrayX = new JsonArray();
        JsonArray arrayY = new JsonArray();

        for(Area area : areas)
        {
            JsonObject areaObject = new JsonObject();

            areaObject.add("coordinate", new JsonPrimitive(area.COORDINATE));

            areaObject.add("color", colorToJson(area.COLOR));

            if(area.ORIENTATION == Area.Orientation.VERTICAL)
                arrayX.add(areaObject);
            else if(area.ORIENTATION == Area.Orientation.HORIZONTAL)
                arrayY.add(areaObject);
        }

        object.add("northsouth", arrayX);

        object.add("eastwest", arrayY);

        return object;
    }

    public static JsonObject colorToJson(Color color)
    {
        JsonObject object = new JsonObject();

        object.add("red", new JsonPrimitive(color.getRed()));
        object.add("green", new JsonPrimitive(color.getGreen()));
        object.add("blue", new JsonPrimitive(color.getBlue()));

        return object;
    }
}

class Area
{
    public final Orientation ORIENTATION;
    public final int COORDINATE;
    public final Color COLOR;

    public Area(Orientation orientation, int coordinate, Color color)
    {
        ORIENTATION = orientation;
        COORDINATE = coordinate;
        COLOR = color;
    }

    static enum Orientation
    {
        VERTICAL,
        HORIZONTAL;
    }
}
