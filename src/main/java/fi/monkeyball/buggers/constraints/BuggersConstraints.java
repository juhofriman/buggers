package fi.monkeyball.buggers.constraints;

import fi.monkeyball.buggers.model.BuggersObject;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by juhofr on 19/02/16.
 */
public class BuggersConstraints {

    private List<BuggersConstraint> constraints = new LinkedList<>();

    public void add(FieldMustExistsConstraint mustExistConstraint) {
        this.constraints.add(mustExistConstraint);
    }

    public boolean isValid(BuggersObject bo) {
        for (BuggersConstraint constraint : this.constraints) {
            boolean objectSatisfies = constraint.apply(bo);
            if(!objectSatisfies) {
                return false;
            }
        }
        return true;
    }
}
