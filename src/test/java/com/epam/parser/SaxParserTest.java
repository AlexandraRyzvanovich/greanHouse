package com.epam.parser;

import com.epam.entity.Flower;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class SaxParserTest {
    private final String PATH_XML = "src/test/resources/flowers.xml";
    private SaxParser saxParser;
    private TestDataBuilder testDataBuilder;

    @BeforeClass
    public void setUp(){
        saxParser = new SaxParser();
        testDataBuilder = new TestDataBuilder();
    }

    @Test
    public void testSaxParserShouldReturnTrueWhenCompareWithValidListFlowerObjects(){
        //given
        List<Flower> expectedListFLowers = testDataBuilder.buildExpectedListFlowers();
        //when
        List<Flower> actualListFLowers = saxParser.parse(PATH_XML);
        //then
        Assert.assertEquals(actualListFLowers.size(), 8);
        Assert.assertEquals(actualListFLowers, expectedListFLowers);
    }
}
