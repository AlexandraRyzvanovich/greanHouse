package parser.domparser;

import entity.*;
import entity.enums.*;
import exception.DomParserException;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import parser.Parser;

public class DomParser implements Parser {
    private List<Flower> flowers;

    public DomParser() {
        this.flowers = new ArrayList<>();
    }

    public List<Flower> getFlowers() {
        return flowers;
    }

    @Override
    public List<Flower> parse(String fileName) throws DomParserException {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = factory.newDocumentBuilder();
            Document doc = docBuilder.parse(fileName);
            Element root = doc.getDocumentElement();
            NodeList roseList = root.getElementsByTagName(ROSE_TAG_NAME);
            for (int i = 0; i < roseList.getLength(); i++) {
                Element flowerElement = (Element) roseList.item(i);
                Flower flower = buildRose(flowerElement);
                flowers.add(flower);
            }

            NodeList wildRosesList = root.getElementsByTagName(WILD_ROSE_TAG_NAME);
            for (int i = 0; i < wildRosesList.getLength(); i++) {
                Element flowerElement = (Element) wildRosesList.item(i);
                Flower flower = buildWildRose(flowerElement);
                flowers.add(flower);
            }

            NodeList gardenRoseList = root.getElementsByTagName(GARDEN_ROSE_TAG_NAME);
            for (int i = 0; i < gardenRoseList.getLength(); i++) {
                Element flowerElement = (Element) gardenRoseList.item(i);
                Flower flower = buildGardenRose(flowerElement);
                flowers.add(flower);
            }
            NodeList hybridRoseList = root.getElementsByTagName(HYBRID_ROSE_TAG_NAME);
            for (int i = 0; i < hybridRoseList.getLength(); i++) {
                Element flowerElement = (Element) hybridRoseList.item(i);
                Flower flower = buildHybridRose(flowerElement);
                flowers.add(flower);
            }
        } catch (IOException e) {
            throw new DomParserException("Exception occurred while parsing file because", e.getCause());
        } catch (SAXException | ParserConfigurationException e) {
            throw new DomParserException ("Exception in Dom parser occurred", e.getCause());
        }
        return flowers;
    }

    private Flower buildRose(Element flowerElement) {
        Flower flower = new Rose();
        buildFlower(flower, flowerElement);

        return flower;
    }

    private Flower buildHybridRose(Element flowerElement) {
        Flower hybridRose = new HybridRose();
        buildFlower(hybridRose, flowerElement);

        HybridRoseSubSort hybridRoseSubSort = null;
        if (flowerElement.hasAttribute(HYBRID_ROSE_SUBSORT_ATTR_NAME)) {
            String hybridRoseSortAttr = flowerElement.getAttribute(HYBRID_ROSE_SUBSORT_ATTR_NAME);
            String hybridRoseSortUpperCase = hybridRoseSortAttr.toUpperCase();
            hybridRoseSubSort = HybridRoseSubSort.valueOf(hybridRoseSortUpperCase);
        }
        ((HybridRose) hybridRose).setHybridRoseSubSort(hybridRoseSubSort);

        String yearOfSelectionElement = getElementTextContent(flowerElement, YEAR_OF_SELECTION_ELEMENT_NAME);
        int yearOfSelection = Integer.parseInt(yearOfSelectionElement);
        ((HybridRose) hybridRose).setYearOfSelection(yearOfSelection);

        return hybridRose;
    }

    private Flower buildGardenRose(Element flowerElement) {
        Flower gardenRose = new GardenRose();
        buildFlower(gardenRose, flowerElement);

        String bushTypeElement = getElementTextContent(flowerElement, BUSH_TYPE_ELEMENT_NAME);
        String bushTypeElementUpperCase = bushTypeElement.toUpperCase();
        BushType bushType = BushType.valueOf(bushTypeElementUpperCase);
        ((GardenRose) gardenRose).setBushType(bushType);

        GardenRoseSort gardenRoseSort = null;
        if (flowerElement.hasAttribute(GARDEN_ROSE_SORT_ATTR_NAME)) {
            String gardenRoseSortElement = flowerElement.getAttribute(GARDEN_ROSE_SORT_ATTR_NAME);
            String gardenRoseSortUpperCase = gardenRoseSortElement.toUpperCase();
            gardenRoseSort = GardenRoseSort.valueOf(gardenRoseSortUpperCase);
        }
        ((GardenRose) gardenRose).setGardenRoseSort(gardenRoseSort);

        return gardenRose;
    }

    private Flower buildWildRose(Element flowerElement) {
        Flower wildRose = new WildRose();
        buildFlower(wildRose, flowerElement);

        String fruitForm = getElementTextContent(flowerElement, FRUIT_FORM_ELEMENT_NAME);
        ((WildRose) wildRose).setFruitForm(fruitForm);

        WildRoseSort wildRoseSort = null;
        if (flowerElement.hasAttribute(WILD_ROSE_SORT_ATR_NAME)) {
            String wildRoseSortAttr = flowerElement.getAttribute(WILD_ROSE_SORT_ATR_NAME);
            String wildRoseSortUpperCase = wildRoseSortAttr.toUpperCase();
            wildRoseSort = WildRoseSort.valueOf(wildRoseSortUpperCase);
        }
            ((WildRose) wildRose).setWildRoseSort(wildRoseSort);

        return wildRose;
    }

    private Flower buildFlower(Flower flower, Element flowerElement) {
        String login = flowerElement.getAttribute(LOGIN_ATTR_NAME);
        flower.setLogin(login);

        String name = getElementTextContent(flowerElement, NAME_ELEMENT_NAME);
        flower.setName(name);

        String colorElement = getElementTextContent(flowerElement, COLOR_ELEMENT_NAME);
        String colorElementUpperCase = colorElement.toUpperCase();
        Color color = Color.valueOf(colorElementUpperCase);
        flower.setColor(color);

        String soilElement = getElementTextContent(flowerElement, SOIL_ELEMENT_NAME);
        String soilElementUpperCase = soilElement.toUpperCase();
        Soil soil = Soil.valueOf(soilElementUpperCase);
        flower.setSoil(soil);

        String multiplyingElement = getElementTextContent(flowerElement, MULTIPLYING_ELEMENT_NAME);
        String multiplyingElementUpperCase = multiplyingElement.toUpperCase();
        Multiplying multiplying = Multiplying.valueOf(multiplyingElementUpperCase);
        flower.setMultiplying(multiplying);

        String growingTips = getElementTextContent(flowerElement, GROWING_TIPS_ELEMENT_NAME);
        flower.setGrowingTips(growingTips);

        String budType = getElementTextContent(flowerElement, BUD_TYPE_ELEMENT_NAME);
        ((Rose) flower).setBudType(budType);

        String petalQuantityElement = getElementTextContent(flowerElement, PETAL_QUANTITY_ELEMENT_NAME);
        int petalQuantity = Integer.parseInt(petalQuantityElement);
        ((Rose) flower).setPetalQuantity(petalQuantity);

        String blossomTime = getElementTextContent(flowerElement, BLOSSOM_TIME_ELEMENT_NAME);
        ((Rose) flower).setBlossomTime(blossomTime);

        return flower;
    }

    private static String getElementTextContent(Element element, String elementName) {
        NodeList nList = element.getElementsByTagName(elementName);
        Node node = nList.item(0);
        String text = node.getTextContent();
        return text;
    }
}