package ui;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import model.EquipmentType;
import model.Player;

// creates the menu for the player to upgrade their base stats
public class UpgradeStatsGUI extends JFrame {

    public UpgradeStatsGUI(Player player) {
        addSubPanel();
    }
        
    // MODIFIES: this
    // EFFECTS: creates the buttons and text for the menu
    private void addSubPanel() {
        addStatUpgradeButtons(null);
    }

    // MODIFIES: this
    // EFFECTS: creates the buttons that allow for stat upgrades
    private void addStatUpgradeButtons(JPanel jPanel) {
        //stub
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
            //stub
        }
    }

    // upgrades player attack
    private class UpgradeAttack extends AbstractAction {

        protected UpgradeAttack() {
            super();
        }

        // MODIFIES: this
        // EFFECTS: upgrades player attack by a set interval and uses a stat point
        @Override
        public void actionPerformed(ActionEvent evt) {
            //stub
        }
    }

    // upgrades player health
    private class UpgradeHealth extends AbstractAction {

        protected UpgradeHealth() {
            super();
        }

        // MODIFIES: this
        // EFFECTS: upgrades player health by a set interval and uses a stat point
        @Override
        public void actionPerformed(ActionEvent evt) {
            //stub
        }
    }
}
