import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.sql.Array;

public class Manager {
    public static Graph garden = new Graph();
    public ArrayList<Plant> allPlants = new ArrayList<>();

    public ArrayList<Plant> bestPlants = new ArrayList<>();
    public ArrayList<Sprinkler> bestSprinklers = new ArrayList<>();


    public Manager(String dataFile) {
        loadData(dataFile, garden);
        loadPlants();
        plantsEverywhere();
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

<<<<<<< HEAD
    /**
     * This method add a plant to each cell hopefully in a smart way
     */
    public String plantsEverywhere(){
        String result = "";
        String bestPlant = "";
        double bestPrice = 0;
        for (Vertex currentCell : garden.vertexMap.values()) {
            
            
            
            // find best plant for cell conditions
            for (int j = 0; j < 10; j++) {
                Plant plant = allPlants.get(j);
                if(plant.getPrice(currentCell.getSunlight(), currentCell.getWater())>bestPrice){
                    bestPlant = plant.name;
                    bestPrice = plant.getPrice(currentCell.getSunlight(), currentCell.getWater());
                }
                // System.out.println("Cell "+currentCell.cell+ "\t"+plant.name+"\tPrice="+plant.getPrice(currentCell.getSunlight(), currentCell.getWater()));
            }

            // System.out.println("Cell "+currentCell.cell+ "\t"+bestPlant+"\tPrice="+bestPrice);
            
            currentCell.plant = new Plant(bestPlant);


        }

        return result;
    }

    public void initializeList() {

    }
=======
>>>>>>> 8771770ade9ca50137bc6124da30c4ca26b2bc65
}
