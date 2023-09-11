package entity;

import java.awt.Rectangle;
import java.util.Random;

import main.GamePanel;

public class NPC_OldMan extends Entity {

    public NPC_OldMan(GamePanel gp) {
        super(gp);

        direction = "down";
        speed = 1;

        solidArea = new Rectangle();
        solidArea.x = 8;
        solidArea.y = 16;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        solidArea.width = 32;
        solidArea.height = 32;

        getImage();
        setDialogue();
    }

    public void getImage() {
        up1 = setup("/res/npc/oldman_up_1", gp.tileSize, gp.tileSize);
        up2 = setup("/res/npc/oldman_up_2", gp.tileSize, gp.tileSize);
        down1 = setup("/res/npc/oldman_down_1", gp.tileSize, gp.tileSize);
        down2 = setup("/res/npc/oldman_down_2", gp.tileSize, gp.tileSize);
        left1 = setup("/res/npc/oldman_left_1", gp.tileSize, gp.tileSize);
        left2 = setup("/res/npc/oldman_left_2", gp.tileSize, gp.tileSize);
        right1 = setup("/res/npc/oldman_right_1", gp.tileSize, gp.tileSize);
        right2 = setup("/res/npc/oldman_right_2", gp.tileSize, gp.tileSize);
    }

    public void setDialogue() {
        dialogues[0] = "Hello, lad.";
        dialogues[1] = "So, you've come to this island to find \nthe treasure?";
        dialogues[2] = "I used to be a great wizard but now... \nI'm a bit too old for taking an adventure.";
        dialogues[3] = "Well, good luck on you!";
    }

    public void setAction() {

        if (onPath == true) {
            // int goalCol = 12;
            // int goalRow =  9;
            int goalCol = (gp.player.worldX + gp.player.solidArea.x) / gp.tileSize;
            int goalRow = (gp.player.worldY + gp.player.solidArea.y) / gp.tileSize;

            searchPath(goalCol, goalRow);
        } else {

            actionLockCounter++;

            if (actionLockCounter == 120) {
                Random random = new Random();
                int i = random.nextInt(100) + 1;

                if (i <= 25) {
                    direction = "up";
                }
                if (i > 25 && i <= 50) {
                    direction = "down";
                }
                if (i > 50 && i <= 75) {
                    direction = "left";
                }
                if (i > 75 && i <= 100) {
                    direction = "right";
                }

                actionLockCounter = 0;
            }
        }
    }

    public void speak() {
        super.speak();

        onPath = true;
    }
}
