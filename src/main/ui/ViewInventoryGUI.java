package ui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import model.Inventory;
import model.Player;
import model.EquipmentType;

// Displays the player's inventory and allows for equipment deletion
public class ViewInventoryGUI extends JFrame {

    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;

    private Player player;
    private Inventory inventory;
    private int index;

    // EFFECTS: creates an inventory screen with 9 equipment buttons
    public ViewInventoryGUI(Player player, int ind) {
        this.player = player;
        this.inventory = player.getInventory();
        index = ind;
        addButtonPanel();
        setSize(WIDTH, HEIGHT);
    }

    // MODIFIES: this
    // EFFECTS: creates a panel of buttons for the inventory screen
    private void addButtonPanel() {
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(new JTextArea(player.getEquipped().equippedToString()));
        buttonPanel.setLayout(new GridLayout(11, 1));
        createButtons(buttonPanel);
        JPanel navigationButtons = new JPanel(new GridLayout(1, 3));
        navigationButtons.add(new JButton(new PreviousPage()));
        navigationButtons.add(new JButton(new BackToMenu()));
        navigationButtons.add(new JButton(new NextPage()));
        
    }

    // MODIFIES: this
    // EFFECTS: creates buttons for each item in the inventory screen
    private void createButtons(JPanel buttonPanel) {
        int x = 0;
        while (x < 9) {
            if (index <= inventory.getSize() - 1) {
                JPanel subPanel = new JPanel(new BorderLayout());
                if (inventory.getEquipment(index).getType() == EquipmentType.ARMOUR) {
                    subPanel.add(new JLabel("ARMOUR"), BorderLayout.LINE_START);
                } else if (inventory.getEquipment(index).getType() == EquipmentType.SWORD) {
                    subPanel.add(new JLabel("SWORD"), BorderLayout.LINE_START);
                }
                subPanel.add(new JTextArea(inventory.getEquipment(index).toString()), BorderLayout.CENTER);
                JPanel subItemAction = new JPanel(new GridLayout(1, 2));
                subItemAction.add(new JButton(new RemoveEquipment(index)));
                subItemAction.add(new JButton(new EquipEquipment(index)));
                subPanel.add(subItemAction, BorderLayout.LINE_END);
            } else {
                buttonPanel.add(new JButton());
            }
            x++;
            index++;
        }
    }


    // remove selected item
    private class RemoveEquipment extends AbstractAction {

        protected RemoveEquipment(int ind) {
            //stub
        }

        // MODIFIES: this
        // EFFECTS: removes selected equipment at index
        @Override
        public void actionPerformed(ActionEvent evt) {
            //stub

        }
    }

    // equip selected item
    private class EquipEquipment extends AbstractAction {

        protected EquipEquipment(int ind) {
            //stub
        }

        // MODIFIES: this
        // EFFECTS: equip selected equipment at index
        @Override
        public void actionPerformed(ActionEvent evt) {
            //stub

        }
    }

    // goes to the previous page
    private class PreviousPage extends AbstractAction {

        protected PreviousPage() {
            //stub
        }

        // MODIFIES: this
        // EFFECTS: opens the inventory GUI on the previous page of items
        @Override
        public void actionPerformed(ActionEvent evt) {
            //stub

        }
    }

    // goes to the next page
    private class NextPage extends AbstractAction {

        protected NextPage() {
            //stub
        }

        // MODIFIES: this
        // EFFECTS: opens the inventory GUI on the next page of items
        @Override
        public void actionPerformed(ActionEvent evt) {
            //stub

        }
    }

    // goes to the main menu
    private class BackToMenu extends AbstractAction {

        protected BackToMenu() {
            //stub
        }

        // MODIFIES: this
        // EFFECTS: opens the main menu
        @Override
        public void actionPerformed(ActionEvent evt) {
            //stub

        }
    }

}
