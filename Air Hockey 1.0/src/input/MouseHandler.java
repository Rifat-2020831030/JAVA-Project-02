package input;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import main.gamePanel;

public class MouseHandler implements MouseListener, MouseMotionListener {

	private gamePanel gamePanel;
	public MouseHandler(gamePanel gamePanel) {
		this.gamePanel= gamePanel;
	}

	public boolean dragged, pressed;
	
	@Override
	public void mouseDragged(MouseEvent e) {
		dragged = true;
		
		if(dragged == true && pressed == true)
		{
			System.out.println("invoked at :"+ e.getX()+" "+e.getY());
			if(e.getX()<400)
			{
				gamePanel.playerX = e.getX();
				gamePanel.playerY = e.getY();
			}
			else if(e.getX()>=400)
			{
				gamePanel.player2X = e.getX();
				gamePanel.player2Y = e.getY();
			}
		}
		// System.out.println("mouse dragged");
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// System.out.println("moved");
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// System.out.println("pressed");
		pressed = true;
		if(dragged == true && pressed == true)
		{
			System.out.println("invoked at :"+ e.getX()+" "+e.getY());
			if(e.getX()<400)
			{
				gamePanel.playerX = e.getX();
				gamePanel.playerY = e.getY();
			}
			else if(e.getX()>=400)
			{
				gamePanel.player2X = e.getX();
				gamePanel.player2Y = e.getY();
			}
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		pressed = false;

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		System.out.println("mouse exited");
	}

}