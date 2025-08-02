package ui;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

import model.Equipment;
import model.EquipmentType;
import model.Player;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

public class BuyEquipmentGUI extends JFrame {

    private static final int WIDTH = 800;
    private static final int HEIGHT = 1000;
    private static final int EQUIPMENT_PRICE = 20;
    private static final double SWORD_BASE_LOWER_RANGE = 1.0;
    private static final double SWORD_BASE_UPPER_RANGE = 3.0;
    private static final double ARMOUR_BASE_LOWER_RANGE = 0.1;
    private static final double ARMOUR_BASE_UPPER_RANGE = 0.45;
    private static final String IMAGES_PATH = System.getProperty("user.dir") + "/images/";

    private Player player;

    // EFFECTS: creates buy equipment screen that allows for naming new equipment
    public BuyEquipmentGUI(Player player) {
        this.player = player;
        addSubPanel();
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    // MODIFIES: this
    // EFFECTS: layouts all buttons and areas
    private void addSubPanel() {
        JPanel subPanel = new JPanel();
        subPanel.setLayout(new BorderLayout());
        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new BorderLayout());
        JTextArea currentlyEquipped = new JTextArea(player.getEquipped().equippedToString());
        infoPanel.setPreferredSize(new Dimension(100, 100));
        infoPanel.add(currentlyEquipped);
        infoPanel.add(new JLabel("Gold: " + Integer.toString(player.getGold()), SwingConstants.RIGHT),
                BorderLayout.LINE_END);
        subPanel.add(infoPanel, BorderLayout.PAGE_START);
        addCreateEquipmentButtons(subPanel);
        subPanel.add(new JButton(new BackToMenu()), BorderLayout.PAGE_END);
        add(subPanel);
    }

    // MODIFIES: this
    // EFFECTS: creates the buttons that allow for new equipment creation
    private void addCreateEquipmentButtons(JPanel jPanel) {
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(2, 1));
        JButton swordButton = new JButton("New Sword\n" + EQUIPMENT_PRICE + " Gold",
                new ImageIcon(IMAGES_PATH + "swordicon.png"));
        swordButton.addActionListener(new CreateEquipment(EquipmentType.SWORD));
        JButton armourButton = new JButton("New Armour\n" + EQUIPMENT_PRICE + " Gold",
                new ImageIcon(IMAGES_PATH + "armouricon.png"));
        armourButton.addActionListener(new CreateEquipment(EquipmentType.ARMOUR));
        buttonPanel.add(swordButton);
        buttonPanel.add(armourButton);
        jPanel.add(buttonPanel);
    }



    // goes to the main menu
    private class BackToMenu extends AbstractAction {

        protected BackToMenu() {
            super("Exit");
        }

        // MODIFIES: this
        // EFFECTS: opens the main menu
        @Override
        public void actionPerformed(ActionEvent evt) {
            dispose();
            new MainMenuGUI(player);

        }
    }

    // creates and adds equipment to the inventory
    private class CreateEquipment extends AbstractAction {

        EquipmentType equipmentType;

        protected CreateEquipment(EquipmentType equipmentType) {
            super();
            this.equipmentType = equipmentType;
        }

        // MODIFIES: this
        // EFFECTS: creates selected equipment and adds it to the inventory
        @Override
        public void actionPerformed(ActionEvent evt) {
            String equipmentName = JOptionPane.showInputDialog(null,
                    "Name your weapon",
                    "Weapon Maker",
                    JOptionPane.QUESTION_MESSAGE);
            if (player.getGold() < EQUIPMENT_PRICE) {
                JOptionPane.showMessageDialog(null, "You need more gold");
            } else {
                player.decreaseGold(EQUIPMENT_PRICE);
                player.getInventory().insertEquipment(createSelectedEquipment(equipmentName));
                dispose();
                new BuyEquipmentGUI(player);
            }
        }

        // EFFECTS: creates and returns a new equipment
        public Equipment createSelectedEquipment(String name) {
            Equipment newEquipment = null;
            double baseModifier = 0;
            if (equipmentType.equals(EquipmentType.SWORD)) {
                baseModifier = Math.random() * (SWORD_BASE_UPPER_RANGE - SWORD_BASE_LOWER_RANGE)
                        + SWORD_BASE_LOWER_RANGE;
                newEquipment = new Equipment(name, baseModifier
                        * player.getDifficulty().getEquipmentAttackMod(),
                        0.0, EquipmentType.SWORD);
            } else if (equipmentType.equals(EquipmentType.ARMOUR)) {
                baseModifier = Math.random() * (ARMOUR_BASE_UPPER_RANGE - ARMOUR_BASE_LOWER_RANGE)
                        + ARMOUR_BASE_LOWER_RANGE;
                newEquipment = new Equipment(name, 0.0, baseModifier
                        * player.getDifficulty().getEquipmentDefenseMod(), EquipmentType.ARMOUR);
            }
            JOptionPane.showMessageDialog(null, "Created Equipment\n"
                    + newEquipment.equipmentToString());
            return newEquipment;
        }
    }
}
