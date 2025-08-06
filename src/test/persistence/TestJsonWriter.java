package persistence;

import model.Player;
import model.Equipment;
import model.EquipmentType;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

// template taken from JsonSerializationDemo
// Tests for JsonWriter class
class TestJsonWriter extends JsonTest {

    @Test
    void testWriterInvalidFile() {
        try {
            Player player = new Player("test", 5, 100);
            JsonWriter writer = new JsonWriter("./data/my\0illegal:fileName.json");
            writer.open();
            fail("IOException was expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testWriterTestPlayerEmpty() {
        try {
            Player player = new Player("test", 5, 100);
            JsonWriter writer = new JsonWriter("./data/testWriterPlayerEmpty.json");
            writer.open();
            writer.write(player);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterPlayerEmpty.json");
            player = reader.read();
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
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void testWriterTestPlayer() {
        Equipment testArmour = new Equipment("test armour", 0, 0.2, EquipmentType.ARMOUR);
        Equipment testSword = new Equipment("test sword", 1.5, 0, EquipmentType.SWORD);
        try {
            Player player = new Player("john", 5, 100);
            player.increaseAttack();
            player.increaseAttack();
            player.increaseAttack();
            player.increaseAttack();
            player.increaseMaxHealth();
            player.increaseExperience(210);
            player.increaseGold(10);
            player.getDifficulty().increaseDifficulty();
            player.getInventory().insertEquipment(testArmour);
            player.getInventory().insertEquipment(testSword);
            player.getEquipped().equip(testArmour, player.getInventory());
            player.getEquipped().equip(testSword, player.getInventory());
            JsonWriter writer = new JsonWriter("./data/testWriterPlayer.json");
            writer.open();
            writer.write(player);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterPlayer.json");
            player = reader.read();
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
            fail("Exception should not have been thrown");
        }
    }
}
