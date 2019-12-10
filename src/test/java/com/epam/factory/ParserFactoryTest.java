package com.epam.factory;

import com.epam.parser.DomParser;
import com.epam.parser.Parser;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ParserFactoryTest {
    private final String VALID_PARSER_TYPE = "DOM";
    private ParserFactory factory;

    @BeforeClass
    public void setUp(){
        factory = new ParserFactory();
    }

    @Test
    public void testParserFactoryShouldReturnTrueWhenGivenStringEqualsEnumType(){
        //when
        Parser parser = factory.getParser(VALID_PARSER_TYPE);
        //then
        Assert.assertEquals(parser.getClass(), DomParser.class);
    }
}
