package fi.monkeyball.buggers.model;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by juhofr on 19/02/16.
 */
public class BuggersObjectBuilder {

    public static class StatefulBuilder {

        private List<BuggersObject.StringObjectTuple> fields = new LinkedList<>();

        public StatefulBuilder string(String key, String value) {
            this.fields.add(new BuggersObject.StringObjectTuple(key, new BuggersString(value)));
            return this;
        }

        public BuggersObject build() {
            return new BuggersObject(this.fields);
        }

        public StatefulBuilder integer(String key, Integer value) {
            this.fields.add(new BuggersObject.StringObjectTuple(key, new BuggersInt(value)));
            return this;
        }

        public StatefulBuilder array(String key, BuggersValue ... objects) {
            this.fields.add(new BuggersObject.StringObjectTuple(key, new BuggersArray(objects)));
            return this;
        }

        public StatefulBuilder buggers(String key, BuggersObject object) {
            this.fields.add(new BuggersObject.StringObjectTuple(key, object));
            return this;
        }
    }

    public static StatefulBuilder buggers() {
        return new StatefulBuilder();
    }
}
