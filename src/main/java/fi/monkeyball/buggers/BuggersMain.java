package fi.monkeyball.buggers;

import static spark.Spark.*;

public class BuggersMain {

	public static void main(String[] args) {
		get("/hello", (req, res) -> "Hello World");
	}

}
