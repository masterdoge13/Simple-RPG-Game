package ui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;


import model.Player;
import persistence.*;

// GUI for the main menu of the game
public class MainMenuGUI extends JFrame {

    private static final int WIDTH = 800;
    private static final int HEIGHT = 1000;
    // taken from TrafficLightGUI in C3-LectureLabSolution
    private static final String IMAGES_PATH = System.getProperty("user.dir") + "/images/";
    private static final String SAVE_FILE = "./data/playerData.json";

    private Player player;
    private JsonReader jsonReader;
    private JsonWriter jsonWriter;
    private JButton combatButton;
    private JButton buyEquipmentButton;
    private JButton viewInventoryButton;
    private JButton upgradeStatPointsButton;
    private JButton saveButton;
    private JButton loadButton;
    private ImageIcon combatButtonIcon;
    private ImageIcon buyEquipmentButtonIcon;
    private ImageIcon viewInventoryButtonIcon;
    private ImageIcon upgradeStatPointsButtonIcon;
    private ImageIcon saveButtonIcon;
    private ImageIcon loadButtonIcon;

    // EFFECTS: creates a main menu GUI with a player
    public MainMenuGUI(Player player) {
        this.player = player;
        jsonReader = new JsonReader(SAVE_FILE);
        jsonWriter = new JsonWriter(SAVE_FILE);
        loadIcons();
        addButtonPanel();
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    // template taken from AlarmControllerUI in AlarmSystem
    // MODIFIES: this
    // EFFECTS: creates a panel of buttons for the menu
    private void addButtonPanel() {
        JPanel buttonPanel = new JPanel();
        createButtons();
        buttonPanel.setLayout(new GridLayout(3, 2));
        buttonPanel.add(combatButton);
        buttonPanel.add(buyEquipmentButton);
        buttonPanel.add(viewInventoryButton);
        buttonPanel.add(upgradeStatPointsButton);
        buttonPanel.add(saveButton);
        buttonPanel.add(loadButton);
        add(buttonPanel);
    }

    // MODIFIES: this
    // EFFECTS: creates buttons for menu
    private void createButtons() {
        createCombatButton();
        createBuyEquipmentButton();
        createViewInventoryButton();
        createUpgradeStatPointsButton();
        createSaveButton();
        createLoadButton();
    }

    // MODIFIES: this
    // EFFECTS: loads icons for buttons
    private void loadIcons() {
        combatButtonIcon = new ImageIcon(IMAGES_PATH + "combatbuttonicon.png");
        buyEquipmentButtonIcon = new ImageIcon(IMAGES_PATH + "buyequipmentbuttonicon.png");
        viewInventoryButtonIcon = new ImageIcon(IMAGES_PATH + "viewinventorybuttonicon.png");
        upgradeStatPointsButtonIcon = new ImageIcon(IMAGES_PATH + "upgradestatpointsbuttonicon.png");
        saveButtonIcon = new ImageIcon(IMAGES_PATH + "savebuttonicon.png");
        loadButtonIcon = new ImageIcon(IMAGES_PATH + "loadbuttonicon.png");
    }

    // MODIFIES: this
    // EFFECTS: creates button for combat
    private void createCombatButton() {
        combatButton = new JButton("Fight", combatButtonIcon);
    }

    // MODIFIES: this
    // EFFECTS: creates button for buying equipment
    private void createBuyEquipmentButton() {
        buyEquipmentButton = new JButton("Buy Equipment", buyEquipmentButtonIcon);
        buyEquipmentButton.addActionListener(new BuyEquipment());
    }

    // MODIFIES: this
    // EFFECTS: creates button for viewing the inventory and equipping equipment
    private void createViewInventoryButton() {
        viewInventoryButton = new JButton("Inventory", viewInventoryButtonIcon);
        viewInventoryButton.addActionListener(new ViewInventory());
    }

    // MODIFIES: this
    // EFFECTS: creates button for upgrading stats
    private void createUpgradeStatPointsButton() {
        upgradeStatPointsButton = new JButton("Upgrade Stats", upgradeStatPointsButtonIcon);
        upgradeStatPointsButton.addActionListener(new UpgradeStatPoints());
    }

    // MODIFIES: this
    // EFFECTS: creates button for saving
    private void createSaveButton() {
        saveButton = new JButton("Save", saveButtonIcon);
        saveButton.addActionListener(new OverwriteSaveData());
    }

    // MODIFIES: this
    // EFFECTS: creates button for loading
    private void createLoadButton() {
        loadButton = new JButton("Load", loadButtonIcon);
        loadButton.addActionListener(new LoadSaveData());
    }

    // opens up the buy equipment menu
    private class BuyEquipment extends AbstractAction {

        protected BuyEquipment() {
            super();
        }

        // MODIFIES: this
        // EFFECTS: opens up the buy equipment menu
        @Override
        public void actionPerformed(ActionEvent evt) {
            //stub
            

        }
    }
    
    // opens up the view inventory menu
    private class ViewInventory extends AbstractAction {

        protected ViewInventory() {
            super();
        }

        // MODIFIES: this
        // EFFECTS: opens up the inventory menu
        @Override
        public void actionPerformed(ActionEvent evt) {
            dispose();
            new ViewInventoryGUI(player, 0);
            

        }
    }

    // opens up the stat upgrade menu
    private class UpgradeStatPoints extends AbstractAction {

        protected UpgradeStatPoints() {
            super();
        }

        // MODIFIES: this
        // EFFECTS: opens up the stat upgrade menu
        @Override
        public void actionPerformed(ActionEvent evt) {
            //stub
            

        }
    }

    // saves player data and returns a pop-up notification
    private class OverwriteSaveData extends AbstractAction {

        protected OverwriteSaveData() {
            super();
        }

        // EFFECTS: saves player to file
        @Override
        public void actionPerformed(ActionEvent evt) {
            try {
                jsonWriter.open();
                jsonWriter.write(player);
                jsonWriter.close();
                JOptionPane.showMessageDialog(null, "Saved player " + player.getName() + " to " + SAVE_FILE);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Failed to load");
            }
            

        }
    }

    // loads player data and returns a pop-up notification
    private class LoadSaveData extends AbstractAction {

        protected LoadSaveData() {
            super();
        }

        // MODIFIES: this
        // EFFECTS: reads player data and saves it to player
        @Override
        public void actionPerformed(ActionEvent evt) {
            try {
                player = jsonReader.read();
                JOptionPane.showMessageDialog(null, "Loaded player " + player.getName() + " from " + SAVE_FILE);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Failed to load");
            }
        }
    }
}
