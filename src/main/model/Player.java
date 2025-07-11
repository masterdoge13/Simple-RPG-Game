package model;

public class Player {

    // REQUIRES: attack > 0 && maxHealth > 0
    // EFFECTS: creates a player with the given name, attack, and max health
    public Player(String name, int attack, int maxHealth) {
        //stub
    }
    
    // REQUIRES: getStatPoints() > 0
    // MODIFIES: this
    // EFFECTS: increases player's max health by a fixed increment and decreases free stat points by 1
    public void increaseMaxHealth() {
        //stub
    }

    // MODIFIES: this
    // EFFECTS: sets current health to max health
    public void fullHeal() {
        //stub
    }

    // REQUIRES: amount > 0
    // MODIFIES: this
    // EFFECTS: increases current health by amount but not more than max health
    public void healHealth(int amount) {
        //stub
    }

    // REQUIRES: amount > 0
    // MODIFIES: this
    // EFFECTS: decreases health by amount but not less than 0
    public void takeDamage(int amount) {
        //stub
    }
    
    // REQUIRES: getStatPoints() > 0
    // MODIFIES: this
    // EFFECTS: increases player's attack by a fixed increment and decreases free stat points by 1
    public void increaseAttack() {
        //stub
    }

    // MODIFIES: this
    // EFFECTS: increments player's level by 1
    public void increaselevel() {
        //stub
    }

    // REQUIRES: amount > 0
    // MODIFIES: this
    // EFFECTS: increases player's experience by amount specified
    public void increaseExperience(int amount) {
        //stub
    }

    // REQUIRES: amount > 0
    // MODIFIES: this
    // EFFECTS: increases player's stat points by amount specified
    public void increaseStatPoints(int amount) {
        //stub
    }

    // EFFECTS: returns the player's max health
    public int getMaxHealth() {
        return -1; //stub
    }

    // EFFECTS: returns the player's current health
    public int getCurrentHealth() {
        return -1; //stub
    }

    // EFFECTS: returns the player's attack
    public int getAttack() {
        return -1; //stub
    }

    // EFFECTS: returns the player's name
    public String getName() {
        return ""; //stub
    }

    // EFFECTS: returns the player's level
    public int getLevel() {
        return -1; //stub
    }

    // EFFECTS: returns the player's experience
    public int getExperience() {
        return -1; //stub
    }

    // EFFECTS: returns the player's free stat points
    public int getStatPoints() {
        return -1; //stub
    }


}
