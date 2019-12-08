import parser.jaxbparser.UnMarshalWithXSD;
import parser.saxparser.FlowersSAXBuilder;
import errorHandler.FlowerErrorHandler;
import validator.ValidatorSAX;

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
        unMarshalWithXSD.parse(pathXML);

    }
}
