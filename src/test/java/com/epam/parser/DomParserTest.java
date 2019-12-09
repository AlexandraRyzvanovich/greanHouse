package com.epam.parser;

import com.epam.entity.*;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class DomParserTest {
    private final String PATH_XML = "src/test/resources/flowers.xml";
    private DomParser domParser;

    @BeforeTest
    public void setUp(){
        domParser = new DomParser();
    }
    @Test
    public void testDomParseShouldReturnListOfSizeEightWhenValidXmlFilePathGiven(){
        List<Flower> actualList = domParser.parse(PATH_XML);
        Assert.assertEquals(actualList.size(), 8);
    }
}
