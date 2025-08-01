package ui;

import java.util.Scanner;
import model.Equipment;
import model.EquipmentType;
import model.Player;
import persistence.JsonReader;
import persistence.JsonWriter;

// Menu screen for managing player stats and equipment
public class GameMenu {

    private static final int BASE_ATTACK = 5;
    private static final int BASE_HEALTH = 100;
    private static final int STARTING_STAT_POINTS = 5;
    private static final int EQUIPMENT_PRICE = 20;
    private static final double SWORD_BASE_LOWER_RANGE = 1.0;
    private static final double SWORD_BASE_UPPER_RANGE = 3.0;
    private static final double ARMOUR_BASE_LOWER_RANGE = 0.1;
    private static final double ARMOUR_BASE_UPPER_RANGE = 0.45;
    private static final String SAVE_FILE = "./data/playerData.json";
    
    private JsonReader jsonReader;
    private JsonWriter jsonWriter;
    private Scanner input;
    private Player player;

    // EFFECTS: runs the game menu
    public GameMenu() {
        runGameMenu();
    }

    // MODIFIES: this
    // EFFECTS: processes user input
    private void runGameMenu() {
        // taken from runTeller() method in TellerApp class in TellerApp
        boolean keepGoing = true;
        String command = null;

        init();

        while (keepGoing) {
            displayMainMenu();
            command = input.next();
            command = command.toLowerCase();

            if (command.equals("q")) {
                keepGoing = false;
            } else {
                processCommandMain(command);
            }
        }

        System.out.println("\nBe seeing you, " + player.getName() + ".");
    }

    // MODIFIES: this
    // EFFECTS: initializes game data, takes input for player name
    private void init() {
        String name;
        // taken from init() method in TellerApp class in TellerApp
        input = new Scanner(System.in);
        input.useDelimiter("\r?\n|\r");
        System.out.println("What is your name?\n");
        name = input.next();
        player = new Player(name, BASE_ATTACK, BASE_HEALTH);
        player.increaseStatPoints(STARTING_STAT_POINTS);
        jsonReader = new JsonReader(SAVE_FILE);
        jsonWriter = new JsonWriter(SAVE_FILE);
    }

    // EFFECTS: processes user command in main menu
    private void processCommandMain(String command) {
        if (command.equals("ne")) {
            addNewEquipment();
        } else if (command.equals("vi")) {
            System.out.println(player.getInventory().inventoryToString());
        } else if (command.equals("st")) {
            upgradeBaseStats();
        } else if (command.equals("ee")) {
            equipEquipment();
        } else if (command.equals("l")) {
            loadSave();
        } else if (command.equals("s")) {
            overwriteSave();
        } else if (command.equals("f")) {
            new Combat(player);
        } else {
            System.out.println("Command not found\n\n");
        }
    }

    // EFFECTS: displays main menu options
    private void displayMainMenu() {
        System.out.println("\nMain Menu:\n");
        System.out.println("\tne -> buy new equipment");
        System.out.println("\tvi -> view inventory");
        System.out.println("\tst -> stat upgrades");
        System.out.println("\tee -> equip equipment");
        System.out.println("\tf -> fight");
        System.out.println("\tl -> load previous data");
        System.out.println("\ts -> save and overwrite previous data");
        System.out.println("\tq -> quit");
    }

    // MODIFIES: this
    // EFFECTS: adds new equipment to the inventory if player has enough gold
    private void addNewEquipment() {
        if (player.getGold() < EQUIPMENT_PRICE) {
            System.out.println("You are broke, fight some more before coming back");
        } else {
            String command = null;
            String name = null;
            System.out.println("\nName your equipment:\n");
            name = input.next();
            displayNewEquipmentMenu();
            command = input.next();
            command = command.toLowerCase();
            if (command.equals("s") || command.equals("a")) {
                Equipment newEquipment = selectEquipment(command, name);
                player.getInventory().insertEquipment(newEquipment);
                System.out.println("Added:\n" + newEquipment.equipmentToString());
                player.decreaseGold(EQUIPMENT_PRICE);
            } else {
                System.out.println("Command not found");
            }
        }
    }

