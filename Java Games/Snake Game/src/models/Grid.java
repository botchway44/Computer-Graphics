package models;

import acm.graphics.GLine;

public class Grid {

	private int width; //screen width
	private int height;//screen height
	private int x_midpoint; 
	private int y_midpoint;
	private int pixel_gap; //pixel gap
	
	private double x_min;
	private double x_max;
	private double y_max;
	private double y_min;
	
	private int x_units = 1;
	private int y_units = 1;
	

	
	public Grid(int width,int height) {
		this.width = width;
		this.height = height;
		
		this.x_min = -5;
		this.x_max = 5;
		this.y_max = 5;
		this.y_min = -5;
	}
	
	public Grid(int width, int height,  double x_min, double x_max, double y_min,double y_max) {
		this.width = width;
		this.height = height;
		
		this.x_min = x_min;
		this.x_max = x_max;
		this.y_max = y_max;
		this.y_min = y_min;
		
	}
	
	public void setXAxis(double x_min, double x_max) {
		this.x_max = x_max;
		this.x_min = x_min;
	}
	
	public double computeRatio(double posCord, double negCord) {
		return( Math.abs(posCord) / ((double) Math.abs(posCord) + Math.abs(negCord)));	
	}
	
	public int computeMidPoint(double posCord, double negCord, int size) {
		return (int) (( Math.abs(posCord) / ((double) Math.abs(posCord) + Math.abs(negCord)))*size);	
	}
	
	public int getWidth() {
		return this.width;
	}
	
	public int getHeight() {
		return this.height;
	}
	

	public int getXMidPoint() {
		//originally
//		return computeMidPoint(this.x_min, this.x_max, this.width);
		
		//now
		return this.getWidth()  / 2;
	}
	
	public int getYMidPoint() {
		//originally
//		return computeMidPoint(this.y_min, this.y_max, this.height);
		
		//now
		return this.getHeight()/2;
	}

	public int getPixel_gap() {
		return pixel_gap;
	}
	
	
	public int getXPixel_gap() {
		return  (int) (this.getXMidPoint() / Math.abs( this.x_max)) ;
	}
	

	public int getYPixel_gap() {
		return  (int) (this.getYMidPoint() /  Math.abs( this.y_max)) ;
	}
	
	public double getXMin() {
		return this.x_min;
	}
	
	
	public double getXMax() {
		return this.getXMax();
	}
	
	
	public double getYMin() {
		return this.getYMin();
	}
	

	public double getYMax() {
		return this.getYMax();
	}
	
	public void setPixel_gap(int pixel_gap) {
		this.pixel_gap = pixel_gap;
	}
}
