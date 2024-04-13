
public class Plant
{
    public String name;
    public double diameter;
    public int selling_price;
    public Vertex location;
    Condition poor;
    Condition fair;
    Condition excellent;

    public static final String BASIL = "Basil";
    public static final String ROSEMARY = "Rosemary";
    public static final String MINT = "Mint";

    public static final String LAVENDER = "Lavender";

    public static final String CILANTRO = "Cilantro";

    public static final String GINSENG = "Ginseng";

    public static final String ANGELICA = "Angelica";

    public static final String PATCHOULI = "Patchouli";

    public static final String VALERIAN = "Valerian";

    public static final String RUE = "Rue";


    public Plant(String name)
    {
        initialize(name);
    }

    public void initialize(String name)
    {
        switch (name)
        {
            case BASIL:
                this.name = name;
                this.diameter = 0.5;
                this.selling_price = 5;
                this.poor = new Condition(40, 60, 2);
                this.fair = new Condition(60, 70, 5);
                this.excellent = new Condition(90, 80, 8);
                break;
            case ROSEMARY:
                this.name = name;
                this.diameter = 2;
                this.selling_price = 7;
                this.poor = new Condition(60, 50, 4);
                this.fair = new Condition(70, 60, 7);
                this.excellent = new Condition(100, 80, 10);
                break;
            case MINT:
                this.name = name;
                this.diameter = 1;
                this.selling_price = 4;
                this.poor = new Condition(30, 80, 1);
                this.fair = new Condition(50, 70, 4);
                this.excellent = new Condition(80, 90, 7);
                break;
            case LAVENDER:
                this.name = name;
                this.diameter = 2;
                this.selling_price = 8;
                this.poor = new Condition(40, 40, 3);
                this.fair = new Condition(60, 50, 6);
                this.excellent = new Condition(80, 60, 9);
                break;
            case CILANTRO:
                this.name = name;
                this.diameter = 0.75;
                this.selling_price = 6;
                this.poor = new Condition(70, 30, 5);
                this.fair = new Condition(80, 50, 8);
                this.excellent = new Condition(100, 70, 11);
                break;
            case GINSENG:
                this.name = name;
                this.diameter = 1;
                this.selling_price = 10;
                this.poor = new Condition(20, 90, 1);
                this.fair = new Condition(40, 80, 4);
                this.excellent = new Condition(70, 100, 7);
                break;
            case ANGELICA:
                this.name = name;
                this.diameter = 3;
                this.selling_price = 12;
                this.poor = new Condition(10, 85, 1);
                this.fair = new Condition(30, 75, 3);
                this.excellent = new Condition(60, 90, 6);
                break;
            case PATCHOULI:
                this.name = name;
                this.diameter = 2;
                this.selling_price = 9;
                this.poor = new Condition(40, 70, 3);
                this.fair = new Condition(60, 80, 6);
                this.excellent = new Condition(90, 100, 9);
                break;
            case VALERIAN:
                this.name = name;
                this.diameter = 1;
                this.selling_price = 11;
                this.poor = new Condition(15, 70, 2);
                this.fair = new Condition(40, 50, 5);
                this.excellent = new Condition(80, 90, 8);
                break;
            case RUE:
                this.name = name;
                this.diameter = 1.75;
                this.selling_price = 7;
                this.poor = new Condition(70, 30, 6);
                this.fair = new Condition(80, 40, 9);
                this.excellent = new Condition(100, 60, 12);
                break;
        }
    }

    public double getPrice(double sunAchieved, double waterAchieved)
    {
        Condition  con = getCondition(sunAchieved,waterAchieved);
        return con.growth *selling_price;
    }

    private Condition getCondition(double sunAchieved, double waterAchieved)
    {
        double poorDis = poor.getDist(sunAchieved, waterAchieved);
        double fairDis = fair.getDist(sunAchieved, waterAchieved);
        double excelentDis = excellent.getDist(sunAchieved, waterAchieved);
        double min = Math.min(Math.min(poorDis,fairDis),excelentDis);
        if(min == poorDis)
            return poor;
        else if(min == fairDis)
            return fair;
        return excellent;
    }


    //Helper class to store the conditions for growth
    public class Condition
    {
        double sunlight;
        double water;
        double growth;

        public Condition(int suntlight, int water, int growth)
        {
            this.sunlight = suntlight;
            this.water = water;
            this.growth = growth;
        }

        public double getDist(double sunAchieved, double waterAchieved)
        {
            return Math.abs(sunlight-sunAchieved) + Math.abs(water - waterAchieved);
        }
    }
}
