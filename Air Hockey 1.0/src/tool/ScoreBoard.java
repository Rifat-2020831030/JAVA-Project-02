package tool;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import main.gamePanel;

public class ScoreBoard {
    
    Font arial_40;
    gamePanel gp;
    private int player1Score;
    private int player2Score;
    Image pl1;
    Image pl2;

    public ScoreBoard(gamePanel gp)
    {
        this.gp = gp;
        player1Score = 0;
        player2Score = 0;
        arial_40 = new Font("Arial", Font.PLAIN, 40);
        InputStream is = getClass().getResourceAsStream("/ice-hockey.png");
        InputStream is1 = getClass().getResourceAsStream("/ice-hockey1.png");

        try {
            pl1 = ImageIO.read(is);
            pl2 = ImageIO.read(is1);
        } catch (IOException e) {}
    }

    public void incrementPlayer1Score() {
        player1Score++;
    }
    public void incrementPlayer2Score() {
        player2Score++;
    }

    public void draw(Graphics2D g2)
    {
        g2.setFont(arial_40);
        g2.setColor(Color.BLACK);
        g2.drawImage(pl1, 280, 15, 50, 50, null, null);
        g2.drawImage(pl2, 480, 15, 50, 50, null, null);
        g2.drawString(player1Score+"", 350, 50);
        g2.drawString(""+player2Score, 430, 50);
    }

}
