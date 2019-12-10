package com.epam.parser;

import com.epam.entity.*;
import com.epam.entity.enums.*;
import com.epam.exception.ParserException;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.util.*;

import static com.epam.parser.Parser.*;

public class FlowerHandler extends DefaultHandler {
    private List<Flower> flowers;
    private Flower rose = null;
    private String thisElement = null;

    public FlowerHandler() {
        flowers = new ArrayList<>();
    }
    public List<Flower> getFlowers() {
        return flowers;
    }

    public void startElement(String uri, String localName, String qName, Attributes attrs) {

        switch (localName) {
            case (Parser.ROSE_TAG_NAME):
                rose = new Rose();
                rose.setLogin(attrs.getValue(0));
                break;
            case (HYBRID_ROSE_TAG_NAME):
                rose = new HybridRose();
                rose.setLogin(attrs.getValue(0));
                HybridRoseSubSort hybridRoseSubSort = null;
                if (attrs.getLength() == 2) {
                    String roseSortValue = attrs.getValue(1);
                    String roseSortValueUpperCase = roseSortValue.toUpperCase();
                    hybridRoseSubSort = HybridRoseSubSort.valueOf(roseSortValueUpperCase);
                }
                ((HybridRose) rose).setHybridRoseSubSort(hybridRoseSubSort);
                break;
            case (GARDEN_ROSE_TAG_NAME):
                rose = new GardenRose();
                rose.setLogin(attrs.getValue(0));
                if (attrs.getLength() == 2) {
                    ((GardenRose) rose).setGardenRoseSort(GardenRoseSort.valueOf(attrs.getValue(1).toUpperCase()));
                } else {
                    ((GardenRose) rose).setGardenRoseSort(null);
                }
                break;
            case (WILD_ROSE_TAG_NAME):
                rose = new WildRose();
                rose.setLogin(attrs.getValue(0));
                if (attrs.getLength() == 2) {
                    ((WildRose) rose).setWildRoseSort(WildRoseSort.valueOf(attrs.getValue(1).toUpperCase()));
                } else {
                    ((WildRose) rose).setWildRoseSort(null);
                }
                break;
            default:
                thisElement = qName;
        }
    }

    public void endElement(String uri, String localName, String qName) {
        if (ROSE_TAG_NAME.equals(localName)) {
            flowers.add(rose);
        }else if(HYBRID_ROSE_TAG_NAME.equals(localName)){
            flowers.add(rose);
        }else if(WILD_ROSE_TAG_NAME.equals(localName)){
            flowers.add(rose);
        } else if(GARDEN_ROSE_TAG_NAME.equals(localName)){
            flowers.add(rose);
        }
    }

    public void characters(char[] ch, int start, int length) {
        String s = new String(ch, start, length).trim();
        if(thisElement != null) {
            switch (thisElement) {
                case NAME_ELEMENT_NAME:
                    rose.setName(s);
                    break;
                case SOIL_ELEMENT_NAME:
                    rose.setSoil(Soil.valueOf(s.toUpperCase()));
                    break;
                case COLOR_ELEMENT_NAME:
                    rose.setColor(Color.valueOf(s.toUpperCase()));
                    break;
                case GROWING_TIPS_ELEMENT_NAME:
                    rose.setGrowingTips(s);
                    break;
                case MULTIPLYING_ELEMENT_NAME:
                    rose.setMultiplying(Multiplying.valueOf(s.toUpperCase()));
                    break;
                case BLOSSOM_TIME_ELEMENT_NAME:
                    ((Rose) rose).setBlossomTime(s);
                    break;
                case PETAL_QUANTITY_ELEMENT_NAME:
                    ((Rose) rose).setPetalQuantity(Integer.parseInt(s));
                    break;
                case BUD_TYPE_ELEMENT_NAME:
                    ((Rose) rose).setBudType(s);
                    break;
                case BUSH_TYPE_ELEMENT_NAME:
                    System.out.println(rose);
                    ((GardenRose) rose).setBushType(BushType.valueOf(s.toUpperCase()));
                    break;
                case YEAR_OF_SELECTION_ELEMENT_NAME:
                    System.out.println(rose);
                    ((HybridRose) rose).setYearOfSelection(Integer.parseInt(s));
                    break;
                case FRUIT_FORM_ELEMENT_NAME:
                    ((WildRose) rose).setFruitForm(s);
                    break;
                default:
                    new ParserException("fail,");
            }
        }
        thisElement = null;
    }

}
