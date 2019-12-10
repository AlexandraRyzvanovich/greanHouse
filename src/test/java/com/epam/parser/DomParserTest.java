package com.epam.parser;

import com.epam.entity.*;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class DomParserTest {
    private final String PATH_XML = "src/test/resources/flowers.xml";
    private DomParser domParser;
    private TestDataBuilder testDataBuilder;

    @BeforeTest
    public void setUp(){
        domParser = new DomParser();
        testDataBuilder = new TestDataBuilder();
    }
    @Test
    public void testDomParseShouldReturnListOfSizeEightWhenValidXmlFilePathGiven(){
        //given
        List<Flower> expectedListFlowers = testDataBuilder.buildExpectedListFlowers();
        //when
        List<Flower> actualList = domParser.parse(PATH_XML);
        //then
        Assert.assertEquals(actualList.size(), 8);
        Assert.assertEquals(actualList, expectedListFlowers);
    }
}
