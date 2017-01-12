
import javax.swing.*;

public class Pomodoro implements Runnable{
	JFrame frame;
	JLabel time;
	JButton start, stop, pause;
	Thread t = null;
	int minutes = 0, seconds = 0;
	String timeString = "0:00";
	
	String setTimeString(int minutes, int seconds){
		String time = "";
		if(minutes < 10){time = "0" + time.concat(Integer.toString(minutes) + ":");}
		else{time = time.concat(Integer.toString(minutes));}
		if(seconds < 10){time = time.concat("0" + Integer.toString(seconds));}
		else{time = time.concat(Integer.toString(seconds));}
		return time;
	}
	Pomodoro(){
		frame = new JFrame("Pomodoro");
		time = new JLabel(timeString);
		start = new JButton("Start");
		stop = new JButton("Stop");
		pause = new JButton("Pause");
		
		minutes = 25; seconds = 0;
		
		t = new Thread(this);
		t.start();
	}
	public void run() {
		
	}
	public static void main(String[] args) {
		JFrame f = new JFrame();
		Clock clock = new Clock();
		Thread t = new Thread(clock);
		StartButton start = new StartButton(t, clock);
		PauseButton pause = new PauseButton(t);
		ResetButton reset = new ResetButton(t, clock);

		f.setSize(500,500);
		f.setLayout(null);
		f.setVisible(true);
		
		f.add(clock);
		f.add(start);
		f.add(pause);
		f.add(reset);

	}




}
