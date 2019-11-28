package core;

import java.awt.Point;
import java.util.ArrayList;

	
public class Layer {
	private ArrayList<Point> points = new ArrayList<>();
	
	public Layer() {
		
	}
	
	public void addPoint(Point p) {
		this.points.add(p);
	}
	
	
	public ArrayList<Point> getPoints(){
	return this.points;
	}
}
