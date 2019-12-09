package entity.enums;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "bush_type")
@XmlEnum
public enum HybridRoseSubSort {
    @XmlEnumValue("cluster")
    CLUSTER,
    @XmlEnumValue("large")
    LARGE,
    @XmlEnumValue("hybrid")
    HYBRID
}
