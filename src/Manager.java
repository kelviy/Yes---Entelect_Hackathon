import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.sql.Array;

public class Manager {
    public Graph garden = new Graph();
    public ArrayList<Plant> allPlants = new ArrayList<>();

    public ArrayList<Plant> bestPlants = new ArrayList<>();
    public ArrayList<Sprinkler> bestSprinklers = new ArrayList<>();


    public Manager(String dataFile) {
        loadData(dataFile, garden);
        loadPlants();
    }

    //Method to load List of plants
    private void loadPlants()
    {
        allPlants.add(new Plant(Plant.BASIL));
        allPlants.add(new Plant(Plant.ROSEMARY));
        allPlants.add(new Plant(Plant.MINT));
        allPlants.add(new Plant(Plant.LAVENDER));
        allPlants.add(new Plant(Plant.CILANTRO));
        allPlants.add(new Plant(Plant.GINSENG));
        allPlants.add(new Plant(Plant.ANGELICA));
        allPlants.add(new Plant(Plant.PATCHOULI));
        allPlants.add(new Plant(Plant.VALERIAN));
        allPlants.add(new Plant(Plant.RUE));
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

    public void initializeList() {

    }
}
