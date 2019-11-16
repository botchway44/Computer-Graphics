package controller;
import java.awt.LayoutManager;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import acm.program.Program;
import models.Grid;
import views.GraphUI;

public class GraphicController extends Program{
	
	  public void run() {
		  
//		  setLayout(new );
		  Grid grid = new Grid(1200,600, -5, 5, -5, 5);
		  
	       (new GraphUI(grid)).start();
	       
	   	JSlider x_slide = new JSlider(0, grid.getWidth(), grid.getWidth()/2);
		x_slide.setName("X VAlues");
		x_slide.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent arg) {
				// TODO Auto-generated method stub
				JSlider s = (JSlider) arg.getSource();
				
				int sV = s.getValue();
				
//				vline.setLocation(s.getValue(), vline.getY());
				println(s.getValue());
			}
			
		});
		add(x_slide);
		
		
		JSlider y_slide = new JSlider(0, grid.getWidth(), grid.getWidth()/2);
		y_slide.setName("X VAlues");
		y_slide.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent arg) {
				JSlider s = (JSlider) arg.getSource();
				
				int sV = s.getValue();
				
//				hline.setLocation(hline.getX(),s.getValue());
				println(s.getValue());
			}
			
		});
		add(y_slide);
//		x_slider
//		add(new JLabel("X values"), NORTH);
//		add(new JLabel("Y values"), EAST);
	       
	}
}
