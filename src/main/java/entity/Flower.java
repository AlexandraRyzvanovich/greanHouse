package entity;

import entity.enums.Color;
import entity.enums.Multiplying;
import entity.enums.Soil;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Objects;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
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
abstract public class Flower {
    @XmlAttribute(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    private long id;
    @XmlElement(name = "name", required = true)
    private String name;
    @XmlElement(name="soil", required = true)
    private Soil soil;
    @XmlElement(name = "color", required = true)
    private Color color;
    @XmlElement(name = "growing-Tips", required = true)
    private String growingTips;
    @XmlElement(name = "multiplying", required = true)
    private Multiplying multiplying;

    public Flower(){

    }

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
