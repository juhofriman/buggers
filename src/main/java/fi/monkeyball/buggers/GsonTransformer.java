package fi.monkeyball.buggers;

import com.google.gson.Gson;

import spark.ResponseTransformer;

public class GsonTransformer implements ResponseTransformer {

	private Gson gson = new Gson();
	
	@Override
	public String render(Object object) throws Exception {
		return gson.toJson(object);
	}
}
