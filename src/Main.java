public class Main {

    public static void main(String[] args) {
        Manager manager = new Manager("data/1.txt");
        String out = "{\n\"Herbs\": [\n";
        for(Vertex v : manager.garden.vertexMap.values())
        {
            if(v.plant != null)
            {
                out += "["+ v.cell+", \""+v.plant.name+"\"],\n";
            }
        }
        out = out.replaceAll(",\n$","\n");
        /*
        int start = out.lastIndexOf(",");
        StringBuilder builder = new StringBuilder();
        builder.append(out.substring(0, start));
        builder.append("\n");
        out = builder.toString();*/
        out+= "],\n\"Sprinklers\": [";
        for(Sprinkler s : manager.bestSprinklers)
        {
            out += "["+ s.index1.cell+", "+s.index2.cell+", "+s.index3.cell+"],\n";
        }
        out = out.replaceAll(",\n$","\n");
        out+= "]\n}";
        System.out.println(out);
    }
}