package model;

public class Equipment {

    // EFFECTS: creates an equipment with a name, attack modifier, defense modifier, and equipment type
    public Equipment(String name, double attackMod, double defenseMod, EquipmentType type) {
        //stub
    }

    // EFFECTS: returns the name of the equipment
    public String getName() {
        return ""; //stub
    }

    // EFFECTS: returns the attack modifier of the equipment
    public double getAttackMod() {
        return -1; //stub
    }

    // EFFECTS: returns the defense modifier of the equipment
    public double getDefenseMod() {
        return -1; //stub
    }

    // EFFECTS: returns the equipment type
    public EquipmentType getType() {
        return EquipmentType.SWORD;
    }
}
