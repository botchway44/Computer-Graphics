package core;

import java.awt.Point;

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
}
