# [@RandomFlightBot](https://twitter.com/RandomFlightBot)

This repository contains code to run a Twitter Bot that tweets out random flight plans every 4 hours. 
You can see a live demo [here](https://twitter.com/RandomFlightBot)

## Tweet Formatting

#### Each Tweet Contains:
* A departure airport, including the name, ICAO code and location
* A destination airport, including the name, ICAO code and location
* The total distance measured in miles, using the haversine formula from coordinates
* An estimated time to arrival, with plane speed assumed to be 200 knots

## Technologies

* Twitter4j API
* Java Spring Boot
* Lombok

## Credit
* Airport data that was used to generate flights can be found [here](https://ourairports.com/data/)
* The airport database was filtered to include only small/medium/large airports that include IATA codes
