package Canvas;
import javafx.scene.canvas.*;
import javafx.scene.paint.*;

import Files.*;
import model.*;

/**
* @author Fortunate Mathale
*/
public class Canvas2D extends Canvas{
	//the width of the canvas
	private int width;
	//the height of the canvas
	private int height;
	//grachics context to draw 
	private GraphicsContext _graphicsContext;

	
	/**
	* Constructor
	* @param width the width of the canvas
	* @param height the height of the canvas
	*/
	public Canvas2D(int width, int height){
		//set the canvas width and height
		super(width,height);
		//store the width of the canvas
		this.width = width;
		//store the height of the canvas
		this.height = height;
		//get the canvas graphics context and stores it
		_graphicsContext = getGraphicsContext2D();

		//clear the canvas
		clearCanvas();

		
	}

	/**
	* clear the canvas
	*/
	public void clearCanvas(){
		_graphicsContext.setFill(Color.web("#333",1));
		_graphicsContext.fillRect(0,0,width,height);		
	}

	/**
	* clear the canvas with a given backfround color
	* @param color the background color
	*/
	public void clearCanvas(Color color){
		_graphicsContext.setFill(color);
		_graphicsContext.fillRect(0,0,width,height);		
	}

	/**
	* get the width of the canvas
	* @return the width of the canvas
	*/
	public int getCanvasWidth(){
		return this.width;
	}


	/**
	* get the height of the canvas
	* @return the height of the canvas
	*/
	public int getCanvasheight(){
		return this.height;
	}


	/**
	* get the GraphicsContext of the canvas
	* @return the GraphicsContext of the canvas
	*/
	public GraphicsContext getGC(){
		return this._graphicsContext;
	}



}