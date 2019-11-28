package controller;
import java.awt.FlowLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;

import acm.gui.TableLayout;
import acm.program.Program;
import core.GraphicsLibrary;
import core.Layer;
import javafx.scene.control.ListView;
import models.Grid;
import views.GraphUI;

public class GraphProgram extends Program {
	
	  private GraphUI graph;
	  private JTextField xcord;
	  private JTextField ycord;
	  private Grid grid;
	  private HashMap<String,Layer> graphPolygonsMap;
	  private ArrayList<String> graphPolygonNames= new ArrayList<>();
	  private JComboBox<String> graphPolygons;
	private JTextField polygonName;
	  
	  public void init() {
//		  this.setResizable(false);
			this.setLayout(new TableLayout(5,1));		
			
			//init the Polygon Map
			graphPolygonsMap = new HashMap<String,Layer>();
			
			//add a default Polygon to the Map
			graphPolygonsMap.put("Default", new Layer());
			
			//Adding a ComboBox on Screen
			 graphPolygonNames.add("Default");
			 graphPolygons = new JComboBox(graphPolygonNames.toArray());
			 add(graphPolygons);
			 
			 JPanel createPolygon = new JPanel();
			 polygonName = new JTextField("Enter Polygon name",12);
			
			 createPolygon.add(polygonName);
			 createPolygon.add(new JButton("Create"));
			 add(createPolygon);
		     
			   //add a UI for entering coordinates
		     JPanel inputPanel = new JPanel();
		     xcord = new JTextField("0",12);
		     ycord = new JTextField("0",12);
		     inputPanel.add(xcord);
		     inputPanel.add(ycord);
		     inputPanel.add(new JButton("Add Cordinate"));
		     
		     add(inputPanel);
		     
		    
		     //Grid Buttons
		     JPanel gridVisibilityPanel = new JPanel();
		     gridVisibilityPanel.setLayout(new TableLayout(6,2));
		     gridVisibilityPanel.add(new JButton("Draw Selected Coord From Layer"));
		     gridVisibilityPanel.add(new JButton("UnDraw"));
		     gridVisibilityPanel.add(new JButton("Remove Grid"));
		     gridVisibilityPanel.add(new JButton("Show Grid"));
		     
		     
		     gridVisibilityPanel.add(new JButton("Remove Horizontal"));
		     gridVisibilityPanel.add(new JButton("Show Horizontal"));
			 
		     gridVisibilityPanel.add(new JButton("Remove Vertical"));
		     gridVisibilityPanel.add(new JButton("Show Vertical"));
		     
		     gridVisibilityPanel.add(new JButton("Remove Labels"));
		     gridVisibilityPanel.add(new JButton("Show Labels"));
		     
			 gridVisibilityPanel.add(new JButton("Clear Layer"));
		     gridVisibilityPanel.add(new JButton("Clear Canvas"));
		     add(gridVisibilityPanel);
		     
		     
		  
		     
	  }
	public void run() {
		  setSize(350,700);
		  this.setResizable(false);
		  grid = new Grid(700,700, -10, 10, -10, 10);
		   
		  
	       graph  = new GraphUI(grid);
	       graph.start();
	       
	       graph.DrawHorizontal();
	       graph.DrawVertical();
	       
	       graph.colorMids();

	     addActionListeners(this);
	}
	
	
	public void actionPerformed(ActionEvent e) {		
		if(e.getActionCommand().equals("Remove Grid")) {
			graph.HideHorizontalLines();
			graph.HideVerticalLines();
		}
		
		if(e.getActionCommand().equals("Show Grid")) {
			graph.ShowHorizontalLines();
			graph.ShowVerticalLines();
		}
		
		if(e.getActionCommand().equals("Show Vertical")) {
			graph.ShowVerticalLines();
		}
		
		if(e.getActionCommand().equals("Remove Vertical")) {
			graph.HideVerticalLines();
		}
		
		if(e.getActionCommand().equals("Remove Horizontal")) {
			graph.HideHorizontalLines();
		}
		if(e.getActionCommand().equals("Show Horizontal")) {
			graph.ShowHorizontalLines();
			
		}
		if(e.getActionCommand().equals("Remove Labels")) {
			graph.HideLabels();
		}
		if(e.getActionCommand().equals("Show Labels")) {
			graph.ShowLabels();	
		}
		if(e.getActionCommand().equals("Clear Layer")) {
			graph.clearGraph();
		}
		
		
		if(e.getActionCommand().equals("Clear Canvas")) {
			graph.clearGraph();
		}
		
		
		if(e.getActionCommand().equals("Draw Selected Coord From Layer")) {
			graph.DrawPolygonFromPoints( graphPolygonsMap.get(""+graphPolygons.getSelectedItem()).getPoints());	
		}
		
		if(e.getActionCommand().equals("UnDraw")) {
			graph.UnDrawPolygonFromPoints( graphPolygonsMap.get(""+graphPolygons.getSelectedItem()).getPoints());	
		}
		
		if(e.getActionCommand().equals("Create")) {
			if(polygonName.getText().length() > 0) {
				String polyname = polygonName.getText();
				 graphPolygons.insertItemAt(polyname,0);
				 graphPolygonNames.add(polyname);
				 
				 graphPolygonsMap.put(polyname, new Layer());	
			}
			
		}
		
		if(e.getActionCommand().equals("Add Cordinate")) {
			try {
			double y = Double.parseDouble(ycord.getText());
			double x = Double.parseDouble(xcord.getText());
			println("x =  "+ x +" y ="+y);
			Point p = new Point();
			p.x = (int) x;
			p.y = (int) y;
			Point pv = GraphicsLibrary.getPixelPosition(grid, p);
			graph.DrawOval(pv);
			
			//add point to Polygon
			System.out.println("points "+ graphPolygons.getSelectedItem() );
			addPointToSelectedPolygon(""+graphPolygons.getSelectedItem(), pv);
			}catch(Exception ex) {
			System.err.print("Couldnt add Coordinate");				
			}
		}
	}
	
	public void addPointToSelectedPolygon(String pname, Point p) {
		Layer pp = graphPolygonsMap.get(pname);
		if(pp != null) {
			pp.addPoint(p);
			System.out.println("Added point to "+ pname );
		}else {
			System.err.print("Point cant be added");
		}
	}
}
