package mainFrame;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

public class PopUpMenu extends JPopupMenu implements ActionListener
{
	private static final long serialVersionUID = 1L;
	public static boolean setLock = false;
	public static Color color;
	public static String chooseTF;
	JMenu timeFormat;
	JMenuItem timeFormatHMS;
	JMenuItem timeFormatHM;
	JMenuItem timeColor;
	JMenuItem lock;
	JMenuItem exit;
	
	public PopUpMenu()
	{
		timeFormat = new JMenu("Choose a time format");
		timeFormatHMS = new JMenuItem("HH:mm:ss");
		timeFormatHM = new JMenuItem("HH:mm");
		timeColor = new JMenuItem("Choose a time color");
		lock = new JMenuItem("Set lock: true");
		exit = new JMenuItem("Exit");
		
		
		timeFormat.add(timeFormatHMS);
		timeFormat.add(timeFormatHM);
		add(timeFormat);
		this.addSeparator();
		add(timeColor);
		this.addSeparator();
        add(lock);
        this.addSeparator();
        add(exit);
        
        timeFormatHMS.addActionListener(this);
        timeFormatHM.addActionListener(this);
        timeColor.addActionListener(this);
        lock.addActionListener(this);
        exit.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e)
	{	
		switch(e.getActionCommand())
		{
			case "HH:mm:ss":			chooseTF = "HH:mm:ss";
										break;
			
			case "HH:mm":				chooseTF = "HH:mm";
										break;
			
			case "Choose a time color":	ColorChooserDialog colorDia = new ColorChooserDialog();
										color = colorDia.getColor();
										break;
			
			case "Set lock: true":		setLock = true;
										lock.setText("Set lock: false");
										repaint();
										break;
			
			case "Set lock: false":		setLock = false;
										lock.setText("Set lock: true");
										repaint();
										break;
			
			case "Exit":				MainFrame.frame.setVisible(false);
										MainFrame.frame.dispose();
										System.exit(0);
										break;	
			
			default:;
										break;
		}
	}
	
	public boolean getsetLock()
	{
		return setLock;
	}
	
	public Color getcolor()
	{
		return color;
	}
	
	public String getchooseTF()
	{
		return chooseTF;
	}
}
