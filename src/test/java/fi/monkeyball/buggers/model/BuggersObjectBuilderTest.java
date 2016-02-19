package fi.monkeyball.buggers.model;

import org.junit.Test;

import static org.junit.Assert.assertFalse;

/**
 * Created by juhofr on 19/02/16.
 */
public class BuggersObjectBuilderTest {
    @Test
    public void testBuilder() throws Exception {
        BuggersObject buggersObject =
                BuggersObjectBuilder
                        .buggers()
                        .string("string", "value")
                        .integer("int", 1)
                        .build();
        assertFalse(buggersObject.keySet().isEmpty());

    }
}
