
public class Plant
{
    public String name;
    public double diameter;
    public int selling_price;
    Condition poor;
    Condition fair;
    Condition excellent;

    public Plant(String name,double diameter,int selling_price,Condition poor,Condition fair,Condition excellent)
    {
        initialize(name);
    }

    public void initialize(String name) {
        switch (name) {
            case "Basil":
                this.name = "Basil";

        }


    }

    //Helper class to store the conditions for growth
    public class Condition
    {
        int suntlight;
        int water;
        int growth;

        public Condition(int suntlight,int water,int growth)
        {
            this.suntlight = suntlight;
            this.water = water;
            this.growth = growth;
        }
    }
}
