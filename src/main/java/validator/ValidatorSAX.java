package validator;

import errorHandler.FlowerErrorHandler;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

public class ValidatorSAX {
    private FlowerErrorHandler errorHandler;
    private final String language = XMLConstants.W3C_XML_SCHEMA_NS_URI;
    private final SchemaFactory factory = SchemaFactory.newInstance(language);

    public ValidatorSAX(FlowerErrorHandler errorHandler) {
        this.errorHandler = errorHandler;
    }

    public Boolean validateXML(String fileName, String schemaName){
        File schemaLocation = new File(schemaName);
        try{
            Schema schema = factory.newSchema(schemaLocation);
            Validator validator = schema.newValidator();
            validator.setErrorHandler(errorHandler);
            Source source = new StreamSource(fileName);
            validator.validate(source);
        } catch (SAXException e) {
            System.err.print("validation "+ fileName + " is not valid because "
                    + e.getMessage());
            return false;
        } catch (IOException e) {
            System.err.print(fileName + " is not valid because "
                    + e.getMessage());
            return false;
        }
        return true;
    }
}