    // EFFECTS: makes an equipment to add
    private Equipment selectEquipment(String command, String name) {
        Equipment newEquipment = null;
        double baseModifier = 0;
        if (command.equals("s")) {
            baseModifier = Math.random() * (SWORD_BASE_UPPER_RANGE - SWORD_BASE_LOWER_RANGE) + SWORD_BASE_LOWER_RANGE;
            newEquipment = new Equipment(name, baseModifier * player.getDifficulty().getEquipmentAttackMod(), 0.0,
                    EquipmentType.SWORD);
        } else if (command.equals("a")) {
            baseModifier = Math.random() * (ARMOUR_BASE_UPPER_RANGE - ARMOUR_BASE_LOWER_RANGE)
                    + ARMOUR_BASE_LOWER_RANGE;
            newEquipment = new Equipment(name, 0.0, baseModifier * player.getDifficulty().getEquipmentDefenseMod(),
                    EquipmentType.ARMOUR);
        }
        return newEquipment; // stub
    }

    // EFFECTS: displays menu options for adding new equipment
    private void displayNewEquipmentMenu() {
        System.out.println("\nBuy Equipment:\n");
        System.out.println("\ts -> Sword");
        System.out.println("\ta -> Armour");
    }

    // MODIFIES: this
    // EFFECTS: upgrade base stats using stat points
    private void upgradeBaseStats() {
        String command = null;
        if (player.getStatPoints() > 0) {
            System.out.println("Free stat points: " + player.getStatPoints());
            displayStatUpgradeMenu();
            command = input.next();
            command = command.toLowerCase();
            if (command.equals("atk")) {
                player.increaseAttack();
            } else if (command.equals("hp")) {
                player.increaseMaxHealth();
            } else {
                System.out.println("Command not found");
            }
        } else {
            System.out.println("No free stat points\n");
        }
        System.out.println(player.getName() + ":\nAttack: " + player.getAttack()
                + "\nMax Health: " + player.getMaxHealth());
    }

    // EFFECTS: displays menu options for upgrading stats
    private void displayStatUpgradeMenu() {
        System.out.println("\nStat Upgrade:\n");
        System.out.println("\tatk -> Base Attack +3");
        System.out.println("\thp -> Base Health +10");
    }

    // MODIFIES: this
    // EFFECTS: equips chosen equipment from player.getInventory() and removes it
    // from inventory
    private void equipEquipment() {
        String command = null;
        int equipIndex = 0;
        System.out.println(player.getInventory().inventoryToString());
        System.out.println("\nType index of desired equipment");
        command = input.next();
        equipIndex = Integer.parseInt(command);
        if (equipIndex < 0) {
            System.out.println("Please put a non-negative integer");
        } else if (player.getInventory().getSize() <= equipIndex) {
            System.out.println("Please choose an index in your inventory");
        } else {
            player.getEquipped().equip(player.getInventory().getEquipment(equipIndex), player.getInventory());
            player.getInventory().removeEquipment(equipIndex);

        }
        System.out.println(player.getEquipped().equippedToString());
    }

    // EFFECTS: saves player to file
    private void overwriteSave() {
        try {
            jsonWriter.open();
            jsonWriter.write(player);
            jsonWriter.close();
            System.out.println("Saved player " + player.getName() + " to " + SAVE_FILE);
        } catch (Exception e) {
            System.out.println("Failed to save");
        }
    }
    
    // MODIFIES: this
    // EFFECTS: loads player from file
    private void loadSave() {
        try {
            player = jsonReader.read();
            System.out.println("Loaded player " + player.getName() + " from " + SAVE_FILE);
        } catch (Exception e) {
            System.out.println("Failed to load");
        }
    }
}
