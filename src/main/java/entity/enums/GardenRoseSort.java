package entity.enums;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "Garden_rose_type")
@XmlEnum
public enum GardenRoseSort {
    @XmlEnumValue("rescht")
    RESCHT,
    @XmlEnumValue("fransis")
    FRANSIS,
    @XmlEnumValue("banky")
    BANKY
}
