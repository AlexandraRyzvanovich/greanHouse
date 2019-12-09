package com.epam.entity;

import com.epam.entity.enums.Color;
import com.epam.entity.enums.Multiplying;
import com.epam.entity.enums.Soil;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Objects;

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
    protected String growingTips;
    @XmlElement(name = "multiplying",required = true)
    @XmlSchemaType(name = "string")
    private Multiplying multiplying;
    @XmlAttribute(name = "login", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    private String login;

    public Flower(){

    }

    public Flower(String id, String name, Soil soil, Color color, String growingTips, Multiplying multiplying) {
        this.name = name;
        this.soil = soil;
        this.color = color;
        this.growingTips = growingTips;
        this.multiplying = multiplying;
        this.login = id;
    }

    public String getLogin(){
        return login;
    }

    public void setLogin(String id){
        this.login = id;
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
        return getLogin().equals(flower.getLogin()) &&
                Objects.equals(getName(), flower.getName()) &&
                getSoil() == flower.getSoil() &&
                getColor() == flower.getColor() &&
                Objects.equals(getGrowingTips(), flower.getGrowingTips()) &&
                getMultiplying() == flower.getMultiplying();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLogin(), getName(), getSoil(), getColor(), getGrowingTips(), getMultiplying());
    }

    @Override
    public String toString() {
        return "Flower{" +
                "id=" + login +
                ", name='" + name + '\'' +
                ", soil=" + soil +
                ", color=" + color +
                ", growingTips='" + growingTips + '\'' +
                ", multiplying=" + multiplying +
                '}';
    }
}
