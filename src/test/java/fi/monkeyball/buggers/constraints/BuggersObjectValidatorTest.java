package fi.monkeyball.buggers.constraints;

import fi.monkeyball.buggers.model.BuggersObject;
import fi.monkeyball.buggers.model.BuggersObjectBuilder;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by juhofr on 19/02/16.
 */
public class BuggersObjectValidatorTest {

    @Test
    public void testSimpleValidation() throws Exception {
        BuggersConstraints buggersConstraints = new BuggersConstraints();
        buggersConstraints.add(new FieldMustExistsConstraint("field"));
        BuggersObject bo = BuggersObjectBuilder.buggers().string("field", "value").build();

        assertTrue(buggersConstraints.isValid(bo));
    }
}
