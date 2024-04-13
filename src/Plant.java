
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
        this.name = name;
        this.diameter = diameter;
        this.selling_price = selling_price;
        this.poor = poor;
        this.fair = fair;
        this.excellent = excellent;
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
