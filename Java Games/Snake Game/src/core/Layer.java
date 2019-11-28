package core;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;

	
public class Layer {
	private ArrayList<Point> points = new ArrayList<>();
	private Color color = Color.blue;
	public Layer() {
		
	}
	
	public void setColor(Color c) {
		this.color =c;
	}
	
	
	public Color getColor() {
		return this.color;
	}
	
	
	public void addPoint(Point p) {
		this.points.add(p);
	}
	
	
	public void clearPoints() {
		this.points.clear();
	}
	
	
	public ArrayList<Point> getPoints(){
	return this.points;
	}
}
