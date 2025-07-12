package model;

public class Inventory {

    // EFFECTS: creates an empty inventory
    public Inventory() {
        //stub
    }

    // MODIFIES: this
    // EFFECTS: adds an equipment to the inventory
    public void insertEquipment(Equipment item) {
        //stub
    }

    // REQUIRES: the inventory has an equipment at the index invIndex
    // MODIFIES: this
    // EFFECTS: removes an equipment at the specified index
    public void removeEquipment(int invIndex) {
        //stub
    }

    // EFFECTS: returns a string of all equipment in inventory
    public String inventoryToString() {
        return "";//stub
    }

    // REQUIRES: the inventory has an equipment at the index invIndex
    // EFFECTS: returns the equipment at the specified index
    public Equipment getEquipment(int invIndex) {
        return new Equipment(null, 0.0, 0.0, EquipmentType.SWORD);//stub
    }

    // EFFECTS: returns the size of the inventory
    public int getSize() {
        return -1;//stub
    }
}
