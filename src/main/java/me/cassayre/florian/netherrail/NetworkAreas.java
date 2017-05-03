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
        registerX(new Color(255, 236, 39), -714);
        registerX(new Color(119, 98, 40), -570);
        registerX(new Color(255, 189, 206), -529);
        registerX(new Color(255, 122, 238), -485);
        registerX(new Color(221, 72, 70), -378, -286);
        registerX(new Color(94, 116, 255), -341);
        registerX(new Color(110, 244, 5), -414, -234);
        registerX(new Color(255, 116, 8), -251, -184);
        registerX(new Color(165, 178, 255), 30, 148, 259);
        registerX(new Color(255, 170, 20), 294);
        registerX(new Color(64, 168, 186), 540);

        registerY(new Color(110, 176, 86), 539);
        registerY(new Color(255, 116, 8), 254);
        registerY(new Color(221, 72, 70), 47);
        registerY(new Color(165, 178, 255), -84, -94, -120, -408);
        registerY(new Color(0, 0, 0), -260, -301, -342);
        registerY(new Color(255, 170, 20), -702);
        registerY(new Color(64, 168, 186), -780);
        registerY(new Color(255, 236, 39), -823);
        registerY(new Color(255, 189, 206), -853);
        registerY(new Color(119, 98, 40), -1069);
        registerY(new Color(94, 116, 255), -1208);
        registerY(new Color(255, 122, 238), -1436);
        registerY(new Color(110, 244, 5), -1740);
    }

    public static void registerX(Color color, int... coordinates)
    {
        register(Area.Orientation.VERTICAL, color, coordinates);
    }

    public static void registerY(Color color, int... coordinates)
    {
        register(Area.Orientation.HORIZONTAL, color, coordinates);
    }

    private static void register(Area.Orientation orientation, Color color, int... coordinates)
    {
        if(orientation == null)
            throw new IllegalArgumentException("Orientation cannot be null.");

        if(color == null)
            throw new IllegalArgumentException("Color cannot be null.");

        areas.add(new Area(orientation, color, coordinates));
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

            JsonArray array = new JsonArray();

            for(Integer value : area.COORDINATES)
                array.add(new JsonPrimitive(value));

            areaObject.add("coordinates", array);

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
    public final int[] COORDINATES;
    public final Color COLOR;

    public Area(Orientation orientation, Color color, int... coordinates)
    {
        ORIENTATION = orientation;
        COORDINATES = coordinates;
        COLOR = color;
    }

    enum Orientation
    {
        VERTICAL,
        HORIZONTAL
    }
}
