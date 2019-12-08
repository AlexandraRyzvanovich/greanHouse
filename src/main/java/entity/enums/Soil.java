package entity.enums;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "Soil")
@XmlEnum
public enum Soil {

    @XmlEnumValue("podzolic")
    PODZOLIC,
    @XmlEnumValue("ground")
    GROUND;
}