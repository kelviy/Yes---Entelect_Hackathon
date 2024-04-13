public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Manager manager = new Manager();
        Graph garden = new Graph();

        manager.loadData("data/1.txt", garden);
    }
}