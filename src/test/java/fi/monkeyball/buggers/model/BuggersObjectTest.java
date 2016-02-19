package fi.monkeyball.buggers.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class BuggersObjectTest {

    @Test
    public void testEmptyBuggersObjectIsEmpty() {
        BuggersObject bo = new BuggersObject();
        assertTrue(bo.keySet().isEmpty());
    }

	@Test
	public void testBuggersObjectWithStringValue() {
        BuggersObject buggersObject = new BuggersObject();
        buggersObject.add("key", new BuggersString("value"));
        assertEquals(((BuggersString)buggersObject.get("key")).getValue(), "value");
    }

    @Test
    public void testBuggersObjectWithMultipleStringValues() {
        BuggersObject buggersObject = new BuggersObject();
        buggersObject.add("key", new BuggersString("value"));
        buggersObject.add("key2", new BuggersString("value2"));
        assertEquals(buggersObject.get("key").getClass(), BuggersString.class);
        assertEquals(buggersObject.get("key2").getClass(), BuggersString.class);
        assertEquals(((BuggersString)buggersObject.get("key")).getValue(), "value");
        assertEquals(((BuggersString)buggersObject.get("key2")).getValue(), "value2");
    }

    @Test
    public void testBuggersObjectWithInteger() {
        BuggersObject buggersObject = new BuggersObject();
        buggersObject.add("key", new BuggersInt(1));
        assertEquals(buggersObject.get("key").getValue(), new Integer(1));
    }

    @Test
    public void testBuggersObjectWithArray() {
        BuggersObject buggersObject = new BuggersObject();
        buggersObject.add("key", new BuggersArray(new BuggersString("foo"), new BuggersInt(4)));

        assertEquals(((BuggersArray)buggersObject.get("key")).getValue().get(0).getValue(), "foo");
        assertEquals(((BuggersArray)buggersObject.get("key")).getValue().get(1).getValue(), new Integer(4));
    }

    @Test
    public void testBuggersObjectWithObject() throws Exception {
        BuggersObject root = new BuggersObject();
        BuggersObject child = new BuggersObject();
        child.add("child", new BuggersString("hello"));
        child.add("child2", new BuggersString("hello2"));
        root.add("key", child);

        assertEquals(root.get("key").getClass(), BuggersObject.class);
        assertEquals(((BuggersObject)root.get("key")).get("child").getValue(), "hello");
        assertEquals(((BuggersObject)root.get("key")).get("child2").getValue(), "hello2");

    }
}
