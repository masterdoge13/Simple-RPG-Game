package ui;

import javax.swing.JFrame;
import java.awt.event.*;

// an abstract class that allows for actions when the window is closed
public abstract class ClosableGUI implements WindowListener {

    // EFFECTS: prints out event log on window close
    public void windowClosing(WindowEvent e) {
        //stub
    }
}
