package mainFrame;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JPanel;

public class MovementPanel extends JPanel implements MouseListener, MouseMotionListener
{
	private static final long serialVersionUID = 1L;
	PopUpMenu menu = new PopUpMenu();
	boolean pressOut = false;
	int prevX, prevY;
	
	// Mouse event for panel movement
	public MovementPanel()
	{
		addMouseMotionListener(this);
	    addMouseListener(this);
	    this.setBackground(new Color(1.0f,1.0f,1.0f,0.0f));
	}
	
	public void mousePressed(MouseEvent e)
	{
		if (e.getButton() == MouseEvent.BUTTON1)
		{
			pressOut = true;
			prevX = e.getX();
			prevY = e.getY();
		}
	}

	public void mouseDragged(MouseEvent e)
	{	
		if ((pressOut == true) && (menu.getsetLock() == false))
			updateLocation(e);
	}

	public void mouseReleased(MouseEvent e)
	{
		if (e.getButton() == MouseEvent.BUTTON1)
			pressOut = false;
		
		if (e.getButton() == MouseEvent.BUTTON3)
			doPopUPMenu(e);
	}

	public void mouseMoved(MouseEvent e)
	{
	}

	public void mouseClicked(MouseEvent e)
	{
	}

	public void mouseExited(MouseEvent e)
	{
	}

	public void mouseEntered(MouseEvent e)
	{
	}

	private void updateLocation(MouseEvent e)
	{	
		MainFrame.frame.setLocation(MainFrame.frame.getX() - prevX + e.getX(), MainFrame.frame.getY() - prevY + e.getY());
	}
	
	private void doPopUPMenu(MouseEvent e)
	{
        menu.show(e.getComponent(), e.getX(), e.getY());
    }
}
