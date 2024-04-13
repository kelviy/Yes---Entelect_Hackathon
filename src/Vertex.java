
import java.util.*;
public class Vertex
{
    public String cell;
    public LinkedList<Edge> adj;
    public double dist;
    public Vertex prev;
    public int scratch;

    private double sunlight, water;
    private Plant plant;

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

    public void setPlant(Plant plant){
        this.plant = plant;
    }
}
