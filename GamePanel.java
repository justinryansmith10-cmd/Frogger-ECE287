import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable{

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


    // Game clock
    Thread gameThread;


    public GamePanel() {

        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);

        // start the game thread when the panel is created
        startGameThread();
    }
    
    // start the main game thread
    public void startGameThread() {
        if (gameThread == null) {
            gameThread = new Thread(this);
            gameThread.start();
        }
    }

    // game loop - simple fixed delay loop
    @Override
    public void run() {
        final int FPS = 60;
        final long drawInterval = 1000L / FPS;

        while (gameThread != null) {
            long startTime = System.currentTimeMillis();

            update();
            repaint();

            long elapsed = System.currentTimeMillis() - startTime;
            long wait = drawInterval - elapsed;
            if (wait < 0) wait = 0;
            try {
                Thread.sleep(wait);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    // update game state (stub)
    private void update() {
        // TODO: update game objects, handle input, collisions, etc.
    }

    // render the game (stub)
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // TODO: draw game objects here
        // Example placeholder:
        g.setColor(Color.WHITE);
        g.drawString("Game Panel", 10, 20);
    }
    
}
