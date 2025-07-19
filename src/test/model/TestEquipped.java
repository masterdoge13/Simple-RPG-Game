package model;

import static org.junit.Assert.assertEquals;

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
        defaultSword = new Equipment("unarmed", 1, 0, EquipmentType.SWORD);
        defaultArmour = new Equipment("unarmoured", 0, 0, EquipmentType.ARMOUR);
        testInventory = new Inventory();
    }

    @Test
    void testConstructor() {
        assertEquals(defaultSword.getName(), testEquipped.getSword().getName());
        assertEquals(defaultArmour.getName(), testEquipped.getArmour().getName());
        assertEquals(1, testEquipped.getTotalAttackMod(), 0.001);
        assertEquals(0, testEquipped.getTotalDefenseMod(), 0.001);
    }

    @Test
    void testEquipSingle() {
        testEquipped.equip(testArmour, testInventory);
        assertEquals(testArmour.getName(), testEquipped.getArmour().getName());
        assertEquals(1, testInventory.getSize());
        assertEquals(defaultArmour.getName(), testInventory.getEquipment(0).getName());
    }

    @Test
    void testEquipMultiple() {
        testEquipped.equip(testArmour, testInventory);
        assertEquals(testArmour.getName(), testEquipped.getArmour().getName());
        assertEquals(1, testInventory.getSize());
        assertEquals(defaultArmour.getName(), testInventory.getEquipment(0).getName());
        testEquipped.equip(testSword, testInventory);
        assertEquals(testSword.getName(), testEquipped.getSword().getName());
        assertEquals(2, testInventory.getSize());
        assertEquals(defaultSword.getName(), testInventory.getEquipment(1).getName());
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
        assertEquals(defaultArmour.getName(), testEquipped.getArmour().getName());
    }

    @Test
    void testGetSword() {
        assertEquals(defaultSword.getName(), testEquipped.getSword().getName());
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

    @Test
    void testSetEquipment() {
        testEquipped.setEquipment(testArmour);
        assertEquals(defaultSword.getName(), testEquipped.getSword().getName());
        assertEquals(testArmour.getName(), testEquipped.getArmour().getName());
        assertEquals(0, testInventory.getSize());
        testEquipped.setEquipment(testArmour);
        assertEquals(defaultSword.getName(), testEquipped.getSword().getName());
        assertEquals(testArmour.getName(), testEquipped.getArmour().getName());
        assertEquals(0, testInventory.getSize());
        testEquipped.setEquipment(testSword);
        assertEquals(testSword.getName(), testEquipped.getSword().getName());
        assertEquals(testArmour.getName(), testEquipped.getArmour().getName());
        assertEquals(0, testInventory.getSize());
        testEquipped.setEquipment(testSword);
        assertEquals(testSword.getName(), testEquipped.getSword().getName());
        assertEquals(testArmour.getName(), testEquipped.getArmour().getName());
        assertEquals(0, testInventory.getSize());
    }
}
