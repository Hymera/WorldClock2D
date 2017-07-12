package mainFrame;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Controller
{
	private LinkedList<EntityA> ea = new LinkedList<EntityA>();
	private int howmany = 0;
	EntityA enta;
	String[][] sOptions = new String[50][9]; // 50 rows, 9 columns
	
	public Controller()
	{
		int i = 0;
		
		sOptions = read_data(sOptions);
		
		for(i = 0; i < howmany; i++)
		{
			addEntity(new CityPanel(sOptions[i][0],sOptions[i][1],sOptions[i][2],sOptions[i][3],sOptions[i][4],sOptions[i][5],sOptions[i][6]));
		}
	}
	
	public void tick()
	{
		int i = 0;
		// A CLASS
		for(i = 0; i < ea.size(); i++)
		{
			enta = ea.get(i);
			
			enta.tick(sOptions[i][7],sOptions[i][8]);
		}
	}
	
	// A CLASS
	public void addEntity(EntityA block)
	{
		ea.add(block);
	}
		
	public void removeEntity(EntityA block)
	{
		ea.remove(block);
	}
		
	public LinkedList<EntityA> getEntityA()
	{
		return ea;
	}
	
	public String[][] read_data(String sOptions[][])
	{
		int j = 0;

		try
		{
			ClassLoader loader = Controller.class.getClassLoader();
	        InputStream input = loader.getResourceAsStream("data/config.csv");
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(input));
			String line;
			
			while((line = bufferedReader.readLine()) != null)
			{
				String[] splittedLine = line.split(",");
				
				for(j = 0; j < splittedLine.length; j++)
				{
					sOptions[howmany][j] = splittedLine[j];
				}
				
				howmany++;
			}
			bufferedReader.close();
		}
		catch(IOException e)
		{
			System.err.println("Cant read file!");
		}
		return sOptions;
	}
}
