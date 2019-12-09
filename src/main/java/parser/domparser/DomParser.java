package parser.domparser;


import entity.*;
import entity.enums.*;
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
    private DocumentBuilder docBuilder;
    public DomParser() {
        this.flowers = new ArrayList<>();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            docBuilder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            System.err.println("Ошибка конфигурации парсера: " + e);
        }
    }

    public List<Flower> getFlowers() {
        return flowers;
    }

    @Override
    public List<Flower> parse(String fileName) {
        try {
            Document doc = docBuilder.parse(fileName);
            Element root = doc.getDocumentElement();
            NodeList flowersList = root.getElementsByTagName(ROSE_TAG_NAME);
            for (int i = 0; i < flowersList.getLength(); i++) {
                Element flowerElement = (Element) flowersList.item(i);
                Flower flower = buildRose(flowerElement);
                flowers.add(flower);
            }
            NodeList flowersList2 = root.getElementsByTagName(WILD_ROSE_TAG_NAME);
            for (int i = 0; i < flowersList2.getLength(); i++) {
                Element flowerElement = (Element) flowersList2.item(i);
                Flower flower = buildWildRose(flowerElement);
                flowers.add(flower);
            }
            NodeList flowersList3 = root.getElementsByTagName(GARDEN_ROSE_TAG_NAME);
            for (int i = 0; i < flowersList3.getLength(); i++) {
                Element flowerElement = (Element) flowersList3.item(i);
                Flower flower = buildGardenRose(flowerElement);
                flowers.add(flower);
            }
            NodeList flowersList4 = root.getElementsByTagName(HYBRID_ROSE_TAG_NAME);
            for (int i = 0; i < flowersList4.getLength(); i++) {
                Element flowerElement = (Element) flowersList4.item(i);
                Flower flower = buildHybridRose(flowerElement);
                flowers.add(flower);
            }


        } catch (IOException e) {
            System.err.println("File error or I/O error: " + e);
        } catch (SAXException e) {
            System.err.println("Parsing failure: " + e);
        }
        return flowers;
    }

    private Flower buildRose(Element flowerElement) {
        Flower flower = new Rose();
        buildFlower(flower, flowerElement);

        return flower;
    }

    private Flower buildHybridRose(Element flowerElement){
        Flower hybridRose = new HybridRose();
        buildFlower(hybridRose, flowerElement);

        String hybridRoseSortAttr = flowerElement.getAttribute(HYBRID_ROSE_SUBSORT_ATTR_NAME);
        HybridRoseSubSort hybridRoseSubSort = HybridRoseSubSort.valueOf(hybridRoseSortAttr);
        ((HybridRose) hybridRose).setHybridRoseSubSort(hybridRoseSubSort);
        String yearOfSelectionElement = getElementTextContent(flowerElement, YEAR_OF_SELECTION_ELEMENT_NAME);
        int yearOfSelection = Integer.parseInt(yearOfSelectionElement);
        ((HybridRose) hybridRose).setYearOfSelection(yearOfSelection);

        return hybridRose;
    }

    private Flower buildGardenRose(Element flowerElement){
        Flower gardenRose = new GardenRose();
        buildFlower(gardenRose, flowerElement);

        String bushTypeElement = getElementTextContent(flowerElement, BUSH_TYPE_ELEMENT_NAME);
        bushTypeElement.toUpperCase();
        BushType bushType = BushType.valueOf(bushTypeElement);
        ((GardenRose) gardenRose).setBushType(bushType);
        String gardenRoseSortElement = flowerElement.getAttribute(GARDEN_ROSE_SORT_ATTR_NAME).toUpperCase();
        gardenRoseSortElement.toUpperCase();
        GardenRoseSort gardenRoseSort = GardenRoseSort.valueOf(gardenRoseSortElement);
        ((GardenRose) gardenRose).setGardenRoseSort(gardenRoseSort);

        return gardenRose;
    }

    private Flower buildWildRose(Element flowerElement){
        Flower wildRose = new WildRose();
        buildFlower(wildRose, flowerElement);

        String fruitForm = getElementTextContent(flowerElement, FRUIT_FORM_ELEMENT_NAME);
        ((WildRose) wildRose).setFruitForm(fruitForm);
        String wildRoseSortAttr = flowerElement.getAttribute(WILD_ROSE_SORT_ATR_NAME).toUpperCase();
        wildRoseSortAttr.toUpperCase();
        WildRoseSort wildRoseSort = WildRoseSort.valueOf(wildRoseSortAttr);
        ((WildRose) wildRose).setWildRoseSort(wildRoseSort);

        return wildRose;
    }



    private Flower buildFlower(Flower flower, Element flowerElement){
        String login = flowerElement.getAttribute(LOGIN_ATTR_NAME);
        flower.setLogin(login);
        String name = getElementTextContent(flowerElement,NAME_ELEMENT_NAME);
        flower.setName(name);
        String colorElement = getElementTextContent(flowerElement, COLOR_ELEMENT_NAME).toUpperCase();
        Color color = Color.valueOf(colorElement);
        flower.setColor(color);
        String soilElement = getElementTextContent(flowerElement, SOIL_ELEMENT_NAME).toUpperCase();;
        Soil soil = Soil.valueOf(soilElement);
        flower.setSoil(soil);
        String multiplyingElement = getElementTextContent(flowerElement, MULTIPLYING_ELEMENT_NAME).toUpperCase();;
        Multiplying multiplying = Multiplying.valueOf(multiplyingElement);
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
