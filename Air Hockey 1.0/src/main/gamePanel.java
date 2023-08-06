package main;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.nio.Buffer;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import input.MouseHandler;
import tool.ball;

public class gamePanel extends JPanel implements Runnable{
    
    final int screenWidth = 800;
    final int screenHeight = 600;

    // image variable
    private BufferedImage bg;
    private BufferedImage ballImage;
    private BufferedImage paddle;
    private BufferedImage paddle2;

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

    //center of everything
    public static int cPaddle = 51;

    Thread gameThread;

    KeyHandler key = new KeyHandler();
    MouseHandler mouse = new MouseHandler(this);

    //constractor
    public gamePanel()
    {
        importImg();
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

    public void importImg()
    {
        InputStream is = getClass().getResourceAsStream("/bg1.png");
        InputStream ballIS = getClass().getResourceAsStream("/ball.png");
        InputStream paddle1IS = getClass().getResourceAsStream("/paddle.png");
        InputStream paddle2IS = getClass().getResourceAsStream("/paddle2.png");
        try {
            bg = ImageIO.read(is);
            ballImage = ImageIO.read(ballIS);
            paddle = ImageIO.read(paddle1IS);
            paddle2 = ImageIO.read(paddle2IS);
        } catch (IOException e) {
            e.printStackTrace();                
        }
    }

    public static void updatePos(int posX, int posY, int player)
    {
        posX -= cPaddle;
        posY -= cPaddle;
        if(player==1)
        {
            if(Collision.restricted(posX, posY))
            {
                playerX = posX;
                playerY = posY;
            }
        }
        else if(player==2)
        {
            if(Collision.restricted(posX, posY))
            {
                player2X = posX;
                player2Y = posY;
            }
        }
    }

    public void startGameThread()
    {
        gameThread = new Thread(this); //initiate threading this window
        gameThread.start(); // call run method
    }
    @Override
    public void run() {

        double interval = 1000000000/FPS;
        long lastTime = System.nanoTime();
        long currentTime;
        double delta = 0;
        long timer =0;
        long drawCount =0;


        while(gameThread != null) //game loop***
        {
            currentTime = System.nanoTime();
            delta += (currentTime- lastTime)/ interval;
            timer+= (currentTime- lastTime);
            lastTime = currentTime;
            if(delta>=1)
            {    
                update();
                repaint();
                delta--;
                drawCount++;
            }
            
            if(timer>=1000000000)
            {
                System.out.println("FPS :"+drawCount);
                drawCount=0; 
                timer=0;
            }

        }
    }
    public void update()
    {
 
        Collision.ballCollided();
        ball.ballX += ball.ballvx;
        ball.ballY += ball.ballvy;

    }
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;
        Graphics2D g3 = (Graphics2D) g;

        g.drawImage(bg, 0, 60, null);

        g.drawImage(ballImage, ball.ballX, ball.ballY, null);
        g.drawImage(paddle, playerX, playerY, null);
        g.drawImage(paddle2, player2X, player2Y, null);

        // g2.setColor(Color.BLUE);
        // g2.fillRect(playerX, playerY, 16, 16);
       
        // g3.setColor(Color.red);
        // g3.fillRect(player2X, player2Y, 20, 20);
        g2.dispose();
    }
}