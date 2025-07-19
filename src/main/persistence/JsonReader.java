package persistence;

import model.Player;
import model.Inventory;
import model.Equipped;
import model.Equipment;
import model.EquipmentType;
import model.Difficulty;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import org.json.*;

// template taken from JsonSerializationDemo
// Represents a reader that reads player from JSON data stored in file
public class JsonReader {

    // EFFECTS: constructs reader to read from source file
    public JsonReader(String source) {
        //stub TODO
    }

    // EFFECTS: reads player from file and returns it;
    // throws IOException if an error occurs reading data from file
    public Player read() throws IOException {
        return new Player(null, 0, 0);//stub TODO
    }

    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        return "";//stub TODO
    }

    // EFFECTS: parses player from JSON object and returns it
    private Player parsePlayer(JSONObject jsonObject) {
        return new Player(null, 0, 0);//stub TODO
    }

    // MODIFIES: p
    // EFFECTS: parses inventory from JSON object and adds them to player
    private void addInventory(Player p, JSONObject jsonObject) {
        //stub TODO
    }

    // MODIFIES: p
    // EFFECTS: parses equipment from JSON object and adds it to player
    private void addEquipment(Player p, JSONObject jsonObject) {
        //stub TODO
    }

    // MODIFIES: p
    // EFFECTS: parses equipped from JSON object and adds it to player equipped
    private void addEquipped(Player p, JSONObject jsonObject) {
        //stub TODO
    }

    // MODIFIES: p
    // EFFECTS: parses difficulty from JSON object and adds it to player equipped
    private void addDifficulty(Player p, JSONObject jsonObject) {
        //stub TODO
    }
}