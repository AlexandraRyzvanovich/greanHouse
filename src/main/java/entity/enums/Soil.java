package entity.enums;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "Soil")
@XmlEnum
public enum Soil {

    @XmlEnumValue("podzolic")
    PODZOLIC("podzolic"),
    @XmlEnumValue("sod podzolic")
    SOD_PODZOLIC("sod podzolic"),
    @XmlEnumValue("ground")
    GROUND("ground");
    private final String value;


    Soil(String value){
        this.value = value;
    }

}
