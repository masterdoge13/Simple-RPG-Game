package model;

public class Equipment {

    private String name;
    private double attackMod;
    private double defenseMod;
    private EquipmentType type;

    // EFFECTS: creates an equipment with a name, attack modifier, defense modifier, and equipment type
    public Equipment(String name, double attackMod, double defenseMod, EquipmentType type) {
        this.name = name;
        this.attackMod = attackMod;
        this.defenseMod = defenseMod;
        this.type = type;
    }

    // MODIFIES: this
    // EFFECTS: increments upgrade number by one up to max upgrade number and increases attack and defense modifiers
    public void incrementUpgrade() {
        //stub
    }

    // EFFECTS: returns the name of the equipment
    public String getName() {
        return name;
    }

    // EFFECTS: returns the attack modifier of the equipment
    public double getAttackMod() {
        return attackMod;
    }

    // EFFECTS: returns the defense modifier of the equipment
    public double getDefenseMod() {
        return defenseMod;
    }

    // EFFECTS: returns the equipment type
    public EquipmentType getType() {
        return type;
    }

    // EFFECTS: returns the upgrade number
    public int getUpgradeNum() {
        return -1; //stub
    }
}
