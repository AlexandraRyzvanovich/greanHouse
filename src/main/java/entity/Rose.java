package entity;

import entity.enums.Color;
import entity.enums.Multiplying;
import entity.enums.Soil;

public class Rose extends Flower {
    String blossomTime;
    int petalQuantity; //кол-ва лепестков
    String budType;

    public Rose(long id, String name, Soil soil, Color color, String growingTips, Multiplying multiplying) {
        super(id, name, soil, color, growingTips, multiplying);
    }
}
