package UI;
//import classes
import javafx.scene.layout.*;
import javafx.scene.control.*;
import Files.FileHandler;
import model.PowerStation;
import Canvas.*;
import model.*;
import javafx.collections.FXCollections;

import java.util.*;



/**
* A class for all the UI
* @author Fortunate Mathale 217014959
*/
public class UIPane extends StackPane{
	//the width of the window
	private int width;
	//the height of the window
	private int height;

	private int action = 0;
	private int x = 0;
	private int y = 0;
	/**
	* Constructor
	* @param width The width of the window
	* @param height The height of the window
	*/
	public UIPane(int width,int height){
		this.width = width;
		this.height = height;
		
		//set up the UI
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
		
		Canvas2D canvas = new Canvas2D((int)(this.width * .54) ,this.height);

		////////////////////////////////////////////////////
		

		
		


		///////////////////////////////////////////////////
		canvasArea.getChildren().add(canvas);

		//Control Area
		HBox controlsArea = new HBox();
		//TODO:create control and add to this area

	
		VBox controlsVBox = new VBox();
		controlsVBox.setStyle("-fx-padding-left: 20;");

		/*Graph<PowerStation> _graph = GraphCreator.create();

		ModelDrawer drawer = new ModelDrawer(canvas);

		drawer.drawGraph(_graph);*/

		//create a grid pane
		//Add a station
		GridPane addStationGridPane = new GridPane();
		addStationGridPane.setHgap(10);
		addStationGridPane.setVgap(10);
		addStationGridPane.getColumnConstraints().add(new ColumnConstraints(150));
		//addStationGridPane.setMinSize(400,800);
		Label lblAddStationTitle = new Label("ENTER STATION DATA");
		Label lblStationName = new Label("Station Name/ID");		
		TextField txtStationName = new TextField();
		addStationGridPane.add(lblAddStationTitle,0,0,2,1);
		//station name 
		addStationGridPane.add(lblStationName,0,1,1,1);
		addStationGridPane.add(txtStationName,1,1,1,1);
		//station address
		Label lblStationAddress = new Label("Station address");		
		TextField txtStationAddress = new TextField();
		addStationGridPane.add(lblStationAddress,0,2,1,1);
		addStationGridPane.add(txtStationAddress,1,2,1,1);
		//station province
		Label lblStationProvince = new Label("Station province");		
		TextField txtStationProvince = new TextField();
		addStationGridPane.add(lblStationProvince,0,3,1,1);
		addStationGridPane.add(txtStationProvince,1,3,1,1);
		//station Postion
		Label lblAddStationPosTitle = new Label("Click on the canvas to get the position");
		Label lblStationPosition = new Label("Canvas Position");		
		Button btnStationPosition = new Button("Select Position");
		
		btnStationPosition.setOnAction( e -> {
			canvas.setOnMouseClicked(e2 -> {
				x = (int)e2.getX();
				y = (int)e2.getY();
				btnStationPosition.setText("Position : (" + x + "," + y + ")");
			});
		});
		addStationGridPane.add(lblAddStationPosTitle,0,4,2,1);
		addStationGridPane.add(lblStationPosition,0,5,1,1);
		addStationGridPane.add(btnStationPosition,1,5,1,1);
		//Electricty that the station produce
		Label lblStationElectricity = new Label("Electricty produce(KW)");		
		TextField txtStationElectricity= new TextField();
		addStationGridPane.add(lblStationElectricity,0,6,1,1);
		addStationGridPane.add(txtStationElectricity,1,6,1,1);
		//Resource used to generate electricty
		//ChoiceBox cb = new ChoiceBox(FXCollections.observableArrayList("COAL","WATER"));
		ChoiceBox<String> cb = new ChoiceBox<String>();
		cb.getItems().addAll("COAL","WATER");
		Label lblStationResource = new Label("Resource name");		
		//TextField txtStationResource = new TextField();
		addStationGridPane.add(lblStationResource,0,7,1,1);
		addStationGridPane.add(cb,1,7,1,1);
		//Resource available
		Label lblStationResourceAvailable = new Label("Resource availabe");		
		TextField txtStationResourceAvailable = new TextField();
		addStationGridPane.add(lblStationResourceAvailable,0,8,1,1);
		addStationGridPane.add(txtStationResourceAvailable,1,8,1,1);
		//Resource Required
		Label lblStationResourceRequired = new Label("Resource required");		
		TextField txtStationResourceRequired = new TextField();
		addStationGridPane.add(lblStationResourceRequired,0,9,1,1);
		addStationGridPane.add(txtStationResourceRequired,1,9,1,1);

		//Create action button
		Button btnAction = new Button("Submit");
		btnAction.setOnAction(e -> {
			switch(action){
				case 1:{
					//add station
					//TODO:get position from the canvas by clicking
					//check if the user has type something

					String address = txtStationAddress.getText();
					String station_id = txtStationName.getText();
					String province = txtStationProvince.getText();

					Position position = new Position(x,y);
					Double electricityProduced = Double.parseDouble(txtStationElectricity.getText());
					String resource = cb.getValue();
					int neededResources = Integer.parseInt(txtStationResourceRequired.getText());
					int availableResources = Integer.parseInt(txtStationResourceAvailable.getText());
					


					PowerStation ps = new PowerStation(address,station_id, province,position,electricityProduced, resource,neededResources,availableResources);

					FileHandler.addStation(ps);

					Graph<PowerStation> _graph = GraphCreator.create();
					ModelDrawer drawer = new ModelDrawer(canvas);
					drawer.drawGraph(_graph);
					canvas.setOnMouseClicked(e2 -> {});
					


					//disable all input for entering station data
					btnStationPosition.setText("Select Position");
					txtStationName.setDisable(true);
					txtStationName.clear();
					cb.setDisable(true);
					txtStationElectricity.setDisable(true);
					txtStationElectricity.clear();
					txtStationProvince.setDisable(true);
					txtStationProvince.clear();
					txtStationAddress.setDisable(true);
					txtStationAddress.clear();
					txtStationResourceRequired.setDisable(true);
					txtStationResourceRequired.clear();
					txtStationResourceAvailable.setDisable(true);
					txtStationResourceAvailable.clear();
					btnAction.setDisable(true);
					btnStationPosition.setDisable(true);
					break;
				}
				case 2:{
					//update station TODO update station
					break;
				}
				case 3:{
					//delete station TODO delete station
					break;
				}

			}
		});
		addStationGridPane.add(btnAction,1,10,1,1);
		//menu option
		Label lblAddStationOptionTitle = new Label("SELECT AN OPTION");
		addStationGridPane.add(lblAddStationOptionTitle,0,11,2,1);

		//disable all input for entering station data
		txtStationName.setDisable(true);
		cb.setDisable(true);
		txtStationElectricity.setDisable(true);
		txtStationProvince.setDisable(true);
		txtStationAddress.setDisable(true);
		txtStationResourceRequired.setDisable(true);
		txtStationResourceAvailable.setDisable(true);
		btnAction.setDisable(true);
		btnStationPosition.setDisable(true);
		//Add and Update station button
		Button _btnAddStation = new Button("Add Station");
		_btnAddStation.setOnAction( e -> {
			//enable all input for entering data for station
			txtStationName.setDisable(false);
			cb.setDisable(false);
			txtStationElectricity.setDisable(false);
			txtStationProvince.setDisable(false);
			txtStationAddress.setDisable(false);
			txtStationResourceRequired.setDisable(false);
			txtStationResourceAvailable.setDisable(false);
			btnAction.setDisable(false);
			btnStationPosition.setDisable(false);
			action = 1;
		});
		Button _btnUpdateStation = new Button("Update Station");
		addStationGridPane.add(_btnAddStation,0,12,1,1);
		addStationGridPane.add(_btnUpdateStation,1,12,1,1);

		//Add and Update station button
		Button _btnDeleteStation = new Button("Delete Station");
		Button _btnViewStation = new Button("View Station");
		addStationGridPane.add(_btnDeleteStation,0,13,1,1);
		addStationGridPane.add(_btnViewStation,1,13,1,1);

		//Resource data
		Label lblAddStationOption2Title = new Label("ENTER RESOURCE DATA");
		addStationGridPane.add(lblAddStationOption2Title,0,14,2,1);
		//resource name
		Label lblResourceName = new Label("Resource name");		
		TextField txtResourceName = new TextField();
		addStationGridPane.add(lblResourceName,0,15,1,1);
		addStationGridPane.add(txtResourceName,1,15,1,1);
		//resource quantity
		Label lblResourceQuantity = new Label("Resource quantity");		
		TextField txtResourceQuantity = new TextField();
		addStationGridPane.add(lblResourceQuantity,0,16,1,1);
		addStationGridPane.add(txtResourceQuantity,1,16,1,1);
		//submit button
		Button btnAddResource = new Button("Submit");
		addStationGridPane.add(btnAddResource,1,17,1,1);

		//Other option
		Label lblAddStationOption3Title = new Label("OTHER OPTIONS");
		addStationGridPane.add(lblAddStationOption3Title,0,18,2,1);

		Button _btnAddResource = new Button("Add Resource");
		Button _btnAllocate = new Button("Allocate resources");
		addStationGridPane.add(_btnAddResource,0,19,1,1);
		addStationGridPane.add(_btnAllocate,1,19,1,1);

		Button _btnShowGraph = new Button("Show in graph format");
		_btnShowGraph.setOnAction( e -> {

			Graph<PowerStation> _graph = GraphCreator.create();

			ModelDrawer drawer = new ModelDrawer(canvas);

			drawer.drawGraph(_graph);

		});
		addStationGridPane.add(_btnShowGraph,1,20,1,1);


		HBox gridsConatiner = new HBox();

		GridPane addConnectionGridPane = new GridPane();

		addConnectionGridPane.setHgap(10);
		addConnectionGridPane.setVgap(10);
		addConnectionGridPane.getColumnConstraints().add(new ColumnConstraints(150));

		Label lblAddConnectionTitle = new Label("CONNECTION STATIONS HERE");
		addConnectionGridPane.add(lblAddConnectionTitle,0,0,2,1);

		ChoiceBox<String> stationID1 = new ChoiceBox<String>();

		//stationID1.getItems().addAll("COAL","WATER");

		Label lblStationID1 = new Label("Select NAME/ID of station 1");		
		addConnectionGridPane.add(lblStationID1,0,1,1,1);
		addConnectionGridPane.add(stationID1,1,1,1,1);

		ChoiceBox<String> stationID2 = new ChoiceBox<String>();

		//stationID2.getItems().addAll("COAL","WATER");

		Label lblStationID2 = new Label("Select NAME/ID of station 2");	
		this.setStationIDChoice(stationID1,stationID2);	
		addConnectionGridPane.add(lblStationID2,0,2,1,1);
		addConnectionGridPane.add(stationID2,1,2,1,1);


		gridsConatiner.getChildren().addAll(addStationGridPane,addConnectionGridPane);


		//create controls
		controlsVBox.getChildren().addAll(
			//viewStations,addStation,removeStation,updateStation
			gridsConatiner
		);
		controlsArea.getChildren().add(controlsVBox);

		mainArea.getChildren().addAll(canvasArea,controlsArea);
		getChildren().add(mainArea);

	}

	private void setStationIDChoice(ChoiceBox c1,ChoiceBox c2){

		//load from file
		FileHandler.loadStations

		c1.getItems().addAll("COAL","WATER");
		c2.getItems().addAll("COAL","WATER");


	}

}





