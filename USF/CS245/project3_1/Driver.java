public class Driver {
	public static void main(String[] args) {
		Comparable[] array = new Comparable[7];
		array[0] = 8;
		array[1] = 6;
		array[2] = 14;
		array[3] = 5;
		array[4] = 3;
		array[5] = 15;
		array[6] = 11;
		
		//print the original Comparable array
		System.out.println("---------------");
		System.out.println("Original array:");
		for (Comparable c : array) {
			System.out.print(c + " ");
		}
		System.out.println();
		System.out.println("---------------");
		System.out.println();
	
		SortingAlgorithms sortAlgorithms = new SortingAlgorithms();
		
		System.out.println("Shaker Sort (from index 1 to 5):");
		sortAlgorithms.shakerSort(array, 1, 5);
		System.out.println();

		System.out.println("In-place Heap Sort (from index 2 to 5):");
		sortAlgorithms.heapSort(array, 2, 5);
		System.out.println();

		System.out.println("randomized Quick Sort (from index 1 to 4:");
		sortAlgorithms.randomizedQuickSort(array, 1, 4);
		System.out.println();
	
		System.out.println("External Sort: see output file");
		sortAlgorithms.externalSort("input", "output", 16, 3);
		
		String[] arrayRGB = new String[10];
		arrayRGB[0] = "g";
		arrayRGB[1] = "r";
		arrayRGB[2] = "g";
		arrayRGB[3] = "g";
		arrayRGB[4] = "b";
		arrayRGB[5] = "r";
		arrayRGB[6] = "r";
		arrayRGB[7] = "g";
		arrayRGB[8] = "b";
		arrayRGB[9] = "r";

		//print the original RGB array
		System.out.println("---------------");
		System.out.println("Original RGB array:");
		for (Comparable c : arrayRGB) {
			System.out.print(c + " ");
		}
		System.out.println();
		System.out.println("---------------");
		System.out.println();

		System.out.println("RGB Sort:");
		sortAlgorithms.rgbSort(arrayRGB);
	}
}