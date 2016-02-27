package fi.monkeyball.buggers.model;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by juhofr on 19/02/16.
 */
public class BuggersArray implements BuggersValue<List<BuggersValue>> {
    private List<BuggersValue> values = new LinkedList<>();

    public BuggersArray(BuggersValue ... values) {
        for (BuggersValue value : values) {
            this.values.add(value);
        }
    }
    @Override
    public List<BuggersValue> getValue() {
        return this.values;
    }

    @Override
    public void accept(BuggersValueVisitor visitor) {
        visitor.visit(this);
    }
}
