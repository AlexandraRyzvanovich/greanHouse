package parser;

import entity.Flower;

import java.util.List;

public interface Parser {
    List<Flower> parse(String path);
}
