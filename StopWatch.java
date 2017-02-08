
public class StopWatch {

	private boolean isRunning;
	private long timeElapsed;
	private long startTime;
	
	public StopWatch(){
		reset();
	}
	
	public void start(){
		if(isRunning)
			return;
		
		isRunning = true;
		startTime = System.nanoTime();
	}
	
	public void stop(){
		if(!isRunning)
			return;
		
		isRunning = false;
		long endTime = System.nanoTime();
		timeElapsed += + endTime - startTime;
	}
	
	public long getTimeElapsed(){
		if(isRunning){
			long endTime = System.nanoTime();
			return timeElapsed + endTime + startTime;
		}
		
		else
			return timeElapsed;
	}
	
	public void reset(){
		timeElapsed = 0;
		isRunning = false;
	}
}
