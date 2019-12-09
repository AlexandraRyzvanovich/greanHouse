package com.epam.entity;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

@XmlRegistry
public class ObjectFactory {

    private final static QName _Flower_QNAME = new QName("http://www.epam.com/flowers", "flower");
    private final static QName _Rose_QNAME = new QName("http://www.epam.com/flowers", "rose");
    private final static QName _HybridRose_QNAME = new QName("http://www.epam.com/flowers", "hybrid_rose");
    private final static QName _GardenRose_QNAME = new QName("http://www.epam.com/flowers", "garden_rose");
    private final static QName _WildRose_QNAME = new QName("http://www.epam.com/flowers", "wild_rose");


    public ObjectFactory() {
    }

    public Flowers createFlowers() {
        return new Flowers();
    }

    public Rose createRose() {
        return new Rose();
    }

    public HybridRose createHybridRose() {
        return new HybridRose();
    }

    public GardenRose createGardenRose() {
        return new GardenRose();
    }

    public WildRose createWildRose() {
        return new WildRose();
    }

    @XmlElementDecl(namespace = "http://www.epam.com/flowers", name = "flower")
    public JAXBElement<Flower> createFlower(Flower value) {
        return new JAXBElement<Flower>(_Flower_QNAME, Flower.class, null, value);
    }

    @XmlElementDecl(namespace = "http://www.epam.com/flowers", name = "rose", substitutionHeadNamespace = "http://www.epam.com/flowers", substitutionHeadName = "flower")
    public JAXBElement<Rose> createRose(Rose value) {
        return new JAXBElement<Rose>(_Rose_QNAME, Rose.class, null, value);
    }

    @XmlElementDecl(namespace = "http://www.epam.com/flowers", name = "hybrid_rose", substitutionHeadNamespace = "http://www.epam.com/flowers", substitutionHeadName = "rose")
    public JAXBElement<HybridRose> createHybridRose(HybridRose value) {
        return new JAXBElement<HybridRose>(_HybridRose_QNAME, HybridRose.class, null, value);
    }

    @XmlElementDecl(namespace = "http://www.epam.com/flowers", name = "garden_rose", substitutionHeadNamespace = "http://www.epam.com/flowers", substitutionHeadName = "rose")
    public JAXBElement<GardenRose> createGardenRose(GardenRose value) {
        return new JAXBElement<GardenRose>(_GardenRose_QNAME, GardenRose.class, null, value);
    }

    @XmlElementDecl(namespace = "http://www.epam.com/flowers", name = "wild_rose", substitutionHeadNamespace = "http://www.epam.com/flowers", substitutionHeadName = "rose")
    public JAXBElement<WildRose> createWildRose(WildRose value) {
        return new JAXBElement<WildRose>(_WildRose_QNAME, WildRose.class, null, value);
    }

}
