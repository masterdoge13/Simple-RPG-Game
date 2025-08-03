package model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestEnemy {

    Difficulty testDifficulty;
    Enemy testEnemy;

    @BeforeEach
    void runBefore() {
        testDifficulty = new Difficulty();
        testEnemy = new Enemy("test", 10, 100, testDifficulty);
    }

    @Test
    void testConstructor() {
        assertEquals("test", testEnemy.getName());
        assertEquals(10, testEnemy.getAttack());
        assertEquals(100, testEnemy.getHealth());
        assertEquals(100, testEnemy.getExperienceGain());
        assertEquals(10, testEnemy.getGoldGain());
        assertEquals(testDifficulty, testEnemy.getDifficulty());
    }

    @Test
    void testGetName() {
        assertEquals("test", testEnemy.getName());
    }

    @Test
    void testGetAttack() {
        assertEquals(10, testEnemy.getAttack());
        testDifficulty.increaseDifficulty();
        testEnemy = new Enemy("test", 10, 100, testDifficulty);
        assertEquals(15, testEnemy.getAttack());
        testDifficulty.increaseDifficulty();
        testEnemy = new Enemy("test", 10, 100, testDifficulty);
        assertEquals(20, testEnemy.getAttack());
    }

    @Test
    void testGetMaxHealth() {
        assertEquals(100, testEnemy.getMaxHealth());
        testDifficulty.increaseDifficulty();
        testEnemy = new Enemy("test", 10, 100, testDifficulty);
        assertEquals(150, testEnemy.getMaxHealth());
        testDifficulty.increaseDifficulty();
        testEnemy = new Enemy("test", 10, 100, testDifficulty);
        assertEquals(200, testEnemy.getMaxHealth());
    }

    @Test
    void testGetHealth() {
        assertEquals(100, testEnemy.getHealth());
        testDifficulty.increaseDifficulty();
        testEnemy = new Enemy("test", 10, 100, testDifficulty);
        assertEquals(150, testEnemy.getHealth());
        testDifficulty.increaseDifficulty();
        testEnemy = new Enemy("test", 10, 100, testDifficulty);
        assertEquals(200, testEnemy.getHealth());
    }

    @Test
    void testGetExperienceGain() {
        assertEquals(100, testEnemy.getExperienceGain());
        testDifficulty.increaseDifficulty();
        assertEquals(150, testEnemy.getExperienceGain());
        testDifficulty.increaseDifficulty();
        assertEquals(200, testEnemy.getExperienceGain());
    }

    @Test
    void testGetGoldGain() {
        assertEquals(10, testEnemy.getGoldGain());
        testDifficulty.increaseDifficulty();
        assertEquals(15, testEnemy.getGoldGain());
        testDifficulty.increaseDifficulty();
        assertEquals(20, testEnemy.getGoldGain());
    }

    @Test
    void testGetDifficulty() {
        assertEquals(testDifficulty, testEnemy.getDifficulty());
        assertEquals(0, testEnemy.getDifficulty().getDifficulty());
        testDifficulty.increaseDifficulty();
        assertEquals(testDifficulty, testEnemy.getDifficulty());
        assertEquals(1, testEnemy.getDifficulty().getDifficulty());
        testDifficulty.increaseDifficulty();
        assertEquals(testDifficulty, testEnemy.getDifficulty());
        assertEquals(2, testEnemy.getDifficulty().getDifficulty());
    }
    @Test
    void testIsDead() {
        assertEquals(100, testEnemy.getHealth());
        assertFalse(testEnemy.isDead());
        testEnemy.takeDamage(99);
        assertEquals(1, testEnemy.getHealth());
        assertFalse(testEnemy.isDead());
        testEnemy.takeDamage(1);
        assertEquals(0, testEnemy.getHealth());
        assertTrue(testEnemy.isDead());
        testEnemy.takeDamage(1);
        assertEquals(-1, testEnemy.getHealth());
        assertTrue(testEnemy.isDead());
        testEnemy.takeDamage(99);
        assertEquals(-100, testEnemy.getHealth());
        assertTrue(testEnemy.isDead());
    }

    @Test
    void testTakeDamage() {
        assertEquals(100, testEnemy.getHealth());
        testEnemy.takeDamage(0);
        assertEquals(100, testEnemy.getHealth());
        testEnemy.takeDamage(1);
        assertEquals(99, testEnemy.getHealth());
        testEnemy.takeDamage(40);
        assertEquals(59, testEnemy.getHealth());
        testEnemy.takeDamage(59);
        assertEquals(0, testEnemy.getHealth());
        testEnemy.takeDamage(14);
        assertEquals(-14, testEnemy.getHealth());
    }
}
