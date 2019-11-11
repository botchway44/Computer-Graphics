import java.awt.Color;
import java.awt.event.KeyEvent;

import javax.swing.JButton;

import acm.graphics.GImage;
import acm.graphics.GLine;
import acm.graphics.GObject;
import acm.graphics.GPoint;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;
import stanford.spl.GButton;

public class GUI extends GraphicsProgram{
	GRect gobj;
	private final int MAX_HEIGHT = 500; 
	private final int MAX_WIDTH = 500; 
	
	
	public void init() {
		addKeyListeners(this);
	}
	 
	public  void run() {
		setSize(510,520);

		//Add buttons to the South of Window
		JButton tx = new JButton("Translate x by 1");
		JButton ty = new JButton("Translate y by 1");
		JButton rotate = new JButton("Rotate 90");
		
		addActionListeners(this);
		add(ty, SOUTH);
		add(tx, SOUTH);
		add(rotate, SOUTH);
		
		//draw the horizontal line
		GLine vline = new GLine(MAX_WIDTH/2,0,MAX_WIDTH/2,MAX_HEIGHT);
		GLine hline = new GLine(0,MAX_HEIGHT/2,MAX_WIDTH,MAX_HEIGHT/2);
//		line.setColor(Color.WHITE);
		add(hline);
		add(vline);
	
		
		//draw a rectangle in the positive Quadrant
		GRect rect = new GRect(50,25);
		add(rect,MAX_WIDTH/2 - rect.getWidth()/2 ,MAX_HEIGHT/2 - rect.getHeight()/2);
		gobj = rect;
		//drawing pixels like a rectangle
		
	}
	
	public void keyPressed(KeyEvent e) {		
		if (gobj != null) {
		      switch (e.getKeyCode()) {
		         case KeyEvent.VK_UP:    gobj.move(0, -1); break;
		         case KeyEvent.VK_DOWN:  gobj.move(0, +1); break;
		         case KeyEvent.VK_LEFT:  gobj.move(-1, 0); break;
		         case KeyEvent.VK_RIGHT: gobj.move(+1, 0); break;
		      }
		   }
		println("UP");
	}
}
                                
//GRect rect = new GRect(100,100);
//rect.setColor(Color.RED);
//rect.setFilled(true);
//rect.setFillColor(Color.GRAY);
//add(rect,100,100);
//
//for(int i=0; i<10; i++) {
//	rect.move(0, 3);
//	pause(100);
//}
//
//GRect rect2 = new GRect(100,100);
//rect2.setColor(Color.RED);
//rect2.setFilled(true);
//rect2.setFillColor(Color.GRAY);
//add(rect2, 300,300);
//
//for(int i=0; i<10; i++) {
//	rect2.move(3, 0);
//	pause(100);
//}
//

//int[][] pixels = (new GImage(new int[MAX_WIDTH][MAX_HEIGHT])).getPixelArray();
//
//for(int i=0; i<pixels.length; i++) {
//	for(int j=0; j<pixels.length; j++) {
//  int pixel = pixels[i][j];      
//  int r = GImage.getRed(pixel) +255;    
//  int g = GImage.getGreen(pixel) ;   
//  int b = GImage.getBlue(pixel);         
//  pixels[i][j] = GImage.createRGBPixel(r, g, b);
//
//		}
//	}
//add(new GImage(pixels));