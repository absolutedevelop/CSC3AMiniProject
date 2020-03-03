import UI.*;

import javafx.application.Application;
import javafx.stage.*;
import javafx.scene.*;

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

	@Override
	public void start(Stage _stage){
		UIPane uipane = new UIPane();
		Scene scene = new Scene(uipane,500,500);
		_stage.setScene(scene);
		_stage.show();
	}
}