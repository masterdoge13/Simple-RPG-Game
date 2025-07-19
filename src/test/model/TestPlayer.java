package model;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestPlayer {
    private Player testPlayer;
    private Equipment testSword;
    private Equipment testArmour;
    private Equipment defaultSword;
    private Equipment defaultArmour;
    @BeforeEach
    void runBefore() {
        testPlayer = new Player("test", 5, 100);
        testSword = new Equipment("test sword", 1.5, 0.1, EquipmentType.SWORD);
        testArmour = new Equipment("test armour", 0.1, 0.2, EquipmentType.ARMOUR);
        defaultSword = new Equipment("unarmed", 0, 0, EquipmentType.SWORD);
        defaultArmour = new Equipment("unarmoured", 0, 0, EquipmentType.ARMOUR);
    }

    @Test
    void testConstructor() {
        assertEquals("test", testPlayer.getName());
        assertEquals(5, testPlayer.getAttack());
        assertEquals(100, testPlayer.getMaxHealth());
        assertEquals(100, testPlayer.getCurrentHealth());
        assertEquals(0, testPlayer.getLevel());
        assertEquals(0, testPlayer.getExperience());
        assertEquals(0, testPlayer.getStatPoints());
        assertEquals(0, testPlayer.getGold());
    }

    @Test
    void testIncreaseMaxHealth() {
        testPlayer.increaseStatPoints(5);
        testPlayer.increaseMaxHealth();
        assertEquals(110, testPlayer.getMaxHealth());
        assertEquals(110, testPlayer.getCurrentHealth());
        assertEquals(4, testPlayer.getStatPoints());
    }

    @Test
    void testIncreaseMaxHealthAllPoints() {
        testPlayer.increaseStatPoints(1);
        testPlayer.increaseMaxHealth();
        assertEquals(110, testPlayer.getMaxHealth());
        assertEquals(110, testPlayer.getCurrentHealth());
        assertEquals(0, testPlayer.getStatPoints());
    }

    @Test
    void testIncreaseMaxHealthMultiple() {
        testPlayer.increaseStatPoints(5);
        testPlayer.increaseMaxHealth();
        assertEquals(110, testPlayer.getMaxHealth());
        assertEquals(110, testPlayer.getCurrentHealth());
        assertEquals(4, testPlayer.getStatPoints());
        testPlayer.increaseMaxHealth();
        assertEquals(120, testPlayer.getMaxHealth());
        assertEquals(120, testPlayer.getCurrentHealth());
        assertEquals(3, testPlayer.getStatPoints());
    }

    @Test
    void testFullHeal() {
        testPlayer.takeDamage(5);
        testPlayer.fullHeal();
        assertEquals(100, testPlayer.getCurrentHealth());
    }

    @Test
    void testFullHealWithMoreDamage() {
        testPlayer.takeDamage(5);
        testPlayer.takeDamage(43);
        testPlayer.fullHeal();
        assertEquals(100, testPlayer.getCurrentHealth());
    }

    @Test
    void testFullHealWithMaxHealthChange() {
        testPlayer.takeDamage(5);
        testPlayer.increaseStatPoints(5);
        testPlayer.increaseMaxHealth();
        testPlayer.takeDamage(43);
        testPlayer.fullHeal();
        assertEquals(110, testPlayer.getCurrentHealth());
    }

    @Test
    void testHealHealth() {
        testPlayer.takeDamage(5);
        testPlayer.healHealth(4);
        assertEquals(99, testPlayer.getCurrentHealth());
    }

    @Test
    void testHealHealthMultiple() {
        testPlayer.takeDamage(10);
        testPlayer.healHealth(4);
        assertEquals(94, testPlayer.getCurrentHealth());
        testPlayer.healHealth(5);
        assertEquals(99, testPlayer.getCurrentHealth());
    }

    @Test
    void testHealHealthAtMax() {
        testPlayer.takeDamage(10);
        testPlayer.healHealth(10);
        assertEquals(100, testPlayer.getCurrentHealth());
    }

    @Test
    void testHealHealthOverMax() {
        testPlayer.takeDamage(10);
        testPlayer.healHealth(11);
        assertEquals(100, testPlayer.getCurrentHealth());
    }

    @Test
    void testTakeDamage() {
        testPlayer.takeDamage(99);
        assertEquals(1, testPlayer.getCurrentHealth());
    }

    @Test
    void testTakeDamageMultiple() {
        testPlayer.takeDamage(50);
        assertEquals(50, testPlayer.getCurrentHealth());
        testPlayer.takeDamage(49);
        assertEquals(1, testPlayer.getCurrentHealth());
    }

    @Test
    void testTakeDamageToZero() {
        testPlayer.takeDamage(100);
        assertEquals(0, testPlayer.getCurrentHealth());
    }

    @Test
    void testTakeDamageToUnderZero() {
        testPlayer.takeDamage(101);
        assertEquals(0, testPlayer.getCurrentHealth());
    }

    @Test
    void testIncreaseAttack() {
        testPlayer.increaseStatPoints(5);
        testPlayer.increaseAttack();
        assertEquals(8, testPlayer.getAttack());
        assertEquals(4, testPlayer.getStatPoints());
    }

    @Test
    void testIncreaseAttackAllPoints() {
        testPlayer.increaseStatPoints(1);
        testPlayer.increaseAttack();
        assertEquals(8, testPlayer.getAttack());
        assertEquals(0, testPlayer.getStatPoints());
    }

    @Test
    void testIncreaseAttackMultiple() {
        testPlayer.increaseStatPoints(5);
        testPlayer.increaseAttack();
        assertEquals(8, testPlayer.getAttack());
        assertEquals(4, testPlayer.getStatPoints());
        testPlayer.increaseAttack();
        assertEquals(11, testPlayer.getAttack());
        assertEquals(3, testPlayer.getStatPoints());
    }

    @Test
    void testIncreaseLevel() {
        testPlayer.increaseLevel();
        assertEquals(1, testPlayer.getLevel());
        assertEquals(5, testPlayer.getStatPoints());
    }

    @Test
    void testIncreaseLevelMultiple() {
        testPlayer.increaseLevel();
        assertEquals(1, testPlayer.getLevel());
        assertEquals(5, testPlayer.getStatPoints());
        testPlayer.increaseLevel();
        assertEquals(2, testPlayer.getLevel());
        assertEquals(10, testPlayer.getStatPoints());
    }

    @Test
    void testIncreaseExperience() {
        testPlayer.increaseExperience(5);
        assertEquals(5, testPlayer.getExperience());
    }

    @Test
    void testIncreaseExperienceMultiple() {
        testPlayer.increaseExperience(5);
        assertEquals(5, testPlayer.getExperience());
        testPlayer.increaseExperience(9);
        assertEquals(14, testPlayer.getExperience());
    }

    @Test
    void testIncreaseExperiencePastThreshold() {
        testPlayer.increaseExperience(99);
        assertEquals(99, testPlayer.getExperience());
        testPlayer.increaseExperience(1);
        assertEquals(1, testPlayer.getLevel());
        assertEquals(5, testPlayer.getStatPoints());
        assertEquals(0, testPlayer.getExperience());
        testPlayer.increaseExperience(1);
        assertEquals(1, testPlayer.getLevel());
        assertEquals(5, testPlayer.getStatPoints());
        assertEquals(1, testPlayer.getExperience());
    }

    @Test
    void testIncreaseExperienceTriplePastThreshold() {
        testPlayer.increaseExperience(300);
        assertEquals(0, testPlayer.getExperience());
        assertEquals(3, testPlayer.getLevel());
        assertEquals(15, testPlayer.getStatPoints());
    }

    @Test
    void testIncreaseExperiencePastThresholdMultiple() {
        testPlayer.increaseExperience(140);
        assertEquals(40, testPlayer.getExperience());
        assertEquals(1, testPlayer.getLevel());
        assertEquals(5, testPlayer.getStatPoints());
        testPlayer.increaseExperience(80);
        assertEquals(20, testPlayer.getExperience());
        assertEquals(2, testPlayer.getLevel());
        assertEquals(10, testPlayer.getStatPoints());
        testPlayer.increaseExperience(110);
        assertEquals(30, testPlayer.getExperience());
        assertEquals(3, testPlayer.getLevel());
        assertEquals(15, testPlayer.getStatPoints());
    }

    @Test
    void testIncreaseExperiencePastThresholdMultipleUseStat() {
        testPlayer.increaseExperience(140);
        assertEquals(40, testPlayer.getExperience());
        assertEquals(1, testPlayer.getLevel());
        testPlayer.increaseAttack();
        assertEquals(4, testPlayer.getStatPoints());
        testPlayer.increaseExperience(80);
        assertEquals(20, testPlayer.getExperience());
        assertEquals(2, testPlayer.getLevel());
        testPlayer.increaseMaxHealth();
        testPlayer.increaseMaxHealth();
        assertEquals(7, testPlayer.getStatPoints());
        testPlayer.increaseExperience(110);
        assertEquals(30, testPlayer.getExperience());
        assertEquals(3, testPlayer.getLevel());
        assertEquals(12, testPlayer.getStatPoints());
        testPlayer.increaseAttack();
        testPlayer.increaseAttack();
        testPlayer.increaseAttack();
        assertEquals(9, testPlayer.getStatPoints());
    }
    
    @Test
    void testIncreaseStatPoints() {
        testPlayer.increaseStatPoints(1);
        assertEquals(1, testPlayer.getStatPoints());
    }

    @Test
    void testIncreaseStatPointsMultiple() {
        testPlayer.increaseStatPoints(1);
        assertEquals(1, testPlayer.getStatPoints());
        testPlayer.increaseStatPoints(5);
        assertEquals(6, testPlayer.getStatPoints());
    }

    @Test
    void testIncreaseGold() {
        testPlayer.increaseGold(10);
        assertEquals(10, testPlayer.getGold());
    }

    @Test
    void testIncreaseGoldMultiple() {
        testPlayer.increaseGold(9);
        assertEquals(9, testPlayer.getGold());
        testPlayer.increaseGold(21);
        assertEquals(30, testPlayer.getGold());
        testPlayer.increaseGold(92);
        assertEquals(122, testPlayer.getGold());
        testPlayer.increaseGold(23);
        assertEquals(145, testPlayer.getGold());
    }

    @Test
    void testDecreaseGold() {
        testPlayer.increaseGold(1000000);
        assertEquals(1000000, testPlayer.getGold());
        testPlayer.decreaseGold(10);
        assertEquals(999990, testPlayer.getGold());
    }

    @Test
    void testDecreaseGoldMultiple() {
        testPlayer.increaseGold(100000);
        assertEquals(100000, testPlayer.getGold());
        testPlayer.decreaseGold(10);
        assertEquals(99990, testPlayer.getGold());
        testPlayer.decreaseGold(10);
        assertEquals(99980, testPlayer.getGold());
        testPlayer.decreaseGold(10);
        assertEquals(99970, testPlayer.getGold());
        testPlayer.decreaseGold(10);
        assertEquals(99960, testPlayer.getGold());
        testPlayer.decreaseGold(99910);
        assertEquals(50, testPlayer.getGold());
        testPlayer.decreaseGold(49);
        assertEquals(1, testPlayer.getGold());
        testPlayer.decreaseGold(1);
        assertEquals(0, testPlayer.getGold());
    }

    @Test
    void testSetLevel() {
        assertEquals(0, testPlayer.getLevel());
        testPlayer.setLevel(5);
        assertEquals(5, testPlayer.getLevel());
        testPlayer.setLevel(5);
        assertEquals(5, testPlayer.getLevel());
        testPlayer.setLevel(2);
        assertEquals(2, testPlayer.getLevel());
        testPlayer.setLevel(15);
        assertEquals(15, testPlayer.getLevel());
        testPlayer.setLevel(7);
        assertEquals(7, testPlayer.getLevel());
    }

    @Test
    void testGetDifficulty() {
        assertEquals(0, testPlayer.getDifficulty().getDifficulty());
        testPlayer.getDifficulty().increaseDifficulty();
        assertEquals(1, testPlayer.getDifficulty().getDifficulty());
        testPlayer.getDifficulty().increaseDifficulty();
        assertEquals(2, testPlayer.getDifficulty().getDifficulty());
        testPlayer.getDifficulty().setDifficulty(6);
        assertEquals(6, testPlayer.getDifficulty().getDifficulty());
        testPlayer.getDifficulty().increaseDifficulty();
        assertEquals(7, testPlayer.getDifficulty().getDifficulty());
        testPlayer.getDifficulty().setDifficulty(0);
        assertEquals(0, testPlayer.getDifficulty().getDifficulty());
    }

    @Test
    void testGetEquipped() {
        assertEquals(defaultArmour.getName(), testPlayer.getEquipped().getArmour().getName());
        assertEquals(defaultSword.getName(), testPlayer.getEquipped().getSword().getName());
        testPlayer.getEquipped().setEquipment(testArmour);
        assertEquals(testArmour.getName(), testPlayer.getEquipped().getArmour().getName());
        assertEquals(defaultSword.getName(), testPlayer.getEquipped().getSword().getName());
        testPlayer.getEquipped().setEquipment(testSword);
        assertEquals(testArmour.getName(), testPlayer.getEquipped().getArmour().getName());
        assertEquals(testSword.getName(), testPlayer.getEquipped().getSword().getName());
    }

    @Test
    void testGetInventory() {
        assertEquals(0, testPlayer.getInventory().getSize());
        testPlayer.getInventory().insertEquipment(defaultArmour);
        assertEquals(1, testPlayer.getInventory().getSize());
        assertEquals(defaultArmour, testPlayer.getInventory().getEquipment(0));
        testPlayer.getInventory().insertEquipment(defaultSword);
        assertEquals(2, testPlayer.getInventory().getSize());
        assertEquals(defaultSword, testPlayer.getInventory().getEquipment(1));
        testPlayer.getInventory().insertEquipment(testArmour);
        assertEquals(3, testPlayer.getInventory().getSize());
        assertEquals(testArmour, testPlayer.getInventory().getEquipment(2));
        testPlayer.getInventory().insertEquipment(testSword);
        assertEquals(4, testPlayer.getInventory().getSize());
        assertEquals(testSword, testPlayer.getInventory().getEquipment(3));
    }
}
