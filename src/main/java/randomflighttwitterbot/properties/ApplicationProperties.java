package randomflighttwitterbot.properties;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class ApplicationProperties {

    @Value("${twitter.apiKey}")
    private String API_KEY;
    @Value("${twitter.apiSecretKey}")
    private String API_KEY_SECRET;
    @Value("${twitter.accessKey}")
    private String ACCESS_TOKEN;
    @Value("${twitter.accessSecretKey}")
    private String ACCESS_TOKEN_SECRET;

    public static final int FOUR_HOURS = 14_400_000;
}
