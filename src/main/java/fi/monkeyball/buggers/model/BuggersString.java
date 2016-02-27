package fi.monkeyball.buggers.model;

/**
 * Created by juhofr on 19/02/16.
 */
public class BuggersString implements BuggersValue<String> {
    private String value;

    public BuggersString(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public void accept(BuggersValueVisitor visitor) {
        visitor.visit(this);
    }
}
