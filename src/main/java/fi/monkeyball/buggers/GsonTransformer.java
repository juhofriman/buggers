package fi.monkeyball.buggers;

import com.google.gson.Gson;

import com.google.gson.GsonBuilder;
import fi.monkeyball.buggers.model.BuggersObject;
import fi.monkeyball.buggers.model.json.BuggerObjectJsonSerializer;
import spark.ResponseTransformer;

public class GsonTransformer implements ResponseTransformer {

	private final Gson gson;

    public GsonTransformer() {
        GsonBuilder gsonBuilder = new GsonBuilder().setPrettyPrinting();
        gsonBuilder.registerTypeAdapter(BuggersObject.class, new BuggerObjectJsonSerializer());
        this.gson = gsonBuilder.create();
    }
	
	@Override
	public String render(Object object) throws Exception {
		return gson.toJson(object);
	}
}
