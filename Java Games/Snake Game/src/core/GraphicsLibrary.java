package core;

import java.awt.Point;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

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
		ArrayList<Point> points = 
				new ArrayList<Point>(); 
		for(int i=0; i<p.size(); i++) {
		 points.add(GraphicsLibrary.getPixelPosition(grid, p.get(i)));
		}
		return points;
	}


	public static Layer RotatePoint(Grid grid, Layer layer,double rtheta) {
		
		Layer new_layer = new Layer();
		new_layer.setColor(layer.getColor());
		new_layer.setName(layer.getName());
		
		for(int i=0; i<layer.getGraphPoints().size(); i++) {
			Point pp = layer.getGraphPoints().get(i);
			
			double xx = 0, yy = 0;
			
			double rad = Math.toRadians(rtheta);
			
			System.err.println(rad);
			
			xx = ((pp.getX()*Math.cos(rad)) - (Math.sin(rad) * pp.getY()));
			yy = ((pp.getX()*Math.sin(rad)) + (Math.cos(rad) * pp.getY()));
			
			System.err.println(" Decimal Rotating x = " + xx + " y = " + yy);
			
			pp.x = (int) ((pp.getX()*Math.cos(rad)) - (Math.sin(rad) * pp.getY()));
			pp.y = (int) ((pp.getX()*Math.sin(rad)) + (Math.cos(rad) * pp.getY()));
			
			new_layer.addGraphPoint(pp);
			System.err.println("Rotating x = "+ pp.x + " y = "+ pp.y+ " with "+ rtheta);
		}
		
		new_layer.setPixelPoints(GraphicsLibrary.computePixelPoints(grid, new_layer.getGraphPoints()));
		
		return new_layer;
	}
	


	public static Layer ScaleAboutMidPoint(Grid grid, Layer layer,Point scaleFactor) {
		
		Layer new_layer = new Layer();
		new_layer.setColor(layer.getColor());
		new_layer.setName(layer.getName());
		
		double midx = findXMid(layer.getGraphPoints());
		double midy = findYMid(layer.getGraphPoints());
		
		System.err.println("Midpoints x = "+ midx + " y = "+ midy);
		for(int i=0; i<layer.getGraphPoints().size(); i++) {
			Point pp = layer.getGraphPoints().get(i);
			
			//translate to the origin 0,0
			pp.x = (int) (pp.x - midx);
			pp.y = (int) (pp.y - midy);
			
			pp.x = (int) ((pp.getX()* scaleFactor.getX()));
			pp.y = (int) ((pp.getY()* scaleFactor.getY()));
			
			
			//translate to the original position
			pp.x = (int) (pp.x + midx);
			pp.y = (int) (pp.y + midy);
			
			new_layer.addGraphPoint(pp);
			System.err.println("Scaling x = "+ pp.x + " y = "+ pp.y+ " with "+ scaleFactor.getX() + " "+ scaleFactor.getY());
		}
		
		new_layer.setPixelPoints(GraphicsLibrary.computePixelPoints(grid, new_layer.getGraphPoints()));
		
		return new_layer;
	}
	
	
	public static Layer RotateAboutMidPoint(Grid grid, Layer layer,double rtheta) {
		
		Layer new_layer = new Layer();
		new_layer.setColor(layer.getColor());
		new_layer.setName(layer.getName());
		
		double midx = findXMid(layer.getGraphPoints());
		double midy = findYMid(layer.getGraphPoints());
		
		System.err.println("Midpoints x = "+ midx + " y = "+ midy);
		for(int i=0; i<layer.getGraphPoints().size(); i++) {
			Point pp = layer.getGraphPoints().get(i);
			
			//translate to the origin 0,0
			pp.x = (int) (pp.x - midx);
			pp.y = (int) (pp.y - midy);
			
			double xx = 0, yy = 0;
			
			double rad = Math.toRadians(rtheta);
			
			System.err.println(rad);
			
			xx = ((pp.getX()*Math.cos(rad)) - (Math.sin(rad) * pp.getY()));
			yy = ((pp.getX()*Math.sin(rad)) + (Math.cos(rad) * pp.getY()));
			
			System.err.println(" Decimal Rotating x = " + xx + " y = " + yy);
			
			pp.x = (int) ((pp.getX()*Math.cos(rad)) - (Math.sin(rad) * pp.getY()));
			pp.y = (int) ((pp.getX()*Math.sin(rad)) + (Math.cos(rad) * pp.getY()));
			
			
			//translate to the original position
			pp.x = (int) (pp.x + midx);
			pp.y = (int) (pp.y + midy);

			new_layer.addGraphPoint(pp);
			System.err.println("Rotating x = "+ pp.x + " y = "+ pp.y+ " with "+ rtheta);
		}
		
		new_layer.setPixelPoints(GraphicsLibrary.computePixelPoints(grid, new_layer.getGraphPoints()));
		
		return new_layer;
	}
	
	
	private static double findYMid(ArrayList<Point> graphPoints) {
		double res = 0;
		
		for(int i=0; i<graphPoints.size(); i++) {
			res += graphPoints.get(i).getY();
		}
		return res/2;
	}

	public static double findXMid(ArrayList<Point> graphPoints) {
		double res = 0;
		
		for(int i=0; i<graphPoints.size(); i++) {
			res += graphPoints.get(i).getX();
		}
		return res/2;
		
	}
	
	public static Layer TranslatePoint(Grid grid, Layer layer,Point vector) {
		
		Layer new_layer = new Layer();
		new_layer.setColor(layer.getColor());
		new_layer.setName(layer.getName());
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
	
	
	public static ArrayList<Layer> ReadFile(File file) throws FileNotFoundException {
		Scanner scan = new Scanner(file);
		ArrayList<Layer> layers = new ArrayList<Layer>();
		while(scan.hasNextLine()) {
			Layer layer = new Layer();
			
			String line = scan.nextLine();
			String[] parts = line.split(" ");
			String layerName = parts[0];
			layer.setName(layerName);
			
			for(int i=1; i<parts.length; i++) {
				String[] coord = parts[i].split(",");
				
				
				double x = Double.parseDouble(coord[0]);
				double y = Double.parseDouble(coord[1]);
				
				Point p = new Point();
				p.x = (int) x;
				p.y = (int) y;
				
				layer.addGraphPoint(p);
			}
			
			layers.add(layer);
		}
		
		scan.close();
		return layers;
	}



	public static void SaveFile(HashMap<String,Layer> layers, String path) {
		try {
//		Scanner scan = new Scanner(new File(path));
		
		System.out.println("in save");
		
			FileWriter fw = new FileWriter(path+".txt");
			//TODO fix save
			
			for(String lname : layers.keySet()) {
			Layer layer = layers.get(lname);
			String line = layer.toString() + System.getProperty("line.separator");
			System.out.println(layer);
			System.out.println(line);
			fw.write(line);
			}
			
			fw.close();
			
			
		}catch(Exception ex) {
			
	}

	}

	public static Layer ReflectXPoint(Grid grid, Layer layer) {
		Layer new_layer = new Layer();
		new_layer.setColor(layer.getColor());
		new_layer.setName(layer.getName());
		for(int i=0; i<layer.getGraphPoints().size(); i++) {
			Point pp = layer.getGraphPoints().get(i);
			
			pp.y =  (int) (-pp.getY());
			
			new_layer.addGraphPoint(pp);
			System.err.println("Translating x = "+pp.x + "y = "+pp.y);
		}
		
		new_layer.setPixelPoints(GraphicsLibrary.computePixelPoints(grid, new_layer.getGraphPoints()));
		
		return new_layer;
	}

	public static Layer ReflectYPoint(Grid grid, Layer layer) {
		Layer new_layer = new Layer();
		new_layer.setColor(layer.getColor());
		new_layer.setName(layer.getName());
		for(int i=0; i<layer.getGraphPoints().size(); i++) {
			Point pp = layer.getGraphPoints().get(i);
			
			pp.x =  (int) (-pp.getX());
			
			new_layer.addGraphPoint(pp);
			System.err.println("Translating x = "+pp.x + "y = "+pp.y);
		}
		
		new_layer.setPixelPoints(GraphicsLibrary.computePixelPoints(grid, new_layer.getGraphPoints()));
		
		return new_layer;
	}

}
