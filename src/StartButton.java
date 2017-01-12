import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StartButton extends MyButton implements ActionListener{
	StartButton start;
	Clock clock;
	boolean isSkip = false;
	Thread thread;
	StartButton(Thread t, Clock c){
		label = "Start";
		this.clock = c;
		setText(label);
		setBounds(50,300,width,height);
		addActionListener(this);
		
		this.thread = t;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(this.isSkip == false){this.thread.start(); this.isSkip = true;}
		setText("Skip");
		clock.setTime(0, 0);
	}
}
