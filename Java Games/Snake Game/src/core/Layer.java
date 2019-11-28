package core;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;

	
public class Layer {
	private ArrayList<Point> pixel_points = new ArrayList<>();
	private ArrayList<Point> graph_points = new ArrayList<>();
	private Color color = Color.blue;
	public Layer() {
		
	}
	
	public void setColor(Color c) {
		this.color =c;
	}
	
	public void setPixelPoints(ArrayList<Point> p) {
		this.pixel_points = p;
	}
	
	public Color getColor() {
		return this.color;
	}
	
	
	public void addPixelPoint(Point p) {
		this.pixel_points.add(p);
	}
	
	public void addGraphPoint(Point p) {
		this.graph_points.add(p);
	}
	
	
	public void clearPoints() {
		this.pixel_points.clear();
	}
	
	
	public ArrayList<Point> getPixelPoints(){
	return this.pixel_points;
	}
	
	public ArrayList<Point> getGraphPoints(){
	return this.graph_points;
	}
}
