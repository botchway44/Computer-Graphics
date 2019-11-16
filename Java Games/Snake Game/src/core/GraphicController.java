package core;
import javax.swing.JButton;
import acm.program.Program;
import ui.GraphUI;

public class GraphicController extends Program{
	
	  public void run() {
		  
		  Grid grid = new Grid(1200,600, -5, 5, -5, 5);
		  
	       (new GraphUI(grid)).start();
	       
	       add(new JButton("south"));
	       
	}
}
