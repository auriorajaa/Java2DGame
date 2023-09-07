package object;

import entity.Entity;
import main.GamePanel;

public class OBJ_ManaCrystal extends Entity {
    GamePanel gp;

    public OBJ_ManaCrystal(GamePanel gp) {
        super(gp);
        this.gp = gp;

        type = type_pickupOnly;
        name = "Mana Crystal";
        value = 1;
        down1 = setup("/res/objects/manacrystal_full", gp.tileSize, gp.tileSize);
        image = setup("/res/objects/manacrystal_full", gp.tileSize, gp.tileSize);
        image2 = setup("/res/objects/manacrystal_blank", gp.tileSize, gp.tileSize);
    }

    public void use(Entity entity) {
        gp.playSE(2);
        gp.ui.addMessage("Mana +" + value);
        entity.mana += value;
    }
}
