package persistence;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import model.EquipmentType;
import model.Player;

// template taken from JsonSerializationDemo
public class TestJsonReader extends JsonTest{

    @Test
    void testReaderNonExistentFile() {
        JsonReader reader = new JsonReader("./data/noSuchFile.json");
        try {
            Player player = reader.read();
            fail("IOException expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testReaderTestPlayerEmpty() {
        JsonReader reader = new JsonReader("./data/testReaderPlayerEmpty.json");
        try {
            Player player = reader.read();
            assertEquals("test", player.getName());
            assertEquals(0, player.getInventory().getSize());
            checkEquipment(player.getEquipped().getArmour(), "unarmoured", 0, 0, EquipmentType.ARMOUR);
            checkEquipment(player.getEquipped().getSword(), "unarmed", 1, 0, EquipmentType.SWORD);
            assertEquals(0, player.getGold());
            assertEquals(0, player.getDifficulty().getDifficulty());
            assertEquals(0, player.getLevel());
            assertEquals(0, player.getExperience());
            assertEquals(0, player.getStatPoints());
            assertEquals(5, player.getAttack());
            assertEquals(100, player.getMaxHealth());
            assertEquals(100, player.getCurrentHealth());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    void testReaderTestPlayer() {
        JsonReader reader = new JsonReader("./data/testReaderPlayer.json");
        try {
            Player player = reader.read();
            assertEquals("john", player.getName());
            assertEquals(4, player.getInventory().getSize());
            checkEquipment(player.getEquipped().getArmour(), "test armour", 0, 0.2, EquipmentType.ARMOUR);
            checkEquipment(player.getEquipped().getSword(), "test sword", 1.5, 0, EquipmentType.SWORD);
            checkEquipment(player.getInventory().getEquipment(0), "test armour", 0, 0.2, EquipmentType.ARMOUR);
            checkEquipment(player.getInventory().getEquipment(1), "test sword", 1.5, 0, EquipmentType.SWORD);
            checkEquipment(player.getInventory().getEquipment(2), "unarmoured", 0, 0, EquipmentType.ARMOUR);
            checkEquipment(player.getInventory().getEquipment(3), "unarmed", 1, 0, EquipmentType.SWORD);
            assertEquals(10, player.getGold());
            assertEquals(1, player.getDifficulty().getDifficulty());
            assertEquals(2, player.getLevel());
            assertEquals(10, player.getExperience());
            assertEquals(5, player.getStatPoints());
            assertEquals(17, player.getAttack());
            assertEquals(110, player.getMaxHealth());
            assertEquals(110, player.getCurrentHealth());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }
}
