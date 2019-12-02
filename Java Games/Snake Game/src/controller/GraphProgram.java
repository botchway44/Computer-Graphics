package controller;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

import acm.gui.TableLayout;
import acm.program.DialogProgram;
import acm.program.Program;
import acm.util.RandomGenerator;
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
	  private HashMap<String,Layer> graphLayerMap;
	  private ArrayList<String> graphLayerNames= new ArrayList<>();
	  private JComboBox<String> graphLayers;
	  private JTextField polygonName;
	private JTextField rtheta;
	private JTextField tx;
	private JTextField ty;
	private JTextField sx;
	private JTextField sy;
	  
	  public void init() {
//		  this.setResizable(false);
		  TableLayout tbl = new TableLayout(11,1);
		  tbl.setVgap(8);
		  this.setLayout(tbl);		
			
			//init the Polygon Map
			graphLayerMap = new HashMap<String,Layer>();
			
			//add a default Polygon to the Map
			Layer la  = new Layer();
			la.setColor(RandomGenerator.getInstance().nextColor());
			la.setName("Default");
			graphLayerMap.put("Default",la);
			
			//Adding a ComboBox on Screen
			 graphLayerNames.add("Default");
			 graphLayers = new JComboBox<String>();
			 graphLayers.insertItemAt("Default", 0);
			 graphLayers.setSelectedIndex(0);
			 add(graphLayers);
			 
			 JPanel createPolygon = new JPanel();
			 polygonName = new JTextField("Enter layer name",12);
			
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
		     
		     rtheta = new JTextField("0",12);
		     RotationPanel.add(rtheta);
		     RotationPanel.add(new JButton("Rotate"));

		     RotationPanel.add(new JCheckBox("Origin"));
		     add(RotationPanel);
		     
		     //add a UI for Performing Rotations
		     add(new JLabel("Perform Translations"));
		     JPanel TranlationPanel = new JPanel();
		     
		     tx = new JTextField("0",12);
		     ty = new JTextField("0",12);
		     TranlationPanel.add(tx);
		     TranlationPanel.add(ty);
		     TranlationPanel.add(new JButton("Translate"));
		     add(TranlationPanel);
		     
		     //add a UI for Performing Rotations
		     add(new JLabel("Perform Scale"));
		     JPanel ScalePanel = new JPanel();
		    
		     sx = new JTextField("0",12);
		     sy = new JTextField("0",12);
		     ScalePanel.add(sx);
		     ScalePanel.add(sy);
		     ScalePanel.add(new JButton("Scale"));
		     ScalePanel.add(new JCheckBox("Origin"));
		     
		     add(ScalePanel);
		     
		     JPanel reflectionPanel = new JPanel();
		     reflectionPanel.add(new JButton("Reflection in the x"));
		     reflectionPanel.add(new JButton("Reflection in the y"));
		     add(reflectionPanel);
		     
	  }
	public void run() {
		  setSize(380,700);
		  this.setResizable(false);
		  grid = new Grid(600,600, -10, 10, -10, 10);
		   
		  
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
				graphLayerMap.get(""+graphLayers.getSelectedItem()).clearPoints();
			}
		}
		
		
		if(e.getActionCommand().equals("Clear Canvas")) {
			graph.clearGraph();
		}
		
		
		if(e.getActionCommand().equals("Delete Layer")) {
			int res = JOptionPane.showConfirmDialog(this, "Do you want to Delete Layer");
			System.out.println(res+"");
		
			//clear the layer points
			if(res ==0 &&  !graphLayers.getSelectedItem().equals("Default")) {
			graphLayerMap.remove(""+graphLayers.getSelectedItem());
			graphLayerNames.remove(graphLayers.getSelectedItem());
			graphLayers.remove( graphLayers.getSelectedIndex());
			//TODO Remove name from list
		}
		}
		
		
		if(e.getActionCommand().equals("Save Graph")) {
			
			try {
			
			JFileChooser ch =new JFileChooser();

			
			int r = ch.showSaveDialog(this) ;
			if( r == JFileChooser.APPROVE_OPTION) {
				
				String path = ch.getSelectedFile().getAbsolutePath();

				System.out.println( "Path " + path );
				GraphicsLibrary.SaveFile(graphLayerMap, path);
			}
			}catch(Exception ex) {
				
			}
		}
		
		
		
		if(e.getActionCommand().equals("Load Graph")) {
			try {
				JFileChooser ch =new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
				FileNameExtensionFilter filter = new FileNameExtensionFilter("Txt files", "txt");
				ch.addChoosableFileFilter(filter);
				
				
			if(ch.showOpenDialog(this) != JFileChooser.CANCEL_OPTION) {
				File file = ch.getSelectedFile();
				System.out.println(file.getName());
				
				ArrayList<Layer> layers = GraphicsLibrary.ReadFile(file);
				
				
				
				for(int i=0; i<layers.size(); i++) {
					
					layers.get(i).setPixelPoints(GraphicsLibrary.computePixelPoints(grid,layers.get(i).getGraphPoints()));
					
					graphLayerMap.put(layers.get(i).getName(), layers.get(i));
					graphLayers.insertItemAt(layers.get(i).getName(), 0);
					graphLayerNames.add(layers.get(i).getName());
				}
				System.out.println("Done Reading file");
				
				
				
			}
			}catch(Exception ex) {
				
			}
		
		}
		
		
		if(e.getActionCommand().equals("Draw Selected Coord From Layer")) {
			graph.DrawLayerFromPoints( graphLayerMap.get(""+graphLayers.getSelectedItem()));	
		}
		
		if(e.getActionCommand().equals("UnDraw")) {
			graph.UnDrawLayerFromPoints( graphLayerMap.get(""+graphLayers.getSelectedItem()));	
		}
		
		
		if(e.getActionCommand().equals("Reflection in the y")) {
			
			System.out.println("Reflecting  layer "+ graphLayers.getSelectedItem() + " -> "+ graphLayerMap.get(""+graphLayers.getSelectedItem()).getGraphPoints().size());
			
			Layer l = GraphicsLibrary.ReflectYPoint(grid, graphLayerMap.get(""+graphLayers.getSelectedItem()));
			
			//l.setPixelPoints(GraphicsLibrary.computePixelPoints(grid, l.getGraphPoints()));
			
			graphLayerMap.put(""+graphLayers.getSelectedItem(), l);
			
			graph.clearGraph();
			graph.DrawLayerFromPoints(l);
		}
		
		
		
		if(e.getActionCommand().equals("Reflection in the x")) {
			
			System.out.println("Reflecting  layer "+ graphLayers.getSelectedItem() + " -> "+ graphLayerMap.get(""+graphLayers.getSelectedItem()).getGraphPoints().size());
			
			Layer l = GraphicsLibrary.ReflectXPoint(grid, graphLayerMap.get(""+graphLayers.getSelectedItem()));
			
			//l.setPixelPoints(GraphicsLibrary.computePixelPoints(grid, l.getGraphPoints()));
			
			graphLayerMap.put(""+graphLayers.getSelectedItem(), l);
			
			graph.clearGraph();
			graph.DrawLayerFromPoints(l);
		}
		
		

		if(e.getActionCommand().equals("Translate")) {
			
			Point vector = new Point();
			vector.x = (int) Double.parseDouble(tx.getText());
			vector.y = (int) Double.parseDouble(ty.getText());
			
//			Point pp = GraphicsLibrary.getGraphPosition(grid,vector);
//			System.out.println("x = "+pp.x + "y = "+pp.y);
			System.out.println("Translating layer "+ graphLayers.getSelectedItem() + " -> "+ graphLayerMap.get(""+graphLayers.getSelectedItem()).getGraphPoints().size());
			
			Layer l = GraphicsLibrary.TranslatePoint(grid, graphLayerMap.get(""+graphLayers.getSelectedItem()), vector);
			
			//l.setPixelPoints(GraphicsLibrary.computePixelPoints(grid, l.getGraphPoints()));
			
			graphLayerMap.put(""+graphLayers.getSelectedItem(), l);
			
			graph.clearGraph();
			graph.DrawLayerFromPoints(l);
		}
		
		
		if(e.getActionCommand().equals("Rotate")) {
			
			Double angle =  Double.parseDouble(rtheta.getText());
			
			System.out.println("Rotating layer "+ graphLayers.getSelectedItem() + " -> "+ graphLayerMap.get(""+graphLayers.getSelectedItem()).getGraphPoints().size());
			
			Layer l = GraphicsLibrary.RotatePoint(grid, graphLayerMap.get(""+graphLayers.getSelectedItem()), angle);
			
			
			graphLayerMap.put(""+graphLayers.getSelectedItem(), l);
			
			graph.clearGraph();
			graph.DrawLayerFromPoints(l);
		}
		
		
		//Creates a layer and Copies a random color to it
		if(e.getActionCommand().equals("Create")) {
			if(polygonName.getText().length() > 0) {
				String polyname = polygonName.getText();
				 graphLayers.insertItemAt(polyname,0);
				 graphLayerNames.add(polyname);
				 
				 Layer l = new Layer();
				 l.setName(polyname);
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
			
			Point graph_point = new Point();
			graph_point.x = (int) x;
			graph_point.y =(int) y;
			
			
			System.out.println("Pixel Points x = "+pv.x + "y = "+pv.y);
			
			graph.DrawOval(pv, graphLayerMap.get(""+graphLayers.getSelectedItem()).getColor());
			
			//add point to Polygon
			System.out.println("points "+ graphLayers.getSelectedItem() );
			addPixelPointToSelectedLayer(""+graphLayers.getSelectedItem(), pv);
			addGraphPointToSelectedLayer(""+graphLayers.getSelectedItem(), graph_point);
			}catch(Exception ex) {
			System.err.print("Couldnt add Coordinate");				
			}
		}
	}
	
	public void addPixelPointToSelectedLayer(String pname, Point p) {
		Layer pp = graphLayerMap.get(pname);
		if(pp != null) {
			pp.addPixelPoint(p);
			System.out.println("Added point to "+ pname );
		}else {
			System.err.print("Point cant be added");
		}
	}
	
	public void addGraphPointToSelectedLayer(String pname, Point p) {
		Layer pp = graphLayerMap.get(pname);
		if(pp != null) {
			pp.addGraphPoint(p);
			System.out.println("Added graph to "+ pname );
		}else {
			System.err.print("Point cant be added");
		}
	}
}
