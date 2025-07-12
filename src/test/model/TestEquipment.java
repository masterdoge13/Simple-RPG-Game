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
        assertEquals(1.5, testSword.getAttackMod(), 0.001);
        assertEquals(0.0, testSword.getDefenseMod(), 0.001);
        assertEquals(EquipmentType.SWORD, testSword.getType());
        assertEquals(0, testSword.getUpgradeNum());
    }

    @Test
    void testConstructorArmour() {
        assertEquals("test armour", testArmour.getName());
        assertEquals(0.0, testArmour.getAttackMod(), 0.001);
        assertEquals(0.2, testArmour.getDefenseMod(), 0.001);
        assertEquals(EquipmentType.ARMOUR, testArmour.getType());
        assertEquals(0, testArmour.getUpgradeNum());
    }

    @Test
    void testIncrementUpgradeSword() {
        testSword.incrementUpgrade();
        assertEquals(1.6, testSword.getAttackMod(), 0.001);
        assertEquals(0.01, testSword.getDefenseMod(), 0.001);
        assertEquals(1, testSword.getUpgradeNum());
    }

    @Test
    void testIncrementUpgradeSwordMultiple() {
        testSword.incrementUpgrade();
        assertEquals(1.6, testSword.getAttackMod(), 0.001);
        assertEquals(0.01, testSword.getDefenseMod(), 0.001);
        assertEquals(1, testSword.getUpgradeNum());
        testSword.incrementUpgrade();
        assertEquals(1.7, testSword.getAttackMod(), 0.001);
        assertEquals(0.02, testSword.getDefenseMod(), 0.001);
        assertEquals(2, testSword.getUpgradeNum());
    }

    @Test
    void testIncrementUpgradeSwordMax() {
        testSword.incrementUpgrade();
        testSword.incrementUpgrade();
        testSword.incrementUpgrade();
        testSword.incrementUpgrade();
        testSword.incrementUpgrade();
        assertEquals(2.0, testSword.getAttackMod(), 0.001);
        assertEquals(0.05, testSword.getDefenseMod(), 0.001);
        assertEquals(5, testSword.getUpgradeNum());
    }

    @Test
    void testIncrementUpgradeSwordOverMax() {
        testSword.incrementUpgrade();
        testSword.incrementUpgrade();
        testSword.incrementUpgrade();
        testSword.incrementUpgrade();
        testSword.incrementUpgrade();
        testSword.incrementUpgrade();
        assertEquals(2.0, testSword.getAttackMod(), 0.001);
        assertEquals(0.05, testSword.getDefenseMod(), 0.001);
        assertEquals(5, testSword.getUpgradeNum());
    }

    @Test
    void testIncrementUpgradeArmour() {
        testArmour.incrementUpgrade();
        assertEquals(0.1, testArmour.getAttackMod(), 0.001);
        assertEquals(0.21, testArmour.getDefenseMod(), 0.001);
        assertEquals(1, testArmour.getUpgradeNum());
    }

    @Test
    void testIncrementUpgradeArmourMultiple() {
        testArmour.incrementUpgrade();
        assertEquals(0.1, testArmour.getAttackMod(), 0.001);
        assertEquals(0.21, testArmour.getDefenseMod(), 0.001);
        assertEquals(1, testArmour.getUpgradeNum());
        testArmour.incrementUpgrade();
        assertEquals(0.2, testArmour.getAttackMod(), 0.001);
        assertEquals(0.22, testArmour.getDefenseMod(), 0.001);
        assertEquals(2, testArmour.getUpgradeNum());
    }

    @Test
    void testIncrementUpgradeArmourMax() {
        testArmour.incrementUpgrade();
        testArmour.incrementUpgrade();
        testArmour.incrementUpgrade();
        testArmour.incrementUpgrade();
        testArmour.incrementUpgrade();
        assertEquals(0.5, testArmour.getAttackMod(), 0.001);
        assertEquals(0.25, testArmour.getDefenseMod(), 0.001);
        assertEquals(5, testArmour.getUpgradeNum());
    }

    @Test
    void testIncrementUpgradeArmourOverMax() {
        testArmour.incrementUpgrade();
        testArmour.incrementUpgrade();
        testArmour.incrementUpgrade();
        testArmour.incrementUpgrade();
        testArmour.incrementUpgrade();
        testArmour.incrementUpgrade();
        assertEquals(0.5, testArmour.getAttackMod(), 0.001);
        assertEquals(0.25, testArmour.getDefenseMod(), 0.001);
        assertEquals(5, testArmour.getUpgradeNum());
    }

    @Test
    void testEquipmentToStringSword() {
        assertEquals("[test sword] +0 Sword - Attack increase 1.5x - Damage reduction 0.0%", 
        testSword.equipmentToString());
    }

    @Test
    void testEquipmentToStringArmour() {
        assertEquals("[test armour] +0 Armour - Attack increase 0.0x - Damage reduction 20.0%", 
        testArmour.equipmentToString());
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
        assertEquals(1.5, testSword.getAttackMod(), 0.001);
    }

    @Test
    void testGetAttackModArmour() {
        assertEquals(0.0, testArmour.getAttackMod(), 0.001);
    }

    @Test
    void testGetDefenseModSword() {
        assertEquals(0.0, testSword.getDefenseMod(), 0.001);
    }

    @Test
    void testGetDefenseModArmour() {
        assertEquals(0.2, testArmour.getDefenseMod(), 0.001);
    }

    @Test
    void testGetEquipmentTypeSword() {
        assertEquals(EquipmentType.SWORD, testSword.getType());
    }

    @Test
    void testGetEquipmentTypeArmour() {
        assertEquals(EquipmentType.ARMOUR, testArmour.getType());
    }

    @Test
    void testGetUpgradeNumSword() {
        assertEquals(0, testSword.getUpgradeNum());
    }

    @Test
    void testGetUpgradeNumArmour() {
        assertEquals(0, testArmour.getUpgradeNum());
    }

}
