import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
public class Clock extends JLabel implements Runnable{
	private int startMinutes = 25, startSeconds = 0, currentMinutes = 0, currentSeconds = 0, breakMinutes = 5;
	private boolean isBreak = false;
	private String label = "FOCUS";
	private JLabel clockMode;
	private Thread t;
	
	Clock(){
		this.clockMode = new JLabel(label);
		clockMode.setBounds(150,100,100,50);

		setBounds(150,200,200,100);
		setText("0:00");

	}
	
	void setTime(int minutes, int seconds){
		this.currentMinutes = minutes;
		this.currentSeconds = seconds;
	}
	
	boolean getMode(){
		return this.isBreak;
	}
	
	String setTimeString(int minutes, int seconds){
		String time = "";
		if(minutes < 10){time = "0" + time.concat(Integer.toString(minutes) + ":");}
		else{time = time.concat(Integer.toString(minutes) + ":");}
		if(seconds < 10){time = time.concat("0" + Integer.toString(seconds));}
		else{time = time.concat(Integer.toString(seconds));}
		return time;
	}

	public void run() {
		this.t = Thread.currentThread();
		System.out.println("THREAD RUNNING");
		while (true){
			clockMode.setText("FOCUS");
			setText(setTimeString(startMinutes, startSeconds));//initialize clock
			currentMinutes = startMinutes;
			currentSeconds = startSeconds;
			while(currentMinutes != 0 && currentSeconds != 0){//Countdown logic
				if(currentSeconds == 0){
					currentSeconds = 59;
					currentMinutes--;
				}
				else{currentSeconds--;}
				setText(setTimeString(currentMinutes, currentSeconds));
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			clockMode.setText("BREAK");
			currentMinutes = breakMinutes;
			currentSeconds = 0;
			while(currentMinutes != 0 && currentSeconds != 0){
				if(currentSeconds == 0){
					currentSeconds = 59;
					currentMinutes--;
				}
				else{currentSeconds--;}
				setText(setTimeString(currentMinutes, currentSeconds));
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}
