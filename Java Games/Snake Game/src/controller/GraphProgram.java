package controller;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import acm.gui.TableLayout;
import acm.program.DialogProgram;
import acm.program.Program;
import acm.util.RandomGenerator;
import core.GraphicsLibrary;
import core.Layer;
import javafx.scene.control.ListView;
import models.Grid;
import views.GraphUI;
import views.PopUp;

public class GraphProgram extends Program {
	
	  private GraphUI graph;
	  private JTextField xcord;
	  private JTextField ycord;
	  private Grid grid;
	  private HashMap<String,Layer> graphLayerMap;
	  private ArrayList<String> graphLayerNames= new ArrayList<>();
	  private JComboBox<String> graphLayers;
	  private JTextField polygonName;
	  
	  public void init() {
//		  this.setResizable(false);
			this.setLayout(new TableLayout(10,1));		
			
			//init the Polygon Map
			graphLayerMap = new HashMap<String,Layer>();
			
			//add a default Polygon to the Map
			graphLayerMap.put("Default", new Layer());
			
			//Adding a ComboBox on Screen
			 graphLayerNames.add("Default");
			 graphLayers = new JComboBox(graphLayerNames.toArray());
			 add(graphLayers);
			 
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
		     gridVisibilityPanel.setLayout(new TableLayout(8,2));
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
		     
		     gridVisibilityPanel.add(new JButton("Set Layer Color"));
		     gridVisibilityPanel.add(new JButton("Delete Layer"));
		     
		     
		     gridVisibilityPanel.add(new JButton("Load Graph"));
		     gridVisibilityPanel.add(new JButton("Save Graph"));
		     
			 gridVisibilityPanel.add(new JButton("Clear Layer"));
		     gridVisibilityPanel.add(new JButton("Clear Canvas"));
		     add(gridVisibilityPanel);
		     
		     
		     //add a UI for Performing Rotations
		     add(new JLabel("Perform Rotations"));
		     JPanel RotationPanel = new JPanel();
		     
		     xcord = new JTextField("0",12);
		     ycord = new JTextField("0",12);
		     RotationPanel.add(xcord);
		     RotationPanel.add(ycord);
		     RotationPanel.add(new JButton("Rotate"));
		     
		     add(RotationPanel);
		     
		     //add a UI for Performing Rotations
		     add(new JLabel("Perform Translations"));
		     JPanel TranlationPanel = new JPanel();
		     
		     xcord = new JTextField("0",12);
		     ycord = new JTextField("0",12);
		     TranlationPanel.add(xcord);
		     TranlationPanel.add(ycord);
		     TranlationPanel.add(new JButton("Translate"));
		     add(TranlationPanel);
		     
		     //add a UI for Performing Rotations
		     add(new JLabel("Perform Scale"));
		     JPanel ScalePanel = new JPanel();
		    
		     xcord = new JTextField("0",12);
		     ycord = new JTextField("0",12);
		     ScalePanel.add(xcord);
		     ScalePanel.add(ycord);
		     ScalePanel.add(new JButton("Scale"));
		     add(ScalePanel);
		     
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
		
		//set color for the layer points
		if(e.getActionCommand().equals("Set Layer Color")) {
			Color res = JColorChooser.showDialog(this, "Choose Color", Color.RED);
			graphLayerMap.get(""+graphLayers.getSelectedItem()).setColor(res);
			JButton bb = (JButton) e.getSource();
			bb.setForeground(res);
		}
		if(e.getActionCommand().equals("Clear Layer")) {
			int res = JOptionPane.showConfirmDialog(this, "Do you want to clear Layer");
				System.out.println(res+"");
			
				//clear the layer points
				if(res ==0) {
				graphLayerMap.get(""+graphLayers.getSelectedItem()).clearPoints();;
			}
		}
		
		
		if(e.getActionCommand().equals("Clear Canvas")) {
			graph.clearGraph();
		}
		
		
		if(e.getActionCommand().equals("Draw Selected Coord From Layer")) {
			graph.DrawPolygonFromPoints( graphLayerMap.get(""+graphLayers.getSelectedItem()));	
		}
		
		if(e.getActionCommand().equals("UnDraw")) {
			graph.UnDrawPolygonFromPoints( graphLayerMap.get(""+graphLayers.getSelectedItem()));	
		}
		
		if(e.getActionCommand().equals("Create")) {
			if(polygonName.getText().length() > 0) {
				String polyname = polygonName.getText();
				 graphLayers.insertItemAt(polyname,0);
				 graphLayerNames.add(polyname);
				 
				 Layer l = new Layer();
				 l.setColor(RandomGenerator.getInstance().nextColor());
				 graphLayerMap.put(polyname, l);	
				 
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
			graph.DrawOval(pv,Color.orange);
			
			//add point to Polygon
			System.out.println("points "+ graphLayers.getSelectedItem() );
			addPointToSelectedPolygon(""+graphLayers.getSelectedItem(), pv);
			}catch(Exception ex) {
			System.err.print("Couldnt add Coordinate");				
			}
		}
	}
	
	public void addPointToSelectedPolygon(String pname, Point p) {
		Layer pp = graphLayerMap.get(pname);
		if(pp != null) {
			pp.addPoint(p);
			System.out.println("Added point to "+ pname );
		}else {
			System.err.print("Point cant be added");
		}
	}
}
