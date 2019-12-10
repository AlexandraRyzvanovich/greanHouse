package com.epam.factory;

import com.epam.entity.enums.ParserType;
import com.epam.exception.ParserFactoryException;
import com.epam.parser.DomParser;
import com.epam.parser.JaxbParser;
import com.epam.parser.Parser;
import com.epam.parser.SaxParser;

public class ParserFactory {

    public Parser getParser(String typeParser) throws ParserFactoryException {
        ParserType type = ParserType.valueOf(typeParser.toUpperCase());
        switch (type) {
            case DOM:
                return new DomParser();
            case JAXB:
                return new JaxbParser();
            case SAX:
                return new SaxParser();
            default:
                throw new ParserFactoryException("No such parser type");
        }
    }
}
