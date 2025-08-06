package ui;


import model.EventLog;
import model.Event;

import java.awt.event.*;

import javax.swing.JFrame;

// an abstract class that allows for actions when the window is closed
public abstract class ClosableGUI extends JFrame implements WindowListener {

    // taken from ScreenPrinter in AlarmSystem
    // EFFECTS: prints out event log on window close
    public void windowClosing(WindowEvent e) {

        for (Event next : EventLog.getInstance()) {
            System.out.println(next.toString() + "\n");
        }

    }

    @Override
    public void windowOpened(WindowEvent e) {
        // pass
    }

    @Override
    public void windowClosed(WindowEvent e) {
        // pass
    }

    @Override
    public void windowIconified(WindowEvent e) {
        // pass
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
        // pass
    }

    @Override
    public void windowActivated(WindowEvent e) {
        // pass
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        // pass
    }
}
