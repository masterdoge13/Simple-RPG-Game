package model;

public class Equipped {

    // EFFECTS: creates an equipped object with placeholder Equipment objects
    public Equipped() {
        //stub
    }
    
    // MODIFIES: this, inventory
    // EFFECTS: equips specified equipment, adds previous equipped object to inventory
    public void equip(Equipment equipment, Inventory inventory) {
        //stub
    }

    // EFFECTS: returns equipped items as a string
    public String equippedToString() {
        return ""; //stub
    }

    // EFFECTS: returns equipped sword
    public Equipment getSword() {
        return new Equipment(null, 0, 0, null);//stub
    }

    // EFFECTS: returns equipped armour
    public Equipment getArmour() {
        return new Equipment(null, 0, 0, null);//stub
    }

    // EFFECTS: returns total attack modifier
    public double getTotalAttackMod() {
        return -1;
    }

    // EFFECTS: returns total defense modifier
    public double getTotalDefenseMod() {
        return -1;
    }
}
