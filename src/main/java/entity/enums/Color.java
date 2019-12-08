package entity.enums;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "Color")
@XmlEnum
public enum Color {

    @XmlEnumValue("white")
    WHITE("white"),
    @XmlEnumValue("red")
    RED("red"),
    @XmlEnumValue("yellow")
    YELLOW("yellow"),
    @XmlEnumValue("pink")
    PINK("pink");
    private final String value;

    Color(String value){
        this.value = value;
    }
}
