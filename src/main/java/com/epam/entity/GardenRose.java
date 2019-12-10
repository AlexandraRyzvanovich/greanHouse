package com.epam.entity;

import com.epam.entity.enums.BushType;
import com.epam.entity.enums.GardenRoseSort;
import com.epam.entity.enums.Soil;
import com.epam.entity.enums.Color;
import com.epam.entity.enums.Multiplying;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "garden_rose", namespace = "http://www.epam.com/flowers")
@XmlType(name = "Garden_rose", propOrder = {
        "bushType"
})
public class GardenRose extends Rose {

    @XmlElement(name = "bush_type", required = true)
    private BushType bushType;
    @XmlAttribute(name = "garden_rose_sort")
    private GardenRoseSort gardenRoseSort;

    public GardenRose(String id, GardenRoseSort gardenRoseSort, String name, Soil soil, Color color, String growingTips, Multiplying multiplying,
                      String blossomTime, int petalQuantity,  String budType, BushType bushType) {
        super(id, name, soil, color, growingTips, multiplying, blossomTime, petalQuantity, budType);
        this.bushType = bushType;
        this.gardenRoseSort = gardenRoseSort;
    }

    public GardenRose() {

    }

    public GardenRoseSort getGardenRoseSort() {
        return gardenRoseSort;
    }

    public void setGardenRoseSort(GardenRoseSort gardenRoseSort) {
        if (gardenRoseSort == null) {
            this.gardenRoseSort = GardenRoseSort.BANKY;
        } else {
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
        if (this == o) {
            return true;
        }
        if (getClass() != o.getClass()) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        GardenRose gardenRose = (GardenRose) o;
        if (gardenRose.bushType == null || gardenRose.gardenRoseSort == null) {
            return false;
        }
        return getGardenRoseSort() == gardenRose.getGardenRoseSort() &&
                getBushType() == gardenRose.getBushType();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + super.hashCode();
        result = prime * result + bushType.hashCode();
        result = prime * result + gardenRoseSort.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "GardenRose{" +
                "bushType=" + bushType +
                ", gardenRoseSort=" + gardenRoseSort +
                '}';
    }
}
