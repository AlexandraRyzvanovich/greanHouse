package com.epam.entity;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)

@XmlRootElement(name = "flowers")
public class Flowers {
    @XmlElementRefs(value = {@XmlElementRef(name = "rose"),
            @XmlElementRef(name = "hybrid_rose"),
            @XmlElementRef(name = "wild_rose"),
            @XmlElementRef(name = "garden_rose")})
    private List<Flower> listFlowers = new ArrayList<>();

        public Flowers() {
        }

        public void setList(ArrayList<Flower> list) {
            this.listFlowers = list;
        }
        public boolean add(Flower flower) {
            return listFlowers.add(flower);
        }
        public List<Flower> getListFlowers(){
            return listFlowers;
        }
}

