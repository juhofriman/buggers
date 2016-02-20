package fi.monkeyball.buggers;

import static spark.Spark.*;


public class BuggersMain {
	
	private static BuggersStore buggersStore = new BuggersStore();

	public static void main(String[] args) {
		before((request, response) -> response.type("application/json"));
		get("/test", (req, res) -> buggersStore.get("foo"), new GsonTransformer());
	}

}
