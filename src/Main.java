public class Main {

    public static void main(String[] args) {
        Manager manager = new Manager("data/1.txt");
        Plant p = new Plant(Plant.CILANTRO);
        System.out.println(p.getPrice(53,77));
    }
}