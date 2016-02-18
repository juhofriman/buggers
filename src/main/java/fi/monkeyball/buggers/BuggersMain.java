package fi.monkeyball.buggers;

import static spark.Spark.*;


public class BuggersMain {
	
	private static BuggersStore buggersStore = new BuggersStore();

	public static void main(String[] args) {
		before((request, response) -> response.type("application/json"));
		get("/*", (req, res) -> buggersStore.get(req.splat()[0]), new GsonTransformer());
	}

}
