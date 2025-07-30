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

    // EFFECTS: creates a main menu GUI with a player
    public MainMenuGUI(Player player) {
        this.player = player;
        addButtonPanel();
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    // template taken from AlarmControllerUI in AlarmSystem
    // EFFECTS: creates a panel of buttons for
    private void addButtonPanel() {
        JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(3,2));
		buttonPanel.add(new JButton());
		buttonPanel.add(new JButton());
		buttonPanel.add(new JButton());
		buttonPanel.add(new JButton());
		buttonPanel.add(new JButton());
		buttonPanel.add(new JButton());
        add(buttonPanel);
    }
}
