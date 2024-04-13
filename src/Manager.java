import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.sql.Array;

public class Manager {
    public HashMap<String, Plant> listPlants = new HashMap<>();
    Graph garden = new Graph();


    public Manager(String dataFile) {
        loadData(dataFile, garden);
    }

    // Template Code for reading in text file
    public void loadData(String textFile, Graph garden) {
        try {
            BufferedReader ff = new BufferedReader(new FileReader(textFile));

            // reads next line then splits the lines and add item
            String line;

            while ((line = ff.readLine()) != null) {
                if (line.equals("}")) {
                    ff.readLine();
                    while ((line = ff.readLine()) != null) {
                        if (!line.equals("}")) {
                            // line = ff.readLine();
                            String[] parts = line.split(":");
                            String nameString = parts[0].trim().substring(1, parts[0].trim().length() - 1);
                            String adjacent = parts[1].trim().substring(parts[1].trim().indexOf('[', 0) + 1,
                                    parts[1].trim().indexOf(']', 0));
                            String[] adjacentcyList = adjacent.split(",");
                            for (String cell : adjacentcyList) {
                                garden.addEdge(nameString, cell);
                            }
                        }

                    }
                }

            }

        } catch (

        IOException e) {
            System.err.println(e.getMessage());
        }
    }

    /**
     * This method add a plant to each cell hopefully in a smart way
     */
    public String plantsEverywhere(){
        String result = "";
        ArrayList<Plant> plants = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            // ArrayList.add(new Plant(Plant.BASIL));
        }

        for (int i = 0; i < 10; i++) {
            Vertex currentCell = garden.getVertex(i+"");
            
            // for (int j = 0; j < 10; j++) {
            //     Plant plant = 
            // }
            
            


        }

        return result;
    }

    public void initializeList() {

    }
}
