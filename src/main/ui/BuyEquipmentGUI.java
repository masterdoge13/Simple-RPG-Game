package ui;

import javax.swing.AbstractAction;
import javax.swing.JFrame;

import model.EquipmentType;
import model.Player;

import java.awt.event.ActionEvent;

public class BuyEquipmentGUI extends JFrame {

    // EFFECTS: creates buy equipment screen that allows for naming new equipment
    public BuyEquipmentGUI(Player player) {
        //stub
    }

    // MODIFIES: this
    // EFFECTS: layouts all buttons and areas
    private void addSubPanel() {
        //stub
    }

    // MODIFIES: this
    // EFFECTS: creates the buttons that allow for new equipment creation
    private void addCreateEquipmentButtons() {
        //stub
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

    // creates and adds equipment to the inventory
    private class CreateEquipment extends AbstractAction {

        protected CreateEquipment(EquipmentType equipmentType) {
            //stub
        }

        // MODIFIES: this
        // EFFECTS: creates selected equipment and adds it to the inventory
        @Override
        public void actionPerformed(ActionEvent evt) {
            //stub

        }
    }
}
