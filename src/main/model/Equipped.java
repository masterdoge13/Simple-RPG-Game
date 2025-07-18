package model;

// Information and stats from equipped equipment
public class Equipped {

    private Equipment sword;
    private Equipment armour;

    // EFFECTS: creates an equipped object with placeholder Equipment objects
    public Equipped() {
        sword = new Equipment("unarmed", 0, 0, EquipmentType.SWORD);
        armour = new Equipment("unarmoured", 0, 0, EquipmentType.ARMOUR);
    }

    // MODIFIES: this, inventory
    // EFFECTS: equips specified equipment, adds previous equipped object to
    // inventory
    public void equip(Equipment equipment, Inventory inventory) {
        if (equipment.getType() == EquipmentType.SWORD) {
            inventory.insertEquipment(sword);
            sword = equipment;
        }
        if (equipment.getType() == EquipmentType.ARMOUR) {
            inventory.insertEquipment(armour);
            armour = equipment;
        }
    }

    // EFFECTS: returns equipped items as a string
    public String equippedToString() {
        return "Equipped:\n" + sword.equipmentToString() + "\n" + armour.equipmentToString()
                + "\nDamage Multiplier: " + getTotalAttackMod()
                + "x\nDamage Reduction: " + getTotalDefenseMod() * 100 + "%";
    }

    // EFFECTS: returns equipped sword
    public Equipment getSword() {
        return sword;
    }

    // EFFECTS: returns equipped armour
    public Equipment getArmour() {
        return armour;
    }

    // EFFECTS: returns total attack modifier
    public double getTotalAttackMod() {
        return sword.getAttackMod() + armour.getAttackMod();
    }

    // EFFECTS: returns total defense modifier
    public double getTotalDefenseMod() {
        return 1 - ((1 - armour.getDefenseMod()) * (1 - sword.getDefenseMod()));
    }

    // MODIFIES: this
    // EFFECTS: equips equipment without putting old equipment back into the inventory
    public void setEquipment(Equipment equipment) {
        //stub TODO
    }
}
