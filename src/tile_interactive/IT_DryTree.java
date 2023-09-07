package tile_interactive;

import main.GamePanel;

public class IT_DryTree extends InteractiveTile{
    GamePanel gp;

    public IT_DryTree(GamePanel gp) {
        super(gp);
        this.gp = gp;

        down1 = setup("/res/tiles_interactive_drytree", gp.tileSize, gp.tileSize);
        destructible = true;
    }
    
}
