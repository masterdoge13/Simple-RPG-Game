package model;

import java.util.ArrayList;

// A class that stores unequipped equipment
public class Inventory {

    private ArrayList<Equipment> inventoryArray;
    // EFFECTS: creates an empty inventory
    
    public Inventory() {
        inventoryArray = new ArrayList<Equipment>();
    }

    // MODIFIES: this
    // EFFECTS: adds an equipment to the inventory
    public void insertEquipment(Equipment item) {
        inventoryArray.add(item);
    }

    // REQUIRES: the inventory has an equipment at the index invIndex
    // MODIFIES: this
    // EFFECTS: removes an equipment at the specified index
    public void removeEquipment(int invIndex) {
        inventoryArray.remove(invIndex);
    }

    // EFFECTS: returns a string of all equipment in inventory
    public String inventoryToString() {
        String items = "";
        int count = 0;
        for (Equipment equipment : inventoryArray) {
            items = items + count + ") " + equipment.equipmentToString() + "\n";
            count++;
        }
        items = "Inventory:\n" + items;
        return items;
    }

    // REQUIRES: the inventory has an equipment at the index invIndex
    // EFFECTS: returns the equipment at the specified index
    public Equipment getEquipment(int invIndex) {
        return inventoryArray.get(invIndex);
    }

    // EFFECTS: returns the size of the inventory
    public int getSize() {
        return inventoryArray.size();
    }
}
