package model;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import persistence.Writable;

// A class that stores unequipped equipment
public class Inventory implements Writable {

    private ArrayList<Equipment> inventoryArray;
    // EFFECTS: creates an empty inventory
    
    public Inventory() {
        inventoryArray = new ArrayList<Equipment>();
    }

    // MODIFIES: this
    // EFFECTS: adds an equipment to the inventory
    public void insertEquipment(Equipment item) {
        inventoryArray.add(item);
        EventLog.getInstance().logEvent(new Event("Added following equipment to inventory:\n" 
                + item.equipmentToString()));
    }

    // REQUIRES: the inventory has an equipment at the index invIndex
    // MODIFIES: this
    // EFFECTS: removes an equipment at the specified index
    public void removeEquipment(int invIndex) {
        Equipment item = inventoryArray.get(invIndex);
        inventoryArray.remove(invIndex);
        EventLog.getInstance().logEvent(new Event("Removed following equipment from inventory:\n" 
                + item.equipmentToString()));
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
        EventLog.getInstance().logEvent(new Event("Retrieved following equipment from inventory:\n" 
                + inventoryArray.get(invIndex).equipmentToString()));
        return inventoryArray.get(invIndex);
    }

    // EFFECTS: returns the size of the inventory
    public int getSize() {
        return inventoryArray.size();
    }

    // EFFECTS: returns the inventory array
    public ArrayList<Equipment> getEquipments() {
        return inventoryArray; //stub
    }

    // template taken from JsonSerializationDemo
    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("inventoryArray", equipmentsToJson());
        return json;
    }

    // template taken from JsonSerializationDemo
    // EFFECTS: returns equipment in inventory as a JSON array
    private JSONArray equipmentsToJson() {
        JSONArray jsonArray = new JSONArray();
        for (Equipment e : inventoryArray) {
            jsonArray.put(e.toJson());
        }

        return jsonArray;
    }

}
