package parser;

import java.util.ArrayList;
import java.util.List;

public interface Parser<Flower> {
    public final String FLOWERS_TAG_NAME = "flowers";
    public final String ROSE_TAG_NAME = "rose";
    public final String GARDEN_ROSE_TAG_NAME = "garden_rose";
    public final String WILD_ROSE_TAG_NAME = "wild_rose";
    public final String HYBRID_ROSE_TAG_NAME = "hybrid_rose";
    public final String LOGIN_ATTR_NAME = "login";
    public final String NAME_ELEMENT_NAME = "name";
    public final String SOIL_ELEMENT_NAME = "soil";
    public final String COLOR_ELEMENT_NAME = "color";
    public final String GROWING_TIPS_ELEMENT_NAME = "growing_tips";
    public final String MULTIPLYING_ELEMENT_NAME = "multiplying";
    public final String BLOSSOM_TIME_ELEMENT_NAME = "blossom_time";
    public final String PETAL_QUANTITY_ELEMENT_NAME = "petal_quantity";
    public final String BUD_TYPE_ELEMENT_NAME  = "bud_type";
    public final String YEAR_OF_SELECTION_ELEMENT_NAME = "year_of_selection";
    public final String BUSH_TYPE_ELEMENT_NAME = "bush_type";
    public final String FRUIT_FORM_ELEMENT_NAME = "fruit_Form";
    public final String GARDEN_ROSE_SORT_ATTR_NAME = "garden_rose_sort";
    public final String HYBRID_ROSE_SUBSORT_ATTR_NAME = "hybrid_rose_subSort";
    public final String WILD_ROSE_SORT_ATR_NAME = "wild_rose_sort";

    public List<String> CONST_LIST = new ArrayList<>();

    List<Flower> parse(String path);
}
