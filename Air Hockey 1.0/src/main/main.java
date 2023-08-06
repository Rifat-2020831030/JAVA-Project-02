package main;
import java.awt.Color;
import java.awt.Component;
import java.awt.PageAttributes.ColorType;

import javax.swing.JFrame;

import input.MouseHandler;

public class main {
    
    public static void main(String[] args) {
        
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("Air Hockey");
        window.setBackground(Color.BLACK);
        

        gamePanel panel = new gamePanel();
        window.add(panel); //add game panel to the main window panel
        window.pack();

        window.setLocationRelativeTo(null);
        window.setVisible(true);

        panel.startGameThread();

    }
}
