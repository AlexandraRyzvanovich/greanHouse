package entity;

import entity.enums.Color;
import entity.enums.Multiplying;
import entity.enums.Soil;

abstract public class Flower {
    private long id;
    private String name;
    private Soil soil;
    private Color color;
    private String growingTips;
    private Multiplying multiplying;

    public Flower(long id, String name, Soil soil, Color color, String growingTips, Multiplying multiplying) {
        this.name = name;
        this.soil = soil;
        this.color = color;
        this.growingTips = growingTips;
        this.multiplying = multiplying;
        this.id = id;
    }

    public long getId(){
        return id;
    }

    public void setId(long id){
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Soil getSoil() {
        return soil;
    }

    public void setSoil(Soil soil) {
        this.soil = soil;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public String getGrowingTips() {
        return growingTips;
    }

    public void setGrowingTips(String growingTips) {
        this.growingTips = growingTips;
    }

    public Multiplying getMultiplying() {
        return multiplying;
    }

    public void setMultiplying(Multiplying multiplying) {
        this.multiplying = multiplying;
    }
}
