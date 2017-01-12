import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PauseButton extends MyButton implements ActionListener{
	JButton pause;
	Thread thread;
	PauseButton(Thread t){
		label = "Pause";
		setText(label);
		setBounds(200,300,width,height);
		
		this.thread = t;
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(this.thread.isInterrupted()){
			try {
				setText("Resume");
				this.thread.wait();
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		else{
			this.thread.interrupt();
			this.thread.interrupted();
		}
		
	}

}
