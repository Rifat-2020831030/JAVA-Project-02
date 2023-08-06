package main;

import tool.ball;

public class Collision {
    
    public static boolean restricted(int posx, int posy)
    {
        System.out.println(posx+" "+posy);
        if(posx<0 || posy <80 || posx+102 >800 || posy+102 >550)
        {
            return false;
        }
        return true;
    }

    public static void ballCollided()
    {
        int x = ball.ballX; //for ease
        int y = ball.ballY;
        int r = ball.radius;

        if(x-r == -20 || x+r ==770)
        {
            System.out.println("x= "+x+" y ="+y);
            ball.ballvx *= (-1);
        }
        else if(y-r==30 || y+r ==550)
        {
            System.out.println("x= "+x+" y ="+y);
            ball.ballvy *= (-1);
        }
    
        //hit box of player 1
        int a= gamePanel.playerX, b = gamePanel.playerX;
        int c = a+102, d = b+102;

    }
}
