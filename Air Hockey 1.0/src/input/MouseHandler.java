package input;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import main.Collision;
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
			//System.out.println("invoked at :"+ e.getX()+" "+e.getY());
			if(e.getX()+20<400)
			{
					gamePanel.updatePos(e.getX(), e.getY(), 1);
			}
			else if(e.getX()-20>=400)
			{
					gamePanel.updatePos(e.getX(), e.getY(), 2);
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
			//System.out.println("invoked at :"+ e.getX()+" "+e.getY());
			if(e.getX()+20<400)
			{
					gamePanel.updatePos(e.getX(), e.getY(), 1);
			}
			else if(e.getX()-20>=400)
			{
					gamePanel.updatePos(e.getX(), e.getY(), 2);
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