import UI.*;

import javafx.application.Application;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.paint.Color;

/**
* @author Fortunate Mathale
* The main class for the program 
*/
public class Main extends Application{
	/**
	* Entry point for the program
	* @param args command line arguments
	*/
	public static void main(String[] args){
		launch(args);
	}	
	/**
	* The start of the project
	* @param _stage the main window 
	*/
	@Override
	public void start(Stage _stage){
		_stage.setTitle("ESKOM Resource allocator");
		UIPane uipane = new UIPane(1000,600);
		
		Scene scene = new Scene(uipane,uipane.getPaneWidth(),uipane.getPaneHeight(),Color.DIMGREY);
		_stage.setScene(scene);
		_stage.show();
	}
}