package test;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JButton;

import acm.graphics.GImage;
import acm.graphics.GLabel;
import acm.graphics.GLine;
import acm.graphics.GObject;
import acm.graphics.GOval;
import acm.graphics.GPoint;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;
import stanford.spl.GButton;

public class GUI extends GraphicsProgram{
	GOval rect;
	private final int MAX_HEIGHT = 600; 
	private final int MAX_WIDTH = 600; 
	private final int STEP_SIZE = 30;
	
	private ArrayList<GObject> VerticalLines = new ArrayList<GObject>();
	private ArrayList<GObject> HorizontalLines = new ArrayList<GObject>();

	
	private JButton ty;
	private JButton tx;
	private JButton rotate;
	private JButton rmGrid;
	private JButton shGrid;
	public void init() {
		addKeyListeners(this);
	}
	 
	public  void run() {
		setSize(600,600);

		//Add buttons to the South of Window
		 tx = new JButton("Translate x by 1");
		 ty = new JButton("Translate y by 1");
		 rotate = new JButton("Rotate 90");
		 rmGrid = new JButton("Remove Grid");
		 shGrid = new JButton("Show Grid");
		
		
		add(ty, SOUTH);
		add(tx, SOUTH);
		add(rotate, SOUTH);
		add(rmGrid, SOUTH);
		add(shGrid, SOUTH);
		
		//draw the horizontal line
		GLine vline = new GLine(MAX_WIDTH/2,0,MAX_WIDTH/2,MAX_HEIGHT);
		GLine hline = new GLine(0,MAX_HEIGHT/2,MAX_WIDTH,MAX_HEIGHT/2);
		
		hline.setColor(Color.red);
		vline.setColor(Color.blue);
		add(hline);
		add(vline);
	
		
		//draw a rectangle in the positive Quadrant
		rect = new GOval(10,10);
		
		
		GLabel label = new GLabel("0");
//		add(label,MAX_WIDTH/2 ,MAX_HEIGHT/2);
		
		add(rect, 360 - rect.getWidth()/2,240 - rect.getHeight()/2 );
		rect.setFilled(true);
		rect.setFillColor(Color.BLACK);
		//drawing pixels like a rectangle
		
		
		//draw the grid from top to bottom 
		for(int i=0, j=0; i<MAX_HEIGHT; i+=STEP_SIZE,j++) {
			GLine vl = new GLine(i,0,i,MAX_HEIGHT);
			GLine hl = new GLine(0,i,MAX_WIDTH,i);
			
			GLabel hlabel = null;
			GLabel vlabel = null;
			if(i>= 300) {
				int v =  j-10;
				 vlabel = new GLabel(""+v);
				 hlabel = new GLabel(""+v);
			}else {
				int v =  j-10;
				 vlabel = new GLabel(""+v);
				 hlabel = new GLabel(""+v);
			}
			add(vlabel,MAX_WIDTH/2 - vlabel.getWidth(), getHeight()-i );
			add(hlabel,i, MAX_HEIGHT/2+hlabel.getHeight());
			
			add(vl);
			VerticalLines.add(vl);
			
			add(hl);
			HorizontalLines.add(hl);
		}
		

		addActionListeners(this);
	}
	
	public void Grid(
			ArrayList<GObject> hlv, Boolean show) {
		for(int i=0; i<hlv.size(); i++) {
			GObject vl = hlv.get(i);
			vl.setVisible(show);
		}
	}
	
	
	public void keyPressed(KeyEvent e) {		
		if (rect != null) {
			 println("X = "+rect.getX()+rect.getWidth()/2);
        	 println("Y = "+rect.getY()+rect.getHeight()/2);
		      switch (e.getKeyCode()) {
		         case KeyEvent.VK_UP: 
		         		rect.setX(rect.getX()); rect.setY(rect.getY()- 15); 
		         		checkQuadrant(rect.getX()+rect.getWidth()/2, rect.getY()+rect.getHeight()/2);
		         		break;
		         case KeyEvent.VK_DOWN: println("Y = "+rect.getY());  rect.setX(rect.getX()); rect.setY(rect.getY()+ 15); break;
		         case KeyEvent.VK_LEFT:  println("Y = "+rect.getY());  rect.setY(rect.getY()); rect.setX(rect.getX()- 15); break;
		         case KeyEvent.VK_RIGHT: println("Y = "+rect.getY());  rect.setY(rect.getY()); rect.setX(rect.getX()+ 15); break;
		      }
		   }
		
		
	}
	
	
	public void checkQuadrant(double x, double y) {
		int tx = 0, ty = 0;
		if(x > 300 && y < 300) {
			tx = (int) ((x - MAX_WIDTH/2)/30);
			ty = (int) ((MAX_WIDTH/2 - y)/30);
		}
		
		
		println("x = "+ tx +" and y = "+ty);
	}
	public void actionPerformed(ActionEvent e) {		
		if(e.getSource() == rmGrid) {
			Grid(VerticalLines,false);
			Grid(HorizontalLines,false);
		}
		if(e.getSource() == shGrid) {
			Grid(VerticalLines,true);
			Grid(HorizontalLines,true);
		}
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