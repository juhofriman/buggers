package fi.monkeyball.buggers.model.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import fi.monkeyball.buggers.model.BuggersObject;
import fi.monkeyball.buggers.model.BuggersObjectBuilder;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by juhofr on 20/02/16.
 */
public class BuggerObjectJsonSerializerTest {

    @Test
    public void testTestSerialization() throws Exception {

        GsonBuilder gsonBuilder = new GsonBuilder().setPrettyPrinting();
        /* Register custom serializers with GsonBuilder */
        gsonBuilder.registerTypeAdapter(BuggersObject.class, new BuggerObjectJsonSerializer());
        Gson gson = gsonBuilder.create();

        BuggersObject bo = BuggersObjectBuilder.buggers().string("string", "value").integer("int", 1).build();

        String json = gson.toJson(bo);

        JsonObject jsonObject = gson.fromJson(json, JsonObject.class);

        assertTrue(jsonObject.get("string").getAsJsonPrimitive().isString());
        assertEquals(jsonObject.get("string").getAsString(), "value");

        // TODO: Implement visitor to BuggersObject and serialize?
        //assertTrue(jsonObject.get("int").getAsJsonPrimitive().isNumber());
        assertEquals(jsonObject.get("int").getAsInt(), 1);

    }


}
