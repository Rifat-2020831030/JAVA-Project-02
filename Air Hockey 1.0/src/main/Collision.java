package main;

import java.awt.Rectangle;

import tool.ball;

public class Collision {
    
    public static boolean restricted(int posx, int posy)
    {
        //System.out.println(posx+" "+posy);
        if(posx<0 || posy <80 || posx+60 >800 || posy+60 >550)
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

        if(x-r == -20 || x+r ==770)  // left & rght wall
        {
            // System.out.println("x= "+x+" y ="+y);
            ball.ballvx *= (-1);
        }
        else if(y-r==50 || y+r ==550) // up & down wall
        {
           // System.out.println("Collision x= "+x+" y ="+y);
            ball.ballvy *= (-1);
        }
    
        //hit box of player 1                             // x1,y1 _____ x2
        int x1 = gamePanel.playerX , x2 = x1+60;     //      |
        int y1 = gamePanel.playerY , y2 = y1+60;     //      |
                                                      //   y2 | 
        //hit box of ball
        int a1 = x, b1 = y;
        int a2 = a1+2*r, b3 = b1+2*r, a4 = a1+2*r, b4 = b1+2*r;

        if( x2<= a1) //coming from right
        {
            if( (b3>= y1 && b3<=y2 && x2==a1) || (b1>= y1 && b1 <=y2 && x2==a1))
            {
                ball.ballvx *= (-1);
              System.out.println("Collition from right");
            }
        }
        else if(x1>= a2) //coming from left
        {
            if( (b4 >= y1 && b4 <= y2 && x1== a2) || (b1 >= y1 && b1 <= y2 && x1==a2))
            {
                ball.ballvx *= (-1);
                 System.out.println("Collision from left");
            }
        }
        else if(y2<= b1) //coming from down
        {
            if( (a1>=x1 && a1 <= x2 && y2==b1) || (a2>= x1 && a2 <= x2 && y2== b1))
            {
                ball.ballvy *= (-1);
                System.out.println("Collision from down");
            }
        }
        else if(y1>= b3) //coming from up
        {
            if( (a1>= x1 && a1 <= x2 && y1==b3) || (a2>=x1 && a2 <= x2 && y1==b3))
            {
                ball.ballvy *=(-1);
                System.out.println("Collision from up");
            }
        }


         //hit box of player 2                          // x11,y11 _____ x22
        int x11 = gamePanel.player2X , x22 = x11+60;     //      |
        int y11 = gamePanel.player2Y , y22 = y11+60;     //      |
                                                       //   y22 | 

        if( x22<= a1) //coming from right
        {
            if( (b3>= y11 && b3<=y22 && x22==a1) || (b1>= y11 && b1 <=y22 && x22==a1))
            {
                ball.ballvx *= (-1);
              System.out.println("Collition from right");
            }
        }
        else if(x11>= a2) //coming from left
        {
            if( (b4 >= y11 && b4 <= y22 && x11== a2) || (b1 >= y11 && b1 <= y22 && x11==a2))
            {
                ball.ballvx *= (-1);
                 System.out.println("Collision from left");
            }
        }
        else if(y22<= b1) //coming from down
        {
            if( (a1>=x11 && a1 <= x22 && y22==b1) || (a2>= x11 && a2 <= x22 && y22== b1))
            {
                ball.ballvy *= (-1);
                System.out.println("Collision from down");
            }
        }
        else if(y11>= b3) //coming from up
        {
            if( (a1>= x11 && a1 <= x22 && y11==b3) || (a2>=x11 && a2 <= x22 && y11==b3))
            {
                ball.ballvy *=(-1);
                System.out.println("Collision from up");
            }
        }
    }
}
