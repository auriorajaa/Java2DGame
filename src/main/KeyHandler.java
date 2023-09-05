package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
    GamePanel gp;

    public boolean upPressed, downPressed, leftPressed, rightPressed, enterPressed;

    public KeyHandler(GamePanel gp) {
        this.gp = gp;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();

        // TITLE STATE
        if (gp.gameState == gp.titleState) {
            titleState(code);
        }

        // PLAY STATE
        else if (gp.gameState == gp.playState) {
            playState(code);
        }

        // PAUSE STATE
        else if (gp.gameState == gp.pauseState) {
            pauseState(code);
        }

        // DIALOGUE STATE
        else if (gp.gameState == gp.dialogueState) {
            dialogueState(code);
        }

        // CHARACTER STATE
        else if (gp.gameState == gp.characterState) {
            characterState(code);
        }
    }

    public void titleState(int code) {
        if (code == KeyEvent.VK_W) {
            // W button
            gp.ui.commandNum--;
            if (gp.ui.commandNum < 0) {
                gp.ui.commandNum = 2;
            }
        }

        if (code == KeyEvent.VK_S) {
            // S button
            gp.ui.commandNum++;
            if (gp.ui.commandNum > 2) {
                gp.ui.commandNum = 0;
            }
        }

        if (code == KeyEvent.VK_ENTER) {
            if (gp.ui.commandNum == 0) {
                // NEW GAME
                gp.ui.titleScreenState = 1;
            }
            if (gp.ui.commandNum == 1) {
                // LOAD GAME
            }
            if (gp.ui.commandNum == 2) {
                System.exit(0);
            }
        }

        if (gp.ui.titleScreenState == 0) {

        } else if (gp.ui.titleScreenState == 1) {
            if (code == KeyEvent.VK_W) {
                // W button
                gp.ui.commandNum--;
                if (gp.ui.commandNum < 0) {
                    gp.ui.commandNum = 3;
                }
            }

            if (code == KeyEvent.VK_S) {
                // S button
                gp.ui.commandNum++;
                if (gp.ui.commandNum > 3) {
                    gp.ui.commandNum = 0;
                }
            }

            if (code == KeyEvent.VK_ENTER) {
                if (gp.ui.commandNum == 0) {
                    gp.gameState = gp.playState;
                    gp.playMusic(0);
                }
                if (gp.ui.commandNum == 1) {
                    gp.gameState = gp.playState;
                    gp.playMusic(0);
                }
                if (gp.ui.commandNum == 2) {
                    gp.gameState = gp.playState;
                    gp.playMusic(0);
                }
                if (gp.ui.commandNum == 3) {
                    gp.ui.titleScreenState = 0;
                }
            }
        }
    }

    public void playState(int code) {
        if (code == KeyEvent.VK_W) {
            // W button
            upPressed = true;
        }

        if (code == KeyEvent.VK_S) {
            // S button
            downPressed = true;
        }

        if (code == KeyEvent.VK_A) {
            // A button
            leftPressed = true;
        }

        if (code == KeyEvent.VK_D) {
            // D button
            rightPressed = true;
        }

        if (code == KeyEvent.VK_P) {
            // P button
            gp.gameState = gp.pauseState;
        }
        if (code == KeyEvent.VK_C) {
            gp.gameState = gp.characterState;
        }
        if (code == KeyEvent.VK_ENTER) {
            // Enter button
            enterPressed = true;
        }
    }

    public void pauseState(int code) {
        if (code == KeyEvent.VK_P) {
            // P button
            gp.gameState = gp.playState;
        }
    }

    public void dialogueState(int code) {
        if (code == KeyEvent.VK_ENTER) {
            // ENTER button
            gp.gameState = gp.playState;
        }
    }

    public void characterState(int code) {
        if (code == KeyEvent.VK_C) {
            // C button
            gp.gameState = gp.playState;
        }

        if (code == KeyEvent.VK_W) {
            if (gp.ui.slotRow != 0) {
                gp.ui.slotRow--;
                gp.playSE(9);
            }
        }

        if (code == KeyEvent.VK_A) {
            if (gp.ui.slotCol != 0) {
                gp.ui.slotCol--;
                gp.playSE(9);
            }
        }

        if (code == KeyEvent.VK_S) {
            if (gp.ui.slotRow != 3) {
                gp.ui.slotRow++;
                gp.playSE(9);
            }
        }

        if (code == KeyEvent.VK_D) {
            if (gp.ui.slotCol != 4) {
                gp.ui.slotCol++;
                gp.playSE(9);
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
        int code = e.getKeyCode();

        if (code == KeyEvent.VK_W) {
            // W button
            upPressed = false;
        }

        if (code == KeyEvent.VK_S) {
            // S button
            downPressed = false;
        }

        if (code == KeyEvent.VK_A) {
            // A button
            leftPressed = false;
        }

        if (code == KeyEvent.VK_D) {
            // D button
            rightPressed = false;
        }
    }
}
