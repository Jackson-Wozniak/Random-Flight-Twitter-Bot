package randomflighttwitterbot.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import randomflighttwitterbot.properties.ApplicationProperties;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

@Configuration
public class TwitterBotConfiguration {

    @Autowired
    private ApplicationProperties applicationProperties;

    @Bean
    public Twitter twitter(){
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey(applicationProperties.getAPI_KEY())
                .setOAuthConsumerSecret(applicationProperties.getAPI_KEY_SECRET())
                .setOAuthAccessToken(applicationProperties.getACCESS_TOKEN())
                .setOAuthAccessTokenSecret(applicationProperties.getACCESS_TOKEN_SECRET());
        TwitterFactory tf = new TwitterFactory(cb.build());
        return tf.getInstance();
    }
}
