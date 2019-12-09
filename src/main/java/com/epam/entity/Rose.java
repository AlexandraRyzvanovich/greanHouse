package com.epam.entity;

import com.epam.entity.enums.Color;
import com.epam.entity.enums.Multiplying;
import com.epam.entity.enums.Soil;

import javax.xml.bind.annotation.*;
import java.util.Objects;
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "rose", namespace = "http://www.epam.com/flowers")
@XmlType(name = "Rose", propOrder = {
        "blossomTime",
        "petalQuantity",
        "budType"
})
@XmlSeeAlso({
        HybridRose.class,
        GardenRose.class,
        WildRose.class
})
public class Rose extends Flower {

    @XmlElement(name = "blossom_time", required = true, defaultValue = "summer")
    private String blossomTime;
    @XmlElement(name = "petal_quantity", defaultValue = "7")
    private int petalQuantity;
    @XmlElement(name = "bud_type", required = true)
    private String budType;

    public Rose(String id, String name, Soil soil, Color color, String growingTips, Multiplying multiplying, String blossomTime, int petalQuantity, String budType) {
        super(id, name, soil, color, growingTips, multiplying);
        this.blossomTime = blossomTime;
        this.petalQuantity = petalQuantity;
        this.budType = budType;
    }

    public Rose() {

    }

    public String getBlossomTime() {
        return blossomTime;
    }

    public void setBlossomTime(String blossomTime) {
        this.blossomTime = blossomTime;
    }

    public int getPetalQuantity() {
        return petalQuantity;
    }

    public void setPetalQuantity(int petalQuantity) {
        this.petalQuantity = petalQuantity;
    }

    public String getBudType() {
        return budType;
    }

    public void setBudType(String budType) {
        this.budType = budType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Rose)) return false;
        if (!super.equals(o)) return false;
        Rose rose = (Rose) o;
        return getPetalQuantity() == rose.getPetalQuantity() &&
                getBlossomTime().equals(rose.getBlossomTime()) &&
                getBudType().equals(rose.getBudType());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getBlossomTime(), getPetalQuantity(), getBudType());
    }

    @Override
    public String toString() {
        return "Rose{" +
                "blossomTime='" + blossomTime + '\'' +
                ", petalQuantity=" + petalQuantity +
                ", budType='" + budType + '\'' +
                '}';
    }
}
