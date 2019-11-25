package controller;

import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class GridController implements ChangeListener{
	public static JSlider x_slide;
	public static JSlider y_slide;
	
	public void init() {
		 x_slide = new JSlider(0, 100, 50);
		x_slide.setName("X VAlues");
			
		y_slide = new JSlider(0,100, 50);
		y_slide.setName("X VAlues");
		
	}

	@Override
	public void stateChanged(ChangeEvent arg) {
		JSlider s = (JSlider) arg.getSource();
		
		int sV = s.getValue();
		
		if(s == y_slide) {
			//update y
		}else if(s == x_slide) {
			//update x
		}
		
	}

}
