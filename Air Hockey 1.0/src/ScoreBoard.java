import javax.swing.*;
import java.awt.*;

public class ScoreBoard extends JFrame {
    private int playerAScore = 0;
    private int playerBScore = 0;
    private JLabel playerAScoreLabel;
    private JLabel playerBScoreLabel;

    public ScoreBoard() {
        setTitle("Air Hockey Scoreboard");
        setSize(200, 100);
        setLayout(new GridLayout(1, 2));

        playerAScoreLabel = new JLabel("Player A: 0", SwingConstants.CENTER);
        playerBScoreLabel = new JLabel("Player B: 0", SwingConstants.CENTER);

        add(playerAScoreLabel);
        add(playerBScoreLabel);
    }

    public void updateScore(char player) {
        if (player == 'A') {
            playerAScore++;
            playerAScoreLabel.setText("Player A: " + playerAScore);
        } else if (player == 'B') {
            playerBScore++;
            playerBScoreLabel.setText("Player B: " + playerBScore);
        }

    }
}


