package entity;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
public class Flowers {
    private List<Flower> listFlowers = new ArrayList<>();
    public Flowers(){

    }

    public void setListFlowers(List<Flower> listFlowers) {
        this.listFlowers = listFlowers;
    }

    public boolean add(Flower flower){
        return listFlowers.add(flower);
    }

    @Override
    public String toString() {
        return "Flowers{" +
                "listFlowers=" + listFlowers +
                '}';
    }
}
