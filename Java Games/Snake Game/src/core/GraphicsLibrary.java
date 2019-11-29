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
	
	//TODO complete the function to convert pixel to graph coord
	public static Point getGraphPosition(Grid grid, Point point) {
		
		//within the first quadrant
		if(point.getX() <= 0 && point.getY() > 0) {
			System.out.println("is in the first quadrant");
		
//			int x = grid.getXMidPoint() -  Math.abs(point.x * grid.getXPixel_gap());
			int x = (grid.getXMidPoint() - point.x )/grid.getXPixel_gap();
//			int y = grid.getYMidPoint() -  Math.abs(point.y * grid.getYPixel_gap());
			int y = (grid.getYMidPoint() - point.y)/grid.getXPixel_gap();
			
			 return new Point(-x,y);
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


	public static Layer RotatePoint(Grid grid, Layer layer,double rtheta) {
		
		Layer new_layer = new Layer();
		new_layer.setColor(layer.getColor());
		
		for(int i=0; i<layer.getGraphPoints().size(); i++) {
			Point pp = layer.getGraphPoints().get(i);
			
			System.err.println("x = " + pp.getX() + " y = " + pp.getY() + " theta " + rtheta);
			
/*			rtheta = Math.toRadians(rtheta);
*/			
			double degree = (pp.x * Math.cos(rtheta) - pp.y * Math.sin(rtheta));
			degree = Math.toRadians(degree);
			System.err.println("Degree = " + degree);
			
			double xx = ((pp.x * Math.cos(rtheta)) - (pp.y * Math.sin(rtheta)));
			double yy = ((pp.x * Math.sin(rtheta)) + (pp.y * Math.cos(rtheta)));
			
/*			xx = Math.toRadians(xx);
*/			
			System.err.println("doubles x = " + xx + " y = " + yy + " theta " + rtheta);
			
			pp.x = (int) ((pp.getX()*Math.cos(Math.PI * 180 / rtheta)) - (Math.sin(Math.PI * 180 / rtheta) * pp.getY()));
			pp.y = (int) ((pp.getX()*Math.sin(rtheta)) + (Math.cos(rtheta) * pp.getY()));
			
			new_layer.addGraphPoint(pp);
			System.err.println("Rotating x = "+pp.x + "y = "+pp.y);
		}
		
		new_layer.setPixelPoints(GraphicsLibrary.computePixelPoints(grid, new_layer.getGraphPoints()));
		
		return new_layer;
	}
	
	
	
	public static Layer TranslatePoint(Grid grid, Layer layer,Point vector) {
		
		Layer new_layer = new Layer();
		new_layer.setColor(layer.getColor());
		
		for(int i=0; i<layer.getGraphPoints().size(); i++) {
			Point pp = layer.getGraphPoints().get(i);
			
			pp.x = (int) (pp.getX() + vector.getX());
			pp.y = (int) (pp.getY() + vector.getY());
			
			new_layer.addGraphPoint(pp);
			System.err.println("Translating x = "+pp.x + "y = "+pp.y);
		}
		
		new_layer.setPixelPoints(GraphicsLibrary.computePixelPoints(grid, new_layer.getGraphPoints()));
		
		return new_layer;
	}

}
