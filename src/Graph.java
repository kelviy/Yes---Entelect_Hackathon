import java.io.*;
import java.util.*;
public class Graph
{
    public static final double INFINITY = Double.MAX_VALUE;
    public HashMap<String,Vertex> vertexMap = new HashMap<String,Vertex>();

    /**
     * Breath First Search to find the shortest distance
     * @param startName name of the start vertex
     */
    public void unweighted( String startName )
    {
        clearAll( );

        Vertex start = vertexMap.get( startName );
        if( start == null )
            throw new NoSuchElementException( "Start vertex not found" );

        Queue<Vertex> q = new LinkedList<Vertex>( );
        q.add( start ); start.dist = 0;

        while( !q.isEmpty( ) )
        {
            Vertex v = q.remove( );

            for( Edge e : v.adj )
            {
                Vertex w = e.dest;
                if( w.dist == INFINITY )
                {
                    w.dist = v.dist + 1;
                    w.prev = v;
                    q.add( w );
                }
            }
        }
    }

    public void addEdge(String sourcename, String destName)
    {
        Vertex v = getVertex(sourcename);
        Vertex w = getVertex(destName);
        v.adj.add(new Edge(w,1));
    }

    public void dijkstra(String startName)
    {
        PriorityQueue<Path> pq = new PriorityQueue<Path>();
        Vertex start = vertexMap.get(startName);
        if(start == null)
        {
            return;
            //throw new NoSuchElementException("Start vertex not found");
        }
        clearAll();
        pq.add(new Path(start,0));
        start.dist=0;
        int nodeSeen =0;
        while(!pq.isEmpty() && nodeSeen < vertexMap.size())
        {
            Path vrec = pq.remove();
            Vertex v = vrec.dest;
            if(v.scratch != 0)
                continue;

            v.scratch =1;
            nodeSeen++;

            for(Edge e : v.adj)
            {
                Vertex w = e.dest;
                double cvw =e.cost;

                if(cvw < 0)
                    throw new RuntimeException("Graph has negative edges");
                if(w.dist > v.dist + cvw)
                {
                    w.dist = v.dist + cvw;
                    w.prev = v;
                    pq.add(new Path(w,w.dist));
                }
            }
        }
    }

    private void clearAll()
    {
        for(Vertex v : vertexMap.values())
        {
            v.reset();
        }
    }

    public Vertex getVertex(String name)
    {
        Vertex v = vertexMap.get(name);
        if (v == null)
        {
            v = new Vertex(name);
            vertexMap.put(name, v);
        }
        return v;
    }

    public String printPath(Vertex dest)
    {
        if(dest.prev == null)
        {
            return dest.cell;
        }
           return printPath(dest.prev) + " " + dest.cell;
    }
}
