package ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

import model.Player;

// creates the menu for the player to upgrade their base stats
public class UpgradeStatsGUI extends JFrame {

    private static final int WIDTH = 800;
    private static final int HEIGHT = 1000;

    private Player player;

    public UpgradeStatsGUI(Player player) {
        this.player = player;
        addSubPanel();
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }
        
    // MODIFIES: this
    // EFFECTS: creates the buttons and text for the menu
    private void addSubPanel() {
        JPanel subPanel = new JPanel();
        subPanel.setLayout(new BorderLayout());
        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new BorderLayout());
        infoPanel.setPreferredSize(new Dimension(100, 50));
        JTextArea currentStats = new JTextArea("Attack: " + Integer.toString(player.getAttack()) 
                + "\nMax Health: " + Integer.toString(player.getMaxHealth()));
        infoPanel.add(currentStats);
        infoPanel.add(new JLabel("Stat Points: " 
                + Integer.toString(player.getStatPoints()), SwingConstants.RIGHT), BorderLayout.LINE_END);
        subPanel.add(infoPanel, BorderLayout.PAGE_START);
        addStatUpgradeButtons(subPanel);
        subPanel.add(new JButton(new BackToMenu()), BorderLayout.PAGE_END);
        add(subPanel);
    }

    // MODIFIES: this
    // EFFECTS: creates the buttons that allow for stat upgrades
    private void addStatUpgradeButtons(JPanel panel) {
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(2, 1));
        JButton upgradeAttackButton = new JButton("Increase Base Attack");
        upgradeAttackButton.addActionListener(new UpgradeAttack());
        JButton upgradeHealthButton = new JButton("Increase Base Health");
        upgradeHealthButton.addActionListener(new UpgradeHealth());
        buttonPanel.add(upgradeAttackButton);
        buttonPanel.add(upgradeHealthButton);
        panel.add(buttonPanel);
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

    // upgrades player attack
    private class UpgradeAttack extends AbstractAction {

        protected UpgradeAttack() {
            super();
        }

        // MODIFIES: this
        // EFFECTS: upgrades player attack by a set interval and uses a stat point
        @Override
        public void actionPerformed(ActionEvent evt) {
            if (player.getStatPoints() > 0) {
                dispose();
                player.increaseAttack();
                new UpgradeStatsGUI(player);
            } else {
                JOptionPane.showMessageDialog(null, "You need more stat points");
            }
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
            if (player.getStatPoints() > 0) {
                dispose();
                player.increaseMaxHealth();
                new UpgradeStatsGUI(player);
            } else {
                JOptionPane.showMessageDialog(null, "You need more stat points");
            }
        }
    }
}
