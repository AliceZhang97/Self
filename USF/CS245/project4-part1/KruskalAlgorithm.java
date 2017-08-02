import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

import java.io.File;
import java.io.FileNotFoundException;

import java.util.Scanner;

public class KruskalAlgorithm {
	private Graph graph; // stores the graph of CityNode-s and edges connecting them
	private List<Edge> edgesMST = new ArrayList<>(); // edges that belong to MinimalSpanningTree

	public KruskalAlgorithm(String filename) {
		graph = new Graph();
		graph.loadGraph(filename);
	}
	
	
	/**
	 * Inner class Graph.
	 * A class that represents a graph where nodes are cities (of type CityNode)
	 * and edges connect them and the cost of each edge is the distance between
	 * the cities.
	 */
	public class Graph {

		private CityNode[] nodes; // stores a CityNode for each node id
		private Edge[] adjacencyList; // for each vertex store a linked list of edges;
		// FILL IN: add a HashMap that maps the name of each city to the corresponding integer id
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
		 * Must catch I/O exceptions inside the method.
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

		
	} // inner class Graph finished ------------------

	/**
	 * Compute minimum spanning tree for this graph. Add edges of Minimal Spanning Tree to
	 * edgesMST list. Should use DisjointSet class.
	 */
	public void computeMST() {
		// FILL IN CODE
		Edge[] list = graph.getAdjacencyList();

		DisjointSets ds = new DisjointSets();
		ds.createSets(list.length);
		//use heap sort to sort the array
		heapSort(list, 0, list.length - 1);

		for (Edge e : list) {
			int v1 = e.getId1();
			int v2 = e.getId2();
			if (ds.find(v1) != ds.find(v2)) {
				edgesMST.add(e);
				ds.union(v1, v2);
			}
		}
	}


	// -------------------- methods needed for GUIApp-------------------
	/** Used in GUIApp to display the MST. Returns a 2D Array, where each element represents
	 * an edge and is an array of two Points (where this edge starts and where it is going). */
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

	/** Used in GUIApp to display the edges of the graph. Returns a 2D array that contains edge info
	 *  that is easy for GUI to display. For each edge, we store an array of two Points, v1 and v2. 
	 *  v1 is the source vertex for this edge, v2 is the destination vertex. 
	 *  This info can be obtained from the adjacency list. */
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

	/** Used in GUIApp to display the nodes of the graph. Return a list of Points that
	 *  correspond to nodes of the graph. */
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

	/** Used in GUIApp to display the names of the cities. Return the list that
	 * contains the "names" of city nodes. */
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

	// In-place Heap Sort
	public void heapSort(Edge[] array, int lowindex, int highindex) {
		//Build the heap:
		Edge[] tmpArray = new Edge[highindex - lowindex + 1];
		int j = 0;
		for (int i = lowindex; i <= highindex; i++) {
			tmpArray[j] = array[i];
			j++;
		}
		buildMaxHeap(tmpArray);

		//Sorting:
		int k = tmpArray.length - 1;
		while (k >= 1) {
			swap(tmpArray, 0, k);
			if (k != 1) {
				pushdown(tmpArray, k, 0);
			}
			k--;
		}

		int q = 0;
		for (int p = 0; p < array.length; p++) {
			if (lowindex <= p && p <= highindex) {
				array[p] = tmpArray[q];
				q++;
			}
		}
	}

	/** ----------------Helper Methods for heapSort -------------------- */
	//swap the two given elements
	private void swap(Edge[] array, int pos1, int pos2) {
		Edge tmp = array[pos1];
		array[pos1] = array[pos2];
		array[pos2] = tmp;
	}
	//push the value down if necessary
	private void pushdown(Edge[] array, int size, int position) {
		int largest;
		while ( !(position > size / 2) && (position < size) ) {
			int left = 0;
			if (position == 0) {
				left = 1;
			} else {
				left = (2 * position) + 1;
				if (left > size) {
					return;
				}
			}
			largest = left;
			if ( (largest < size - 1) && array[largest].compareTo(array[largest + 1]) < 0 ) {
				largest ++;
			}
			if (array[position].compareTo(array[largest]) >= 0 ) {
				return;
			}
			swap(array, position, largest);
			position = largest;
			size--;
		}
	}
	//build the heap using bottom up algorithm
	public void buildMaxHeap(Edge[] array) {
		int n = array.length; //number of elements need to build

		for (int pos = n/2; pos >= 1; pos--) { //start from position n/2
			int i = pos;
			Edge tmp = array[i - 1];
			boolean check = false;

			while (!check && (2 * i <= n) ) {
				int j = 2 * i;
				if (j < n) {
					//choose the larger element
					if (array[j - 1].compareTo(array[j]) < 0 ) {
						j++;
					}
				}
				if ( tmp.compareTo(array[j - 1]) > 0 ) {
					check = true;
				} else {
					array[i - 1] = array[j - 1];
					i = j;
				}
			}
			array[i - 1] = tmp;
		}
	}
	/** -------------------------------------------------------------- */
	

}
