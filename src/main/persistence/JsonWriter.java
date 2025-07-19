package persistence;

import model.Player;
import org.json.JSONObject;


import java.io.*;

// template taken from JsonSerializationDemo
// Represents a writer that writes JSON representation of the player to file
public class JsonWriter {

    // EFFECTS: constructs writer to write to destination file
    public JsonWriter(String destination) {
        //stub TODO
    }

    // MODIFIES: this
    // EFFECTS: opens writer; throws FileNotFoundException if destination file cannot
    // be opened for writing
    public void open() throws FileNotFoundException {
       //stub TODO
    }

    // MODIFIES: this
    // EFFECTS: writes JSON representation of the player to file
    public void write(Player p) {
        //stub TODO
    }

    // MODIFIES: this
    // EFFECTS: closes writer
    public void close() {
        //stub TODO
    }

    // MODIFIES: this
    // EFFECTS: writes string to file
    private void saveToFile(String json) {
        //stub TODO
    }
}
