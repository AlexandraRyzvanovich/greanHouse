package com.epam.parser;

import com.epam.entity.Flower;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class JaxbParserTest {
    private final String PATH_XML = "src/test/resources/flowers.xml";
    private JaxbParser jaxbParser;
    private TestDataBuilder testDataBuilder;

    @BeforeClass
    public void setUp(){
        jaxbParser = new JaxbParser();
        testDataBuilder = new TestDataBuilder();
    }


    @Test
    public void testJaxbParserShouldReturnTrueWhenCompareWithValidExpectedListFlowers(){
        //given
        List<Flower> expectedFlowerList = testDataBuilder.buildExpectedListFlowers();
        //when
        List<Flower> actualListFlowers = jaxbParser.parse(PATH_XML);
        //then
        Assert.assertEquals(actualListFlowers.size(), 8);
        Assert.assertEquals(actualListFlowers, expectedFlowerList);
    }

}
