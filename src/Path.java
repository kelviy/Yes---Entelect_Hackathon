
public class Path implements Comparable<Path>
{
    public Vertex dest;
    public double cost;

    public Path(Vertex d,double c)
    {
        dest = d;
        cost = c;
    }


    @Override
    public int compareTo(Path o)
    {
        if(cost <o.cost)
            return -1;
        else if(cost > o.cost)
            return 1;
        return 0;
    }
}
