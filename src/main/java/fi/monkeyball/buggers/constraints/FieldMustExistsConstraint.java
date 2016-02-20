package fi.monkeyball.buggers.constraints;

import fi.monkeyball.buggers.model.BuggersObject;
import fi.monkeyball.buggers.model.BuggersValue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by juhofr on 19/02/16.
 */
public class FieldMustExistsConstraint implements BuggersConstraint {

    private final String[] fields;

    public FieldMustExistsConstraint(String field) {
        this.fields = field.split("\\.");
    }

    @Override
    public boolean apply(BuggersObject object) {

        BuggersObject traverseObject = object;

        Queue<String> keys = new LinkedList<>();
        for (String s : this.fields) {
            keys.add(s);
        }

        // This is horrible...
        while(!keys.isEmpty()) {
            String key = keys.remove();
            if(traverseObject.containsKey(key)) {
                if(keys.isEmpty()) {
                    return true;
                }
                BuggersValue buggersValue = traverseObject.get(key);
                if(buggersValue instanceof BuggersObject) {
                    traverseObject = (BuggersObject) buggersValue;
                    continue;
                }
                return false;

            } else {
                return false;
            }
        }
        return false;
    }
}
