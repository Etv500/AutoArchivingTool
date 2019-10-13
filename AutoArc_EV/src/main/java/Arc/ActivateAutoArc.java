package Arc;


import java.util.Calendar;
import java.util.TimerTask;
import java.util.Timer;

public class ActivateAutoArc {
	
	//boolean swithc = true;
	Timer timer = new Timer();
	int inputhour;
	
	public void Activate(String sethour) {
		
		
		inputhour=Integer.parseInt(sethour);
		boolean swithc = true;
		
		
		if (swithc == true) { 
			TimerTask tt = new TimerTask(){
				public void run(){
					Calendar cal = Calendar.getInstance(); 
	 
					int hour = cal.get(Calendar.HOUR_OF_DAY);//get the hour number of the day, from 0 to 23
					System.out.println(sethour);
					System.out.println(inputhour);
					if(hour == inputhour){
						CopyPaste A = new CopyPaste();
						A.CopyAndPaste(null,null);
						//doing the scheduled task
					}
				}
			};
			timer.schedule(tt, 1000, 1000*3600); //delay the task 1 second, and then run task every hour
		}	
		else {
		}
	}
	
	public void CancelActivate() {
		timer.cancel();
		timer.purge();
	}
	
}
