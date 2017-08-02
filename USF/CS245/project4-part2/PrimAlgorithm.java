import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import java.io.File;
import java.io.FileNotFoundException;

import java.util.Scanner;

public class PrimAlgorithm {
	private Graph graph; // stores the graph of CityNode-s and edges connecting
	// them
	private List<Edge> edgesMST = new ArrayList<>(); // edges that belong to
	// MinimalSpanningTree

	public PrimAlgorithm(String filename) {
		graph = new Graph();
		graph.loadGraph(filename);
	}

	/**
	 * A class that represents a graph where nodes are cities (of type CityNode)
	 * and edges connect them and the cost of each edge is the distance between
	 * the cities.
	 */
	public class Graph {

		private CityNode[] nodes;
		private Edge[] adjacencyList; // for each vertex store a linked list of
		// edges;
		// FILL IN: other instance variables as needed
		HashMap<String, Integer> result = new HashMap<String, Integer>();
		private void createHashMap(CityNode[] nodes, HashMap<String, Integer> result) {
			int nodeID = 0;
			for (CityNode c : nodes) {
				String s = c.getCity();
				if (!result.containsKey(s)) {
					result.put(s, nodeID);
					nodeID = nodeID + 1;
				}
			}
		}

		/**
		 * Read graph info from the given file, and create nodes and edges of
		 * the graph.
		 * 
		 * @param filename
		 */
		public void loadGraph(String filename) {
			// FILL IN CODE
			File inputFile = new File(filename);

			try(Scanner input = new Scanner(inputFile)) {
				int numCities = 0;
				while (input.hasNextLine()) {
					String line = input.nextLine();
					if (line.equals("NODES")) {
						//get the number of city nodes
						line = input.nextLine();
						numCities = Integer.parseInt(line);
						nodes = new CityNode[numCities];

						//fill out the CityNode array
						for (int i = 0; i < numCities; i++) {
							String newCity = input.nextLine();
							String[] var = newCity.split(" ");
							String cityName = var[0];
							double x = Double.parseDouble(var[1]);
							double y = Double.parseDouble(var[2]);
							CityNode city = new CityNode(cityName, x, y);
							nodes[i] = city;
						}
						//hashmap
						createHashMap(nodes, result);
					} else if (line.equals("ARCS")) {
						adjacencyList = new Edge[numCities];

						while (input.hasNextLine()) {
							//get information of an Edge
							String newEdge = input.nextLine();
							String[] var = newEdge.split(" ");
							String sourceCity = var[0];
							int id1 = result.get(sourceCity);
							String destinationCity = var[1];
							int id2 = result.get(destinationCity);
							int cost = Integer.parseInt(var[2]);
							Edge edge = new Edge(id1, id2, cost);

							//fill out the adjacency list
							if (adjacencyList[id1] == null) {
								adjacencyList[id1] = edge;
							} else if (adjacencyList[id1] != null) {
								Edge pointer = adjacencyList[id1];
								while (pointer.next() != null) {
									pointer = pointer.next();
								}
								pointer.setNext(edge);
							}
						}
					}
				}
			} catch (FileNotFoundException fnf) {
				System.out.println(fnf.getMessage());
				return;
			}

		}

		//a helper method to get a list of all edges
		public Edge[] getAdjacencyList() {

			//get the size of array
			int count = 0;
			for (int i = 0; i < adjacencyList.length; i++) {
				if (adjacencyList[i] != null) {
					Edge pointer = adjacencyList[i];
					while (pointer != null) {
						count++;
						pointer = pointer.next();
					}
				}
			}

			Edge[] returnList = new Edge[count];
			int j = 0;
			for (int i = 0; i < adjacencyList.length; i++) {
				if (adjacencyList[i] != null) {
					Edge pointer = adjacencyList[i];
					while (pointer != null) {
						returnList[j] = pointer;
						j++;
						pointer = pointer.next();
					}
				}
				
			}

			return returnList;	
		}

	} // class MapGraph ------------------

