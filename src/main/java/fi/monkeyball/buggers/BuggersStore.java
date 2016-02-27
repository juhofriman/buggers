package fi.monkeyball.buggers;


import fi.monkeyball.buggers.model.BuggersObject;
import fi.monkeyball.buggers.model.BuggersObjectBuilder;

public class BuggersStore {

    public BuggersObject get(String s) {
        return BuggersObjectBuilder.buggers()
                .buggers("key1", 
                		BuggersObjectBuilder
                		.buggers()
                		.string("a", "value")
                		.string("b", "value2")
                		.buggers("deep", BuggersObjectBuilder
                				.buggers()
                				.integer("c1", 1)
                				.build())
                		.build())
                .build();
    }
}
