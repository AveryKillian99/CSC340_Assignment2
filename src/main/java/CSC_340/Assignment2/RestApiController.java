package CSC_340.Assignment2;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import java.util.logging.Level;
import java.util.logging.Logger;

public class RestApiController {

    /**
     * get a random joke
     *
     * @return a randomJoke object.
     */
    @GetMapping("/joke")
    public Object getJoke(@RequestParam(value = "general")String general ) {
        try {
            String url = "https://official-joke-api.appspot.com/random_joke";
            RestTemplate restTemplate = new RestTemplate();
            ObjectMapper mapper = new ObjectMapper();
            /**
             * The response from the above API is a 'single' JSON object that looks like this:
             * {
             *     "type": "general",
             *     "setup": "How do you get two whales in a car?",
             *     "punchline": "Start in England and drive West.",
             *     "id": 125
             * }
             */

            String jsonListResponse = restTemplate.getForObject(url, String.class);
            JsonNode root = mapper.readTree(jsonListResponse);

            //Extract relevant info from the response and use it for what you want, in this case build a Fruit object
            randomJoke joke = new randomJoke(root.get("setup").asText(), root.get("punchline").asText());
            return joke;
        } catch (JsonProcessingException ex) {
            Logger.getLogger(RestApiController.class.getName()).log(Level.SEVERE,
                    null, ex);
            return "error in joke";
        }
    }
}
