package test;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import acm.graphics.GLine;
import acm.graphics.GPoint;
import acm.program.GraphicsProgram;
import stanford.spl.GSlider;

public class GridTemplate extends GraphicsProgram{

	int width = 600;
	int height = 600;
	int pixel_gap = 30;
	
	
	
	private GLine vline;
	private GLine hline;
	
	int left_x = -5;
	int right_x = 5;
	int top_y = 5;
	int bottom_y = -5;
	int x_units = 1;
	int y_units = 1;
	public void run() {
		
		setSize(width,height);
		
		
		
		
		int x_midpoint = (int) computeMidPoint(left_x,right_x,width);
		
		int y_midpoint = (int) computeMidPoint(top_y,bottom_y,height);
		
		 vline = new GLine(x_midpoint,0,x_midpoint, height);
		 hline = new GLine(0,y_midpoint,width, y_midpoint);
	
		
		println("x midpoint = "+ x_midpoint);
		println("y midpoint = "+ y_midpoint);
		add(vline);
		add(hline);
		
		JSlider x_slide = new JSlider(0, 600, 300);
		x_slide.setName("X VAlues");
		x_slide.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent arg) {
				// TODO Auto-generated method stub
				JSlider s = (JSlider) arg.getSource();
				
				int sV = s.getValue();
				
				vline.setLocation(s.getValue(), vline.getY());
				println(s.getValue());
			}
			
		});
		add(x_slide,NORTH);
		
		
		JSlider y_slide = new JSlider(0, width, width);
		y_slide.setName("X VAlues");
		y_slide.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent arg) {
				JSlider s = (JSlider) arg.getSource();
				
				int sV = s.getValue();
				
				hline.setLocation(hline.getX(),s.getValue());
				println(s.getValue());
			}
			
		});
		add(y_slide,EAST);
//		x_slider
		add(new JLabel("X values"), NORTH);
		add(new JLabel("Y values"), EAST);
	}
	
	
	public double computeRatio(double posCord, double negCord) {
		return( Math.abs(posCord) / ((double) Math.abs(posCord) + Math.abs(negCord)));	
	}
	
	public int computeMidPoint(double posCord, double negCord, int size) {
		return (int) (( Math.abs(posCord) / ((double) Math.abs(posCord) + Math.abs(negCord)))*size);	
	}
}
