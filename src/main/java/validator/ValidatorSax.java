package validator;

import errorHandler.FlowerErrorHandler;
import exception.ValidatorException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

public class ValidatorSax {
    private FlowerErrorHandler errorHandler;
    private final String language = XMLConstants.W3C_XML_SCHEMA_NS_URI;
    private final SchemaFactory factory = SchemaFactory.newInstance(language);
    private static final Logger LOGGER = LogManager.getLogger();

    public ValidatorSax(FlowerErrorHandler errorHandler) {
        this.errorHandler = errorHandler;
    }

    public Boolean validateXML(String fileName, String schemaName) throws ValidatorException{
        File schemaLocation = new File(schemaName);
        try{
            Schema schema = factory.newSchema(schemaLocation);
            Validator validator = schema.newValidator();
            validator.setErrorHandler(errorHandler);
            Source source = new StreamSource(fileName);
            validator.validate(source);
        } catch (SAXException | IOException ex ) {
            LOGGER.warn("Validation failed because" + ex.getMessage());
            return false;
        }
        return true;
    }
}
