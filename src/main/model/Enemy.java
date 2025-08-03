package model;

// An enemy for the player to fight and gain rewards from
public class Enemy {

    private String name;
    private int attack;
    private int health;
    private int maxHealth;
    private int baseExperience;
    private int baseGold;
    private Difficulty difficulty;


    // REQUIRES: attack >= 0 && health > 0
    // EFFECTS: creates an enemy with the specified base attack, base health, and difficulty modifier
    public Enemy(String name, int attack, int health, Difficulty difficulty) {
        this.name = name;
        this.attack = (int) (attack * (1 + 0.5 * difficulty.getDifficulty()));
        baseExperience = 100;
        baseGold = 10;
        this.health = (int) (health * (1 + 0.5 * difficulty.getDifficulty()));
        this.maxHealth = this.health;
        this.difficulty = difficulty;
    }

    // EFFECTS: returns the experience gained on kill
    public int getExperienceGain() {
        int finalExperience = (int) (baseExperience * (1 + 0.5 * difficulty.getDifficulty()));
        return finalExperience;
    }

    // EFFECTS: returns the gold gained on kill
    public int getGoldGain() {
        int finalGold = (int) (baseGold * (1 + 0.5 * difficulty.getDifficulty()));
        return finalGold;
    }

    // EFFECTS: returns the name
    public String getName() {
        return name;
    }

    // EFFECTS: returns the attack damage
    public int getAttack() {
        return attack;
    }

    // EFFECTS: returns the health
    public int getHealth() {
        return health;
    }

    // EFFECTS: returns the max health
    public int getMaxHealth() {
        return maxHealth;
    }

    // EFFECTS: returns the difficulty of the enemy
    public Difficulty getDifficulty() {
        return difficulty;
    }

    // EFFECTS: returns true if enemy is killed
    public boolean isDead() {
        return health <= 0;
    }

    // REQUIRES: damage >= 0
    // MODIFIES: this
    // EFFECTS: decreases health by damage
    public void takeDamage(int damage) {
        health -= damage;
    }
}
