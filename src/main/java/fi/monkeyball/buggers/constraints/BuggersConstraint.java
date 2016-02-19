package fi.monkeyball.buggers.constraints;

import fi.monkeyball.buggers.model.BuggersObject;

/**
 * Created by juhofr on 19/02/16.
 */
public interface BuggersConstraint {

    boolean apply(BuggersObject object);
}
