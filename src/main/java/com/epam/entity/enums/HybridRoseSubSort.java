package com.epam.entity.enums;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "Hybrid_rose_subsort")
@XmlEnum
public enum HybridRoseSubSort {
    @XmlEnumValue("cluster")
    CLUSTER,
    @XmlEnumValue("large")
    LARGE,
    @XmlEnumValue("hybrid")
    HYBRID
}
