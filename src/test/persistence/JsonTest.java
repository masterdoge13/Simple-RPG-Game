package persistence;

import model.Equipment;
import model.EquipmentType;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class JsonTest {

    protected void checkEquipment(Equipment equipment, String name, double attackMod, double defenseMod, EquipmentType type) {
        assertEquals(name, equipment.getName());
        assertEquals(attackMod, equipment.getAttackMod(), 0.0001);
        assertEquals(defenseMod, equipment.getDefenseMod(), 0.0001);
        assertEquals(type, equipment.getType());
    }
}

