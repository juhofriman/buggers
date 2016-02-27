package fi.monkeyball.buggers.model.json;

import com.google.gson.*;
import fi.monkeyball.buggers.model.*;

import java.lang.reflect.Type;

/**
 * Created by juhofr on 20/02/16.
 */
public class BuggerObjectJsonSerializer implements JsonSerializer<BuggersObject> {

    @Override
    public JsonElement serialize(BuggersObject buggersObject, Type type, JsonSerializationContext jsonSerializationContext) {
        BuggersToJsonMapper bs = new BuggersToJsonMapper();
        buggersObject.accept(bs);
        return bs.getJsonObject();
    }

    private static class BuggersToJsonMapper implements BuggersValueVisitor {

        JsonObject root = new JsonObject();
        JsonObject jsonObject = root;
        // Horrible...
        private String currentKey = null;

        private JsonElement getJsonObject() {
            return this.root;
        }

        @Override
        public void visit(BuggersObject buggersObject) {
            if(this.currentKey != null) {
                this.jsonObject = new JsonObject();
                this.root.add(this.currentKey, jsonObject);
            }
            for (String key : buggersObject.keySet()) {
                this.currentKey = key;
                buggersObject.get(this.currentKey).accept(this);
            }
        }

        @Override
        public void visit(BuggersInt buggersInt) {
            jsonObject.add(this.currentKey, new JsonPrimitive(buggersInt.getValue()));
        }

        @Override
        public void visit(BuggersArray buggersArray) {

        }

        @Override
        public void visit(BuggersString buggersString) {
            jsonObject.add(this.currentKey, new JsonPrimitive(buggersString.getValue()));
        }
    }
}
