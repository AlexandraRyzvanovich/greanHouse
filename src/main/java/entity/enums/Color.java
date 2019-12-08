package entity.enums;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "Color")
@XmlEnum
public enum Color {

    @XmlEnumValue("white")
    WHITE,
    @XmlEnumValue("red")
    RED,
    @XmlEnumValue("yellow")
    YELLOW,
    @XmlEnumValue("pink")
    PINK;

}
