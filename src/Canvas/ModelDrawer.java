package Canvas;

import javafx.scene.canvas.*;
import javafx.scene.paint.*;
import model.PowerStation;
import model.Graph;
import java.util.List;
import model.Position;

/**
* @author Fortunate Mathale
*/
public class ModelDrawer{

	//canvas graphics context
	private GraphicsContext gc;
	//canvas width
	private int canvasWidth;
	//canvas height
	private int canvasHeight;
	//canvas 
	private Canvas2D canvas;

	/**
	* Constructor
	* @param gc the 2D canvas graphics context to draw on the canvas
	*/
	public ModelDrawer(Canvas2D canvas){
		this.gc = canvas.getGC();
		this.canvasWidth = canvas.getCanvasWidth();
		this.canvasHeight = canvas.getCanvasheight();
		this.canvas = canvas;
	}

	/**
	* draw a power station in the canvas in detailed form
	* @param powerStation the power station to display
	*/
	public void drawStationDetails(PowerStation powerStation){

		gc.setFill(Color.RED);
		gc.fillRect(10,10,300,300);


	}

	/**
	* Draw a power station for a graph
	* @param powerStation The power station to draw
	*/
	private void drawStation(PowerStation powerStation){
		//clear the canvas
		
		
		//the position 
		int x = powerStation.getPos().x;
		int y = powerStation.getPos().y;	

		//station size
		int size = 50;

	    //gc.setFill(Color.WHITE);
	    gc.setFill(Color.BLUE);
	    gc.fillOval(x,y,size,size);

	    int textX = x + size + 20;

	    //Station properties
	    String resourceType = powerStation.getResource();
	    int availableResources = powerStation.getAvailableResources();
	    int neededResources = powerStation.getNeededResources();

	    String infor = "Resource used\t| " + resourceType + "\n";
	    infor += "Station ID\t| " + powerStation.getStationId() + "\n";
	    infor += "Resources Available\t| " + availableResources + "\n";
	    infor += "Resources needed\t| " + neededResources;
	    

	    gc.setFill(Color.RED);
	    gc.fillText(infor,textX,y);
	    

	}


	public void drawGraph(Graph<PowerStation> _graph){

		
		//get all the edges
		List<Graph.Edge<PowerStation> > edges = _graph.getEdges();

		int lineShift = 25;

		for (Graph.Edge<PowerStation> e : edges) {
			Position fromPos = e.getFromVertex().getValue().getPos();
			Position toPos = e.getToVertex().getValue().getPos();

			gc.setStroke(Color.BLUE);
			gc.setLineWidth(4);
			gc.strokeLine(fromPos.x + lineShift,fromPos.y + lineShift,toPos.x + lineShift,toPos.y + lineShift);

		}

		//get the graph verices
		List<Graph.Vertex<PowerStation> > vertices = _graph.getVertices();

		for (Graph.Vertex<PowerStation> v : vertices) {
			this.drawStation(v.getValue());	
		}


	} 


}



