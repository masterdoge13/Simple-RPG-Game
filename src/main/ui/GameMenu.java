package ui;
import java.util.Scanner;
import model.Equipment;
import model.EquipmentType;
import model.Equipped;
import model.Inventory;
import model.Player;

// Menu screen for managing player stats and equipment
public class GameMenu {

    // EFFECTS: runs the game menu
    public GameMenu() {
        //stub
    }

    // MODIFIES: this
    // EFFECTS: initializes game data, takes input for player name
    public void init() {
        //stub
    }

    // EFFECTS: processes user command in main menu
    public void processCommandMain() {
        //stub
    }

    // EFFECTS: displays main menu options
    public void displayMainMenu() {
        //stub
    }

    // MODIFIES: this
    // EFFECTS: adds new equipment to the inventory
    public void addNewEquipment() {
        //stub
    }

    // EFFECTS: makes an equipment to add
    public Equipment selectEquipment() {
        return new Equipment(null, 0, 0, null); //stub
    }

    // EFFECTS: displays menu options for adding new equipment
    public void displayNewEquipmentMenu() {
        //stub
    }

    // MODIFIES: this
    // EFFECTS: upgrade base stats using stat points
    public void upgradeBaseStats() {
        //stub
    }

    // EFFECTS: displays menu options for upgrading stats
    public void displayStatUpgradeMenu() {
        //stub
    }

    // MODIFIES: this
    // EFFECTS: equips chosen equipment from inventory
    public void equipEquipment() {
        //stub
    }
}
