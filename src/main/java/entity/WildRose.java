package entity;

public class WildRose extends Rose {
    WildRoseSort wildRoseType;
    String fruitsForm;

    public WildRose(long id, String name, Soil soil, Color color, String growingTips, Multiplying multiplying) {
        super(id, name, soil, color, growingTips, multiplying);
    }
}
