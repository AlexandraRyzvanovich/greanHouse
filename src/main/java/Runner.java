
import com.epam.entity.Flower;
import com.epam.parser.JaxbParser;

import java.util.List;

public class Runner {
    public static void main(String[] args) {
        String pathXML = "./src/test/resources/flowers.xml";


        JaxbParser jaxbParser = new JaxbParser();
        List<Flower> list = jaxbParser.parse(pathXML);
        System.out.println("+++++++++++++++++JAXB++++++++++++++++++++++++++++");
        for (Flower flower : list) {
            System.out.println("НАКОНЕЦ-то JAXB" + flower);
        }
        System.out.println("+++++++++++++++JAXB+++++++++++++++++++++++++");


    }
}
