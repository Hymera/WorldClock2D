package mainFrame;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.util.LinkedList;
import java.util.Timer;
import javax.swing.JFrame;

public class MainFrame
{
	private static MyTimerTask timertask;
	static JFrame frame = new JFrame();
	static Controller c = new Controller();
	public static LinkedList<EntityA> ea;
	
	public static void main(String[] args)
	{
		ea = c.getEntityA();
		EntityA enta;
		Timer_Task();	
		String imgBG = "/bg/Worldmap.png";
		
		ImagePanel panelBG = new ImagePanel(imgBG);
		MovementPanel panelMove = new MovementPanel();
		
		Container cp = new Container();
	    cp.setLayout(null);
		
	    cp.add(panelMove);
		for(int i = 0; i < ea.size(); i++)
		{
			enta = ea.get(i);
			cp.add((Component)enta);
		}
	    cp.add(panelBG);
		
		frame.getContentPane().add(cp);
		frame.setPreferredSize(new Dimension(800, 570));		
		frame.setUndecorated(true);			
		frame.pack();
		frame.setVisible(true);
		
		panelMove.setSize(frame.getWidth(), frame.getHeight());
		
		frame.setTitle("World Clock");
		frame.setBackground(new Color(1.0f,1.0f,1.0f,0.0f));	
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void Timer_Task()
	{
		Timer timer = new Timer();
		timertask = new MyTimerTask();
		timer.scheduleAtFixedRate(timertask, 0, 100);
	}
}
