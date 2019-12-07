package entity;

import entity.enums.Color;
import entity.enums.Multiplying;
import entity.enums.Soil;

import java.util.Objects;

abstract public class Flower {

    private String id;
    private String name;
    private Soil soil;
    private Color color;
    private String growingTips;
    private Multiplying multiplying;

    public Flower(){

    }

    public Flower(String id, String name, Soil soil, Color color, String growingTips, Multiplying multiplying) {
        this.name = name;
        this.soil = soil;
        this.color = color;
        this.growingTips = growingTips;
        this.multiplying = multiplying;
        this.id = id;
    }

    public String getId(){
        return id;
    }

    public void setId(String id){
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Flower)) return false;
        Flower flower = (Flower) o;
        return getId() == flower.getId() &&
                Objects.equals(getName(), flower.getName()) &&
                getSoil() == flower.getSoil() &&
                getColor() == flower.getColor() &&
                Objects.equals(getGrowingTips(), flower.getGrowingTips()) &&
                getMultiplying() == flower.getMultiplying();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getSoil(), getColor(), getGrowingTips(), getMultiplying());
    }

    @Override
    public String toString() {
        return "Flower{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", soil=" + soil +
                ", color=" + color +
                ", growingTips='" + growingTips + '\'' +
                ", multiplying=" + multiplying +
                '}';
    }
}
