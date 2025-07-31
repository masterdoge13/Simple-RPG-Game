package ui;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import model.Player;

// GUI for the main menu of the game
public class MainMenuGUI extends JFrame {

    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    private Player player;
    private JButton combatButton;
    private JButton buyEquipmentButton;
    private JButton viewInventoryButton;
    private JButton equipEquipmentButton;
    private JButton saveButton;
    private JButton loadButton;

    // EFFECTS: creates a main menu GUI with a player
    public MainMenuGUI(Player player) {
        this.player = player;
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
		buttonPanel.setLayout(new GridLayout(3,2));
		buttonPanel.add(new JButton());
		buttonPanel.add(new JButton());
		buttonPanel.add(new JButton());
		buttonPanel.add(new JButton());
		buttonPanel.add(new JButton());
		buttonPanel.add(new JButton());
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
    // EFFECTS: creates button for combat
    private void createCombatButton() {
        //stub
    }

    // MODIFIES: this
    // EFFECTS: creates button for buying equipment
    private void createBuyEquipmentButton() {
        //stub
    }

    // MODIFIES: this
    // EFFECTS: creates button for viewing the inventory
    private void createViewInventoryButton() {
        //stub
    }

    // MODIFIES: this
    // EFFECTS: creates button for equipping equipment
    private void createEquipEquipmentButton() {
        //stub
    }

    // MODIFIES: this
    // EFFECTS: creates button for saving
    private void createSaveButton() {
        //stub
    }

    // MODIFIES: this
    // EFFECTS: creates button for loading
    private void createLoadButton() {
        //stub
    }
}
