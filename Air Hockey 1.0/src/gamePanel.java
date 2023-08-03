import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class gamePanel extends JPanel implements Runnable{
    
    final int screenWidth = 800;
    final int screenHeight = 600;

    //timing variable
    final private int FPS = 60;


    //set default position
    private int playerX = 100;
    private int playerY = 100;
    private int speed = 5;

    Thread gameThread;

    KeyHandler key = new KeyHandler();

    //constractor
    public gamePanel()
    {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight)); //set window size
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true); //enhance rendering
        this.setFocusable(true);
    }

    public void startGameThread()
    {
        gameThread = new Thread(this); //initiate threading this window
        gameThread.start(); // call run method
    }
    @Override
    public void run() {
       
        long lastTime = System.currentTimeMillis();
        long interval = 100000/FPS;
        while(gameThread != null) //game loop***
        {
            long elapsed = System.currentTimeMillis() - lastTime;
            update();
            
            repaint();
            if(elapsed<= interval)
            {
                long slp = interval - elapsed;
                try {
                    Thread.sleep(slp);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public void update()
    {
        if(key.upKey )
        {
            playerY-= speed;
        }
        if(key.downKey)
        {
            playerY+= speed;
        }
        if(key.leftKey)
        {
            playerX-= speed;
        }
        if(key.rightKey)
        {
            playerX+= speed;
        }
    }
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        g2.setColor(Color.white);
        g2.fillRect(playerX, playerY, 16, 16);

        g2.dispose();
    }
}
