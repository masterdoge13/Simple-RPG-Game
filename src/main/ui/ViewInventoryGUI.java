package ui;

import javax.swing.JFrame;
import javax.swing.JPanel;

import model.Player;

// Displays the player's inventory and allows for equipment deletion
public class ViewInventoryGUI extends JFrame {

    // EFFECTS: creates an inventory screen with 9 equipment buttons
    public ViewInventoryGUI(Player player, int ind) {
        addButtonPanel();
        setSize(WIDTH, HEIGHT);
    }

    // MODIFIES: this
    // EFFECTS: creates a panel of buttons for the inventory screen
    private void addButtonPanel() {
        //stub
    }

    // MODIFIES: this
    // EFFECTS: creates buttons for inventory screen
    private void createButtons(JPanel buttonPanel) {
        //stub
    }
}
