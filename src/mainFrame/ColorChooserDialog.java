package mainFrame;

import java.awt.Color;
import javax.swing.JColorChooser;
import javax.swing.JFrame;

public class ColorChooserDialog extends JFrame
{
	private static final long serialVersionUID = 1L;
	private Color color;
	
	public ColorChooserDialog()
	{
		color = JColorChooser.showDialog(this, "Choose a color", Color.red);
		// System.out.println("The selected color was:" + color);
	}
		
	public Color getColor()
	{
		return color;
	}
}
