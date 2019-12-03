package entity;

import entity.enums.*;

public class GardenRose extends Rose {
    GardenRoseSort gardenRoseSort;
    BushType bushType;

    public GardenRose(long id, String name, Soil soil, Color color, String growingTips, Multiplying multiplying) {
        super(id, name, soil, color, growingTips, multiplying);
    }
}
