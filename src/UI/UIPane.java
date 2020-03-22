package UI;
import javafx.scene.layout.*;
import javafx.scene.control.*;

import Canvas.Canvas2D;
/**
* A class for all the UI
* @author Fortunate Mathale 217014959
*/
public class UIPane extends StackPane{
	//the width of the window
	private int width;
	//the height of the window
	private int height;

	/**
	* Constructor
	* @param width The width of the window
	* @param height The height of the window
	*/
	public UIPane(int width,int height){
		this.width = width;
		this.height = height;

		setUpUI();

	}

	/**
	* Get the window's width
	* @return the width of the window
	*/
	public int getPaneWidth(){
		return this.width;
	}

	/**
	* Get the window's height
	* @return the height of the window
	*/
	public int getPaneHeight(){
		return this.height;
	}

	/**
	* Set up all the UI controls and layout
	*/
	private void setUpUI(){
		//the main layout
		HBox mainArea = new HBox();

		//Canvas Area
		HBox canvasArea = new HBox();
		//TODO: create a canvas and add to this area(Canvas area)
		
		Canvas2D canvas = new Canvas2D((int)(this.width * .78) ,this.height);





		canvasArea.getChildren().add(canvas);

		//Control Area
		HBox controlsArea = new HBox();
		//TODO:create control and add to this area

	
		VBox controlsVBox = new VBox();
		controlsVBox.setStyle("-fx-padding: 0;");
		//create controls
		controlsVBox.getChildren().addAll(
			createBtn("View Station"),
			createBtn("Resources"),
			createBtn("Add Station"),
			createBtn("Add Resources")
		);
		controlsArea.getChildren().add(controlsVBox);

		mainArea.getChildren().addAll(canvasArea,controlsArea);
		getChildren().add(mainArea);

	}

	private VBox createBtn(String title){
		VBox btnContainer = new VBox();
		btnContainer.setStyle("-fx-padding: 10");
		String btnStyles = "-fx-padding: 10 40; -fx-pointer: cursor;";

		Button btn = new Button("" + title + "\t");
		btn.setStyle(btnStyles);

		btnContainer.getChildren().add(btn);
		return btnContainer;
	}

}





