package fi.monkeyball.buggers.model.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import fi.monkeyball.buggers.model.BuggersObject;
import fi.monkeyball.buggers.model.BuggersObjectBuilder;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by juhofr on 20/02/16.
 */
public class BuggerObjectJsonSerializerTest {

    private Gson gson;

    @Before
    public void setUp() {
        GsonBuilder gsonBuilder = new GsonBuilder().setPrettyPrinting();
        /* Register custom serializers with GsonBuilder */
        gsonBuilder.registerTypeAdapter(BuggersObject.class, new BuggerObjectJsonSerializer());
        this.gson = gsonBuilder.create();
    }

    @Test
    public void testTestSerializationWithPrimitiveTypes() throws Exception {

        BuggersObject bo = BuggersObjectBuilder.buggers().string("string", "value").integer("int", 1).build();

        String json = gson.toJson(bo);

        JsonObject jsonObject = gson.fromJson(json, JsonObject.class);

        assertTrue(jsonObject.get("string").getAsJsonPrimitive().isString());
        assertEquals(jsonObject.get("string").getAsString(), "value");

        assertTrue(jsonObject.get("int").getAsJsonPrimitive().isNumber());
        assertEquals(jsonObject.get("int").getAsInt(), 1);

    }

    @Test
    public void testSerializationWithNestedObject() throws Exception {

        BuggersObject bo = BuggersObjectBuilder.buggers()
                .buggers("key1", BuggersObjectBuilder.buggers().string("a", "b").build())
                .build();

        String json = gson.toJson(bo);

        JsonObject jsonObject = gson.fromJson(json, JsonObject.class);

        assertTrue(jsonObject.get("key1").isJsonObject());

    }
}
