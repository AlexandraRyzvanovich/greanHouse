package parser.jaxbparser;

import entity.Flower;
import entity.Flowers;
import errorHandler.FlowerErrorHandler;
import exception.JaxbParserException;
import org.xml.sax.SAXException;
import parser.Parser;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class UnMarshalWithXSD implements Parser {
    public List<Flower> flowerList;
    private final String xsdFileName = "flowers.xsd";

    public List<Flower> parse(String path) throws JaxbParserException{
        flowerList = new ArrayList<>();
        ClassLoader classLoader = this.getClass().getClassLoader();
        URL xsdSchema = classLoader.getResource(xsdFileName);

        try {
            JAXBContext jc = JAXBContext.newInstance(Flowers.class);
            Unmarshaller unmarshaller = jc.createUnmarshaller();
            SchemaFactory factory =
                    SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            File schemaLocation;
            if(xsdSchema == null){
                throw new JaxbParserException("XSD file not found");
            }else {
                schemaLocation = new File(xsdSchema.getFile());
            }
            Schema schema = factory.newSchema(schemaLocation);
            unmarshaller.setSchema(schema);
            Flowers st =
                    (Flowers) unmarshaller.unmarshal(new File(path));
            System.out.println(st);
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
        return flowerList;
    }
}




