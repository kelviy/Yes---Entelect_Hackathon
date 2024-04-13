
import java.util.*;
public class Vertex
{
    public String cell;
    public LinkedList<Edge> adj;
    public double dist;
    public Vertex prev;
    public int scratch;

    public Plant plant = null;

    private double sunlight, water;

    public Vertex(String nm)
    {
        cell = nm;
        adj = new LinkedList<Edge>();
        reset();
        plant = null;
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
     * @param diameter
     * @return the overall percentage of sunlight in the radius
     */
    public double calcSunlight(double diameter) {
        double radius = diameter / 2;
        double distance = (int)Math.ceil(radius / 2);

        double total = 0;
        double sum = 0;

        Manager.garden.unweighted(cell);

        for (int i = 0; i < Manager.garden.vertexMap.size(); i++) {
            double cellDist = Manager.garden.vertexMap.get(String.valueOf(i)).dist;
            if (cellDist <= distance) {
                sum += Manager.garden.vertexMap.get(String.valueOf(i)).sunlight;
                total += 100;
            }
        }
        return sum/total;
    }

    /**
     * calculates the overall sunlight in the radius. Includes hexagons as long as they are in the circle
     * @param diameter
     * @return the overall percentage of sunlight in the radius
     */
    public double calcWater(double diameter) {
        double radius = diameter / 2;
        double distance = (int)Math.ceil(radius / 2);

        double total = 0;
        double sum = 0;

        Manager.garden.unweighted(cell);

        for (int i = 0; i < Manager.garden.vertexMap.size(); i++) {
            double cellDist = Manager.garden.vertexMap.get(String.valueOf(i)).dist;
            if (cellDist <= distance) {
                sum += Manager.garden.vertexMap.get(String.valueOf(i)).water;
                total += 100;
            }
        }
        return sum/total;
    }
}
