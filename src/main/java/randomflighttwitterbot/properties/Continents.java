package randomflighttwitterbot.properties;

import java.util.Map;

public class Continents {
    private static final Map<String, String> continents = Map.of(
            "NA", "North America",
            "OC", "Oceania",
            "SA", "South America",
            "EU", "Europe",
            "AS", "Asia",
            "AF", "Africa");

    public static String getContinentWithAbbreviation(String abbreviation){
        if(abbreviation == null) return "";
        if(continents.get(abbreviation) != null) return continents.get(abbreviation);
        return abbreviation;
    }
}
