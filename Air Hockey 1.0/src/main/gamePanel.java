package main;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

import input.MouseHandler;

public class gamePanel extends JPanel implements Runnable{
    
    final int screenWidth = 800;
    final int screenHeight = 600;

    //timing variable
    final private int FPS = 60;

    //set default position
    //player 1
    public static int playerX = 100;
    public static int playerY = 100;
    //player 2
    public static int player2X = 400;
    public static int player2Y = 400;
    private int speed = 10;

    Thread gameThread;

    KeyHandler key = new KeyHandler();
    
    MouseHandler mouse = new MouseHandler(this);

    //constractor
    public gamePanel()
    {
        mouse = new MouseHandler(this);
        this.addMouseListener(mouse);
        this.addMouseMotionListener(mouse);
        this.setPreferredSize(new Dimension(screenWidth, screenHeight)); //set window size
        this.addKeyListener(key);
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true); //enhance rendering
        this.setFocusable(true); 
        startGameThread();
    }

    // public void setPlayerPos(int x, int y)
    // {
        
    //      if(mouse.pressed == true && mouse.dragged==true)
    //     {
    //         playerX = x;
    //         playerY = y;
    //     }
    // }

    public void startGameThread()
    {
        gameThread = new Thread(this); //initiate threading this window
        gameThread.start(); // call run method
    }
    @Override
    public void run() {

        long interval = 1000000000/FPS;
        long lastTime = System.nanoTime();
        long currentTime;
        int delta = 0;

        while(gameThread != null) //game loop***
        {
            // currentTime = System.nanoTime();
            // delta += (currentTime- lastTime)/ interval;
            // lastTime = currentTime;

            //System.out.println("Mouse moved: "+ mouse.moved+ " mouse pressed: "+mouse.pressed);

        
                update();

                repaint();
               
            

        }
    }
    public void update()
    {
 
        // playerX = (int) mouse.posX;
        // playerY = (int) mouse.posY;

    }
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;
        Graphics2D g3 = (Graphics2D) g;

        g2.setColor(Color.white);
        g2.fillRect(playerX, playerY, 16, 16);
       
        g3.setColor(Color.red);
        g3.fillRect(player2X, player2Y, 20, 20);

        g3.dispose();
        g2.dispose();
    }
}