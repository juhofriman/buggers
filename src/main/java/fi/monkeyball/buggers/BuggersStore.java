package fi.monkeyball.buggers;


import fi.monkeyball.buggers.model.BuggersObject;
import fi.monkeyball.buggers.model.BuggersObjectBuilder;

public class BuggersStore {

    public BuggersObject get(String s) {
        return BuggersObjectBuilder
                .buggers()
                .string("a", "foo")
                .string("b", "bar")
                .integer("c", 1)
                .buggers("key1", BuggersObjectBuilder.buggers().string("a", "b").build())
                .build();
    }
}
