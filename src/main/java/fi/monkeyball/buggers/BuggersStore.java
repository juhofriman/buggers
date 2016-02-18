package fi.monkeyball.buggers;

import fi.monkeyball.buggers.model.BuggersKeyValue;

public class BuggersStore {

	public BuggersKeyValue get(String string) {
		return new BuggersKeyValue("dummyObject", string);
	}

}
