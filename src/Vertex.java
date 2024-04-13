
import java.util.*;
public class Vertex
{
    public String name;
    public LinkedList<Edge> adj;
    public double dist;
    public Vertex prev;

    public int scratch;
    public Vertex(String nm)
    {
        name = nm;
        adj = new LinkedList<Edge>();
        reset();
    }

    public Vertex(Vertex other)
    {
        name =other.name;
        dist = other.dist;
        adj = new LinkedList<Edge>(other.adj);
        prev = other.prev;
    }

    public void reset()
    {
        dist = Graph.INFINITY;
        prev = null;
        scratch =0;
    }
}
