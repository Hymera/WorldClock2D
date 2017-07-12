package mainFrame;

import java.util.TimerTask;

public class MyTimerTask extends TimerTask
{
	public void run()
	{
		MainFrame.c.tick();
	}
}
