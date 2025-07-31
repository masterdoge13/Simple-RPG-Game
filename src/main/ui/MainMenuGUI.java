package ui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;


import model.Player;

// GUI for the main menu of the game
public class MainMenuGUI extends JFrame {

    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    // taken from TrafficLightGUI in C3-LectureLabSolution
    private static final String IMAGES_PATH = System.getProperty("user.dir") + "/images/";

    private Player player;
    private JButton combatButton;
    private JButton buyEquipmentButton;
    private JButton viewInventoryButton;
    private JButton equipEquipmentButton;
    private JButton saveButton;
    private JButton loadButton;
    private ImageIcon combatButtonIcon;
    private ImageIcon buyEquipmentButtonIcon;
    private ImageIcon viewInventoryButtonIcon;
    private ImageIcon equipEquipmentButtonIcon;
    private ImageIcon saveButtonIcon;
    private ImageIcon loadButtonIcon;

    // EFFECTS: creates a main menu GUI with a player
    public MainMenuGUI(Player player) {
        this.player = player;
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
        buttonPanel.add(equipEquipmentButton);
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
        createEquipEquipmentButton();
        createSaveButton();
        createLoadButton();
    }

    // MODIFIES: this
    // EFFECTS: loads icons for buttons
    private void loadIcons() {
        combatButtonIcon = new ImageIcon(IMAGES_PATH + "combatbuttonicon.png");
        buyEquipmentButtonIcon = new ImageIcon(IMAGES_PATH + "buyequipmentbuttonicon.png");
        viewInventoryButtonIcon = new ImageIcon(IMAGES_PATH + "viewinventorybuttonicon.png");
        equipEquipmentButtonIcon = new ImageIcon(IMAGES_PATH + "equipequipmentbuttonicon.png");
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
        buyEquipmentButton.addActionListener(new buyEquipment());
    }

    // MODIFIES: this
    // EFFECTS: creates button for viewing the inventory
    private void createViewInventoryButton() {
        viewInventoryButton = new JButton("Inventory", viewInventoryButtonIcon);
        viewInventoryButton.addActionListener(new viewInventory());
    }

    // MODIFIES: this
    // EFFECTS: creates button for equipping equipment
    private void createEquipEquipmentButton() {
        equipEquipmentButton = new JButton("Equip", equipEquipmentButtonIcon);
        equipEquipmentButton.addActionListener(new equipEquipment());
    }

    // MODIFIES: this
    // EFFECTS: creates button for saving
    private void createSaveButton() {
        saveButton = new JButton("Save", saveButtonIcon);
        saveButton.addActionListener(new overwriteSaveData());
    }

    // MODIFIES: this
    // EFFECTS: creates button for loading
    private void createLoadButton() {
        loadButton = new JButton("Load", loadButtonIcon);
        loadButton.addActionListener(new loadSaveData());
    }

    // opens up the buy equipment menu
    private class buyEquipment extends AbstractAction {

        protected buyEquipment() {
            super();
        }

        @Override
        public void actionPerformed(ActionEvent evt) {
            //stub
            

        }
    }
    
    // opens up the view inventory menu
    private class viewInventory extends AbstractAction {

        protected viewInventory() {
            super();
        }

        @Override
        public void actionPerformed(ActionEvent evt) {
            //stub
            

        }
    }

    // opens up the equip equipment menu
    private class equipEquipment extends AbstractAction {

        protected equipEquipment() {
            super();
        }

        @Override
        public void actionPerformed(ActionEvent evt) {
            //stub
            

        }
    }

    // saves player data and returns a pop-up notification
    private class overwriteSaveData extends AbstractAction {

        protected overwriteSaveData() {
            super();
        }

        @Override
        public void actionPerformed(ActionEvent evt) {
            //stub
            

        }
    }

    // saves player data and returns a pop-up notification
    private class loadSaveData extends AbstractAction {

        protected loadSaveData() {
            super();
        }

        @Override
        public void actionPerformed(ActionEvent evt) {
            //stub
            

        }
    }

    
}
