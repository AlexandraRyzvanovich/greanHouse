package entity;

import entity.enums.Color;
import entity.enums.HybridRoseSubSort;
import entity.enums.Multiplying;
import entity.enums.Soil;

public class HybridRose extends Rose {
    HybridRoseSubSort hybridRoseSubSort;
    int yearOfSelection;
    public HybridRose(long id, String name, Soil soil, Color color, String growingTips, Multiplying multiplying) {
        super(id, name, soil, color, growingTips, multiplying);
    }
}
