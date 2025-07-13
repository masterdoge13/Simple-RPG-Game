package model;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestEquipped {

    private Equipment testSword;
    private Equipment testArmour;
    private Equipment defaultSword;
    private Equipment defaultArmour;
    private Equipped testEquipped;
    private Inventory testInventory;

    @BeforeEach
    void runBefore() {
        testSword = new Equipment("test sword", 1.5, 0.1, EquipmentType.SWORD);
        testArmour = new Equipment("test armour", 0.1, 0.2, EquipmentType.ARMOUR);
        testEquipped = new Equipped();
        defaultSword = new Equipment("unarmed", 0, 0, EquipmentType.SWORD);
        defaultArmour = new Equipment("unarmoured", 0, 0, EquipmentType.ARMOUR);
        testInventory = new Inventory();
    }

    @Test
    void testConstructor() {
        assertEquals(defaultSword, testEquipped.getSword());
        assertEquals(defaultArmour, testEquipped.getArmour());
        assertEquals(0, testEquipped.getTotalAttackMod());
        assertEquals(0, testEquipped.getTotalDefenseMod());
    }

    @Test
    void testEquipSingle() {
        testEquipped.equip(testArmour, testInventory);
        assertEquals(testArmour, testEquipped.getArmour());
        assertEquals(1, testInventory.getSize());
        assertEquals(defaultArmour, testInventory.getEquipment(0));
    }

    @Test
    void testEquipMultiple() {
        testEquipped.equip(testArmour, testInventory);
        assertEquals(testArmour, testEquipped.getArmour());
        assertEquals(1, testInventory.getSize());
        assertEquals(defaultArmour, testInventory.getEquipment(0));
        testEquipped.equip(testSword, testInventory);
        assertEquals(testSword, testEquipped.getSword());
        assertEquals(2, testInventory.getSize());
        assertEquals(defaultSword, testInventory.getEquipment(1));
    }

    @Test
    void testEquippedToStringDefault() {
        assertEquals("Equipped:\n" + defaultSword.equipmentToString() + "\n" + defaultArmour.equipmentToString() 
        + "\nDamage Multiplier: " + testEquipped.getTotalAttackMod() + "x\nDamage Reduction: " + testEquipped.getTotalDefenseMod()*100 + "%", testEquipped.equippedToString());
    }

    @Test
    void testEquippedToStringChanged() {
        testEquipped.equip(testSword, testInventory);
        testEquipped.equip(testArmour, testInventory);
        assertEquals("Equipped:\n" + testSword.equipmentToString() + "\n" + testArmour.equipmentToString() 
        + "\nDamage Multiplier: " + testEquipped.getTotalAttackMod() + "x\nDamage Reduction: " + testEquipped.getTotalDefenseMod()*100 + "%", testEquipped.equippedToString());
    }

    @Test
    void testGetArmour() {
        assertEquals(defaultArmour, testEquipped.getArmour());
    }

    @Test
    void testGetSword() {
        assertEquals(defaultSword, testEquipped.getSword());
    }

    @Test
    void testGetTotalAttackMod() {
        assertEquals(defaultSword.getAttackMod(), testEquipped.getTotalAttackMod(), 0.001);
    }

    @Test
    void testGetTotalAttackModChanged() {
        testEquipped.equip(testSword, testInventory);
        assertEquals(testSword.getAttackMod(), testEquipped.getTotalAttackMod(), 0.001);
    }

    @Test
    void testGetTotalAttackModMultiple() {
        testEquipped.equip(testSword, testInventory);
        testEquipped.equip(testArmour, testInventory);
        assertEquals(testSword.getAttackMod() + testArmour.getAttackMod(), testEquipped.getTotalAttackMod(), 0.001);
    }

    @Test
    void testGetTotalDefenseMod() {
        assertEquals(0.0, testEquipped.getTotalDefenseMod(), 0.001);
    }

    @Test
    void testGetTotalDefenseModChanged() {
        testEquipped.equip(testArmour, testInventory);
        assertEquals(testArmour.getDefenseMod(), testEquipped.getTotalDefenseMod(), 0.001);
    }

    @Test
    void testGetTotalDefenseModMultiple() {
        testEquipped.equip(testSword, testInventory);
        testEquipped.equip(testArmour, testInventory);
        assertEquals(1 - ((1 - testArmour.getDefenseMod()) * (1 - testSword.getDefenseMod())), testEquipped.getTotalDefenseMod(), 0.001);
    }
}
