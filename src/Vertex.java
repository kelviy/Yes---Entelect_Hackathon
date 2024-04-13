
import java.util.*;
public class Vertex
{
    public String cell;
    public LinkedList<Edge> adj;
    public double dist;
    public Vertex prev;
    public int scratch;

    private double sunlight, water;

    public Vertex(String nm)
    {
        cell = nm;
        adj = new LinkedList<Edge>();
        reset();
        sunlight = 100;
        water=0;
    }

    public void reset()
    {
        dist = Graph.INFINITY;
        prev = null;
        scratch =0;
    }

    public double getSunlight(){
        return sunlight;
    }

    public double getWater(){
        return water;
    }

    public void setWater(double waterLevel){
        water = waterLevel;
    }

    public void setSunlight(double sunlightLevel){
        sunlight = sunlightLevel;
    }

    /**
     * calculates the overall sunlight in the radius. Includes hexagons as long as they are in the circle
     * @param radius
     * @return the overall percentage of sunlight in the radius
     */
    public double calcSunlight(double diameter) {
        double radius = diameter / 2;
        int distance = (int)Math.ceil(radius / 2);
    }
}
