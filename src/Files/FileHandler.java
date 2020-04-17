package Files;

import java.util.ArrayList;
import model.*;
import java.util.Scanner;
import java.io.*;
import java.util.StringTokenizer;

/**
* @author Fortunate Mathale
*/
public class FileHandler{

	/**
	* load all power stations from a textfile 
	* @return a list of power stations
	*/
	public static ArrayList<PowerStation> loadStations(){
		//file object
		File file = null;
		//scanner to read file data
		Scanner scanner = null;
		//location of the text file of stations
		String path = "data/StationsData.txt";
		//array list to store the stations from file
		ArrayList<PowerStation> stations  = new ArrayList<PowerStation>();
		try{
			//create a file object
			file = new File(path);	
			//create a scanner object
			scanner  = new Scanner(file);

			//store the string line for the power station
			String line = "";
			//loop for all the stations in the file
			while(scanner.hasNextLine()){

				//read the line from a file
				line = scanner.nextLine();

				//create a string tokenizer to break the line 
				StringTokenizer tokenizer =  new StringTokenizer(line,"#");
				//get the station ID
				String station_id = tokenizer.nextToken();
				//get the station address
				String address = tokenizer.nextToken();
				//get the station province
				String province = tokenizer.nextToken();
				//get the station dimensions
				String dimensions = tokenizer.nextToken();
				StringTokenizer dimTokenizer = new StringTokenizer(dimensions,"x");
				Position pos = new Position(Integer.parseInt(dimTokenizer.nextToken()),Integer.parseInt(dimTokenizer.nextToken()));
				
				double usage  = Double.parseDouble(tokenizer.nextToken());
				//get the station resources
				//get the resource type
				String _resource = tokenizer.nextToken();
				StringTokenizer _resourceToken = new StringTokenizer(_resource,"_");
				String resourceType = _resourceToken.nextToken();
				int resourceNeeded = Integer.parseInt(_resourceToken.nextToken());
				int resourceAvailable = Integer.parseInt(_resourceToken.nextToken());

				

				//System.out.println(station_id + address);

				//create a new Power Station object
				PowerStation powerStation = new PowerStation(address,station_id,province,pos,usage,resourceType,resourceNeeded,resourceAvailable);
				//System.out.println(powerStation.toString());
				//System.out.println(powerStation.toString());
				//add the new Power Station to the list of Stations
				stations.add(powerStation);
			}

		}catch(Exception ex){
			//print the error
			//System.out.println(ex);
		}finally{
			//check if file is closed and closed it
			if(file != null){
				//close the file
				try{
					file = null;
					scanner = null;
				}catch(Exception ex){
					//System.out.println(ex);
				}
			}
		}

		//return the list of stations
		return stations;
	}

	public static void addStation(PowerStation powerStation){

		//create a file handler 
		File file = null;
		//create a file writer
		FileWriter fileWriter = null;
		//create a buffered writer
		BufferedWriter bufferedWriter = null;
		//create a print write
		PrintWriter printWriter = null;

		try{
			//set the file object
			file = new File("data/StationsData.txt");
			//set the file writer object
			fileWriter = new FileWriter(file,true);
			//set the buffered writer object
			bufferedWriter = new BufferedWriter(fileWriter);
			//set the print writer object
			printWriter = new PrintWriter(bufferedWriter);

			//create a line to print
			String line = powerStation.getStationId() + "#" + powerStation.getAddress() + "#" + powerStation.getProvince() + "#" + powerStation.getPos().x + "x" + powerStation.getPos().y + "#" + (int)powerStation.getElectricityProduced() + "#" + powerStation.getResource() + "_" + powerStation.getNeededResources() + "_" + powerStation.getAvailableResources();
			//"Station06#374 Bankers Street melvill#Gauteng#520x450#98666#Water_1000_134";

			printWriter.println(line);
			printWriter.flush();
			//System.out.println(line);



		}catch(Exception ex){
			System.out.println(ex);
		}finally{
			//close the file
		}



	}




	/**
	* load the graph mappings from a file
	* A arraylist of strings representing mapping
	*/
	public static ArrayList<String> loadMapping(){
		//array list to store the strings
		ArrayList<String> mapping  = new ArrayList<String>();
		//scanner to read the mappaing
		Scanner scanner = null;
		//file handler
		File file = null;
		//the location of the mapping text file
		String path = "data/Maping.txt";

		try{
			//create the file object
			file = new File(path);
			//create the scanner
			scanner = new Scanner(file);
			//string to store the current line
			String line = "";

			//loop for all the lines 
			while(scanner.hasNextLine()){
				//read the line
				line = scanner.nextLine();
				mapping.add(line);
			}

		}catch(Exception ex){
			System.out.println(ex);
		}finally{
			if(file != null){
				file = null;
			}
		}

		//return the mapping array
		return mapping;
	}


}