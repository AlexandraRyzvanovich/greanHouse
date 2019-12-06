package JAXBParser;


import entity.Flower;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.File;

public class UnMarshalJAXB {
    JAXBContext jc = null;

    public void parse() {
        try {
            jc = JAXBContext.newInstance("com.epam.flowers");
            Unmarshaller um = jc.createUnmarshaller();
            String schemaName = "src/main/resources/flowers.xsd";
            SchemaFactory factory =
                    SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            File schemaLocation = new File(schemaName);
// создание схемы и перадача ее демарашаллизатору
            Schema schema = factory.newSchema(schemaLocation);
            um.setSchema(schema);
            Flower st =
                    (Flower) um.unmarshal(new File("src/test/resources/flowers.xml"));
            System.out.println(st);
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}




