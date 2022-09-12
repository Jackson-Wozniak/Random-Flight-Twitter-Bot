package randomflighttwitterbot.tweet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import randomflighttwitterbot.model.Airport;
import randomflighttwitterbot.model.FlightTweet;
import randomflighttwitterbot.properties.Continents;

import javax.annotation.PostConstruct;
import java.io.File;
import java.nio.file.Files;
import java.util.*;

@Component
/*
Because I will be deploying this as a twitter bot, I am using a csv file as a DB instead to
reduce costs. Also, I do not care so much about speed because the tweets are sent on an
interval that does not need to be exact(aka it can wait a while)
 */
public class FlightGenerator {

    @Autowired
    private TwitterBotMessageSender sender;
    private static final File file = new File("airports-Copy.csv");

    public void handleFlightGeneration() throws Exception {
        List<String> allLines = Files.readAllLines(file.toPath());
        FlightTweet tweet = findTwoAirports(allLines);
        if(tweet == null) return;
        sender.sendTweet(tweet);
    }

    private FlightTweet findTwoAirports(List<String> allLines){
        List<Airport> airports = new ArrayList<>();
        Collections.shuffle(allLines);
        for(int i = 0; i < 100; i++){
            airports.add(csvFileLineToAirport(allLines.get(0)));
            airports.add(allLines.stream()
                    .map(FlightGenerator::csvFileLineToAirport)
                    .filter(airport -> !airport.getIcaoCode().equals(airports.get(0).getIcaoCode()))
                    .filter(airport -> airports.get(0).isFlightToAnotherAirportValid(
                            airport, 200, 3))
                    .findFirst()
                    .orElse(null));
            if(airports.get(1) == null){
                continue;
            }
            return new FlightTweet(airports.get(0), airports.get(1));
        }
        return null;
    }

    private static Airport csvFileLineToAirport(String line) {
        String[] airport1 = line.split(",");
        return new Airport(
                airport1[0],
                airport1[1],
                airport1[2],
                Double.parseDouble(airport1[3]),
                Double.parseDouble(airport1[4]),
                Continents.getContinentWithAbbreviation(airport1[5]),
                new Locale("", airport1[6]).getDisplayCountry());
    }

    private static boolean doTheyMatch(String country){
        return country.replace(" ", "").equals("US");
    }
}
