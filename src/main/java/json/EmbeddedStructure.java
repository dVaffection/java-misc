package json;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.Iterator;

public class EmbeddedStructure {

    public static void main(String... args) throws IOException {
        toObject();
    }

    public static void toObject() throws IOException {
        String jsonData = "{\"_embedded\": {\"userCues\": [ { \"id\": \"53ef044944ae3ea8ee7f7277\", \"title\": \"title1\" } ] } }";

        ObjectMapper mapper = new ObjectMapper();
        JsonNode rootNode = mapper.readTree(jsonData);
        Iterator<JsonNode> elements = rootNode.path("_embedded").path("userCues").elements();

        while (elements.hasNext()) {
            JsonNode cue = elements.next();
            System.out.println(cue.path("id").asText());
        }


        System.out.println(rootNode);
    }

}
