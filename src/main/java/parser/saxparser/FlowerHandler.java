package parser.saxparser;

import entity.*;
import entity.enums.*;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.util.*;

public class FlowerHandler extends DefaultHandler {
    private List<Flower> flowers;
    private Flower rose = null;
    private FlowerEnum currentEnum = null;
    private EnumSet<FlowerEnum> withText;
    public FlowerHandler() {
        flowers = new ArrayList<>();
        withText = EnumSet.range(FlowerEnum.NAME, FlowerEnum.WILD_ROSE_SORT);
    }
    public List<Flower> getFlowers() {
        return flowers;
    }

    public void startElement(String uri, String localName, String qName, Attributes attrs) {
        if ("rose".equals(localName)) {
            rose = new Rose();
            rose.setLogin(attrs.getValue(0));

        } else if("hybrid_rose".equals(localName)) {
            rose =  new HybridRose();
            rose.setLogin(attrs.getValue(0));
            if (attrs.getLength() == 2) {
                ((HybridRose) rose).setHybridRoseSubSort(HybridRoseSubSort.valueOf(attrs.getValue(1).toUpperCase()));
            }else{
                ((HybridRose) rose).setHybridRoseSubSort(null);
            }
        }
        else if("garden_rose".equals(localName)){
            GardenRose rose1 = new GardenRose();
            rose = new GardenRose();
            rose.setLogin(attrs.getValue(0));
            if (attrs.getLength() == 2) {
                ((GardenRose)rose).setGardenRoseSort(GardenRoseSort.valueOf(attrs.getValue(1).toUpperCase()));
            } else {
                ((GardenRose)rose).setGardenRoseSort(null);
            }
        }
        else if("wild_rose".equals(localName)){
            rose = new WildRose();
            rose.setLogin(attrs.getValue(0));
            if (attrs.getLength() == 2) {
                ((WildRose)rose).setWildRoseSort(WildRoseSort.valueOf(attrs.getValue(1).toUpperCase()));
            } else {
                ((WildRose)rose).setWildRoseSort(null);
            }
        }
        else {
            FlowerEnum temp = FlowerEnum.valueOf(localName.toUpperCase());
            if (withText.contains(temp)) {
                currentEnum = temp;
            }
        }
    }

    public void endElement(String uri, String localName, String qName) {
        if ("rose".equals(localName)) {
            flowers.add(rose);
        }else if("hybrid_rose".equals(localName)){
            flowers.add(rose);
        }else if("wild_rose".equals(localName)){
            flowers.add(rose);
        } else if("garden_rose".equals(localName)){
            flowers.add(rose);
        }

    }

    public void characters(char[] ch, int start, int length) {
        String s = new String(ch, start, length).trim();
        if (currentEnum != null ) {
            switch (currentEnum) {
                case NAME:
                    rose.setName(s);
                    break;
                case SOIL:
                    rose.setSoil(Soil.valueOf(s.toUpperCase()));
                    break;
                case COLOR:
                    rose.setColor(Color.valueOf(s.toUpperCase()));
                    break;
                case GROWING_TIPS:
                    rose.setGrowingTips(s);
                    break;
                case MULTIPLYING:
                    rose.setMultiplying(Multiplying.valueOf(s.toUpperCase()));
                    break;
                case BLOSSOM_TIME:
                    ((Rose) rose).setBlossomTime(s);
                    break;
                case PETAL_QUANTITY:
                    ((Rose) rose).getPetalQuantity();
                    break;
                case BUD_TYPE:
                    ((Rose) rose).setBudType(s);
                    break;
                case BUSH_TYPE:
                    System.out.println(rose);
                    ((GardenRose) rose).setBushType(BushType.valueOf(s.toUpperCase()));
                    break;
                case YEAR_OF_SELECTION:
                    System.out.println(rose);
                    ((HybridRose) rose).setYearOfSelection(Integer.parseInt(s));
                    break;
                case FRUIT_FORM:
                    ((WildRose) rose).setFruitForm(s);
                    break;
                default:
                    throw new EnumConstantNotPresentException(
                            currentEnum.getDeclaringClass(), currentEnum.name());
            }
        }
        currentEnum = null;
    }

}
