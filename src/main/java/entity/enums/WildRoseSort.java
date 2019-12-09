package entity.enums;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "Wild_rose_sort")
@XmlEnum
public enum WildRoseSort {
    @XmlEnumValue("bracteata")
    BRACTEATA,
    @XmlEnumValue("foliolosa")
    FOLIOLOSA,
    @XmlEnumValue("rugosa")
    RUGOSA,
    @XmlEnumValue("woodsii")
    WOODSII
}
