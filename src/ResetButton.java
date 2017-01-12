import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
public class ResetButton extends MyButton implements ActionListener{
	Clock clock;
	Thread thread;
	ResetButton(Thread t, Clock c){
		label = "Reset";
		setText(label);
		setBounds(350,300,width, height);
		this.clock = c;
		this.thread = t;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(clock.getMode()){
			clock.setTime(25, 0);
		}
		else{
			clock.setTime(5, 0);
		}
	}

}
