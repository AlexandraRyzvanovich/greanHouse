package com.epam.parser;

import com.epam.entity.Flower;
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
        try{
            reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(flowerHandler);
        }catch (SAXException e) {
            System.err.print("ошибка SAX парсера: " + e);
        }
    }

    public List<Flower> getFlowers() {
        return flowers;
    }

    @Override
    public List<Flower> parse(String fileName) {
        try {
            reader.parse(fileName);
        } catch (SAXException e) {
            System.err.print("ошибка SAX парсера: " + e);
        } catch (IOException e) {
            System.err.print("ошибка I/О потока: " + e);
        }
        flowers = flowerHandler.getFlowers();
        return flowers;
    }
}
