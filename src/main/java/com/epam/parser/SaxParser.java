package com.epam.parser;

import com.epam.entity.Flower;
import com.epam.exception.ParserException;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;
import java.util.List;

public class SaxParser implements Parser {
    private List<Flower> flowers;
    private FlowerHandler flowerHandler;
    private XMLReader reader;

    public SaxParser() {
        flowerHandler = new FlowerHandler();
    }

    public List<Flower> getFlowers() {
        return flowers;
    }

    @Override
    public List<Flower> parse(String fileName) throws ParserException {
        try {
            reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(flowerHandler);
            reader.parse(fileName);
        } catch (SAXException | IOException e) {
            throw new ParserException("Sax parser failed because", e.getCause());
        }
        flowers = flowerHandler.getFlowers();
        return flowers;
    }
}
