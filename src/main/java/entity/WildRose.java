package entity;

import entity.enums.Color;
import entity.enums.Multiplying;
import entity.enums.Soil;
import entity.enums.WildRoseSort;

public class WildRose extends Rose {
    WildRoseSort wildRoseSort;
    String fruitsForm;

    public WildRose(long id, String name, Soil soil, Color color, String growingTips, Multiplying multiplying) {
        super(id, name, soil, color, growingTips, multiplying);
    }
}
