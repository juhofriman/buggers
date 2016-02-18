package fi.monkeyball.buggers.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BuggersObjectTest {

	@Test
	public void buggersObjectCanBeKeyValue() {
		BuggersKeyValue bo = new BuggersKeyValue("key", "value");
		assertEquals(bo.getKey(), "key");
	}
}
