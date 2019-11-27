package views;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JButton;

import acm.graphics.GLabel;
import acm.graphics.GLine;
import acm.graphics.GObject;
import acm.program.GraphicsProgram;
import models.Grid;

public class GraphUI extends GraphicsProgram implements Runnable{

	private Grid grid;
	private GLine vline;
	private GLine hline;
	private ArrayList<GObject> VerticalLines = new ArrayList<GObject>();
	private ArrayList<GObject> HorizontalLines = new ArrayList<GObject>();
	
	private ArrayList<GObject> VerticalLabels = new ArrayList<GObject>();
	private ArrayList<GObject> HorizontalLabels = new ArrayList<GObject>();
	
	public GraphUI(Grid grid) {
		this.grid = grid;
	}
	public void run() {
		setSize(grid.getWidth(), grid.getHeight());

	}
	
	public void colorMids() {
		vline = new GLine(grid.getXMidPoint(),0, grid.getXMidPoint(), grid.getHeight());
		vline.setColor(Color.red);
		add(vline);
		hline = new GLine(0,grid.getYMidPoint(),  grid.getWidth(),grid.getYMidPoint());
		hline.setColor(Color.red);
		
		add(hline);
	}
	
	
	public void DrawGrid() {
		//draw the grid from top to bottom 
		for(int i=0, j=0; i<grid.getHeight(); i+=grid.getPixel_gap(),j++) {
			GLine vl = new GLine(i,0,i,grid.getHeight());
			GLine hl = new GLine(0,i,grid.getWidth(),i);
			
			GLabel hlabel = null;
			GLabel vlabel = null;
			if(i>= grid.getHeight()/2) {
				int v =  j-10;
				 vlabel = new GLabel(""+v);
				 hlabel = new GLabel(""+v);
			}else {
				int v =  j-10;
				 vlabel = new GLabel(""+v);
				 hlabel = new GLabel(""+v);
			}
			add(vlabel,grid.getWidth()/2 - vlabel.getWidth(), getHeight()-i );
			add(hlabel,i, grid.getHeight()/2+hlabel.getHeight());
			
			add(vl);
			VerticalLines.add(vl);
			
			add(hl);
//			HorizontalLines.add(hl);
		}
		
		
		
	}
	
	public void DrawHorizontal() {
		
		int leftCount = (grid.getHeight()/2)/grid.getXPixel_gap();
		
		for(int i=0, j=0; i<grid.getHeight(); i+=grid.getXPixel_gap(),j++) {
			GLine hl = new GLine(0,i,grid.getWidth(),i);
			
			GLabel vlabel = null;
			if(i>= grid.getHeight()/2) {
				int v =  j-leftCount;
				
				 vlabel = new GLabel(""+v);
			}else {
				int v =  j-leftCount;
				
				 vlabel = new GLabel(""+v);
			}
			
			add(vlabel,grid.getWidth()/2 - vlabel.getWidth(), getHeight()-i );
			VerticalLabels.add(vlabel);
			
			add(hl);
			HorizontalLines.add(hl);
		}
		
	}

	public void DrawVertical() {
		int leftCount = (grid.getWidth()/2)/grid.getYPixel_gap();
		
		for(int i=0, j=0; i<grid.getWidth(); i+=grid.getYPixel_gap(),j++) {
			GLine vl = new GLine(i,0,i,grid.getHeight());

			GLabel hlabel = null;
			if(i>= grid.getWidth()/2) {
				int v =  j-leftCount;
				 hlabel = new GLabel(""+v);
			}else {
				int v =  j-leftCount;
				 hlabel = new GLabel(""+v);
			}
			add(hlabel,i, grid.getHeight()/2+hlabel.getHeight());
			HorizontalLabels.add(hlabel);
			add(vl);
			VerticalLines.add(vl);
			}
}
	
	public void ShowLine(
			ArrayList<GObject> hlv, Boolean show) {
		for(int i=0; i<hlv.size(); i++) {
			GObject vl = hlv.get(i);
			vl.setVisible(show);
		}
	}
	
	
	public void ShowVerticalLines() {
			this.ShowLine(VerticalLines, true);
		}
	
	public void ShowHorizontalLines() {
		this.ShowLine(HorizontalLines, true);
	}
	
	public void HideVerticalLines() {
		this.ShowLine(VerticalLines, false);
	}

	public void HideHorizontalLines() {
	this.ShowLine(HorizontalLines, false);
	}
	
	
	public void HideLabels() {
		this.ShowLine(HorizontalLabels, false);
		this.ShowLine(VerticalLabels, false);
	}

	public void ShowLabels() {
	this.ShowLine(HorizontalLabels, true);
	this.ShowLine(VerticalLabels, true);
	}
}

