package views;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import acm.program.DialogProgram;

public class PopUp extends DialogProgram{
	public void init() {
		  JPanel inputPanel = new JPanel();
		  JTextField xcord = new JTextField("0",12);
		  JTextField ycord = new JTextField("0",12);
		     inputPanel.add(xcord);
		     inputPanel.add(ycord);
		     inputPanel.add(new JButton("Add Cordinate"));
		     
		     add(inputPanel);
	}
	
	public void run() {
		
	}
}
