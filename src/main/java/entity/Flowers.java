package entity;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

@XmlRootElement
public class Flowers {
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

