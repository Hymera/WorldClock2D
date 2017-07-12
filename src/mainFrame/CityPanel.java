package mainFrame;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CityPanel extends JPanel implements EntityA
{
	private static final long serialVersionUID = 1L;
	PopUpMenu menu = new PopUpMenu();
	JLabel name = new JLabel();
	JLabel time = new JLabel();
	
	public CityPanel(String city, String x, String y, String xcorrection, String ycorrection, String width, String height)
	{
		name.setText(city);
		name.setFont(new Font("Arial", Font.PLAIN, 12));
		name.setBackground(Color.white);
		name.setLayout(new GridBagLayout());
		name.setOpaque(true);
		
		time.setFont(new Font("Arial", Font.PLAIN, 20));
		time.setForeground(Color.red);
		time.setBackground(Color.black);
		time.setLayout(new GridBagLayout());
		time.setOpaque(true);
		
		this.add(time);
		this.add(name);	
		this.setBounds(getXpixel(Double.valueOf(x))-Integer.valueOf(xcorrection), getYpixel(Double.valueOf(y))-Integer.valueOf(ycorrection), Integer.valueOf(width), Integer.valueOf(height));
		this.setOpaque(false);
	}
	
	public void tick(String timeformat, String timezone)
	{
		if(menu.getcolor() != null)
		{
			time.setForeground(menu.getcolor());
		}
		
		if(menu.getchooseTF() != null)
		{
			time.setText(SystemDateTime.now(menu.getchooseTF(), timezone));
		}
		else
		{
			time.setText(SystemDateTime.now(timeformat, timezone));
		}
	}
	
	public static double toRadians(double deg)
	{
		return deg/180.0*Math.PI;
	}
	
	public static int getXpixel(double lon)
	{
		int pixel = 0;
		double MAP_START_LAT = 90.0;
		double MAP_END_LAT = -90.0;
		
		double mapTop = toRadians(MAP_START_LAT);
		mapTop = Math.log(Math.tan(mapTop) + (1.0 / Math.cos(mapTop)));

		double mapBottom = toRadians(MAP_END_LAT);
		mapBottom = Math.log(Math.tan(mapBottom) + (1.0 / Math.cos(mapBottom)));
		
		double mapWidth = 800; //img.getWidth(null);
		pixel = (int)(Math.floor((mapWidth / 2.0) + ((lon / 180.0) * (mapWidth / 2.0)) + 0.5));
		
		return pixel;
	}
	
	public static int getYpixel(double lat)
	{
		int pixel = 0;
		double MAP_START_LAT = 85.0;
		double MAP_END_LAT = -85.0;
		
		double mapTop = toRadians(MAP_START_LAT);
		mapTop = Math.log(Math.tan(mapTop) + (1.0 / Math.cos(mapTop)));

		double mapBottom = toRadians(MAP_END_LAT);
		mapBottom = Math.log(Math.tan(mapBottom) + (1.0 / Math.cos(mapBottom)));
		
		double mapHeight = 800; //img.getHeight(null);

		if(lat > MAP_START_LAT)
			lat = MAP_START_LAT;
		else if(lat < MAP_END_LAT)
			lat = MAP_END_LAT;
		lat = toRadians(lat);
		lat = Math.log(Math.tan(lat) + (1.0 / Math.cos(lat)));

		if(lat > 0.0)
		{
			lat /= mapTop;
			pixel = (int)(Math.floor(((mapHeight / 2.0) - (lat * (mapHeight / 2.0))) + 0.5));
		}
		else
		{
			lat /= mapBottom;
			pixel = (int)(Math.floor(((mapHeight / 2.0) + (lat * (mapHeight / 2.0))) + 0.5));
		}	
		
		return pixel;
	}
}