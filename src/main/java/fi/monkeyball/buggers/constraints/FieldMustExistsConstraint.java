package fi.monkeyball.buggers.constraints;

import fi.monkeyball.buggers.model.BuggersObject;

/**
 * Created by juhofr on 19/02/16.
 */
public class FieldMustExistsConstraint implements BuggersConstraint {
    private final String field;

    public FieldMustExistsConstraint(String field) {
        this.field = field;
    }

    @Override
    public boolean apply(BuggersObject object) {
        return object.containsKey(this.field);
    }
}
