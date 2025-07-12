package model;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestInventory {

    private Inventory testInventory;
    private Equipment testSword;
    private Equipment testArmour;

    @BeforeEach
    void runBefore() {
        testInventory = new Inventory();
        testSword = new Equipment("test sword", 1.5, 0.0, EquipmentType.SWORD);
        testArmour = new Equipment("test armour", 0.0, 0.2, EquipmentType.ARMOUR);
    }

    @Test
    void testConstructor() {
        assertEquals(0, testInventory.getSize());
    }

    @Test
    void testInsertEquipment() {
        testInventory.insertEquipment(testArmour);
        assertEquals(1, testInventory.getSize());
        assertEquals(testArmour, testInventory.getEquipment(0));
    }

    @Test
    void testInsertEquipmentMultiple() {
        testInventory.insertEquipment(testArmour);
        assertEquals(1, testInventory.getSize());
        testInventory.insertEquipment(testSword);
        assertEquals(2, testInventory.getSize());
        assertEquals(testArmour, testInventory.getEquipment(0));
        assertEquals(testSword, testInventory.getEquipment(1));
    }

    @Test
    void testRemoveEquipment() {
        testInventory.insertEquipment(testArmour);
        assertEquals(1, testInventory.getSize());
        testInventory.removeEquipment(0);
        assertEquals(0, testInventory.getSize());
    }
    @Test
    void testRemoveEquipmentMultiple() {
        testInventory.insertEquipment(testArmour);
        testInventory.insertEquipment(testArmour);
        testInventory.insertEquipment(testSword);
        testInventory.removeEquipment(0);
        assertEquals(2, testInventory.getSize());
        assertEquals(testSword, testInventory.getEquipment(1));
        testInventory.removeEquipment(1);
        assertEquals(1, testInventory.getSize());
        assertEquals(testArmour, testInventory.getEquipment(0));
        testInventory.removeEquipment(0);
        assertEquals(0, testInventory.getSize());
    }

    @Test
    void testInventoryToStringEmpty() {
        assertEquals("Inventory:\n", testInventory.inventoryToString());
    }

    @Test
    void testInventoryToStringSingle() {
        testInventory.insertEquipment(testArmour);
        assertEquals("Inventory:\n" + testArmour.equipmentToString() + "/n", testInventory.inventoryToString());
    }

    @Test
    void testInventoryToStringMultiple() {
        testInventory.insertEquipment(testArmour);
        testInventory.insertEquipment(testSword);
        assertEquals("Inventory:\n" 
        + testArmour.equipmentToString() + "/n" 
        + testSword.equipmentToString() + "/n", testInventory.inventoryToString());
    }

    @Test
    void testGetEquipment() {
        testInventory.insertEquipment(testArmour);
        assertEquals(testArmour, testInventory.getEquipment(0));
    }

    @Test
    void testGetEquipmentBigger() {
        testInventory.insertEquipment(testArmour);
        testInventory.insertEquipment(testArmour);
        testInventory.insertEquipment(testSword);
        testInventory.insertEquipment(testArmour);
        assertEquals(testSword, testInventory.getEquipment(2));
    }

    @Test
    void testGetSizeEmpty() {
        assertEquals(0, testInventory);
    }

    @Test
    void testGetSizeMultiple() {
        testInventory.insertEquipment(testArmour);
        assertEquals(1, testInventory.getSize());
        testInventory.insertEquipment(testArmour);
        assertEquals(2, testInventory.getSize());
    }
}
