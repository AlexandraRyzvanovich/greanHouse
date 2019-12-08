package entity.enums;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "Multiplying")
@XmlEnum
public enum Multiplying {

    @XmlEnumValue("leaves")
    LEAVES("leaves"),
    @XmlEnumValue("cuttage")
    CUTTAGE("cuttage"),
    @XmlEnumValue("seeds")
    SEEDS("seeds");
    private String value;
    Multiplying(String value){
        this.value = value;
    }
}
