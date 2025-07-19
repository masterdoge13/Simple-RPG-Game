package model;

// the difficulty and the modifiers to different aspects of the game
public class Difficulty {

    private int difficultyValue;

    // EFFECTS: creates a difficulty modifier
    public Difficulty() {
        difficultyValue = 0;
    }

    // MODIFIES: this
    // EFFECTS: increments the difficulty number
    public void increaseDifficulty() {
        difficultyValue++;
    }

    // EFFECTS: returns the equipment attack modifier difficulty increase
    public double getEquipmentAttackMod() {
        return 1 + 0.25 * difficultyValue;
    }

    // EFFECTS: returns the equipment attack modifier difficulty increase
    public double getEquipmentDefenseMod() {
        double difficultyDouble = difficultyValue;
        if (difficultyValue == 0) {
            return 1;
        } else {
            return 1 + 1 - Math.pow(9 / 10, difficultyDouble);
        }
    }

    // EFFECTS: returns the difficulty number
    public int getDifficulty() {
        return difficultyValue;
    }

    // REQUIRES: difficulty >= 0
    // MODIFIES: this
    // EFFECTS: sets the difficulty number to specified number
    public void setDifficulty(int difficulty) {
        difficultyValue = difficulty;
    }
}
