
import entity.Flower;
import parser.jaxbparser.UnMarshalWithXSD;

import java.util.List;

public class Runner {
    public static void main(String[] args) {
        String pathXML = "./src/test/resources/flowers.xml";


        UnMarshalWithXSD unMarshalWithXSD = new UnMarshalWithXSD();
        List<Flower> list = unMarshalWithXSD.parse(pathXML);
        System.out.println("+++++++++++++++++JAXB++++++++++++++++++++++++++++");
        for (Flower flower : list) {
            System.out.println("НАКОНЕЦ-то JAXB" + flower);
        }
        System.out.println("+++++++++++++++JAXB+++++++++++++++++++++++++");


    }
}
