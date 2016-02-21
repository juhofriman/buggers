package fi.monkeyball.buggers.model;

import java.util.*;

public class BuggersObject implements BuggersValue<Map<String, BuggersValue>> {

    private Map<String, BuggersValue> values = new HashMap<>();

    public BuggersObject(List<StringObjectTuple> fields) {
        for (StringObjectTuple field : fields) {
            this.values.put(field.key, field.value);
        }

    }

    public Set<String> keySet() {
        return this.values.keySet();
    }

    public BuggersValue get(String key) {
        return values.get(key);
    }

    @Override
    public Map<String, BuggersValue> getValue() {
        return this.values;
    }

    public boolean containsKey(String field) {
        return this.values.containsKey(field);
    }


    // TODO: Is this correct place?
    public static final class StringObjectTuple {
        public String key;
        public BuggersValue value;
        public StringObjectTuple(String key, BuggersValue value) {
            this.key = key;
            this.value = value;
        }
    }
}
