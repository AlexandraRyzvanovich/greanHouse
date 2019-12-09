package com.epam.entity;

import com.epam.entity.enums.Color;
import com.epam.entity.enums.HybridRoseSubSort;
import com.epam.entity.enums.Multiplying;
import com.epam.entity.enums.Soil;

import javax.xml.bind.annotation.*;
import java.util.Objects;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "hybrid_rose", namespace = "http://www.epam.com/flowers")
@XmlType(name = "Hybrid_Rose", propOrder = {
        "yearOfSelection"
})
public class HybridRose extends Rose {

    @XmlElement(name = "year_of_selection", required = true)
    private int yearOfSelection;
    @XmlAttribute(name = "hybrid_rose_subSort")
    private HybridRoseSubSort hybridRoseSubSort;

    public HybridRose(String id, String name, Soil soil, Color color, String growingTips, Multiplying multiplying,
                      String blossomTime, int petalQuantity, String budType, int yearOfSelection, HybridRoseSubSort hybridRoseSubSort) {
        super(id, name, soil, color, growingTips, multiplying, blossomTime, petalQuantity, budType);
        this.yearOfSelection = yearOfSelection;
        this.hybridRoseSubSort = hybridRoseSubSort;
    }

    public HybridRose() {

    }

    public HybridRoseSubSort getHybridRoseSubSort() {
        return hybridRoseSubSort;
    }

    public void setHybridRoseSubSort(HybridRoseSubSort hybridRoseSubSort) {
        if(hybridRoseSubSort ==null){
            this.hybridRoseSubSort = HybridRoseSubSort.LARGE;
        }else {
            this.hybridRoseSubSort = hybridRoseSubSort;
        }
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
                '}';
    }
}
