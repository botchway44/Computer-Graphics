import acm.graphics.GLine;
import acm.program.GraphicsProgram;;


public class Grid extends GraphicsProgram{
	
	public void run() {
		//Screen Definition
		double screenA = 600;
		double screenB = 600;
		
		//Define axis
		double left_x = 0;
		double right_x = 0;
		double top_y = 0;
		double bottom_y = 0;
		
		left_x = left_x / left_x + right_x;
		right_x = right_x / left_x + right_x;
		
		top_y = top_y / top_y + bottom_y;
		bottom_y = bottom_y / top_y + bottom_y;
		
		//pixel allocation
		
		setSize(screenA,screenB);
		
		double screenAllocationX = Math.abs(left_x) / Math.abs(left_x) + Math.abs(right_x);
		double midpoint_x = screenAllocationX * screenA;
		
		double screenAllocationY = Math.abs(top_y) / Math.abs(top_y) + Math.abs(bottom_y);
		double midpoint_y = screenAllocationY * screenB;
		
		
		
		GLine vline = new GLine(midpoint_x,0,screenA/2,screenB);
		GLine hline = new GLine(0,screenB/2,screenA,screenB/2);
		
		add(hline);
		add(vline);
		
	}
}
