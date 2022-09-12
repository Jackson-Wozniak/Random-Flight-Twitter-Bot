package randomflighttwitterbot.tweet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import randomflighttwitterbot.model.FlightTweet;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;

@Component
public class TwitterBotMessageSender{

    @Autowired
    private Twitter twitter;

    public void sendTweet(FlightTweet tweet) {
        Status status;
        try {
            status = twitter.updateStatus(tweet.formatTweet());
            System.out.println(status);
        } catch (TwitterException e) {
            e.printStackTrace();
        }
    }
}
