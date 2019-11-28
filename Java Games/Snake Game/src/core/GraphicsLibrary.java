package core;

import java.awt.Point;
import java.util.ArrayList;

import models.Grid;

public  class GraphicsLibrary {
	
	public static Point getPixelPosition(Grid grid, Point point) {
		
		//within the first quadrant
		if(point.getX() <= 0 && point.getY() > 0) {
			System.out.println("is in the first quadrant");
		
			int x = grid.getXMidPoint() -  Math.abs(point.x * grid.getXPixel_gap());
			int y = grid.getYMidPoint() -  Math.abs(point.y * grid.getYPixel_gap());
			
			 return new Point(x,y);
		}
		
		else if(point.getX() <= 0 && point.getY() <= 0) {
			System.out.println("is in the third quadrant");
			int x = grid.getXMidPoint() -  Math.abs(point.x * grid.getXPixel_gap());
			int y = grid.getYMidPoint() + Math.abs(point.y * grid.getYPixel_gap());
			 
			return new Point(x,y);
		}
		
		else if(point.getX() > 0 && point.getY() > 0) {
			System.out.println("is in the second quadrant");
			
			int x = grid.getXMidPoint() +  Math.abs(point.x * grid.getXPixel_gap());
			int y = grid.getYMidPoint() - Math.abs(point.y * grid.getYPixel_gap());
			 
			return new Point(x,y);
		}
		
		else if(point.getX() > 0 && point.getY() <= 0) {
			System.out.println("is in the third quadrant");
			
			int x = grid.getXMidPoint() +  Math.abs(point.x * grid.getXPixel_gap());
			int y = grid.getYMidPoint() + Math.abs(point.y * grid.getYPixel_gap());
			 
			return new Point(x,y);
		}
		return point;
		
	}
	

	
	public static ArrayList<Point> computePixelPoints(Grid grid,ArrayList<Point> p){
		ArrayList<Point> points = new ArrayList<Point>(); 
		for(int i=0; i<p.size(); i++) {
		 points.add(GraphicsLibrary.getPixelPosition(grid, p.get(i)));
		}
		return points;
	}


	public static Layer TranslatePoint(Grid grid, Layer l,Point vector) {
		
		Layer layer = l;
		
		for(int i=0; i<layer.getGraphPoints().size(); i++) {
			Point pp = layer.getGraphPoints().get(i);
			
			pp.x = (int) (pp.getX() + vector.getX());
			pp.y = (int) (pp.getY() + vector.getY());
			
			layer.addPixelPoint(pp);
			System.err.println("Translating x = "+pp.x + "y = "+pp.y);
		}
		
		return layer;
	}

}
