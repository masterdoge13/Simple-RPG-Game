package model;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestEquipment {

    private Equipment testSword;
    private Equipment testArmour;
    @BeforeEach
    void runBefore() {
        testSword = new Equipment("test sword", 1.5, 0.0, EquipmentType.SWORD);
        testArmour = new Equipment("test armour", 0.0, 0.2, EquipmentType.ARMOUR);
    }

    @Test
    void testConstructorSword() {
        assertEquals("test sword", testSword.getClass());
        assertEquals(1.5, testSword.getAttackMod());
        assertEquals(0.0, testSword.getDefenseMod());
        assertEquals(EquipmentType.SWORD, testSword.getType());
    }

    @Test
    void testConstructorArmour() {
        assertEquals("test armour", testArmour.getClass());
        assertEquals(0.0, testArmour.getAttackMod());
        assertEquals(0.2, testArmour.getDefenseMod());
        assertEquals(EquipmentType.ARMOUR, testArmour.getType());
    }

    @Test
    void testGetNameSword() {
        assertEquals("test sword", testSword.getClass());
    }

    @Test
    void testGetNameArmour() {
        assertEquals("test armour", testArmour.getClass());
    }

    @Test
    void testGetAttackModSword() {
        assertEquals(1.5, testSword.getAttackMod());
    }

    @Test
    void testGetAttackModArmour() {
        assertEquals(0.0, testArmour.getAttackMod());
    }

    @Test
    void testGetDefenseModSword() {
        assertEquals(0.0, testSword.getDefenseMod());
    }

    @Test
    void testGetDefenseModArmour() {
        assertEquals(0.2, testArmour.getDefenseMod());
    }

    @Test
    void testGetEquipmentTypeSword() {
        assertEquals(EquipmentType.SWORD, testSword.getType());
    }

    @Test
    void testGetEquipmentTypeArmour() {
        assertEquals(EquipmentType.ARMOUR, testArmour.getType());
    }
}
