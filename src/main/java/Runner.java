import entity.Flower;
import parser.jaxbparser.UnMarshalWithXSD;
import parser.saxparser.FlowersSAXBuilder;
import errorHandler.FlowerErrorHandler;
import validator.ValidatorSAX;

import java.util.List;

public class Runner {
    public static void main(String[] args) {
        FlowerErrorHandler errorHandler = new FlowerErrorHandler();
        ValidatorSAX validatorSAX = new ValidatorSAX(errorHandler);
        String pathXML = "./src/test/resources/flowers.xml";
        String pathXSD = "src/main/resources/flowers.xsd";
        boolean res = validatorSAX.validateXML(pathXML, pathXSD);



        FlowersSAXBuilder saxBuilder = new FlowersSAXBuilder();
        saxBuilder.buildListFlowers("src/test/resources/flowers.xml");
        System.out.println(saxBuilder.getFlowers());

        UnMarshalWithXSD unMarshalWithXSD = new UnMarshalWithXSD();
        List<Flower> list = unMarshalWithXSD.parse(pathXML);
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++");
        for (Flower flower:list
             ) {
            System.out.println(flower);
        }
    }
}
