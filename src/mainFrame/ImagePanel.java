package mainFrame;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class ImagePanel extends JPanel
{
	private static final long serialVersionUID = 1L;
	BufferedImage img;

	public ImagePanel(String imgData)
	{
		try
		{
			img = ImageIO.read(ResourceLoader.load(imgData));
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));
		setPreferredSize(size);
		setMinimumSize(size);
		setMaximumSize(size);
		setSize(size);
		setLayout(null);
	}

	public void paintComponent(Graphics g)
	{
		super.paintComponents(g);

		g.drawImage(img, 0, 0, null);
		g.dispose();
	}
	
}
