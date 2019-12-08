package entity;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.*;
import java.util.ArrayList;

@XmlAccessorType(XmlAccessType.FIELD)

@XmlRootElement(name = "flowers")
public class Flowers {
    @XmlElementRef(name = "flower", namespace = "http://www.epam.com/flowers", type = JAXBElement.class)
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
            return "Students [list=" + list + "]";
        }
}

