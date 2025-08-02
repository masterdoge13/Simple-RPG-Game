package ui;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

import model.Player;

import java.awt.event.ActionEvent;

// pop-up at the beginning of the game to get player name
// template taken from AlarmControllerUI class in AlarmSystem
public class PlayerNameGUI extends JFrame {

    private static final int BASE_ATTACK = 5;
    private static final int BASE_HEALTH = 100;
    private static final int STARTING_STAT_POINTS = 5;
    private static final int WIDTH = 800;
    private static final int HEIGHT = 1000;

    private Player player;

    // EFFECTS: creates the pop-up window
    public PlayerNameGUI() {
        add(new JButton(new NameInput()));
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    // the pop-up window and player initialization
    private class NameInput extends AbstractAction {

        protected NameInput() {
            super("Name Hero");
        }

        // MODIFIES: this
        // EFFECTS: creates the pop-up window for naming the player and opens the main menu
        @Override
        public void actionPerformed(ActionEvent evt) {
            String playerName = JOptionPane.showInputDialog(null,
                    "What is your name?",
                    "Hero Maker",
                    JOptionPane.QUESTION_MESSAGE);
            player = new Player(playerName, BASE_ATTACK, BASE_HEALTH);
            player.increaseStatPoints(STARTING_STAT_POINTS);
            dispose();
            new MainMenuGUI(player);

        }
    }
}
