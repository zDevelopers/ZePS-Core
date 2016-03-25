package me.cassayre.florian.netherrail;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public final class MapCreator
{
    private MapCreator() {}

    private static int toImageX(int mapX)
    {
        return (int) ((mapX + 837) / 2) * 2;
    }

    private static int toImageY(int mapY)
    {
        return (int) ((mapY + 1763) / 2) * 2;
    }

    /**
     * Creates a basic map rendering to help correcting indexation issues.
     * @param location the path to save the image
     * @throws IOException
     */
    public static void saveMap(String location) throws IOException
    {
        BufferedImage img = new BufferedImage(798 * 2, 1194 * 2, BufferedImage.TYPE_INT_ARGB);

        Graphics2D g = img.createGraphics();

        for(Station station : Station.values())
        {
            for(Direction direction : Direction.values())
            {
                Station connection = station.getSubStation(direction);

                if(connection == null)
                    continue;

                PathType pathType = station.getPathType(direction);

                if(pathType == PathType.OFFICIAL_RAIL)
                    g.setColor(new Color(157, 221, 255));
                else if(pathType == PathType.OFFICIAL_WALKING)
                    g.setColor(new Color(57, 151, 147));
                else if(pathType == PathType.UNOFFICIAL_RAIL)
                    g.setColor(new Color(82, 123, 248));
                else if(pathType == PathType.UNOFFICIAL_WALKING)
                    g.setColor(new Color(136, 87, 255));

                g.setStroke(new BasicStroke(8, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));

                g.drawLine(toImageX(station.getX()), toImageY(station.getY()), toImageX(connection.getX()), toImageY(connection.getY()));
            }
        }


        for(Station station : Station.values())
        {
            if(station.isIntersection())
            {
                g.setColor(Color.GREEN);
                if(station.isDangerous())
                    g.setColor(new Color(41, 156, 27));

                if(!station.isVisible())
                    g.setColor(new Color(206, 227, 194));

                g.fillOval(toImageX(station.getX()) - 10, toImageY(station.getY()) - 10, 20, 20);
            }

            if(station.isPortal())

                g.setColor(new Color(159, 87, 209));
            if(station.isDangerous())
                g.setColor(new Color(156, 69, 108));

            if(!station.isVisible())
                g.setColor(new Color(227, 194, 226));

            g.fillOval(toImageX(station.getX()) - 8, toImageY(station.getY()) - 8, 16, 16);

            g.setColor(Color.DARK_GRAY);

            AffineTransform fontAT = new AffineTransform();
            fontAT.setToScale(2, 2);
            Font theFont = g.getFont();
            fontAT.rotate(- Math.PI / 4.0);
            Font theDerivedFont = theFont.deriveFont(fontAT);
            g.setFont(theDerivedFont);

            g.drawString(station.toString(), toImageX(station.getX() + 20), toImageY(station.getY()) - 20);

            g.setFont(theFont);


        }

        ImageIO.write(img, "png", new File(location));
    }
}
