package ui;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;

import model.Player;

// graphical menu screen for combat
public class CombatGUI {

    // MODIFIES: this
    // EFFECTS: Initializes combat with player data
    public CombatGUI(Player player) {
        //stub
    }

    // MODIFIES: this
    // EFFECTS: initializes enemy data and player data
    private void init() {
        //stub
    }


    // MODIFIES: this
    // EFFECTS: gives rewards for winning, increases difficulty and exits combat
    private void winCombat() {
        //stub
    }

    // MODIFIES: this
    // EFFECTS: decreases difficulty for losing and exit combat
    private void loseCombat() {
        //stub
    }

    // MODIFIES: this
    // EFFECTS: attack the enemy
    private void attack() {
        //stub
    }

    // MODIFIES: this
    // EFFECTS: enemy attacks the player
    private void getAttacked() {
        //stub
    }


    // processes a turn of combat
    private class CombatTurn extends AbstractAction {

        protected CombatTurn(int combatOption) {
            super();
        }

        // MODIFIES: this
        // EFFECTS: player attacks the enemy and gets attacked back
        @Override
        public void actionPerformed(ActionEvent evt) {
            //stub
        }
    }
}
