package randomflighttwitterbot.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import randomflighttwitterbot.utils.GenerateFlightUtils;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class FlightTweet {

    private Airport airport1;
    private Airport airport2;
    private String flightTime;
    private String flightDistance;

    public FlightTweet(Airport airport1, Airport airport2){
        this.airport1 = airport1;
        this.airport2 = airport2;
        this.flightDistance = String.valueOf(
                GenerateFlightUtils.calculateFlightDistanceInMiles(airport1, airport2));
        this.flightTime = GenerateFlightUtils.convertHoursToHHmm(
                GenerateFlightUtils.calculateFlightHours(150,
                        Double.parseDouble(flightDistance)));
    }

    public String formatTweet(){
        return "Departure\n" +
                "Airport: " + airport1.getAirportName() + " | " + airport1.getIcaoCode() + "\n" +
                "Location: " + airport1.getCountry() + " | " + airport1.getContinent() + "\n" +
                "\n" +
                "Destination\n" +
                "Airport: " + airport2.getAirportName() + " | " + airport2.getIcaoCode() + "\n" +
                "Location: " + airport2.getCountry() + " | " + airport2.getContinent() + "\n" +
                "\n" +
                "Distance: " + getFlightDistance() + "mi\n" +
                "Time: " + getFlightTime();

    }
}
