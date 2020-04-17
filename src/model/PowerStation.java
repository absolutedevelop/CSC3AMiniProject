package model;

/**
* @author Fortunate Mathale
*/
public class PowerStation implements Comparable<PowerStation>{


	//the address of the power station
	private String address;
	//the station number or ID
	private String station_id;
	//station province
	private String province;
	//the positionb of the area that the power station supply electricity
	private Position position;
	//usage of eleectricty per months in klw
	private double electricityProduced;
	//Type of resource used in the power station for the generation of electricity
	private String resource;
	//The amount of resources needed 
	private int neededResources;
	//Available reources in the power station
	private int availableResources;

	public PowerStation(String station_id){
		this.station_id = station_id;
	}

	/**
	* Constructor
	*/
	public PowerStation(String address,String station_id,String province,Position position, double electricityProduced,String resource,int neededResources,int availableResources){
		this.address = address;
		this.station_id = station_id;
		this.province = province;
		this.position = position;
		this.electricityProduced = electricityProduced;
		this.resource = resource;
		this.availableResources = availableResources;
		this.neededResources = neededResources;
	}

	//compare two stations
	@Override
	public int compareTo(PowerStation another){
		return 0;
	}

	//getters
	public String getStationId(){
		return this.station_id;
	}
	
	//get the station address
	public String getAddress(){
		return this.address;
	}

	//get the station province
	public String getProvince(){
		return this.province;
	}

	//get the position
	public Position getPos(){
		return this.position;
	}

	//get the resource
	public String getResource(){
		return this.resource;
	}

	public int getAvailableResources(){
		return this.availableResources;
	}

	public int getNeededResources(){
		return this.neededResources;
	}

	//get the electricity produced
	public double getElectricityProduced(){
		return this.electricityProduced;
	}



	@Override
	public String toString(){
		String string  = "";
		string = station_id;
		return string;
	}



}