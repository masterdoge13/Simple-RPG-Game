package model;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestPlayer {
    private Player testPlayer;
    @BeforeEach
    void runBefore() {
        testPlayer = new Player("test", 5, 100);
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

}
