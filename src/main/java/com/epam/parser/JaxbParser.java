package com.epam.parser;

import com.epam.entity.Flower;
import com.epam.entity.Flowers;
import com.epam.exception.ParserException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.File;
import java.net.URL;
import java.util.List;

public class JaxbParser implements Parser {
    private static final Logger LOGGER = LogManager.getLogger();
    private final String XSD_FILE_NAME = "flowers.xsd";
    public List<Flower> flowerList;

    public List<Flower> parse(String path) throws ParserException {
        ClassLoader classLoader = this.getClass().getClassLoader();
        URL xsdSchema = classLoader.getResource(XSD_FILE_NAME);
        try {
            JAXBContext jc = JAXBContext.newInstance(Flowers.class);
            Unmarshaller unmarshaller = jc.createUnmarshaller();
            SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            File schemaLocation;
            if(xsdSchema == null){
                throw new ParserException("XSD file not found");
            }else {
                schemaLocation = new File(xsdSchema.getFile());
            }
            Schema schema = factory.newSchema(schemaLocation);
            unmarshaller.setSchema(schema);
            Flowers st =
                    (Flowers) unmarshaller.unmarshal(new File(path));
            flowerList = st.getListFlowers();

        } catch (JAXBException | SAXException e) {
            throw new ParserException("Impossible to parse file because ", e.getCause());
        }
        return flowerList;
    }
}