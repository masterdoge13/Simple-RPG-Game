package persistence;

import model.Player;
import model.Equipment;
import model.EquipmentType;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import org.json.*;

// template taken from JsonSerializationDemo
// Represents a reader that reads player from JSON data stored in file
public class JsonReader {
    private String source;

    // EFFECTS: constructs reader to read from source file
    public JsonReader(String source) {
        this.source = source;
    }

    // EFFECTS: reads player from file and returns it;
    // throws IOException if an error occurs reading data from file
    public Player read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parsePlayer(jsonObject);
    }

    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }

    // EFFECTS: parses player from JSON object and returns it
    private Player parsePlayer(JSONObject jsonObject) {
        String name = jsonObject.getString("name");
        int attack = jsonObject.getInt("attack");
        int health = jsonObject.getInt("maxHealth");
        Player player = new Player(name, attack, health);
        int gold = jsonObject.getInt("gold");
        player.getDifficulty().setDifficulty(jsonObject.getInt("difficulty"));
        int statPoints = jsonObject.getInt("statPoints");
        int level = jsonObject.getInt("level");
        int experience = jsonObject.getInt("experience");
        player.increaseGold(gold);
        player.increaseStatPoints(statPoints);
        player.setLevel(level);
        player.increaseExperience(experience);
        addInventoryEquipment(player, jsonObject.getJSONObject("inventory"));
        addEquipped(player, jsonObject.getJSONObject("equipped"));
        return player;
    }

    // MODIFIES: player
    // EFFECTS: parses inventory from JSON object and adds them to player
    private void addInventoryEquipment(Player player, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("inventoryArray");
        for (Object json : jsonArray) {
            JSONObject nextEquipment = (JSONObject) json;
            player.getInventory().insertEquipment(readEquipment(nextEquipment));
        }
    }

    // EFFECTS: parses equipment from JSON object and returns the equipment
    private Equipment readEquipment(JSONObject jsonObject) {
        String name = jsonObject.getString("name");
        double defenseMod = jsonObject.getDouble("defenseMod");
        double attackMod = jsonObject.getDouble("attackMod");
        int upgradeNum = jsonObject.getInt("upgradeNum");
        EquipmentType type = EquipmentType.valueOf(jsonObject.getString("type"));
        Equipment equipment = new Equipment(name, attackMod, defenseMod, type);
        equipment.setUpgradeNum(upgradeNum);
        return equipment;
    }

    // MODIFIES: player
    // EFFECTS: parses equipped from JSON object and adds it to player equipped
    private void addEquipped(Player player, JSONObject jsonObject) {
        Equipment sword = readEquipment(jsonObject.getJSONObject("equippedSword"));
        Equipment armour = readEquipment(jsonObject.getJSONObject("equippedArmour"));
        player.getEquipped().setEquipment(armour);
        player.getEquipped().setEquipment(sword);
    }

    
}