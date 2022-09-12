package randomflighttwitterbot.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import randomflighttwitterbot.properties.ApplicationProperties;
import randomflighttwitterbot.tweet.FlightGenerator;

@Configuration
@EnableScheduling
public class SchedulerConfiguration {

    @Autowired
    private FlightGenerator flightGenerator;

    @Scheduled(fixedDelay = ApplicationProperties.FOUR_HOURS)
    public void processTweet() throws Exception {
        flightGenerator.handleFlightGeneration();
    }
}
