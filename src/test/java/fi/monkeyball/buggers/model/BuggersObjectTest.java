package fi.monkeyball.buggers.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.util.concurrent.atomic.AtomicBoolean;

public class BuggersObjectTest {

    @Test
    public void testEmptyBuggersObjectIsEmpty() {
        BuggersObject bo = BuggersObjectBuilder.buggers().build();
        assertTrue(bo.keySet().isEmpty());
    }

	@Test
	public void testBuggersObjectWithStringValue() {
        BuggersObject buggersObject = BuggersObjectBuilder.buggers().string("key", "value").build();
        assertEquals(((BuggersString)buggersObject.get("key")).getValue(), "value");
    }

    @Test
    public void testBuggersObjectWithMultipleStringValues() {
        BuggersObject buggersObject = BuggersObjectBuilder.buggers()
                .string("key", "value")
                .string("key2", "value2")
                .build();
        assertEquals(buggersObject.get("key").getClass(), BuggersString.class);
        assertEquals(buggersObject.get("key2").getClass(), BuggersString.class);
        assertEquals(((BuggersString)buggersObject.get("key")).getValue(), "value");
        assertEquals(((BuggersString)buggersObject.get("key2")).getValue(), "value2");
    }

    @Test
    public void testBuggersObjectWithInteger() {
        BuggersObject buggersObject = BuggersObjectBuilder.buggers().integer("key", 1).build();
        assertEquals(buggersObject.get("key").getValue(), new Integer(1));
    }

    @Test
    public void testBuggersObjectWithArray() {
        BuggersObject buggersObject =  BuggersObjectBuilder
                .buggers()
                // TODO: factories for single values
                .array("key", new BuggersString("foo"), new BuggersInt(4))
                .build();

        assertEquals(((BuggersArray)buggersObject.get("key")).getValue().get(0).getValue(), "foo");
        assertEquals(((BuggersArray)buggersObject.get("key")).getValue().get(1).getValue(), new Integer(4));
    }

    @Test
    public void testBuggersObjectWithObject() throws Exception {
        // Not the best solution for builder but will do for now
        BuggersObject root = BuggersObjectBuilder
                .buggers().buggers("key",
                        BuggersObjectBuilder.buggers().string("child", "hello").string("child2", "hello2").build()).build();

        assertEquals(root.get("key").getClass(), BuggersObject.class);
        assertEquals(((BuggersObject)root.get("key")).get("child").getValue(), "hello");
        assertEquals(((BuggersObject)root.get("key")).get("child2").getValue(), "hello2");

    }

    @Test
    public void testAcceptsVisitor() {
        BuggersObject buggersObject = BuggersObjectBuilder.buggers()
                .string("key", "value")
                .integer("integer", 1)
                .build();

        final AtomicBoolean visitStringCalled = new AtomicBoolean(false);
        final AtomicBoolean visitIntegerCalled = new AtomicBoolean(false);

        buggersObject.accept(new BuggersValueVisitor() {
            @Override
            public void visit(BuggersObject buggersObject) {
                for (String key : buggersObject.keySet()) {
                    buggersObject.get(key).accept(this);
                }
            }

            @Override
            public void visit(BuggersInt buggersInt) {
                visitIntegerCalled.set(true);
                assertEquals(new Integer(1), buggersInt.getValue());
            }

            @Override
            public void visit(BuggersArray buggersArray) {

            }

            @Override
            public void visit(BuggersString buggersString) {
                visitStringCalled.set(true);
                assertEquals("value", buggersString.getValue());
            }
        });

        assertTrue(visitStringCalled.get());
        assertTrue(visitIntegerCalled.get());
    }
}
