package ui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

import model.Inventory;
import model.Player;
import model.EquipmentType;

// Displays the player's inventory and allows for equipment deletion
public class ViewInventoryGUI extends ClosableGUI {

    private static final int WIDTH = 800;
    private static final int HEIGHT = 1000;
    private static final int ITEMS_PER_PAGE = 9;
    private static final String IMAGES_PATH = System.getProperty("user.dir") + "/images/";

    private Player player;
    private Inventory inventory;
    private int index;

    // EFFECTS: creates an inventory screen with 9 equipment buttons
    public ViewInventoryGUI(Player player, int ind) {
        this.player = player;
        this.inventory = player.getInventory();
        index = ind;
        addButtonPanel();
        addWindowListener(this);
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    // MODIFIES: this
    // EFFECTS: creates a panel of buttons for the inventory screen
    private void addButtonPanel() {
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(ITEMS_PER_PAGE + 2, 1));
        buttonPanel.add(new JTextArea(player.getEquipped().equippedToString()));
        createButtons(buttonPanel);
        JPanel navigationButtons = new JPanel(new GridLayout(1, 3));
        navigationButtons.add(new JButton(new PreviousPage()));
        navigationButtons.add(new JButton(new BackToMenu()));
        navigationButtons.add(new JButton(new NextPage()));
        buttonPanel.add(navigationButtons);
        add(buttonPanel);
    }

    // MODIFIES: this
    // EFFECTS: creates buttons for each item in the inventory screen
    private void createButtons(JPanel buttonPanel) {
        int x = 0;
        while (x < ITEMS_PER_PAGE) {
            if (index <= inventory.getSize() - 1) {
                JPanel subPanel = new JPanel(new BorderLayout());
                if (inventory.getEquipment(index).getType() == EquipmentType.ARMOUR) {
                    subPanel.add(new JLabel("ARMOUR",
                            new ImageIcon(IMAGES_PATH + "armouricon.png"), 0), BorderLayout.LINE_START);
                } else if (inventory.getEquipment(index).getType() == EquipmentType.SWORD) {
                    subPanel.add(new JLabel("SWORD",
                            new ImageIcon(IMAGES_PATH + "swordicon.png"), 0), BorderLayout.LINE_START);
                }
                subPanel.add(new JTextArea(inventory.getEquipment(index).equipmentToString()), BorderLayout.CENTER);
                JPanel subItemAction = new JPanel(new GridLayout(1, 2));
                subItemAction.add(new JButton(new RemoveEquipment(index)));
                subItemAction.add(new JButton(new EquipEquipment(index)));
                subPanel.add(subItemAction, BorderLayout.LINE_END);
                buttonPanel.add(subPanel);
            } else {
                buttonPanel.add(new JButton());
            }
            x++;
            index++;
        }
    }

    // remove selected item
    private class RemoveEquipment extends AbstractAction {

        private int chosenIndex;

        protected RemoveEquipment(int ind) {
            super("Remove");
            this.chosenIndex = ind;
        }

        // MODIFIES: this
        // EFFECTS: removes selected equipment at index and refreshes the page
        @Override
        public void actionPerformed(ActionEvent evt) {
            inventory.removeEquipment(chosenIndex);
            index -= ITEMS_PER_PAGE;
            if (index < 0) {
                index = 0;
            }
            dispose();
            new ViewInventoryGUI(player, index);

        }
    }

    // equip selected item
    private class EquipEquipment extends AbstractAction {

        private int chosenIndex;

        protected EquipEquipment(int ind) {
            super("Equip");
            chosenIndex = ind;
        }

        // MODIFIES: this
        // EFFECTS: equip selected equipment at index and refreshes the page
        @Override
        public void actionPerformed(ActionEvent evt) {
            player.getEquipped().equip(inventory.getEquipment(chosenIndex), inventory);
            player.getInventory().removeEquipment(chosenIndex);
            index -= ITEMS_PER_PAGE;
            if (index < 0) {
                index = 0;
            }
            dispose();
            new ViewInventoryGUI(player, index);

        }
    }

    // goes to the previous page
    private class PreviousPage extends AbstractAction {

        protected PreviousPage() {
            super("Prev");
        }

        // MODIFIES: this
        // EFFECTS: opens the inventory GUI on the previous page of items
        @Override
        public void actionPerformed(ActionEvent evt) {
            index -= ITEMS_PER_PAGE * 2;
            if (index < 0) {
                index = 0;
            }
            dispose();
            new ViewInventoryGUI(player, index);

        }
    }

    // goes to the next page
    private class NextPage extends AbstractAction {

        protected NextPage() {
            super("Next");
        }

        // MODIFIES: this
        // EFFECTS: opens the inventory GUI on the next page of items
        @Override
        public void actionPerformed(ActionEvent evt) {
            dispose();
            new ViewInventoryGUI(player, index);

        }
    }

    // goes to the main menu
    private class BackToMenu extends AbstractAction {

        protected BackToMenu() {
            super("Exit");
        }

        // MODIFIES: this
        // EFFECTS: opens the main menu
        @Override
        public void actionPerformed(ActionEvent evt) {
            dispose();
            new MainMenuGUI(player);

        }
    }

}
