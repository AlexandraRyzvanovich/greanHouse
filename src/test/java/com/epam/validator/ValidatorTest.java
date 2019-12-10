package com.epam.validator;

import com.epam.errorhandler.FlowerErrorHandler;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ValidatorTest {
    private final String PATH_XML = "src/test/resources/flowers.xml";
    private final String PATH_XSD = "src/main/resources/flowers.xsd";
    private ValidatorSax validator;
    private FlowerErrorHandler errorHandler;

    @BeforeClass
    public void setUp(){
        errorHandler = new FlowerErrorHandler();
        validator = new ValidatorSax(errorHandler);
    }

    @Test
    public void testValidatorShouldReturnTrueWhenValidXmlAndXSDSchemaGiven(){
        Boolean actualValidationResult = validator.validateXML(PATH_XML, PATH_XSD);
        //then
        Assert.assertTrue(actualValidationResult);
    }
}