	/**
	 * Compute minimum spanning tree for this graph using Prim's algorithm,
	 * starting with vertex =  startNode. 
	 * Add edges of MST to edgesMST list.
	 */
	public void computeMST(int startNode) {
		// FILL IN CODE

		//initialize the table using 2D array
		int[][] table = new int[graph.nodes.length][2];
		for (int i = 0; i < graph.nodes.length; i++) {
			//start vertex:
			if (i == startNode) {
				table[i][0] = 0;
				table[i][1] = -1;
			//else:
			} else {
				table[i][0] = Integer.MAX_VALUE;
				table[i][1] = -1;
			}
		}

		//create the priority queue / MinHeap
		PriorityQueue queue = new PriorityQueue(table.length + 1);
		for (int j = 0; j < table.length; j++) {
			int priority = table[j][0];
			queue.insert(j, priority);
		}

		//create positions array
		queue.createPositions();

		//Prim's Algorithm
		for (int i = 0; i < table.length; i++) {
			//call removeMin first
			int removed = queue.removeMin();
			
			//add edge to MST
			if ( table[removed][1] >= 0 ) {
				Edge newEdge = new Edge(table[removed][1], removed, table[removed][0]);
				edgesMST.add(newEdge);
			}

			//get neighbours
			Edge[] list = graph.getAdjacencyList();
			ArrayList<Edge> tmp = new ArrayList<Edge>();
			for (Edge e : list) {
				if (e.getId1() == removed || e.getId2() == removed) {
					tmp.add(e);
				}
			}
			
			//update table & call reduceKey as needed
			for (int k = 0; k < tmp.size(); k++) {
				if (tmp.get(k).getId1() == removed) {
					if (table[tmp.get(k).getId2()][0] > tmp.get(k).getCost()) {
						table[tmp.get(k).getId2()][0] = tmp.get(k).getCost();
						table[tmp.get(k).getId2()][1] = tmp.get(k).getId1();

						queue.reduceKey(tmp.get(k).getId2(), tmp.get(k).getCost());
					}
				} else if (tmp.get(k).getId2() == removed) {
					if (table[tmp.get(k).getId1()][0] > tmp.get(k).getCost()) {
						table[tmp.get(k).getId1()][0] = tmp.get(k).getCost();
						table[tmp.get(k).getId1()][1] = tmp.get(k).getId2();

						queue.reduceKey(tmp.get(k).getId1(), tmp.get(k).getCost());
					}
				}
			}
		}

	}

	// -------------------- Methods needed for GUIApp-------------------
	/**
	 * Used in GUIApp to display the MST. Returns a 2D Array, where each element
	 * represents an edge and is an array of two Points (where this edge starts
	 * and where it is going).
	 */
	public Point[][] getMSTEdges() {
		Point[][] edges = new Point[edgesMST.size()][2];
		// FILL IN CODE
		int k = 0;
		for (int i = 0; i < edgesMST.size(); i++) {
			//get the Points of the source city and the destination city
			edges[i][0] = graph.nodes[edgesMST.get(k).getId1()].getLocation();
			edges[i][1] = graph.nodes[edgesMST.get(k).getId2()].getLocation();
			k++;
		}

		return edges;
	}

	/**
	 * Used in GUIApp to display the edges of the graph. Returns a 2D array that
	 * contains edge info that is easy for GUI to display. For each edge, we
	 * store an array of two Points, v1 and v2. v1 is the source vertex for this
	 * edge, v2 is the destination vertex. This info can be obtained from the
	 * adjacency list
	 */
	public Point[][] getEdges() {
		Edge[] list = graph.getAdjacencyList();
		Point[][] edges2D = new Point[list.length][2];
		// FILL IN CODE
		int k = 0;
		for (int i = 0; i < list.length; i++) {
			//get the Points of the source city and the destination city
			edges2D[i][0] = graph.nodes[list[k].getId1()].getLocation();
			edges2D[i][1] = graph.nodes[list[k].getId2()].getLocation();
			k++;
		}

		return edges2D;
	}

	/**
	 * Used in GUIApp to display the nodes of the graph. Return a list of Points
	 * that correspond to nodes of the graph.
	 */
	public Point[] getNodes() {
		Point[] nodes = new Point[graph.nodes.length];
		// FILL IN CODE
		int i = 0;
		for (CityNode c : graph.nodes) {
			nodes[i] = c.getLocation();
			i++;
		}
		
		return nodes;
	}

	/**
	 * Used in GUIApp to display the names of the airports. Return the list that
	 * contains the "names" of nodes (corresponding cities)
	 */
	public String[] getCities() {
		String[] labels = new String[graph.nodes.length];
		// FILL IN CODE
		int i = 0;
		for (CityNode c : graph.nodes) {
			labels[i] = c.getCity();
			i++;
		}
		
		return labels;

	}

}
