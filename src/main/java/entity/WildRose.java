package entity;

import entity.enums.Color;
import entity.enums.Multiplying;
import entity.enums.Soil;
import entity.enums.WildRoseSort;


import java.util.Objects;

public class WildRose extends Rose {
    private WildRoseSort wildRoseSort;
    private String fruitForm;

    public WildRose(String id, String name, Soil soil, Color color, String growingTips, Multiplying multiplying, WildRoseSort wildRoseSort, String fruitForm) {
        super(id, name, soil, color, growingTips, multiplying);
        this.wildRoseSort = wildRoseSort;
        this.fruitForm = fruitForm;
    }

    public WildRose() {

    }

    public WildRoseSort getWildRoseSort() {
        return wildRoseSort;
    }

    public void setWildRoseSort(WildRoseSort wildRoseSort) {
        if(wildRoseSort == null){
            this.wildRoseSort = WildRoseSort.FOLIOLOSA;
        }else {
            this.wildRoseSort = wildRoseSort;
        }
    }

    public String getFruitForm() {
        return fruitForm;
    }

    public void setFruitForm(String fruitForm) {
        this.fruitForm = fruitForm;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WildRose)) return false;
        if (!super.equals(o)) return false;
        WildRose wildRose = (WildRose) o;
        return getWildRoseSort() == wildRose.getWildRoseSort() &&
                getFruitForm().equals(wildRose.getFruitForm());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getWildRoseSort(), getFruitForm());
    }

    @Override
    public String toString() {
        return "WildRose{" +
                "wildRoseSort=" + wildRoseSort +
                ", fruitForm='" + fruitForm + '\'' +
                '}';
    }
}
