package fi.monkeyball.buggers.model;

/**
 * Created by juhofr on 19/02/16.
 */
public class BuggersInt implements BuggersValue<Integer> {
    private Integer value;

    public BuggersInt(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    @Override
    public void accept(BuggersValueVisitor visitor) {
        visitor.visit(this);
    }
}
