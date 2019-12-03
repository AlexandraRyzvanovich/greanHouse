package entity;

public class HybridRose extends Rose {
    HybridRoseSubSort hybridRoseSubSort;
    int yearOfSelection;
    public HybridRose(long id, String name, Soil soil, Origin origin, Color color, String growingTips, Multiplying multiplying) {
        super(id, name, soil, origin, color, growingTips, multiplying);
    }
}
