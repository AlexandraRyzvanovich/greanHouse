package com.epam.entity;

import com.epam.entity.enums.Color;
import com.epam.entity.enums.Multiplying;
import com.epam.entity.enums.Soil;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "flower", namespace = "http://www.epam.com/flowers")
@XmlType(name = "Flower", propOrder = {
        "name",
        "soil",
        "color",
        "growingTips",
        "multiplying"
})
@XmlSeeAlso({
        Rose.class
})
public abstract class Flower {

    @XmlElement(name = "name", required = true)
    private String name;
    @XmlElement(name = "soil", required = true)
    @XmlSchemaType(name = "string")
    private Soil soil;
    @XmlElement(name = "color", required = true)
    @XmlSchemaType(name = "string")
    private Color color;
    @XmlElement(name = "growing_tips", required = true)
    private String growingTips;
    @XmlElement(name = "multiplying",required = true)
    @XmlSchemaType(name = "string")
    private Multiplying multiplying;
    @XmlAttribute(name = "id", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    private String id;

    public Flower() {
    }

    public Flower(String id, String name, Soil soil, Color color, String growingTips, Multiplying multiplying) {
        this.name = name;
        this.soil = soil;
        this.color = color;
        this.growingTips = growingTips;
        this.multiplying = multiplying;
        this.id = id;
    }

    public String getLogin() {
        return id;
    }

    public void setLogin(String id) {
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
        if (this == o) {
            return true;
        }
        if (getClass() != o.getClass()) {
            return false;
        }
        Flower flower = (Flower) o;
        if (flower.name == null || flower.color == null ||
            flower.growingTips == null | flower.id == null ||
                flower.multiplying == null || flower.soil == null) {
            return false;
        }
        return getLogin().equals(flower.getLogin()) &&
                getName().equals(flower.getName()) &&
                getSoil() == flower.getSoil() &&
                getColor() == flower.getColor() &&
                getGrowingTips().equals(flower.getGrowingTips()) &&
                getMultiplying() == flower.getMultiplying();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id.hashCode();
        result = prime * result + name.hashCode();
        result = prime * result + color.hashCode();
        result = prime * result + growingTips.hashCode();
        result = prime * result + multiplying.hashCode();
        result = prime * result + soil.hashCode();
        return result;
    }
}
