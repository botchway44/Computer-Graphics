package controller;
import java.awt.FlowLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import acm.gui.TableLayout;
import acm.program.Program;
import core.GraphicsLibrary;
import models.Grid;
import views.GraphUI;

public class GraphProgram extends Program {
	
	  private GraphUI graph;
	  private JTextField xcord;
	  private JTextField ycord;
	  private Grid grid;
	public void run() {
//		this.setResizable(false);
		this.setLayout(new TableLayout(5,1));
//		setSize(400,700);
		  grid = new Grid(700,700, -10, 10, -10, 10);
		   
		  
	      
	     GridController gd = new GridController();
	     gd.init();
	     
	     JPanel gridScalePanel = new JPanel();
	     gridScalePanel.add(new JLabel("X axis"));
	     gridScalePanel.add(gd.x_slide);

	     gridScalePanel.add(new JLabel("Y axis"));
	     gridScalePanel.add(gd.y_slide);
	     add(gridScalePanel);
	     
	     JPanel gridVisibilityPanel = new JPanel();
	     gridVisibilityPanel.setLayout(new FlowLayout());
	     gridVisibilityPanel.add(new JButton("Remove Grid"));
	     gridVisibilityPanel.add(new JButton("Show Grid"));
	     
	     
	     gridVisibilityPanel.add(new JButton("Remove Horizontal"));
	     gridVisibilityPanel.add(new JButton("Show Horizontal"));
		 
	     gridVisibilityPanel.add(new JButton("Remove Vertical"));
	     gridVisibilityPanel.add(new JButton("Show Vertical"));
	     
		 gridVisibilityPanel.add(new JButton("Remove Labels"));
	     gridVisibilityPanel.add(new JButton("Show Labels"));
	     add(gridVisibilityPanel);
	     
	     
	     //add a UI for entering coordinates
	     JPanel inputPanel = new JPanel();
	     xcord = new JTextField("x coord",12);
	     ycord = new JTextField("y coord",12);
	     inputPanel.add(xcord);
	     inputPanel.add(ycord);
	     inputPanel.add(new JButton("Add Cordinate"));
	     
	     add(inputPanel);
	     
	     
	       graph  = new GraphUI(grid);
	       graph.start();
	       
	       graph.DrawHorizontal();
	       graph.DrawVertical();
	       
	       graph.colorMids();

	     addActionListeners(this);
	}
	
	
	public void actionPerformed(ActionEvent e) {		
		if(e.getActionCommand().equals("Remove Grid")) {
			graph.HideHorizontalLines();
			graph.HideVerticalLines();
		}
		
		if(e.getActionCommand().equals("Show Grid")) {
			graph.ShowHorizontalLines();
			graph.ShowVerticalLines();
		}
		
		if(e.getActionCommand().equals("Show Vertical")) {
			graph.ShowHorizontalLines();
			graph.ShowVerticalLines();
		}
		
		if(e.getActionCommand().equals("Remove Vertical")) {
			graph.HideVerticalLines();
		}
		
		if(e.getActionCommand().equals("Remove Horizontal")) {
			graph.HideHorizontalLines();
		}
		if(e.getActionCommand().equals("Show Horizontal")) {
			graph.ShowHorizontalLines();
			
		}
		if(e.getActionCommand().equals("Remove Labels")) {
			graph.HideLabels();
		}
		if(e.getActionCommand().equals("Show Labels")) {
			graph.ShowLabels();
			
		}
		if(e.getActionCommand().equals("Add Cordinate")) {
			
			double y = Double.parseDouble(ycord.getText());
			double x = Double.parseDouble(xcord.getText());
			println("x =  "+ x +" y ="+y);
			Point p = new Point();
			p.x = (int) x;
			p.y = (int) y;
			GraphicsLibrary.getPixelPosition(grid, p);
		}
	}
}
