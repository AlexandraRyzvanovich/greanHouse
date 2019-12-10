
import com.epam.entity.Flower;
import com.epam.errorhandler.FlowerErrorHandler;
import com.epam.parser.JaxbParser;
import com.epam.validator.ValidatorSax;

import java.util.List;

public class Runner {
    public static void main(String[] args) {
        String pathXML = "./src/test/resources/flowers.xml";
        String pathXSD = "C:\\Users\\sasha\\IdeaProjects\\greenhouse\\src\\main\\resources\\flowers.xsd";
        FlowerErrorHandler errorHandler = new FlowerErrorHandler();
        ValidatorSax validatorSax = new ValidatorSax(errorHandler);
        Boolean result = validatorSax.validateXML( pathXML,pathXSD);
        System.out.println(result);


        JaxbParser jaxbParser = new JaxbParser();
        List<Flower> list = jaxbParser.parse(pathXML);
        System.out.println("+++++++++++++++++JAXB++++++++++++++++++++++++++++");
        for (Flower flower : list) {
            System.out.println("НАКОНЕЦ-то JAXB" + flower);
        }
        System.out.println("+++++++++++++++JAXB+++++++++++++++++++++++++");


    }
}
