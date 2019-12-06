package parser;

import entity.Flower;
import entity.Flowers;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class UnMarshalJAXB {

    public void parseJAXB(){
        try {
            JAXBContext jc = JAXBContext.newInstance(Flower.class);
            Unmarshaller u = jc.createUnmarshaller();
            FileReader reader = new FileReader("data/studs_marsh.xml");
            Flowers flowers = (Flowers) u.unmarshal(reader);
            System.out.println(flowers);
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}

