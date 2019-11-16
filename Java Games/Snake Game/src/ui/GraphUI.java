package ui;

import javax.swing.JButton;

import acm.graphics.GLine;
import acm.program.GraphicsProgram;
import core.Grid;

public class GraphUI extends GraphicsProgram implements Runnable{

	Grid grid;
	public GraphUI(Grid grid) {
		this.grid = grid;
	}
	public void run() {
		setSize(grid.getWidth(), grid.getHeight());
		
		add(new GLine(grid.getXMidPoint(),0, grid.getXMidPoint(), grid.getHeight()));
		add(new GLine(0,grid.getYMidPoint(),  grid.getWidth(),grid.getYMidPoint()));
		
	}
}
