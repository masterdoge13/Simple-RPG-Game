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
        assertEquals("test sword", testSword.getName());
        assertEquals(1.5, testSword.getAttackMod(), 0.01);
        assertEquals(0.0, testSword.getDefenseMod(), 0.01);
        assertEquals(EquipmentType.SWORD, testSword.getType());
    }

    @Test
    void testConstructorArmour() {
        assertEquals("test armour", testArmour.getName());
        assertEquals(0.0, testArmour.getAttackMod(), 0.01);
        assertEquals(0.2, testArmour.getDefenseMod(), 0.01);
        assertEquals(EquipmentType.ARMOUR, testArmour.getType());
    }

    @Test
    void testGetNameSword() {
        assertEquals("test sword", testSword.getName());
    }

    @Test
    void testGetNameArmour() {
        assertEquals("test armour", testArmour.getName());
    }

    @Test
    void testGetAttackModSword() {
        assertEquals(1.5, testSword.getAttackMod(), 0.01);
    }

    @Test
    void testGetAttackModArmour() {
        assertEquals(0.0, testArmour.getAttackMod(), 0.01);
    }

    @Test
    void testGetDefenseModSword() {
        assertEquals(0.0, testSword.getDefenseMod(), 0.01);
    }

    @Test
    void testGetDefenseModArmour() {
        assertEquals(0.2, testArmour.getDefenseMod(), 0.01);
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
