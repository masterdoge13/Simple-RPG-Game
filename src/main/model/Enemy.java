package model;

public class Enemy {

    // REQUIRES: attack >= 0 && health > 0
    // EFFECTS: creates an enemy with the specified base attack, base health, and difficulty modifier
    public Enemy(String name, int attack, int health, Difficulty difficulty) {
        //stub
    }

    // EFFECTS: returns the experience gained on kill
    public int getExperienceGain() {
        return -1;//stub
    }

    // EFFECTS: returns the gold gained on kill
    public int getGoldGain() {
        return -1;//stub
    }
    // EFFECTS: returns the attack damage
    public int getAttack() {
        return -1;//stub
    }

    // EFFECTS: returns the health
    public int getHealth() {
        return -1;//stub
    }

    // EFFECTS: returns the difficulty of the enemy
    public Difficulty getDifficulty() {
        return new Difficulty();//stub
    }

    // MODIFIES: this
    // EFFECTS: returns true if enemy is killed
    public boolean isDead() {
        return false;//stub
    }

    // REQUIRES: damage >= 0
    // MODIFIES: this
    // EFFECTS: decreases health by damage
    public void takeDamage(int damage) {
        //stub
    }
}
