package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

// Taken from EventTest in AlarmSystem
// Tests for Event class
public class TestEvent {
    private Event e;
    private Date d;
    private static String s = "Added following equipment to inventory:\n" +
                "[unarmed] +0 Sword - Attack increase 1.0x - Damage reduction 0.0%";

    // NOTE: these tests might fail if time at which line (2) below is executed
    // is different from time that line (1) is executed. Lines (1) and (2) must
    // run in same millisecond for this test to make sense and pass.

    @BeforeEach
    public void runBefore() {
        e = new Event(s); // (1)
        d = Calendar.getInstance().getTime(); // (2)
    }

    @Test
    public void testEvent() {
        assertEquals(s, e.getDescription());
        assertEquals(d.getTime(), e.getDate().getTime(), 20); //added float delta to account for compute time
    }

    @Test
    public void testToString() {
        assertEquals(d.toString() + "\n" + s, e.toString());
    }

    @SuppressWarnings("unlikely-arg-type")
    @Test
    public void testEquals() {
        assertFalse(e.equals(null));
        assertFalse(e.equals("string"));
    }

    @Test
    public void testHash() {
        Map<Event, String> m = new HashMap<>();
        m.put(e, "thing");
        assertNull(m.get(new Event("desc")));
        assertEquals(m.get(e), "thing");
        
    }
}
