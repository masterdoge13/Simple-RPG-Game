package ui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

import model.Enemy;
import model.Player;

// graphical menu screen for combat
public class CombatGUI extends JFrame {

    private static final int WIDTH = 800;
    private static final int HEIGHT = 1000;
    private static final String IMAGES_PATH = System.getProperty("user.dir") + "/images/";

    private Player player;
    private Enemy enemy;
    private int playerAttackEffective;
    private int enemyAttackEffective;
    private boolean keepGoing;

    // MODIFIES: this
    // EFFECTS: initializes combat with player data
    public CombatGUI(Player player) {
        this.player = player;
        this.player.fullHeal();
        keepGoing = true;
        init();
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    // MODIFIES: this
    // EFFECTS: continues combat with player and enemy data
    public CombatGUI(Player player, Enemy enemy) {
        this.player = player;
        this.enemy = enemy;
        keepGoing = true;
        cont();
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    // MODIFIES: this
    // EFFECTS: initializes enemy data and player data
    private void init() {
        enemy = new Enemy("Bad Guy", 10, 100, player.getDifficulty());
        playerAttackEffective = (int) (player.getAttack() * player.getEquipped().getTotalAttackMod());
        enemyAttackEffective = (int) (enemy.getAttack() * (1 - player.getEquipped().getTotalDefenseMod()));
        addSubPanel();
    }

    // MODIFIES: this
    // EFFECTS: continues combat with updated data
    private void cont() {
        playerAttackEffective = (int) (player.getAttack() * player.getEquipped().getTotalAttackMod());
        enemyAttackEffective = (int) (enemy.getAttack() * (1 - player.getEquipped().getTotalDefenseMod()));
        addSubPanel();
    }

    // MODIFIES: this
    // EFFECTS: layouts all buttons and areas
    private void addSubPanel() {
        JPanel subPanel = new JPanel();
        subPanel.setLayout(new GridLayout(2, 1));
        addInfoPanel(subPanel);
        addButtonPanel(subPanel);
        add(subPanel);
    }

    // MODIFIES: this
    // EFFECTS: layouts all graphics and text areas
    private void addInfoPanel(JPanel panel) {
        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new GridLayout(2, 2));
        infoPanel.add(enemyPortrait());
        infoPanel.add(enemyInfo());
        infoPanel.add(playerPortrait());
        infoPanel.add(playerInfo());
        panel.add(infoPanel);
    }

    // EFFECTS: returns a JPanel with the enemy's name and portrait
    private JPanel enemyPortrait() {
        JPanel enemyPortrait = new JPanel(new BorderLayout());
        enemyPortrait.add(new JLabel(enemy.getName()), BorderLayout.PAGE_END);
        enemyPortrait.add(new JLabel(new ImageIcon(IMAGES_PATH + "badguy.png")), BorderLayout.CENTER);
        return enemyPortrait;
    }

    // EFFECTS: returns a JPanel with the enemy's stats
    private JPanel enemyInfo() {
        JPanel enemyInfo = new JPanel(new GridLayout(3, 1));
        String enemyString;
        enemyString = "Difficulty Level: " + player.getDifficulty().getDifficulty();
        enemyString += "\nAttack: " + enemy.getAttack();
        enemyString += "\nHealth: " + enemy.getHealth() + "/" + enemy.getMaxHealth();
        enemyInfo.add(new JTextArea());
        enemyInfo.add(new JTextArea(enemyString));
        enemyInfo.add(new JTextArea());
        return enemyInfo;
    }

    // EFFECTS: returns a JPanel with the player's name and portrait
    private JPanel playerPortrait() {
        JPanel playerPortrait = new JPanel(new BorderLayout());
        playerPortrait.add(new JLabel(player.getName()), BorderLayout.PAGE_END);
        playerPortrait.add(new JLabel(new ImageIcon(IMAGES_PATH + "player.png")), BorderLayout.CENTER);
        return playerPortrait;
    }

    // EFFECTS: returns a JPanel with the players's stats
    private JPanel playerInfo() {
        JPanel playerInfo = new JPanel(new GridLayout(3, 1));
        String playerString;
        playerString = "Attack: " + player.getAttack();
        playerString += "\nHealth: " + player.getCurrentHealth() + "/" + player.getMaxHealth();
        playerString += "\n" + player.getEquipped().equippedToString();
        playerInfo.add(new JTextArea());
        playerInfo.add(new JTextArea(playerString));
        playerInfo.add(new JTextArea());
        return playerInfo;
    }

    // MODIFIES: this
    // EFFECTS: layouts all buttons
    private void addButtonPanel(JPanel panel) {
        JPanel buttonPanel = new JPanel(new GridLayout(2, 2));
        JButton slashButton = new JButton("Slash", new ImageIcon(IMAGES_PATH + "slashicon.png"));
        slashButton.addActionListener(new CombatTurn(0));
        slashButton.setToolTipText("Beats Feinting");
        JButton feintButton = new JButton("Feint", new ImageIcon(IMAGES_PATH + "feinticon.png"));
        feintButton.addActionListener(new CombatTurn(1));
        feintButton.setToolTipText("Beats Parrying");
        JButton parryButton = new JButton("Parry", new ImageIcon(IMAGES_PATH + "parryicon.png"));
        parryButton.addActionListener(new CombatTurn(2));
        parryButton.setToolTipText("Beats Slashing");
        JButton retreatButton = new JButton("Retreat", new ImageIcon(IMAGES_PATH + "retreaticon.png"));
        retreatButton.addActionListener(new Retreat());
        buttonPanel.add(slashButton);
        buttonPanel.add(feintButton);
        buttonPanel.add(parryButton);
        buttonPanel.add(retreatButton);
        panel.add(buttonPanel);
    }

    // MODIFIES: this
    // EFFECTS: gives rewards for winning, increases difficulty and exits combat
    private void winCombat() {
        player.getDifficulty().increaseDifficulty();
        player.increaseExperience(enemy.getExperienceGain());
        player.increaseGold(enemy.getGoldGain());
        player.fullHeal();
        JOptionPane.showMessageDialog(null, "Combat Won!\nGained:\n" + enemy.getExperienceGain() + " EXP\n"
                + enemy.getGoldGain() + " Gold\n\nDifficulty increased to "
                + player.getDifficulty().getDifficulty());
        dispose();
        keepGoing = false;
        new MainMenuGUI(player);
    }

    // MODIFIES: this
    // EFFECTS: exit combat without any gains, decreases difficulty by 1
    private void loseCombat() {
        if (player.getDifficulty().getDifficulty() > 0) {
            player.getDifficulty().setDifficulty(player.getDifficulty().getDifficulty() - 1);
        }
        player.fullHeal();
        JOptionPane.showMessageDialog(null, "Combat Lost.\nTry not losing next time\n\nDifficulty decreased");
        dispose();
        keepGoing = false;
        new MainMenuGUI(player);
    }

    // MODIFIES: this
    // EFFECTS: attack the enemy
    private void attack() {
        enemy.takeDamage(playerAttackEffective);
        if (enemy.isDead()) {
            winCombat();
        }
    }

    // MODIFIES: this
    // EFFECTS: enemy attacks the player
    private void getAttacked() {
        player.takeDamage(enemyAttackEffective);
        if (player.getCurrentHealth() <= 0 && keepGoing) {
            loseCombat();
        }
    }

    // processes a turn of combat
    private class CombatTurn extends AbstractAction {

        int playerCombatOption;
        int enemyCombatOption;

        protected CombatTurn(int combatOption) {
            super();
            this.playerCombatOption = combatOption;
            this.enemyCombatOption = (int) (Math.random() * 3);
        }

        // MODIFIES: this
        // EFFECTS: player attacks the enemy and gets attacked back
        @Override
        public void actionPerformed(ActionEvent evt) {
            if (playerCombatOption == enemyCombatOption) {
                attack();
                getAttacked();
            } else if (playerCombatOption == 0) {
                slashAttack();
            } else if (playerCombatOption == 1) {
                feintAttack();
            } else if (playerCombatOption == 2) {
                parryAttack();
            }
            if (keepGoing) {
                dispose();
                new CombatGUI(player, enemy);
            }
        }
        
        // EFFECTS: figures out whether the player gets attacked or the enemy if player slashes
        private void slashAttack() {
            if (enemyCombatOption == 1) {
                attack();
            } else if (enemyCombatOption == 2) {
                getAttacked();
            }
        }

        // EFFECTS: figures out whether the player gets attacked or the enemy if player feints
        private void feintAttack() {
            if (enemyCombatOption == 2) {
                attack();
            } else if (enemyCombatOption == 0) {
                getAttacked();
            }
        }

        // EFFECTS: figures out whether the player gets attacked or the enemy if player parries
        private void parryAttack() {
            if (enemyCombatOption == 0) {
                attack();
            } else if (enemyCombatOption == 1) {
                getAttacked();
            }
        }
    }

    // lose the fight early
    private class Retreat extends AbstractAction {

        protected Retreat() {
            super();
        }

        // MODIFIES: this
        // EFFECTS: lose combat and go to main menu
        @Override
        public void actionPerformed(ActionEvent evt) {
            loseCombat();

        }
    }
}
