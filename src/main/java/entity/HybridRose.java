package entity;

import entity.enums.Color;
import entity.enums.HybridRoseSubSort;
import entity.enums.Multiplying;
import entity.enums.Soil;

import javax.xml.bind.annotation.*;
import java.util.Objects;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Hybrid-Rose", propOrder = {
        "hybrid-RoseSubSort",
        "year-Of-Selection"
})
public class HybridRose extends Rose {
    @XmlElement(required = true)
    HybridRoseSubSort hybridRoseSubSort;
    @XmlElement(name = "year-Of-Selection")
    private int yearOfSelection;

    public HybridRose(long id, String name, Soil soil, Color color, String growingTips, Multiplying multiplying) {
        super(id, name, soil, color, growingTips, multiplying);
    }

    public HybridRose(long id, String name, Soil soil, Color color, String growingTips, Multiplying multiplying, HybridRoseSubSort hybridRoseSubSort, int yearOfSelection) {
        super(id, name, soil, color, growingTips, multiplying);
        this.hybridRoseSubSort = hybridRoseSubSort;
        this.yearOfSelection = yearOfSelection;
    }

    public HybridRoseSubSort getHybridRoseSubSort() {
        return hybridRoseSubSort;
    }

    public void setHybridRoseSubSort(HybridRoseSubSort hybridRoseSubSort) {
        this.hybridRoseSubSort = hybridRoseSubSort;
    }

    public int getYearOfSelection() {
        return yearOfSelection;
    }

    public void setYearOfSelection(int yearOfSelection) {
        this.yearOfSelection = yearOfSelection;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof HybridRose)) return false;
        if (!super.equals(o)) return false;
        HybridRose that = (HybridRose) o;
        return getYearOfSelection() == that.getYearOfSelection() &&
                getHybridRoseSubSort() == that.getHybridRoseSubSort();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getHybridRoseSubSort(), getYearOfSelection());
    }

    @Override
    public String toString() {
        return "HybridRose{" +
                "hybridRoseSubSort=" + hybridRoseSubSort +
                ", yearOfSelection=" + yearOfSelection +
                ", blossomTime='" + blossomTime + '\'' +
                ", petalQuantity=" + petalQuantity +
                ", budType='" + budType + '\'' +
                '}';
    }
}
