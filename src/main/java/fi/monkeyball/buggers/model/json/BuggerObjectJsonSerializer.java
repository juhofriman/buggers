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

        JsonElement jsonObject = null;
       
        
        private JsonElement getJsonObject() {
            return this.jsonObject;
        }

        @Override
        public void visit(BuggersObject buggersObject) {
            JsonObject json = new JsonObject();
            for (String key : buggersObject.keySet()) {
				BuggersToJsonMapper buggersToJsonMapper = new BuggersToJsonMapper();
				buggersObject.get(key).accept(buggersToJsonMapper);
				json.add(key, buggersToJsonMapper.getJsonObject());
			}
            this.jsonObject = json;
          
        }

        @Override
        public void visit(BuggersInt buggersInt) {
            this.jsonObject = new JsonPrimitive(buggersInt.getValue());
        }

        @Override
        public void visit(BuggersArray buggersArray) {

        }

        @Override
        public void visit(BuggersString buggersString) {
        	this.jsonObject = new JsonPrimitive(buggersString.getValue());
        }
    }
}
