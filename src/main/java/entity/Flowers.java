package entity;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.*;
import java.util.ArrayList;

@XmlAccessorType(XmlAccessType.FIELD)

@XmlRootElement(name = "flowers")
public class Flowers {
    @XmlElementRefs(value = {@XmlElementRef(name = "rose"),
            @XmlElementRef(name = "hybrid_rose"),
            @XmlElementRef(name = "wild_rose"),
            @XmlElementRef(name = "garden_rose")})
    private ArrayList<Flower> list = new ArrayList<>();
        public Flowers() {
        }
        public void setList(ArrayList<Flower> list) {
            this.list = list;
        }
        public boolean add(Flower flower) {
            return list.add(flower);
        }
        @Override
        public String toString() {
            return "Flowers [list=" + list + "]";
        }
}

