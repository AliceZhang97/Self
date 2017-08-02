/** A class that represents the Disjoint Sets data structure. Must use Union by Rank and Path compression. */
public class DisjointSets {
	// array of "parent" indices. Stores either the index of the parent or (-height) for the root
	private int[] parent; 

	public void createSets(int n) {
		// FILL IN CODE
		parent = new int[n];
		for (int i = 0; i < n; i++) {
			parent[i] = -1;
		}
	}

	/**
	 * Returns the root of the "tree" that x belongs to. Uses path compression
	 * heuristic.
	 */
	public int find(int x) {
		// FILL IN CODE
		if (parent[x] < 0) {
			return x;
		}
		else {
			return parent[x] = find(parent[x]);
		}
		// change it
	}

	/** Merges two sets: the one with x and the one with y. Should use Union by Rank heuristic. */
	public void union(int x, int y) {
		// FILL IN CODE
		int rootx = find(x);
		int rooty = find(y);
		if (parent[rootx] < parent[rooty]) {
			parent[rooty] = rootx;
		} else {
			if (parent[rootx] == parent[rooty]) {
				parent[rooty]--;
			}
			parent[rootx] = rooty;
		}
	}

}
