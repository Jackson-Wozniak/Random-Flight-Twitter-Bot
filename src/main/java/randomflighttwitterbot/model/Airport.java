package randomflighttwitterbot.model;

import randomflighttwitterbot.utils.GenerateFlightUtils;

public class Airport {

    private String icaoCode;
    private String size;
    private String airportName;
    private Double latitude;
    private Double longitude;
    private String continent;
    private String country;

    public Airport(String icaoCode,
                   String size,
                   String airportName,
                   Double latitude,
                   Double longitude,
                   String continent,
                   String country) {
        this.icaoCode = icaoCode;
        this.size = size;
        this.airportName = airportName;
        this.latitude = latitude;
        this.longitude = longitude;
        this.continent = continent;
        this.country = country;
    }

    public String getIcaoCode() {
        return icaoCode;
    }

    public void setIcaoCode(String icaoCode) {
        this.icaoCode = icaoCode;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getAirportName() {
        return airportName;
    }

    public void setAirportName(String airportName) {
        this.airportName = airportName;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Airport{" +
                "icaoCode='" + icaoCode + '\'' +
                ", size='" + size + '\'' +
                ", airportName='" + airportName + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", continent='" + continent + '\'' +
                ", country='" + country + '\'' +
                '}';
    }

    public boolean isFlightToAnotherAirportValid(
            Airport airport2,
            int planeSpeed,
            double maxFlightHours){
        return GenerateFlightUtils.calculateFlightHours(planeSpeed,
                GenerateFlightUtils.calculateFlightDistanceInMiles(this, airport2)) < maxFlightHours;
    }
}
