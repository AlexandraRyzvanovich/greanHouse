package com.epam.entity;

import com.epam.entity.enums.Color;
import com.epam.entity.enums.HybridRoseSubSort;
import com.epam.entity.enums.Multiplying;
import com.epam.entity.enums.Soil;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "hybrid_rose", namespace = "http://www.epam.com/flowers")
@XmlType(name = "Hybrid_Rose", propOrder = {
        "yearOfSelection"
})
public class HybridRose extends Rose {

    @XmlElement(name = "year_of_selection", required = true)
    private int yearOfSelection;
    @XmlAttribute(name = "hybrid_rose_subSort", required = false)
    private HybridRoseSubSort hybridRoseSubSort;

    public HybridRose(String id, HybridRoseSubSort hybridRoseSubSort, String name, Soil soil, Color color, String growingTips, Multiplying multiplying,
                      String blossomTime, int petalQuantity, String budType, int yearOfSelection ) {
        super(id, name, soil, color, growingTips, multiplying, blossomTime, petalQuantity, budType);
        this.yearOfSelection = yearOfSelection;
        this.hybridRoseSubSort = hybridRoseSubSort;
    }

    public HybridRose() {

    }
   
    public HybridRoseSubSort getHybridRoseSubSort() {
        if(hybridRoseSubSort == null) {
            return HybridRoseSubSort.LARGE;
        }
            return hybridRoseSubSort;
    }

    public void setHybridRoseSubSort(HybridRoseSubSort hybridRoseSubSort) {
        if (hybridRoseSubSort == null) {
            this.hybridRoseSubSort = HybridRoseSubSort.LARGE;
        } else {
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
        if (this == o) {
            return true;
        }
        if (getClass() != o.getClass()) {
            return false;
        }
        if(!super.equals(o)){
            return false;
        }
        HybridRose hybridRose = (HybridRose) o;
        if (hybridRose.hybridRoseSubSort == null) {
            return false;
        }
        return getYearOfSelection() == hybridRose.getYearOfSelection() &&
                getHybridRoseSubSort() == hybridRose.getHybridRoseSubSort();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + super.hashCode();
        result = prime * result + hybridRoseSubSort.hashCode();
        result = prime * result + yearOfSelection;

        return result;
    }

    @Override
    public String toString() {
        return "HybridRose{" +
                "yearOfSelection=" + yearOfSelection +
                ", hybridRoseSubSort=" + hybridRoseSubSort +
                '}';
    }
}
