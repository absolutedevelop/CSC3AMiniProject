package model;

//import classes
import Files.FileHandler;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
* @author Fortunate Mathale
*/
public class GraphCreator{

	/**
	* create a graph
	* @return a graph of power stations
	*/
	public static Graph<PowerStation> create(){
		//create vertices
		ArrayList<Graph.Vertex<PowerStation> > vertices = GraphCreator.createVertices();

		//create edges
		ArrayList<Graph.Edge<PowerStation> > edges = GraphCreator.createEdges(vertices);

		//create a graph
		Graph<PowerStation> graph = new Graph<PowerStation>(vertices,edges);

		//return the graph
		return graph;
	}



	/**
	* create vertices from a text file
	* @return ArrayList of vertices storing powerstaion
	*/
	private static ArrayList<Graph.Vertex<PowerStation> > createVertices(){
		//array list to store the vertices
		ArrayList<Graph.Vertex<PowerStation> > vertices = new ArrayList<Graph.Vertex<PowerStation> >();

		//loop for all power stations from a text file
		for (PowerStation station : FileHandler.loadStations()) {
			
			//create a vertice object
			Graph.Vertex<PowerStation> vertex = new Graph.Vertex<PowerStation>(station);

			//add the vertix to the list of vertices
			vertices.add(vertex);
		}


		//return the list of verices
		return vertices;
	}


	/**
	* Create a list of edges from a text file
	* @return a list of Egedes 
	*/
	private static ArrayList<Graph.Edge<PowerStation> > createEdges(ArrayList<Graph.Vertex<PowerStation> > vertices){
		//array list to the edges
		ArrayList<Graph.Edge<PowerStation> > edges = new ArrayList<Graph.Edge<PowerStation> >();

		//loop for all the edges from a text file
		for (String string : FileHandler.loadMapping()) {
			//create a string tokenizer
			StringTokenizer tokenizer = new StringTokenizer(string,"#");
			//get the first token 
			String strV1 = tokenizer.nextToken().toUpperCase();
			//get the second token
			String strV2 = tokenizer.nextToken().toUpperCase();
			//get the cost of the mapping
			int cost = Integer.parseInt(tokenizer.nextToken());

			//store the vertices that connect an edge
			Graph.Vertex<PowerStation> vertexA = null;
			Graph.Vertex<PowerStation> vertexB = null;
			
			//loop for all the verices
			for (Graph.Vertex<PowerStation> v : vertices) {
				
				//get the power station stored in the vertex
				PowerStation station = v.getValue();
				//get the station ID
				String stationID = station.getStationId().toUpperCase();

				//System.out.println(stationID + " --- " + strV1);

				//compare the station ID to the one from the file
				if(stationID.equals(strV1)){
					vertexA = v;
				}else if(stationID.equals(strV2)){
					vertexB = v;
				}

			}

			//create an edge
			if(vertexA != null && vertexB != null){
				Graph.Edge<PowerStation> edge = new Graph.Edge<PowerStation>(cost,vertexA,vertexB);
				//add the edge to the list
				edges.add(edge);
			}

		}

		//return the list of egdes
		return edges;
	}



}