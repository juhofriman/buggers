package fi.monkeyball.buggers.model.json;

import com.google.gson.*;
import fi.monkeyball.buggers.model.BuggersObject;

import java.lang.reflect.Type;

/**
 * Created by juhofr on 20/02/16.
 */
public class BuggerObjectJsonSerializer implements JsonSerializer<BuggersObject> {

    @Override
    public JsonElement serialize(BuggersObject buggersObject, Type type, JsonSerializationContext jsonSerializationContext) {
        JsonObject jsonObject = new JsonObject();
        for (String key : buggersObject.keySet()) {
            jsonObject.add(key, new JsonPrimitive(buggersObject.get(key).getValue().toString()));
        }

        return jsonObject;
    }
}
