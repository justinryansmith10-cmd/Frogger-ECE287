import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

public class GamePanel extends JPanel{

    // Screen Settings
    final int originalTileSize = 16; // 16x16 pixel tile, however 16x16 is VERY small on modern monitors

    // to fix this issue we will create a scale

    final int scale = 3;

    // 48x48 pixels
    final int tileSize = originalTileSize * scale;

    // now to decide how big we want our display to be
    final int maxScreenCol = 16;
    final int maxScreenRow = 12; 
    final int screenWidth = tileSize * maxScreenCol; // 768
    final int screenHeight = tileSize * maxScreenRow; // 576
    // this is still relatively small(especially on a high res monitor)


    public GamePanel() {

        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
    }
    
}
