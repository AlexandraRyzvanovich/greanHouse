package entity.enums;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "Multiplying")
@XmlEnum
public enum Multiplying {

    @XmlEnumValue("leaves")
    LEAVES,
    @XmlEnumValue("cuttage")
    CUTTAGE,
    @XmlEnumValue("seeds")
    SEEDS;

}
