package ui;

import java.util.Scanner;
import model.Equipment;
import model.EquipmentType;
import model.Equipped;
import model.Inventory;
import model.Player;

// Menu screen for managing player stats and equipment
public class GameMenu {

    private static final int BASE_ATTACK = 5;
    private static final int BASE_HEALTH = 100;
    private static final int STARTING_STAT_POINTS = 5;
    private Player player;
    private Inventory inventory;
    private Equipped equipped;
    private Scanner input;

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
        inventory = new Inventory();
        equipped = new Equipped();
        String name;
        // taken from init() method in TellerApp class in TellerApp
        input = new Scanner(System.in);
        input.useDelimiter("\r?\n|\r");
        System.out.println("What is your name?\n");
        name = input.next();
        player = new Player(name, BASE_ATTACK, BASE_HEALTH);
        player.increaseStatPoints(STARTING_STAT_POINTS);
    }

    // EFFECTS: processes user command in main menu
    private void processCommandMain(String command) {
        if (command.equals("ne")) {
            addNewEquipment();
        } else if (command.equals("vi")) {
            System.out.println(inventory.inventoryToString());
        } else if (command.equals("st")) {
            upgradeBaseStats();
        } else if (command.equals("ee")) {
            equipEquipment();
        } else {
            System.out.println("Command not found\n\n");
        }
    }

    // EFFECTS: displays main menu options
    private void displayMainMenu() {
        System.out.println("\nMain Menu:\n");
        System.out.println("\tne -> add new equipment");
        System.out.println("\tvi -> view inventory");
        System.out.println("\tst -> stat upgrades");
        System.out.println("\tee -> equip equipment");
        System.out.println("\tq -> quit");
    }

    // MODIFIES: this
    // EFFECTS: adds new equipment to the inventory
    private void addNewEquipment() {
        String command = null;
        String name = null;
        System.out.println("\nName your equipment:\n");
        name = input.next();
        displayNewEquipmentMenu();
        command = input.next();
        command = command.toLowerCase();
        if (command.equals("s") || command.equals("a")) {
            Equipment newEquipment = selectEquipment(command, name);
            inventory.insertEquipment(newEquipment);
            System.out.println("Added:\n" + newEquipment.equipmentToString());
        } else {
            System.out.println("Command not found");
        }

    }

    // EFFECTS: makes an equipment to add
    private Equipment selectEquipment(String command, String name) {
        Equipment newEquipment = null;
        if (command.equals("s")) {
            newEquipment = new Equipment(name, 1.5, 0.0, EquipmentType.SWORD);
        } else if (command.equals("a")) {
            newEquipment = new Equipment(name, 0.0, 0.2, EquipmentType.ARMOUR);
        }
        return newEquipment; // stub
    }

    // EFFECTS: displays menu options for adding new equipment
    private void displayNewEquipmentMenu() {
        System.out.println("\nMake Equipment:\n");
        System.out.println("\ts -> Sword");
        System.out.println("\ta -> Armour");
    }

    // MODIFIES: this
    // EFFECTS: upgrade base stats using stat points
    private void upgradeBaseStats() {
        String command = null;
        if (player.getStatPoints() > 0) {
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
    // EFFECTS: equips chosen equipment from inventory and removes it from inventory
    private void equipEquipment() {
        String command = null;
        int equipIndex = 0;
        System.out.println(inventory.inventoryToString());
        System.out.println("\nType index of desired equipment");
        command = input.next();
        equipIndex = Integer.parseInt(command);
        if (equipIndex < 0) {
            System.out.println("Please put a non-negative integer");
        } else if (inventory.getSize() <= equipIndex) {
            System.out.println("Please choose an index in your inventory");
        } else {
            equipped.equip(inventory.getEquipment(equipIndex), inventory);
            inventory.removeEquipment(equipIndex);
            
        }
        System.out.println(equipped.equippedToString());
    }
}
