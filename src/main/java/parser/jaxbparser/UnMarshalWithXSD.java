package parser.jaxbparser;

import entity.Flower;
import entity.Flowers;
import org.xml.sax.SAXException;
import parser.Parser;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class UnMarshalWithXSD implements Parser {

    public List<Flower> parse(String path) {
        List<Flower> flowerList = new ArrayList<>();
        JAXBContext jc;
        try {
            jc = JAXBContext.newInstance(Flowers.class);
            Unmarshaller um = jc.createUnmarshaller();
            String schemaName = "src/main/resources/flowers.xsd";
            SchemaFactory factory =
                    SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            File schemaLocation = new File(schemaName);
            Schema schema = factory.newSchema(schemaLocation);
            um.setSchema(schema);
            Flowers st =
                    (Flowers) um.unmarshal(new File("src/test/resources/flowers.xml"));
            System.out.println(st);
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
        return flowerList;
    }
}




