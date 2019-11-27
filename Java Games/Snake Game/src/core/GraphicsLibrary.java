package core;

import java.awt.Point;

import models.Grid;

public  class GraphicsLibrary {
	
	public static Point getPixelPosition(Grid grid, Point point) {
		
		//within the first quadrant
		if(point.getX() < grid.getXMidPoint() && point.getY() < grid.getYMidPoint()) {
			System.out.println("is in the first quadrant");
		}
		
		else if(point.getX() < grid.getXMidPoint() && point.getY() > grid.getYMidPoint()) {
			System.out.println("is in the second quadrant");
		}
		 
		return point;
		
	}
}
