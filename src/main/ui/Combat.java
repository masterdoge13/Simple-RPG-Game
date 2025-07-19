package ui;

import java.util.Scanner;
import model.Enemy;
import model.Player;

public class Combat {

    private Player player;
    private Enemy enemy;
    private boolean keepGoing;
    private Scanner input;
    private int playerAttackEffective;
    private int enemyAttackEffective;
    private int enemyStartHealth;

    // MODIFIES: this
    // EFFECTS: Initializes combat with player data
    public Combat(Player player) {
        this.player = player;
        runCombat();
    }

    // MODIFIES: this
    // EFFECTS: processes user input
    private void runCombat() {
        String command = null;
        init();

        while (keepGoing) {
            displayMainMenu();
            command = input.next();
            command = command.toLowerCase();

            if (command.equals("r")) {
                loseCombat();
            } else {
                processCommandCombat(command);
            }
        }
        player.fullHeal();
        System.out.println("\n\nBattle Over\n\n");

    }

    // MODIFIES: this
    // EFFECTS: initializes enemy data and player data
    private void init() {
        enemy = new Enemy("Bad Guy", 10, 100, player.getDifficulty());
        input = new Scanner(System.in);
        keepGoing = true;
        input.useDelimiter("\r?\n|\r");
        playerAttackEffective = (int) (player.getAttack() * player.getEquipped().getTotalAttackMod());
        enemyAttackEffective = (int) (enemy.getAttack() * (1 - player.getEquipped().getTotalDefenseMod()));
        enemyStartHealth = enemy.getHealth();
        System.out.println("Difficulty Level " + player.getDifficulty().getDifficulty());
    }

    // EFFECTS: processes user command in combat
    private void processCommandCombat(String command) {
        if (command.equals("a")) {
            attack();
        } else {
            System.out.println("Invalid command");
        }
    }

    // EFFECTS: displays main menu options
    private void displayMainMenu() {
        System.out.println("Enemy: " + enemy.getName());
        System.out.println("Enemy Health: " + enemy.getHealth() + "/" + enemyStartHealth
                + "\nEnemy Attack: " + enemy.getAttack());
        System.out.println("Player: " + player.getName());
        System.out.println("Player Health: " + player.getCurrentHealth() + "/" + player.getMaxHealth()
                + "\nPlayer Attack: " + playerAttackEffective);
        System.out.println("\nCombat Menu:\n");
        System.out.println("\ta -> Attack");
        System.out.println("\tr -> Retreat");
    }

    // MODIFIES: this
    // EFFECTS: gives rewards for winning, increases difficulty and exits combat
    private void winCombat() {
        keepGoing = false;
        System.out.println("You win! increasing difficulty level by 1");
        player.increaseExperience(enemy.getExperienceGain());
        player.increaseGold(enemy.getGoldGain());
        player.getDifficulty().increaseDifficulty();
        System.out.println("Difficulty: " + player.getDifficulty().getDifficulty());
        System.out.println("Player Level: " + player.getLevel());
        System.out.println("Player Experience: " + player.getExperience());
        System.out.println("Player Gold: " + player.getGold());

    }

    // MODIFIES: this
    // EFFECTS: decreases difficulty for losing and exit combat
    private void loseCombat() {
        keepGoing = false;
        if (player.getDifficulty().getDifficulty() > 0) {
            System.out.println("You Lose! Lowering difficulty level by 1");
            player.getDifficulty().setDifficulty(player.getDifficulty().getDifficulty() - 1);
            System.out.println("Difficulty: " + player.getDifficulty().getDifficulty());
        } else {
            System.out.println("You Lose! Please upgrade something bro you kinda suck");
        }
    }

    // MODIFIES: this
    // EFFECTS: attack the enemy
    private void attack() {
        enemy.takeDamage(playerAttackEffective);
        if (enemy.isDead()) {
            winCombat();
        } else {
            getAttacked();
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
}
