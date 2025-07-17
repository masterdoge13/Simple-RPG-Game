package model;

// Contains player information and stats
public class Player {

    private static final int HEALTH_INCREMENT = 10;
    private static final int ATTACK_INCREMENT = 3;
    private static final int STAT_INCREMENT = 5;
    private static final int EXPERIENCE_THRESHOLD = 100;

    private String name;
    private int attack;
    private int maxHealth;
    private int currentHealth;
    private int level;
    private int experience;
    private int statPoints;
    private int gold;

    // REQUIRES: attack > 0 && maxHealth > 0
    // EFFECTS: creates a player with the given name, attack, and max health and sets current health to max health
    public Player(String name, int attack, int maxHealth) {
        this.name = name;
        this.attack = attack;
        this.maxHealth = maxHealth;
        this.currentHealth = maxHealth;
        level = 0;
        experience = 0;
        statPoints = 0;
        gold = 0;

    }

    // REQUIRES: getStatPoints() > 0
    // MODIFIES: this
    // EFFECTS: increases player's max health and current health by a fixed
    // increment and decreases free stat points by 1
    public void increaseMaxHealth() {
        maxHealth += HEALTH_INCREMENT;
        currentHealth += HEALTH_INCREMENT;
        statPoints--;
    }

    // MODIFIES: this
    // EFFECTS: sets current health to max health
    public void fullHeal() {
        currentHealth = maxHealth;
    }

    // REQUIRES: amount > 0
    // MODIFIES: this
    // EFFECTS: increases current health by amount but not more than max health
    public void healHealth(int amount) {
        if (currentHealth + amount >= maxHealth) {
            currentHealth = maxHealth;
        } else {
            currentHealth += amount;
        }
    }

    // REQUIRES: amount > 0
    // MODIFIES: this
    // EFFECTS: decreases health by amount but not less than 0
    public void takeDamage(int amount) {
        if (currentHealth - amount <= 0) {
            currentHealth = 0;
        } else {
            currentHealth -= amount;
        }
    }

    // REQUIRES: getStatPoints() > 0
    // MODIFIES: this
    // EFFECTS: increases player's attack by a fixed increment and decreases free
    // stat points by 1
    public void increaseAttack() {
        attack += ATTACK_INCREMENT;
        statPoints--;
    }

    // MODIFIES: this
    // EFFECTS: increments player's level by 1 and increases stat points by a fixed increment
    public void increaseLevel() {
        level++;
        increaseStatPoints(STAT_INCREMENT);
    }

    // REQUIRES: amount > 0
    // MODIFIES: this
    // EFFECTS: increases player's experience by amount specified and levels up if possible
    public void increaseExperience(int amount) {
        experience += amount;
        if (experience >= EXPERIENCE_THRESHOLD) {
            while (experience >= EXPERIENCE_THRESHOLD) {
                experience -= EXPERIENCE_THRESHOLD;
                increaseLevel();
            }
        }
    }

    // REQUIRES: amount > 0
    // MODIFIES: this
    // EFFECTS: increases player's stat points by amount specified
    public void increaseStatPoints(int amount) {
        statPoints += amount;
    }

    // REQUIRES: amount > 0 && amount <= gold
    // MODIFIES: this
    // EFFECTS: decreases gold
    public void decreaseGold(int amount) {
        gold -= amount;
    }

    // REQUIRES: amount > 0
    // MODIFIES: this
    // EFFECTS: increases gold
    public void increaseGold(int amount) {
        gold += amount;
    }

    // EFFECTS: returns the player's max health
    public int getMaxHealth() {
        return maxHealth;
    }

    // EFFECTS: returns the player's current health
    public int getCurrentHealth() {
        return currentHealth;
    }

    // EFFECTS: returns the player's attack
    public int getAttack() {
        return attack;
    }

    // EFFECTS: returns the player's name
    public String getName() {
        return name;
    }

    // EFFECTS: returns the player's level
    public int getLevel() {
        return level;
    }

    // EFFECTS: returns the player's experience
    public int getExperience() {
        return experience;
    }

    // EFFECTS: returns the player's free stat points
    public int getStatPoints() {
        return statPoints;
    }

    // EFFECTS: returns the player's gold
    public int getGold() {
        return gold;
    }
}
