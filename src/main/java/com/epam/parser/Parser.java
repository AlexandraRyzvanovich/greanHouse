package com.epam.parser;

import java.util.List;

public interface Parser<Flower> {
    String ROSE_TAG_NAME = "rose";
    String GARDEN_ROSE_TAG_NAME = "garden_rose";
    String WILD_ROSE_TAG_NAME = "wild_rose";
    String HYBRID_ROSE_TAG_NAME = "hybrid_rose";
    String LOGIN_ATTR_NAME = "id";
    String NAME_ELEMENT_NAME = "name";
    String SOIL_ELEMENT_NAME = "soil";
    String COLOR_ELEMENT_NAME = "color";
    String GROWING_TIPS_ELEMENT_NAME = "growing_tips";
    String MULTIPLYING_ELEMENT_NAME = "multiplying";
    String BLOSSOM_TIME_ELEMENT_NAME = "blossom_time";
    String PETAL_QUANTITY_ELEMENT_NAME = "petal_quantity";
    String BUD_TYPE_ELEMENT_NAME  = "bud_type";
    String YEAR_OF_SELECTION_ELEMENT_NAME = "year_of_selection";
    String BUSH_TYPE_ELEMENT_NAME = "bush_type";
    String FRUIT_FORM_ELEMENT_NAME = "fruit_Form";
    String GARDEN_ROSE_SORT_ATTR_NAME = "garden_rose_sort";
    String HYBRID_ROSE_SUBSORT_ATTR_NAME = "hybrid_rose_subSort";
    String WILD_ROSE_SORT_ATR_NAME = "wild_rose_sort";

    List<Flower> parse(String path);
}
