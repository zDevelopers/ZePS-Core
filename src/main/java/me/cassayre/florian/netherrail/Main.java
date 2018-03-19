package me.cassayre.florian.netherrail;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;

public class Main
{

    public static void main(String[] args)
    {
        final JsonObject error = new JsonObject();

        error.addProperty("time", 0);
        error.addProperty("result", "failed");

        // TODO Something cleaner here.

        try
        {
            switch (args[0].toLowerCase())
            {
                case "pathfinder":
                    System.out.println(new PathFinder(Station.values()[Integer.parseInt(args[1])], Station.values()[Integer.parseInt(args[2])], args.length >= 4 ? Boolean.valueOf(args[3]) : true, args.length >= 5 ? Boolean.valueOf(args[4]) : true).find());
                    return;

                case "list":
                    boolean withNetwork = false;

                    if (args.length >= 2)
                    {
                        withNetwork = Boolean.parseBoolean(args[1]);
                    }

                    final JsonObject listRoot = new JsonObject();

                    listRoot.addProperty("result", "success");
                    listRoot.addProperty("time", 0);

                    listRoot.addProperty("withNetwork", withNetwork);

                    final JsonArray stations = new JsonArray();

                    for (Station station : Station.getStationsAlphabetically())
                    {
                        stations.add(station.toJson(withNetwork));
                    }

                    listRoot.add("stations", stations);

                    System.out.print(listRoot);
                    return;

                case "colors":
                    System.out.println(NetworkAreas.toJson());
                    return;

                case "map":
                    MapCreator.saveMap(args.length > 2 ? args[2] : "netherrail_map.png", args.length > 1 ? Integer.parseInt(args[1]) : 2);
                    return;

                default:
                    throw new IllegalArgumentException(args[0]);
            }
        }

        // TODO Create a REAL error catcher.

        catch(ArrayIndexOutOfBoundsException ex)
        {
            error.add("cause", new JsonPrimitive("Not enough arguments."));
        }
        catch(NumberFormatException ex)
        {
            error.add("cause", new JsonPrimitive("Invalid station id."));
        }
        catch(PathImpossibleException ex)
        {
            error.add("cause", new JsonPrimitive("Path not found."));
        }
        catch(IllegalArgumentException ex)
        {
            error.add("cause", new JsonPrimitive("Invalid argument."));
        }
        catch(Exception ex)
        {
            error.add("cause", new JsonPrimitive("Unknown internal error."));
        }

        System.out.print(error);
    }

    /*
    (Ancien)

    Paramètres :

    - Chemin officiel OU non officiel
    - Chemins accessibles OU en travaux
    - Distance la plus courte OU trajet le plus rapide
    - Descente en cours de route OU descente à un arrêt officiel

     */
}
