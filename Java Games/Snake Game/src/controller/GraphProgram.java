package controller;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import acm.gui.TableLayout;
import acm.program.Program;
import models.Grid;
import views.GraphUI;

public class GraphProgram extends Program {
	
	  private GraphUI graph;

	public void run() {
		  
		this.setLayout(new TableLayout(5,1));
//		  setLayout(fl );
		   Grid grid = new Grid(500,600, -5, 5, -5, 5);
		   grid.setPixel_gap(30);
		  
	       graph  = new GraphUI(grid);
	       graph.start();
	       
	       graph.DrawHorizontal();
	       graph.DrawVertical();
	     GridController gd = new GridController();
	     gd.init();
	     
	     JPanel gridScalePanel = new JPanel();
	     gridScalePanel.add(new JLabel("X axis"));
	     gridScalePanel.add(gd.x_slide);

	     gridScalePanel.add(new JLabel("Y axis"));
	     gridScalePanel.add(gd.y_slide);
	     add(gridScalePanel);
	     
	     JPanel gridVisibilityPanel = new JPanel();
	     
	     gridVisibilityPanel.add(new JButton("Remove Grid"));
	     gridVisibilityPanel.add(new JButton("Show Grid"));
	     
	     
	     gridVisibilityPanel.add(new JButton("Remove Horizontal"));
	     gridVisibilityPanel.add(new JButton("Show Horizontal"));
		 
	     gridVisibilityPanel.add(new JButton("Remove Vertical"));
	     gridVisibilityPanel.add(new JButton("Show Vertical"));
	     
		 gridVisibilityPanel.add(new JButton("Remove Labels"));
	     gridVisibilityPanel.add(new JButton("Show Labels"));
	     
	     add(gridVisibilityPanel,SOUTH);
	     
	     
	     
	     
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
	}
}
