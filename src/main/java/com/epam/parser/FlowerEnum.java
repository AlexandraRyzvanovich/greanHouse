package com.epam.parser;

public enum FlowerEnum {
    FLOWERS("flowers"),
    ROSE("rose"),
    GARDEN_ROSE("garden_rose"),
    WILD_ROSE("wild_rose"),
    HYBRID_ROSE("hybrid_rose"),
    NAME("name"),
    SOIL("soil"),
    COLOR("color"),
    GROWING_TIPS("growing_tips"),
    MULTIPLYING("multiplying"),
    BLOSSOM_TIME("blossom_time"),
    PETAL_QUANTITY("petal_quantity"),
    BUD_TYPE("bud_type"),
    YEAR_OF_SELECTION("year_of_selection"),
    BUSH_TYPE("bush_type"),
    FRUIT_FORM("fruit_Form"),
    WILD_ROSE_SORT("wild_rose_sort");

    private String value;
    private FlowerEnum(String value) {
        this.value = value;
    }
    public String getValue(){
        return value;
    }
}
