package com.epam;

import com.epam.factory.ParserFactory;
import com.epam.parser.DomParser;
import com.epam.parser.Parser;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class parserFactory {
    private ParserFactory factory;

    @BeforeClass
    public void setUp(){
        factory = new ParserFactory();
    }

    @Test
    public void testParserFactoryShouldReturnTrueWhenGivenStringEqualsEnumType(){
        //given
        String parserType = "DOM";
        //when
        Parser parser = factory.getParser(parserType);
        //then
        Assert.assertEquals(parser.getClass(), DomParser.class);
    }

}
