package entity;

import entity.enums.*;
import java.util.Objects;

public class GardenRose extends Rose {
    private GardenRoseSort gardenRoseSort;
    private BushType bushType;

    public GardenRose(String id, String name, Soil soil, Color color, String growingTips, Multiplying multiplying, GardenRoseSort gardenRoseSort, BushType bushType) {
        super(id, name, soil, color, growingTips, multiplying);
        this.gardenRoseSort = gardenRoseSort;
        this.bushType = bushType;
    }

    public GardenRose() {

    }

    public GardenRoseSort getGardenRoseSort() {
        return gardenRoseSort;
    }

    public void setGardenRoseSort(GardenRoseSort gardenRoseSort) {
        if(gardenRoseSort==null){
            this.gardenRoseSort = GardenRoseSort.BANKY;
        }else {
            this.gardenRoseSort = gardenRoseSort;
        }
    }

    public BushType getBushType() {
        return bushType;
    }

    public void setBushType(BushType bushType) {
        this.bushType = bushType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GardenRose)) return false;
        if (!super.equals(o)) return false;
        GardenRose that = (GardenRose) o;
        return getGardenRoseSort() == that.getGardenRoseSort() &&
                getBushType() == that.getBushType();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getGardenRoseSort(), getBushType());
    }

    @Override
    public String toString() {
        return "GardenRose{" +
                "gardenRoseSort=" + gardenRoseSort +
                ", bushType=" + bushType +
                '}';
    }
}
