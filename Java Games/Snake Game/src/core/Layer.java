package core;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;

	
public class Layer {
	private ArrayList<Point> pixel_points = new ArrayList<>();
	private ArrayList<Point> graph_points = new ArrayList<>();
	private Color color = Color.blue;
	private String name;
	public Layer() {
		
	}
	
	public void setColor(Color c) {
		this.color =c;
	}
	
	public void setName(String name) {
		this.name =name;
	}
	
	
	public void setPixelPoints(ArrayList<Point> p) {
		this.pixel_points = p;
	}
	
	public Color getColor() {
		return this.color;
	}
	
	public String getName() {
		return this.name;
	}
	
	
	public void addPixelPoint(Point p) {
		this.pixel_points.add(p);
	}
	
	public void addGraphPoint(Point p) {
		this.graph_points.add(p);
	}
	
	
	public void clearPoints() {
		this.pixel_points.clear();
		this.graph_points.clear();
	}
	
	
	public ArrayList<Point> getPixelPoints(){
	return this.pixel_points;
	}
	
	public ArrayList<Point> getGraphPoints(){
	return this.graph_points;
	}
	
	public String toString() {
		
		String res = this.name;
		
		for(int i=0; i<graph_points.size(); i++) {
			Point p = graph_points.get(i);
			res  = res + " "+p.x +","+p.y;
		}
		return res;
		
	}
}
