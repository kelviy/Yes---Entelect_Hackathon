
import java.util.*;
public class Vertex
{
    public String cell;
    public LinkedList<Edge> adj;
    public double dist;
    public Vertex prev;

    public int scratch;
    public Vertex(String nm)
    {
        cell = nm;
        adj = new LinkedList<Edge>();
        reset();
    }

    public void reset()
    {
        dist = Graph.INFINITY;
        prev = null;
        scratch =0;
    }
}
