package model;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

// Tests for Difficulty class
public class TestDifficulty {

    Difficulty testDifficulty;

    @BeforeEach
    void runBefore() {
        testDifficulty = new Difficulty();
    }

    @Test
    void testConstructor() {
        assertEquals(0, testDifficulty.getDifficulty());
        assertEquals(1.0, testDifficulty.getEquipmentAttackMod(), 0.0001);
        assertEquals(1.0, testDifficulty.getEquipmentDefenseMod(), 0.0001);
    }

    @Test
    void testIncreaseDifficulty() {
        assertEquals(0, testDifficulty.getDifficulty());
        testDifficulty.increaseDifficulty();
        assertEquals(1, testDifficulty.getDifficulty());
        testDifficulty.increaseDifficulty();
        assertEquals(2, testDifficulty.getDifficulty());
        testDifficulty.increaseDifficulty();
        assertEquals(3, testDifficulty.getDifficulty());
    }

    @Test
    void testGetEquipmentAttackMod() {
        assertEquals(1.0, testDifficulty.getEquipmentAttackMod(), 0.0001);
        testDifficulty.increaseDifficulty();
        assertEquals(1.25, testDifficulty.getEquipmentAttackMod(), 0.0001);
        testDifficulty.increaseDifficulty();
        assertEquals(1.5, testDifficulty.getEquipmentAttackMod(), 0.0001);
        testDifficulty.increaseDifficulty();
        assertEquals(1.75, testDifficulty.getEquipmentAttackMod(), 0.0001);
        testDifficulty.increaseDifficulty();
        assertEquals(2, testDifficulty.getEquipmentAttackMod(), 0.0001);
    }

    @Test
    void testGetEquipmentDefenseMod() {
        assertEquals(1.0, testDifficulty.getEquipmentDefenseMod(), 0.0001);
        testDifficulty.increaseDifficulty();
        assertEquals(1.0 + (1-(9/10)), testDifficulty.getEquipmentDefenseMod(), 0.0001);
        testDifficulty.increaseDifficulty();
        assertEquals(1.0 + (1-Math.pow(9/10, 2)), testDifficulty.getEquipmentDefenseMod(), 0.0001);
        testDifficulty.increaseDifficulty();
        assertEquals(1.0 + (1-Math.pow(9/10, 3)), testDifficulty.getEquipmentDefenseMod(), 0.0001);
        testDifficulty.increaseDifficulty();
        assertEquals(1.0 + (1-Math.pow(9/10, 4)), testDifficulty.getEquipmentDefenseMod(), 0.0001);
    }

    @Test
    void testSetDifficulty() {
        assertEquals(0, testDifficulty.getDifficulty());
        testDifficulty.setDifficulty(5);
        assertEquals(5, testDifficulty.getDifficulty());
        testDifficulty.setDifficulty(5);
        assertEquals(5, testDifficulty.getDifficulty());
        testDifficulty.setDifficulty(2);
        assertEquals(2, testDifficulty.getDifficulty());
        testDifficulty.setDifficulty(20);
        assertEquals(20, testDifficulty.getDifficulty());
    }
}
