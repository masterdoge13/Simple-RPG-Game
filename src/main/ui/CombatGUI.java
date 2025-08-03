package ui;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import model.Enemy;
import model.Player;

// graphical menu screen for combat
public class CombatGUI extends JFrame {

    private Player player;
    private Enemy enemy;
    private int playerAttackEffective;
    private int enemyAttackEffective;
    private int enemyStartHealth;

    // MODIFIES: this
    // EFFECTS: Initializes combat with player data
    public CombatGUI(Player player) {
        this.player = player;
        init();
    }

    // MODIFIES: this
    // EFFECTS: Initializes combat with player and enemy data 
    public CombatGUI(Player player, Enemy enemy) {
        this.player = player;
        this.enemy = enemy;
    }

    // MODIFIES: this
    // EFFECTS: initializes enemy data and player data
    private void init() {
        enemy = new Enemy("Bad Guy", 10, 100, player.getDifficulty());
        playerAttackEffective = (int) (player.getAttack() * player.getEquipped().getTotalAttackMod());
        enemyAttackEffective = (int) (enemy.getAttack() * (1 - player.getEquipped().getTotalDefenseMod()));
        enemyStartHealth = enemy.getHealth();
        addSubPanel();

    }

    // MODIFIES: this
    // EFFECTS: layouts all buttons and areas
    private void addSubPanel() {
        //stub
    }

    // MODIFIES: this
    // EFFECTS: layouts all graphics and text areas
    private void addInfoPanel() {
        //stub
    }

    // MODIFIES: this
    // EFFECTS: layouts all buttons
    private void addButtonPanel() {
        //stub
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
        new MainMenuGUI(player);
    }

    // MODIFIES: this
    // EFFECTS: exit combat without any gains, decreases difficulty by 1
    private void loseCombat() {
        player.getDifficulty().setDifficulty(player.getDifficulty().getDifficulty() - 1);
        player.fullHeal();
        JOptionPane.showMessageDialog(null, "Combat Lost.\nTry not losing next time\n\nDifficulty decreased");
        dispose();
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
        if (player.getCurrentHealth() <= 0) {
            loseCombat();
        }
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
