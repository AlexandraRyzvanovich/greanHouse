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
        Assert.assertEquals(actualListFlowers.get(0).getClass(), expectedFlowerList.get(0).getClass());
        Assert.assertEquals(actualListFlowers.get(1).getClass(), expectedFlowerList.get(1).getClass());
        Assert.assertEquals(actualListFlowers.get(2).getClass(), expectedFlowerList.get(2).getClass());
        Assert.assertEquals(actualListFlowers.get(3).getClass(), expectedFlowerList.get(3).getClass());
        Assert.assertEquals(actualListFlowers.get(4).getClass(), expectedFlowerList.get(4).getClass());
        Assert.assertEquals(actualListFlowers.get(5).getClass(), expectedFlowerList.get(5).getClass());
        Assert.assertEquals(actualListFlowers.get(6).getClass(), expectedFlowerList.get(6).getClass());
        Assert.assertEquals(actualListFlowers.get(7).getClass(), expectedFlowerList.get(7).getClass());
    }
}
