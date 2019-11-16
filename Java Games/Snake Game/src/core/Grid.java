package core;

import acm.graphics.GLine;

public class Grid {

	private int width; //screen width
	private int height;//screen height
	private int pixel_gap; //pixel gap
	
	private double x_min;
	private double x_max;
	private double y_max;
	private double y_min;
	
	private int x_units = 1;
	private int y_units = 1;
	
	private GLine vline;
	private GLine hline;
	
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
		return computeMidPoint(this.x_min, this.x_max, this.width);
	}
	
	public int getYMidPoint() {
		return computeMidPoint(this.y_min, this.y_max, this.height);
	}
}
