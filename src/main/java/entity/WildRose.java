package entity;

import entity.enums.Color;
import entity.enums.Multiplying;
import entity.enums.Soil;
import entity.enums.WildRoseSort;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Wild-Rose", propOrder = {
        "wild-Rose-Sort",
        "fruits-Form"
})
public class WildRose extends Rose {
    @XmlElement(name = "average-mark")
    WildRoseSort wildRoseSort;
    String fruitsForm;

    public WildRose(long id, String name, Soil soil, Color color, String growingTips, Multiplying multiplying) {
        super(id, name, soil, color, growingTips, multiplying);
    }
}
