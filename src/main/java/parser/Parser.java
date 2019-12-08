package parser;

import java.util.List;

public interface Parser<Flower> {
    List<Flower> parse(String path);
}
