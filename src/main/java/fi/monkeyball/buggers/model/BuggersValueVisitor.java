package fi.monkeyball.buggers.model;

/**
 * Created by juhofr on 21/02/16.
 */
public interface BuggersValueVisitor {

    void visit(BuggersObject buggersObject);

    void visit(BuggersInt buggersInt);

    void visit(BuggersArray buggersArray);

    void visit(BuggersString buggersString);
}
