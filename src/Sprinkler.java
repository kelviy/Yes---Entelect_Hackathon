public class Sprinkler {

    public Vertex index1;
    public Vertex index2;
    public Vertex index3;

    public static final double SPRINKLER_RADIUS =  3;

    public Sprinkler(Vertex index1, Vertex index2, Vertex index3) {
        this.index1 = index1;
        this.index2 = index2;
        this.index3 = index3;
    }

    /**
     *  This checks if the indexes are adjacent and hence valid. The sprinkler will be placed at the intersection between the three hexagons.
     * @param index1 reference of vertex 1
     * @param index2 reference of vertex 2
     * @param index3 reference of vertex 3
     * @return true if valid
     */
    public boolean checkValid(Vertex index1, Vertex index2, Vertex index3) {
        Edge toVertex1 = new Edge(index1, 1);
        Edge toVertex2 = new Edge(index2, 1);
        Edge toVertex3 = new Edge(index3, 1);

        if (index1.adj.contains(toVertex2) && index1.adj.contains(toVertex3)) {

        }
        return false;
    }
}
