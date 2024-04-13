import java.io.*;
import java.util.HashMap;

public class Manager {
    public HashMap<String, Plant> listPlants = new HashMap<>();

    public Manager() {

    }

    // Template Code for reading in text file
    public void loadData(String textFile) {
        try {
            BufferedReader ff = new BufferedReader(new FileReader(textFile));

            // reads next line then splits the lines and add item
            String line;

            while((line = ff.readLine()) != null) {
                String[] parts = line.split("\t");

                String term = parts[0];
                String sentence = parts[1];
                double score = Double.parseDouble(parts[2]);

            }

        } catch(IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public void initializeList() {

    }
}
