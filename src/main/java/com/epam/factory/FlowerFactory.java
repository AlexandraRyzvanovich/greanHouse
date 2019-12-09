package com.epam.factory;

import com.epam.parser.DomParser;
import com.epam.parser.JaxbParser;
import com.epam.parser.Parser;
import com.epam.parser.SaxParser;

public class FlowerFactory {
    private enum TypeParser {
        SAX, JAXB, DOM
    }
    public Parser createStudentBuilder(String typeParser) {
        TypeParser type = TypeParser.valueOf(typeParser.toUpperCase());
        switch (type) {
            case DOM:
                return new DomParser();
            case JAXB:
                return new JaxbParser();
            case SAX:
                return new SaxParser();
            default:
                throw new EnumConstantNotPresentException (type.getDeclaringClass(), type.name());
        }
    }
}
