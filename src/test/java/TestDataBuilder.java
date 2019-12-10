import com.epam.entity.*;
import com.epam.entity.enums.*;

import java.util.ArrayList;
import java.util.List;

public class TestDataBuilder {
    private List<Flower> listFlowers;

    public TestDataBuilder() {
        listFlowers = new ArrayList<>();
    }

    public List<Flower> buildTestData(){
        Flower rose = new Rose("rose0000", "my Favorite Rose 0", Soil.PODZOLIC, Color.WHITE,
                "not specified", Multiplying.SEEDS, "winter", 5, "round"  );
        listFlowers.add(rose);
        Flower rose2 = new Rose("rose0001", "my Favorite Rose 1", Soil.PODZOLIC, Color.WHITE,
                "careful", Multiplying.LEAVES, "winter", 5, "oval");
        listFlowers.add(rose2);
        Flower gardenRose = new GardenRose("rose0002", GardenRoseSort.BANKY, "my Favorite Rose 2", Soil.GROUND, Color.YELLOW,
                "not specified", Multiplying.SEEDS,"middle summer", 2, "square", BushType.CLIMBING);
        listFlowers.add(gardenRose);
        Flower gardenRose2 = new GardenRose("rose0003", GardenRoseSort.RESCHT, "my Favorite Rose 3", Soil.PODZOLIC, Color.PINK,
                "not specified", Multiplying.LEAVES, "spring", 12, "huge oval", BushType.SINGLE);
        listFlowers.add(gardenRose2);
        Flower hybridRose = new HybridRose("rose0004", HybridRoseSubSort.LARGE, "my Favorite Rose 4", Soil.PODZOLIC, Color.RED,
                "poor once a week", Multiplying.SEEDS, "autumn", 13, "round", 1880 );
        listFlowers.add(hybridRose);
        Flower hybridRose2 = new HybridRose("rose0005", HybridRoseSubSort.CLUSTER, "my Favorite Rose 5", Soil.PODZOLIC, Color.YELLOW,
                "not specified", Multiplying.CUTTAGE, "spring", 8, "oval", 1999);
        listFlowers.add(hybridRose2);
        Flower wildRose = new WildRose("rose0006", WildRoseSort.RUGOSA, "my Favorite Rose 6", Soil.PODZOLIC, Color.YELLOW,
                "poor 2 times a day", Multiplying.CUTTAGE, "spring", 25, "round with inside round bud", "round" );
        listFlowers.add(wildRose);
        Flower wildRose2 = new WildRose("rose0007", WildRoseSort.WOODSII, "my Favorite Rose 7", Soil.PODZOLIC, Color.RED,
                "not specified", Multiplying.LEAVES, "summer", 13, "oval small", "small round");
        listFlowers.add(wildRose2);

        return listFlowers;
    }
}
