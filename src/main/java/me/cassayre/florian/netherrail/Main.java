package me.cassayre.florian.netherrail;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;

public class Main
{

    public static void main(String[] args)
    {
        try
        {
            MapCreator.saveMap("E:/nethermap.png");
        } catch(java.io.IOException e)
        {
            e.printStackTrace();
        }

        Station.values(); // Test if the stations are correctly indexed.

        JsonObject error = new JsonObject();

        error.add("time", new JsonPrimitive(0));
        error.add("result", new JsonPrimitive("failed"));

        // TODO Something cleaner here.

        try
        {
            if(args[0].equals("pathfinder"))
            {
                System.out.println(new PathFinder(Station.values()[Integer.parseInt(args[1])], Station.values()[Integer.parseInt(args[2])], args.length >= 4 ? Boolean.valueOf(args[3]) : true, args.length >= 5 ? Boolean.valueOf(args[4]) : true).find());
                return;
            }
            else if(args[0].equals("list"))
            {
                JsonObject object = new JsonObject();
                object.add("result", new JsonPrimitive("success"));
                object.add("time", new JsonPrimitive(0));

                JsonArray array = new JsonArray();

                for(Station station : Station.getStationsAlphabetically())
                {
                    array.add(station.toJson());
                }

                object.add("stations", array);

                System.out.print(object);
                return;
            }
            else
            {
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
            error.add("cause", new JsonPrimitive("Internal error."));
        }
        catch(Exception ex)
        {
            error.add("cause", new JsonPrimitive("Unknown"));
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
