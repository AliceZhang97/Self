import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class Test {
	public static void main(String[] args) {
	// 1). Test Shaker Sort
		//Random list:
		// a). size of 100
		double duration;
		Random randomGenerator = new Random();
		SortingAlgorithms sortAlgorithms = new SortingAlgorithms();
		Comparable[] listRandom100 = new Comparable[100];
		long startTime = System.currentTimeMillis();

		int numIters = 1000;
		for (int i = 0; i < numIters; i++) {
			//generate a random list
			for (int j = 0; j < 100; j++) {
				listRandom100[j] = randomGenerator.nextInt();
			}
			//sort it using Shaker Sort
			sortAlgorithms.shakerSort(listRandom100, 0, 99);
		}
		long endTime = System.currentTimeMillis();
		duration = ((double)(endTime - startTime)) / numIters;

		double durationOverhead;
		long startTimeOverhead = System.currentTimeMillis();
		for (int i = 0; i < numIters; i++) {
			//generate a random list
			for (int j = 0; j < 100; j++) {
				listRandom100[j] = randomGenerator.nextInt();
			}
		}
		long endTimeOverhead = System.currentTimeMillis();
		durationOverhead = ((double)(endTimeOverhead - startTimeOverhead)) / numIters;

		double runningTime = duration - durationOverhead;
		System.out.println("Running Time for Shaker Sort (random list of size 100): " + runningTime);

		// b). size of 1000
		Comparable[] listRandom1000 = new Comparable[1000];
		startTime = System.currentTimeMillis();

		numIters = 200;
		for (int i = 0; i < numIters; i++) {
			//generate a random list
			for (int j = 0; j < 1000; j++) {
				listRandom1000[j] = randomGenerator.nextInt();
			}
			//sort it using Shaker Sort
			sortAlgorithms.shakerSort(listRandom1000, 0, 999);
		}
		endTime = System.currentTimeMillis();
		duration = ((double)(endTime - startTime)) / numIters;

		startTimeOverhead = System.currentTimeMillis();
		for (int i = 0; i < numIters; i++) {
			//generate a random list
			for (int j = 0; j < 1000; j++) {
				listRandom1000[j] = randomGenerator.nextInt();
			}
		}
		endTimeOverhead = System.currentTimeMillis();
		durationOverhead = ((double)(endTimeOverhead - startTimeOverhead)) / numIters;
		runningTime = duration - durationOverhead;
		System.out.println("Running Time for Shaker Sort (random list of size 1000): " + runningTime);
	
	
		// c). size of 10000
		Comparable[] listRandom10000 = new Comparable[10000];
		startTime = System.currentTimeMillis();

		numIters = 5;
		for (int i = 0; i < numIters; i++) {
			//generate a random list
			for (int j = 0; j < 10000; j++) {
				listRandom10000[j] = randomGenerator.nextInt();
			}
			//sort it using Shaker Sort
			sortAlgorithms.shakerSort(listRandom10000, 0, 9999);
		}
		endTime = System.currentTimeMillis();
		duration = ((double)(endTime - startTime)) / numIters;

		startTimeOverhead = System.currentTimeMillis();
		for (int i = 0; i < numIters; i++) {
			//generate a random list
			for (int j = 0; j < 10000; j++) {
				listRandom10000[j] = randomGenerator.nextInt();
			}
		}
		endTimeOverhead = System.currentTimeMillis();
		durationOverhead = ((double)(endTimeOverhead - startTimeOverhead)) / numIters;
		runningTime = duration - durationOverhead;
		System.out.println("Running Time for Shaker Sort (random list of size 10000): " + runningTime);

		// d). size of 100000
		Comparable[] listRandom100000 = new Comparable[100000];
		startTime = System.currentTimeMillis();

		numIters = 3;
		for (int i = 0; i < numIters; i++) {
			//generate a random list
			for (int j = 0; j < 100000; j++) {
				listRandom100000[j] = randomGenerator.nextInt();
			}
			//sort it using Shaker Sort
			sortAlgorithms.shakerSort(listRandom100000, 0, 99999);
		}
		endTime = System.currentTimeMillis();
		duration = ((double)(endTime - startTime)) / numIters;

		startTimeOverhead = System.currentTimeMillis();
		for (int i = 0; i < numIters; i++) {
			//generate a random list
			for (int j = 0; j < 100000; j++) {
				listRandom100000[j] = randomGenerator.nextInt();
			}
		}
		endTimeOverhead = System.currentTimeMillis();
		durationOverhead = ((double)(endTimeOverhead - startTimeOverhead)) / numIters;
		runningTime = duration - durationOverhead;
		System.out.println("Running Time for Shaker Sort (random list of size 100000): " + runningTime);
	
		//Sorted list:
		// a). size of 100
		Comparable[] listSorted100 = new Comparable[100];
		startTime = System.currentTimeMillis();

		numIters = 1000;
		for (int i = 0; i < numIters; i++) {
			//generate a sorted list
			for (int j = 0; j < 100; j++) {
				listSorted100[j] = j;
			}
			//sort it using Shaker Sort
			sortAlgorithms.shakerSort(listSorted100, 0, 99);
		}
		endTime = System.currentTimeMillis();
		duration = ((double)(endTime - startTime)) / numIters;

		startTimeOverhead = System.currentTimeMillis();
		for (int i = 0; i < numIters; i++) {
			//generate a sorted list
			for (int j = 0; j < 100; j++) {
				listSorted100[j] = j;
			}
		}
		endTimeOverhead = System.currentTimeMillis();
		durationOverhead = ((double)(endTimeOverhead - startTimeOverhead)) / numIters;
		runningTime = duration - durationOverhead;
		System.out.println("Running Time for Shaker Sort (sorted list of size 100): " + runningTime);
	
		// b). size of 1000
		Comparable[] listSorted1000 = new Comparable[1000];
		startTime = System.currentTimeMillis();

		numIters = 200;
		for (int i = 0; i < numIters; i++) {
			//generate a sorted list
			for (int j = 0; j < 1000; j++) {
				listSorted1000[j] = j;
			}
			//sort it using Shaker Sort
			sortAlgorithms.shakerSort(listSorted1000, 0, 999);
		}
		endTime = System.currentTimeMillis();
		duration = ((double)(endTime - startTime)) / numIters;

		startTimeOverhead = System.currentTimeMillis();
		for (int i = 0; i < numIters; i++) {
			//generate a sorted list
			for (int j = 0; j < 1000; j++) {
				listSorted1000[j] = j;
			}
		}
		endTimeOverhead = System.currentTimeMillis();
		durationOverhead = ((double)(endTimeOverhead - startTimeOverhead)) / numIters;
		runningTime = duration - durationOverhead;
		System.out.println("Running Time for Shaker Sort (sorted list of size 1000): " + runningTime);

		// c). size of 10000
		Comparable[] listSorted10000 = new Comparable[10000];
		startTime = System.currentTimeMillis();

		numIters = 5;
		for (int i = 0; i < numIters; i++) {
			//generate a sorted list
			for (int j = 0; j < 10000; j++) {
				listSorted10000[j] = j;
			}
			//sort it using Shaker Sort
			sortAlgorithms.shakerSort(listSorted10000, 0, 9999);
		}
		endTime = System.currentTimeMillis();
		duration = ((double)(endTime - startTime)) / numIters;

		startTimeOverhead = System.currentTimeMillis();
		for (int i = 0; i < numIters; i++) {
			//generate a sorted list
			for (int j = 0; j < 10000; j++) {
				listSorted10000[j] = j;
			}
		}
		endTimeOverhead = System.currentTimeMillis();
		durationOverhead = ((double)(endTimeOverhead - startTimeOverhead)) / numIters;
		runningTime = duration - durationOverhead;
		System.out.println("Running Time for Shaker Sort (sorted list of size 10000): " + runningTime);

		// d). size of 100000
		Comparable[] listSorted100000 = new Comparable[100000];
		startTime = System.currentTimeMillis();

		numIters = 3;
		for (int i = 0; i < numIters; i++) {
			//generate a sorted list
			for (int j = 0; j < 100000; j++) {
				listSorted100000[j] = j;
			}
			//sort it using Shaker Sort
			sortAlgorithms.shakerSort(listSorted100000, 0, 99999);
		}
		endTime = System.currentTimeMillis();
		duration = ((double)(endTime - startTime)) / numIters;

		startTimeOverhead = System.currentTimeMillis();
		for (int i = 0; i < numIters; i++) {
			//generate a sorted list
			for (int j = 0; j < 100000; j++) {
				listSorted100000[j] = j;
			}
		}
		endTimeOverhead = System.currentTimeMillis();
		durationOverhead = ((double)(endTimeOverhead - startTimeOverhead)) / numIters;
		runningTime = duration - durationOverhead;
		System.out.println("Running Time for Shaker Sort (sorted list of size 100000): " + runningTime);
	
		//Reverse sorted list:
		// a). size of 100
		Comparable[] listReverse100 = new Comparable[100];
		startTime = System.currentTimeMillis();

		numIters = 1000;
		for (int i = 0; i < numIters; i++) {
			//generate a reversed sorted list
			int curr = 100;
			for (int j = 0; j < 100; j++) {
				listReverse100[j] = curr;
				curr = curr - 1;
			}
			//sort it using Shaker Sort
			sortAlgorithms.shakerSort(listReverse100, 0, 99);
		}
		endTime = System.currentTimeMillis();
		duration = ((double)(endTime - startTime)) / numIters;

		startTimeOverhead = System.currentTimeMillis();
		for (int i = 0; i < numIters; i++) {
			//generate a sorted list
			int curr = 100;
			for (int j = 0; j < 100; j++) {
				listReverse100[j] = curr;
				curr = curr - 1;
			}
		}
		endTimeOverhead = System.currentTimeMillis();
		durationOverhead = ((double)(endTimeOverhead - startTimeOverhead)) / numIters;
		runningTime = duration - durationOverhead;
		System.out.println("Running Time for Shaker Sort (Reversed sorted list of size 100): " + runningTime);
	
		// b). size of 1000
		Comparable[] listReverse1000 = new Comparable[1000];
		startTime = System.currentTimeMillis();

		numIters = 200;
		for (int i = 0; i < numIters; i++) {
			//generate a reversed sorted list
			int curr = 1000;
			for (int j = 0; j < 1000; j++) {
				listReverse1000[j] = curr;
				curr = curr - 1;
			}
			//sort it using Shaker Sort
			sortAlgorithms.shakerSort(listReverse1000, 0, 999);
		}
		endTime = System.currentTimeMillis();
		duration = ((double)(endTime - startTime)) / numIters;

		startTimeOverhead = System.currentTimeMillis();
		for (int i = 0; i < numIters; i++) {
			//generate a sorted list
			int curr = 1000;
			for (int j = 0; j < 1000; j++) {
				listReverse1000[j] = curr;
				curr = curr - 1;
			}
		}
		endTimeOverhead = System.currentTimeMillis();
		durationOverhead = ((double)(endTimeOverhead - startTimeOverhead)) / numIters;
		runningTime = duration - durationOverhead;
		System.out.println("Running Time for Shaker Sort (Reversed sorted list of size 1000): " + runningTime);

		// c). size of 10000
		Comparable[] listReverse10000 = new Comparable[10000];
		startTime = System.currentTimeMillis();

		numIters = 5;
		for (int i = 0; i < numIters; i++) {
			//generate a reversed sorted list
			int curr = 10000;
			for (int j = 0; j < 10000; j++) {
				listReverse10000[j] = curr;
				curr = curr - 1;
			}
			//sort it using Shaker Sort
			sortAlgorithms.shakerSort(listReverse10000, 0, 9999);
		}
		endTime = System.currentTimeMillis();
		duration = ((double)(endTime - startTime)) / numIters;

		startTimeOverhead = System.currentTimeMillis();
		for (int i = 0; i < numIters; i++) {
			//generate a sorted list
			int curr = 10000;
			for (int j = 0; j < 10000; j++) {
				listReverse10000[j] = curr;
				curr = curr - 1;
			}
		}
		endTimeOverhead = System.currentTimeMillis();
		durationOverhead = ((double)(endTimeOverhead - startTimeOverhead)) / numIters;
		runningTime = duration - durationOverhead;
		System.out.println("Running Time for Shaker Sort (Reversed sorted list of size 10000): " + runningTime);

		// d). size of 100000
		Comparable[] listReverse100000 = new Comparable[100000];
		startTime = System.currentTimeMillis();

		numIters = 3;
		for (int i = 0; i < numIters; i++) {
			//generate a reversed sorted list
			int curr = 100000;
			for (int j = 0; j < 100000; j++) {
				listReverse100000[j] = curr;
				curr = curr - 1;
			}
			//sort it using Shaker Sort
			sortAlgorithms.shakerSort(listReverse100000, 0, 99999);
		}
		endTime = System.currentTimeMillis();
		duration = ((double)(endTime - startTime)) / numIters;

		startTimeOverhead = System.currentTimeMillis();
		for (int i = 0; i < numIters; i++) {
			//generate a sorted list
			int curr = 100000;
			for (int j = 0; j < 100000; j++) {
				listReverse100000[j] = curr;
				curr = curr - 1;
			}
		}
		endTimeOverhead = System.currentTimeMillis();
		durationOverhead = ((double)(endTimeOverhead - startTimeOverhead)) / numIters;
		runningTime = duration - durationOverhead;
		System.out.println("Running Time for Shaker Sort (Reversed sorted list of size 100000): " + runningTime);
	

	// 2). Test Heap Sort
		//Random list:
		// a). size of 100
		startTime = System.currentTimeMillis();

		numIters = 1000;
		for (int i = 0; i < numIters; i++) {
			//generate a random list
			for (int j = 0; j < 100; j++) {
				listRandom100[j] = randomGenerator.nextInt();
			}
			//sort it using Heap Sort
			sortAlgorithms.heapSort(listRandom100, 0, 99);
		}
		endTime = System.currentTimeMillis();
		duration = ((double)(endTime - startTime)) / numIters;

		startTimeOverhead = System.currentTimeMillis();
		for (int i = 0; i < numIters; i++) {
			//generate a random list
			for (int j = 0; j < 100; j++) {
				listRandom100[j] = randomGenerator.nextInt();
			}
		}
		endTimeOverhead = System.currentTimeMillis();
		durationOverhead = ((double)(endTimeOverhead - startTimeOverhead)) / numIters;

		runningTime = duration - durationOverhead;
		System.out.println("Running Time for Heap Sort (random list of size 100): " + runningTime);
	
		// b). size of 1000
		startTime = System.currentTimeMillis();

		numIters = 500;
		for (int i = 0; i < numIters; i++) {
			//generate a random list
			for (int j = 0; j < 1000; j++) {
				listRandom1000[j] = randomGenerator.nextInt();
			}
			//sort it using Heap Sort
			sortAlgorithms.heapSort(listRandom1000, 0, 999);
		}
		endTime = System.currentTimeMillis();
		duration = ((double)(endTime - startTime)) / numIters;

		startTimeOverhead = System.currentTimeMillis();
		for (int i = 0; i < numIters; i++) {
			//generate a random list
			for (int j = 0; j < 1000; j++) {
				listRandom1000[j] = randomGenerator.nextInt();
			}
		}
		endTimeOverhead = System.currentTimeMillis();
		durationOverhead = ((double)(endTimeOverhead - startTimeOverhead)) / numIters;

		runningTime = duration - durationOverhead;
		System.out.println("Running Time for Heap Sort (random list of size 1000): " + runningTime);

		// c). size of 10000
		startTime = System.currentTimeMillis();

		numIters = 300;
		for (int i = 0; i < numIters; i++) {
			//generate a random list
			for (int j = 0; j < 10000; j++) {
				listRandom10000[j] = randomGenerator.nextInt();
			}
			//sort it using Heap Sort
			sortAlgorithms.heapSort(listRandom10000, 0, 9999);
		}
		endTime = System.currentTimeMillis();
		duration = ((double)(endTime - startTime)) / numIters;

		startTimeOverhead = System.currentTimeMillis();
		for (int i = 0; i < numIters; i++) {
			//generate a random list
			for (int j = 0; j < 10000; j++) {
				listRandom10000[j] = randomGenerator.nextInt();
			}
		}
		endTimeOverhead = System.currentTimeMillis();
		durationOverhead = ((double)(endTimeOverhead - startTimeOverhead)) / numIters;

		runningTime = duration - durationOverhead;
		System.out.println("Running Time for Heap Sort (random list of size 10000): " + runningTime);

		// d). size of 100000
		startTime = System.currentTimeMillis();

		numIters = 200;
		for (int i = 0; i < numIters; i++) {
			//generate a random list
			for (int j = 0; j < 100000; j++) {
				listRandom100000[j] = randomGenerator.nextInt();
			}
			//sort it using Heap Sort
			sortAlgorithms.heapSort(listRandom100000, 0, 99999);
		}
		endTime = System.currentTimeMillis();
		duration = ((double)(endTime - startTime)) / numIters;

		startTimeOverhead = System.currentTimeMillis();
		for (int i = 0; i < numIters; i++) {
			//generate a random list
			for (int j = 0; j < 100000; j++) {
				listRandom100000[j] = randomGenerator.nextInt();
			}
		}
		endTimeOverhead = System.currentTimeMillis();
		durationOverhead = ((double)(endTimeOverhead - startTimeOverhead)) / numIters;

		runningTime = duration - durationOverhead;
		System.out.println("Running Time for Heap Sort (random list of size 100000): " + runningTime);
	
		//Sorted list:
		// a). size of 100
		startTime = System.currentTimeMillis();

		numIters = 1000;
		for (int i = 0; i < numIters; i++) {
			//generate a sorted list
			for (int j = 0; j < 100; j++) {
				listSorted100[j] = j;
			}
			//sort it using Heap Sort
			sortAlgorithms.heapSort(listSorted100, 0, 99);
		}
		endTime = System.currentTimeMillis();
		duration = ((double)(endTime - startTime)) / numIters;

		startTimeOverhead = System.currentTimeMillis();
		for (int i = 0; i < numIters; i++) {
			//generate a sorted list
			for (int j = 0; j < 100; j++) {
				listSorted100[j] = j;
			}
		}
		endTimeOverhead = System.currentTimeMillis();
		durationOverhead = ((double)(endTimeOverhead - startTimeOverhead)) / numIters;
		runningTime = duration - durationOverhead;
		System.out.println("Running Time for Heap Sort (sorted list of size 100): " + runningTime);
	
		// b). size of 1000
		startTime = System.currentTimeMillis();

		numIters = 500;
		for (int i = 0; i < numIters; i++) {
			//generate a sorted list
			for (int j = 0; j < 1000; j++) {
				listSorted1000[j] = j;
			}
			//sort it using Heap Sort
			sortAlgorithms.heapSort(listSorted1000, 0, 999);
		}
		endTime = System.currentTimeMillis();
		duration = ((double)(endTime - startTime)) / numIters;

		startTimeOverhead = System.currentTimeMillis();
		for (int i = 0; i < numIters; i++) {
			//generate a sorted list
			for (int j = 0; j < 1000; j++) {
				listSorted1000[j] = j;
			}
		}
		endTimeOverhead = System.currentTimeMillis();
		durationOverhead = ((double)(endTimeOverhead - startTimeOverhead)) / numIters;
		runningTime = duration - durationOverhead;
		System.out.println("Running Time for Heap Sort (sorted list of size 1000): " + runningTime);

		// c). size of 10000
		startTime = System.currentTimeMillis();

		numIters = 300;
		for (int i = 0; i < numIters; i++) {
			//generate a sorted list
			for (int j = 0; j < 10000; j++) {
				listSorted10000[j] = j;
			}
			//sort it using Heap Sort
			sortAlgorithms.heapSort(listSorted10000, 0, 9999);
		}
		endTime = System.currentTimeMillis();
		duration = ((double)(endTime - startTime)) / numIters;

		startTimeOverhead = System.currentTimeMillis();
		for (int i = 0; i < numIters; i++) {
			//generate a sorted list
			for (int j = 0; j < 10000; j++) {
				listSorted10000[j] = j;
			}
		}
		endTimeOverhead = System.currentTimeMillis();
		durationOverhead = ((double)(endTimeOverhead - startTimeOverhead)) / numIters;
		runningTime = duration - durationOverhead;
		System.out.println("Running Time for Heap Sort (sorted list of size 10000): " + runningTime);

		// d). size of 100000
		startTime = System.currentTimeMillis();

		numIters = 200;
		for (int i = 0; i < numIters; i++) {
			//generate a sorted list
			for (int j = 0; j < 100000; j++) {
				listSorted100000[j] = j;
			}
			//sort it using Heap Sort
			sortAlgorithms.heapSort(listSorted100000, 0, 99999);
		}
		endTime = System.currentTimeMillis();
		duration = ((double)(endTime - startTime)) / numIters;

		startTimeOverhead = System.currentTimeMillis();
		for (int i = 0; i < numIters; i++) {
			//generate a sorted list
			for (int j = 0; j < 100000; j++) {
				listSorted100000[j] = j;
			}
		}
		endTimeOverhead = System.currentTimeMillis();
		durationOverhead = ((double)(endTimeOverhead - startTimeOverhead)) / numIters;
		runningTime = duration - durationOverhead;
		System.out.println("Running Time for Heap Sort (sorted list of size 100000): " + runningTime);
	
		//Reverse sorted list:
		// a). size of 100
		startTime = System.currentTimeMillis();

		numIters = 1000;
		for (int i = 0; i < numIters; i++) {
			//generate a reversed sorted list
			int curr = 100;
			for (int j = 0; j < 100; j++) {
				listReverse100[j] = curr;
				curr = curr - 1;
			}
			//sort it using Heap Sort
			sortAlgorithms.heapSort(listReverse100, 0, 99);
		}
		endTime = System.currentTimeMillis();
		duration = ((double)(endTime - startTime)) / numIters;

		startTimeOverhead = System.currentTimeMillis();
		for (int i = 0; i < numIters; i++) {
			//generate a sorted list
			int curr = 100;
			for (int j = 0; j < 100; j++) {
				listReverse100[j] = curr;
				curr = curr - 1;
			}
		}
		endTimeOverhead = System.currentTimeMillis();
		durationOverhead = ((double)(endTimeOverhead - startTimeOverhead)) / numIters;
		runningTime = duration - durationOverhead;
		System.out.println("Running Time for Heap Sort (Reversed sorted list of size 100): " + runningTime);
	
		// b). size of 1000
		startTime = System.currentTimeMillis();

		numIters = 500;
		for (int i = 0; i < numIters; i++) {
			//generate a reversed sorted list
			int curr = 1000;
			for (int j = 0; j < 1000; j++) {
				listReverse1000[j] = curr;
				curr = curr - 1;
			}
			//sort it using Heap Sort
			sortAlgorithms.heapSort(listReverse1000, 0, 999);
		}
		endTime = System.currentTimeMillis();
		duration = ((double)(endTime - startTime)) / numIters;

		startTimeOverhead = System.currentTimeMillis();
		for (int i = 0; i < numIters; i++) {
			//generate a sorted list
			int curr = 1000;
			for (int j = 0; j < 1000; j++) {
				listReverse1000[j] = curr;
				curr = curr - 1;
			}
		}
		endTimeOverhead = System.currentTimeMillis();
		durationOverhead = ((double)(endTimeOverhead - startTimeOverhead)) / numIters;
		runningTime = duration - durationOverhead;
		System.out.println("Running Time for Heap Sort (Reversed sorted list of size 1000): " + runningTime);

		// c). size of 10000
		startTime = System.currentTimeMillis();

		numIters = 300;
		for (int i = 0; i < numIters; i++) {
			//generate a reversed sorted list
			int curr = 10000;
			for (int j = 0; j < 10000; j++) {
				listReverse10000[j] = curr;
				curr = curr - 1;
			}
			//sort it using Heap Sort
			sortAlgorithms.heapSort(listReverse10000, 0, 9999);
		}
		endTime = System.currentTimeMillis();
		duration = ((double)(endTime - startTime)) / numIters;

		startTimeOverhead = System.currentTimeMillis();
		for (int i = 0; i < numIters; i++) {
			//generate a sorted list
			int curr = 10000;
			for (int j = 0; j < 10000; j++) {
				listReverse10000[j] = curr;
				curr = curr - 1;
			}
		}
		endTimeOverhead = System.currentTimeMillis();
		durationOverhead = ((double)(endTimeOverhead - startTimeOverhead)) / numIters;
		runningTime = duration - durationOverhead;
		System.out.println("Running Time for Heap Sort (Reversed sorted list of size 10000): " + runningTime);

		// d). size of 100000
		startTime = System.currentTimeMillis();

		numIters = 200;
		for (int i = 0; i < numIters; i++) {
			//generate a reversed sorted list
			int curr = 100000;
			for (int j = 0; j < 100000; j++) {
				listReverse100000[j] = curr;
				curr = curr - 1;
			}
			//sort it using Heap Sort
			sortAlgorithms.heapSort(listReverse100000, 0, 99999);
		}
		endTime = System.currentTimeMillis();
		duration = ((double)(endTime - startTime)) / numIters;

		startTimeOverhead = System.currentTimeMillis();
		for (int i = 0; i < numIters; i++) {
			//generate a sorted list
			int curr = 100000;
			for (int j = 0; j < 100000; j++) {
				listReverse100000[j] = curr;
				curr = curr - 1;
			}
		}
		endTimeOverhead = System.currentTimeMillis();
		durationOverhead = ((double)(endTimeOverhead - startTimeOverhead)) / numIters;
		runningTime = duration - durationOverhead;
		System.out.println("Running Time for Heap Sort (Reversed sorted list of size 100000): " + runningTime);
	

	// 3). Test randomized quick sort
		//Random list:
		// a). size of 100
		startTime = System.currentTimeMillis();

		numIters = 1000;
		for (int i = 0; i < numIters; i++) {
			//generate a random list
			for (int j = 0; j < 100; j++) {
				listRandom100[j] = randomGenerator.nextInt();
			}
			//sort it using Randomized Quick Sort
			sortAlgorithms.randomizedQuickSort(listRandom100, 0, 99);
		}
		endTime = System.currentTimeMillis();
		duration = ((double)(endTime - startTime)) / numIters;

		startTimeOverhead = System.currentTimeMillis();
		for (int i = 0; i < numIters; i++) {
			//generate a random list
			for (int j = 0; j < 100; j++) {
				listRandom100[j] = randomGenerator.nextInt();
			}
		}
		endTimeOverhead = System.currentTimeMillis();
		durationOverhead = ((double)(endTimeOverhead - startTimeOverhead)) / numIters;

		runningTime = duration - durationOverhead;
		System.out.println("Running Time for Randomized Quick Sort (random list of size 100): " + runningTime);
	
		// b). size of 1000
		startTime = System.currentTimeMillis();

		numIters = 500;
		for (int i = 0; i < numIters; i++) {
			//generate a random list
			for (int j = 0; j < 1000; j++) {
				listRandom1000[j] = randomGenerator.nextInt();
			}
			//sort it using Randomized Quick Sort
			sortAlgorithms.randomizedQuickSort(listRandom1000, 0, 999);
		}
		endTime = System.currentTimeMillis();
		duration = ((double)(endTime - startTime)) / numIters;

		startTimeOverhead = System.currentTimeMillis();
		for (int i = 0; i < numIters; i++) {
			//generate a random list
			for (int j = 0; j < 1000; j++) {
				listRandom1000[j] = randomGenerator.nextInt();
			}
		}
		endTimeOverhead = System.currentTimeMillis();
		durationOverhead = ((double)(endTimeOverhead - startTimeOverhead)) / numIters;

		runningTime = duration - durationOverhead;
		System.out.println("Running Time for Randomized Quick Sort (random list of size 1000): " + runningTime);

		// c). size of 10000
		startTime = System.currentTimeMillis();

		numIters = 300;
		for (int i = 0; i < numIters; i++) {
			//generate a random list
			for (int j = 0; j < 10000; j++) {
				listRandom10000[j] = randomGenerator.nextInt();
			}
			//sort it using Randomized Quick Sort
			sortAlgorithms.randomizedQuickSort(listRandom10000, 0, 9999);
		}
		endTime = System.currentTimeMillis();
		duration = ((double)(endTime - startTime)) / numIters;

		startTimeOverhead = System.currentTimeMillis();
		for (int i = 0; i < numIters; i++) {
			//generate a random list
			for (int j = 0; j < 10000; j++) {
				listRandom10000[j] = randomGenerator.nextInt();
			}
		}
		endTimeOverhead = System.currentTimeMillis();
		durationOverhead = ((double)(endTimeOverhead - startTimeOverhead)) / numIters;

		runningTime = duration - durationOverhead;
		System.out.println("Running Time for Randomized Quick Sort (random list of size 10000): " + runningTime);

		// d). size of 100000
		startTime = System.currentTimeMillis();

		numIters = 200;
		for (int i = 0; i < numIters; i++) {
			//generate a random list
			for (int j = 0; j < 100000; j++) {
				listRandom100000[j] = randomGenerator.nextInt();
			}
			//sort it using Randomized Quick Sort
			sortAlgorithms.randomizedQuickSort(listRandom100000, 0, 99999);
		}
		endTime = System.currentTimeMillis();
		duration = ((double)(endTime - startTime)) / numIters;

		startTimeOverhead = System.currentTimeMillis();
		for (int i = 0; i < numIters; i++) {
			//generate a random list
			for (int j = 0; j < 100000; j++) {
				listRandom100000[j] = randomGenerator.nextInt();
			}
		}
		endTimeOverhead = System.currentTimeMillis();
		durationOverhead = ((double)(endTimeOverhead - startTimeOverhead)) / numIters;

		runningTime = duration - durationOverhead;
		System.out.println("Running Time for Randomized Quick Sort (random list of size 100000): " + runningTime);
	
		//Sorted list:
		// a). size of 100
		startTime = System.currentTimeMillis();

		numIters = 1000;
		for (int i = 0; i < numIters; i++) {
			//generate a sorted list
			for (int j = 0; j < 100; j++) {
				listSorted100[j] = j;
			}
			//sort it using Randomized Quick Sort
			sortAlgorithms.randomizedQuickSort(listSorted100, 0, 99);
		}
		endTime = System.currentTimeMillis();
		duration = ((double)(endTime - startTime)) / numIters;

		startTimeOverhead = System.currentTimeMillis();
		for (int i = 0; i < numIters; i++) {
			//generate a sorted list
			for (int j = 0; j < 100; j++) {
				listSorted100[j] = j;
			}
		}
		endTimeOverhead = System.currentTimeMillis();
		durationOverhead = ((double)(endTimeOverhead - startTimeOverhead)) / numIters;
		runningTime = duration - durationOverhead;
		System.out.println("Running Time for Randomized Quick Sort (sorted list of size 100): " + runningTime);
	
		// b). size of 1000
		startTime = System.currentTimeMillis();

		numIters = 500;
		for (int i = 0; i < numIters; i++) {
			//generate a sorted list
			for (int j = 0; j < 1000; j++) {
				listSorted1000[j] = j;
			}
			//sort it using Randomized Quick Sort
			sortAlgorithms.randomizedQuickSort(listSorted1000, 0, 999);
		}
		endTime = System.currentTimeMillis();
		duration = ((double)(endTime - startTime)) / numIters;

		startTimeOverhead = System.currentTimeMillis();
		for (int i = 0; i < numIters; i++) {
			//generate a sorted list
			for (int j = 0; j < 1000; j++) {
				listSorted1000[j] = j;
			}
		}
		endTimeOverhead = System.currentTimeMillis();
		durationOverhead = ((double)(endTimeOverhead - startTimeOverhead)) / numIters;
		runningTime = duration - durationOverhead;
		System.out.println("Running Time for Randomized Quick Sort (sorted list of size 1000): " + runningTime);

		// c). size of 10000
		startTime = System.currentTimeMillis();

		numIters = 300;
		for (int i = 0; i < numIters; i++) {
			//generate a sorted list
			for (int j = 0; j < 10000; j++) {
				listSorted10000[j] = j;
			}
			//sort it using Randomized Quick Sort
			sortAlgorithms.randomizedQuickSort(listSorted10000, 0, 9999);
		}
		endTime = System.currentTimeMillis();
		duration = ((double)(endTime - startTime)) / numIters;

		startTimeOverhead = System.currentTimeMillis();
		for (int i = 0; i < numIters; i++) {
			//generate a sorted list
			for (int j = 0; j < 10000; j++) {
				listSorted10000[j] = j;
			}
		}
		endTimeOverhead = System.currentTimeMillis();
		durationOverhead = ((double)(endTimeOverhead - startTimeOverhead)) / numIters;
		runningTime = duration - durationOverhead;
		System.out.println("Running Time for Randomized Quick Sort (sorted list of size 10000): " + runningTime);

		// d). size of 100000
		startTime = System.currentTimeMillis();

		numIters = 200;
		for (int i = 0; i < numIters; i++) {
			//generate a sorted list
			for (int j = 0; j < 100000; j++) {
				listSorted100000[j] = j;
			}
			//sort it using Randomized Quick Sort
			sortAlgorithms.randomizedQuickSort(listSorted100000, 0, 99999);
		}
		endTime = System.currentTimeMillis();
		duration = ((double)(endTime - startTime)) / numIters;

		startTimeOverhead = System.currentTimeMillis();
		for (int i = 0; i < numIters; i++) {
			//generate a sorted list
			for (int j = 0; j < 100000; j++) {
				listSorted100000[j] = j;
			}
		}
		endTimeOverhead = System.currentTimeMillis();
		durationOverhead = ((double)(endTimeOverhead - startTimeOverhead)) / numIters;
		runningTime = duration - durationOverhead;
		System.out.println("Running Time for Randomized Quick Sort (sorted list of size 100000): " + runningTime);
	
		//Reverse sorted list:
		// a). size of 100
		startTime = System.currentTimeMillis();

		numIters = 1000;
		for (int i = 0; i < numIters; i++) {
			//generate a reversed sorted list
			int curr = 100;
			for (int j = 0; j < 100; j++) {
				listReverse100[j] = curr;
				curr = curr - 1;
			}
			//sort it using Randomized Quick Sort
			sortAlgorithms.randomizedQuickSort(listReverse100, 0, 99);
		}
		endTime = System.currentTimeMillis();
		duration = ((double)(endTime - startTime)) / numIters;

		startTimeOverhead = System.currentTimeMillis();
		for (int i = 0; i < numIters; i++) {
			//generate a sorted list
			int curr = 100;
			for (int j = 0; j < 100; j++) {
				listReverse100[j] = curr;
				curr = curr - 1;
			}
		}
		endTimeOverhead = System.currentTimeMillis();
		durationOverhead = ((double)(endTimeOverhead - startTimeOverhead)) / numIters;
		runningTime = duration - durationOverhead;
		System.out.println("Running Time for Randomized Quick Sort (Reversed sorted list of size 100): " + runningTime);
	
		// b). size of 1000
		startTime = System.currentTimeMillis();

		numIters = 500;
		for (int i = 0; i < numIters; i++) {
			//generate a reversed sorted list
			int curr = 1000;
			for (int j = 0; j < 1000; j++) {
				listReverse1000[j] = curr;
				curr = curr - 1;
			}
			//sort it using Randomized Quick Sort
			sortAlgorithms.randomizedQuickSort(listReverse1000, 0, 999);
		}
		endTime = System.currentTimeMillis();
		duration = ((double)(endTime - startTime)) / numIters;

		startTimeOverhead = System.currentTimeMillis();
		for (int i = 0; i < numIters; i++) {
			//generate a sorted list
			int curr = 1000;
			for (int j = 0; j < 1000; j++) {
				listReverse1000[j] = curr;
				curr = curr - 1;
			}
		}
		endTimeOverhead = System.currentTimeMillis();
		durationOverhead = ((double)(endTimeOverhead - startTimeOverhead)) / numIters;
		runningTime = duration - durationOverhead;
		System.out.println("Running Time for Randomized Quick Sort (Reversed sorted list of size 1000): " + runningTime);

		// c). size of 10000
		startTime = System.currentTimeMillis();

		numIters = 300;
		for (int i = 0; i < numIters; i++) {
			//generate a reversed sorted list
			int curr = 10000;
			for (int j = 0; j < 10000; j++) {
				listReverse10000[j] = curr;
				curr = curr - 1;
			}
			//sort it using Randomized Quick Sort
			sortAlgorithms.randomizedQuickSort(listReverse10000, 0, 9999);
		}
		endTime = System.currentTimeMillis();
		duration = ((double)(endTime - startTime)) / numIters;

		startTimeOverhead = System.currentTimeMillis();
		for (int i = 0; i < numIters; i++) {
			//generate a sorted list
			int curr = 10000;
			for (int j = 0; j < 10000; j++) {
				listReverse10000[j] = curr;
				curr = curr - 1;
			}
		}
		endTimeOverhead = System.currentTimeMillis();
		durationOverhead = ((double)(endTimeOverhead - startTimeOverhead)) / numIters;
		runningTime = duration - durationOverhead;
		System.out.println("Running Time for Randomized Quick Sort (Reversed sorted list of size 10000): " + runningTime);

		// d). size of 100000
		startTime = System.currentTimeMillis();

		numIters = 200;
		for (int i = 0; i < numIters; i++) {
			//generate a reversed sorted list
			int curr = 100000;
			for (int j = 0; j < 100000; j++) {
				listReverse100000[j] = curr;
				curr = curr - 1;
			}
			//sort it using Randomized Quick Sort
			sortAlgorithms.randomizedQuickSort(listReverse100000, 0, 99999);
		}
		endTime = System.currentTimeMillis();
		duration = ((double)(endTime - startTime)) / numIters;

		startTimeOverhead = System.currentTimeMillis();
		for (int i = 0; i < numIters; i++) {
			//generate a sorted list
			int curr = 100000;
			for (int j = 0; j < 100000; j++) {
				listReverse100000[j] = curr;
				curr = curr - 1;
			}
		}
		endTimeOverhead = System.currentTimeMillis();
		durationOverhead = ((double)(endTimeOverhead - startTimeOverhead)) / numIters;
		runningTime = duration - durationOverhead;
		System.out.println("Running Time for Randomized Quick Sort (Reversed sorted list of size 100000): " + runningTime);

	// 4). Test Comb Sort
		//Random list:
		// a). size of 100
		startTime = System.currentTimeMillis();

		numIters = 1000;
		for (int i = 0; i < numIters; i++) {
			//generate a random list
			for (int j = 0; j < 100; j++) {
				listRandom100[j] = randomGenerator.nextInt();
			}
			//sort it using Comb Sort
			sortAlgorithms.combSort(listRandom100, 0, 99);
		}
		endTime = System.currentTimeMillis();
		duration = ((double)(endTime - startTime)) / numIters;

		startTimeOverhead = System.currentTimeMillis();
		for (int i = 0; i < numIters; i++) {
			//generate a random list
			for (int j = 0; j < 100; j++) {
				listRandom100[j] = randomGenerator.nextInt();
			}
		}
		endTimeOverhead = System.currentTimeMillis();
		durationOverhead = ((double)(endTimeOverhead - startTimeOverhead)) / numIters;

		runningTime = duration - durationOverhead;
		System.out.println("Running Time for Comb Sort (random list of size 100): " + runningTime);
	
		// b). size of 1000
		startTime = System.currentTimeMillis();

		numIters = 500;
		for (int i = 0; i < numIters; i++) {
			//generate a random list
			for (int j = 0; j < 1000; j++) {
				listRandom1000[j] = randomGenerator.nextInt();
			}
			//sort it using Comb Sort
			sortAlgorithms.combSort(listRandom1000, 0, 999);
		}
		endTime = System.currentTimeMillis();
		duration = ((double)(endTime - startTime)) / numIters;

		startTimeOverhead = System.currentTimeMillis();
		for (int i = 0; i < numIters; i++) {
			//generate a random list
			for (int j = 0; j < 1000; j++) {
				listRandom1000[j] = randomGenerator.nextInt();
			}
		}
		endTimeOverhead = System.currentTimeMillis();
		durationOverhead = ((double)(endTimeOverhead - startTimeOverhead)) / numIters;

		runningTime = duration - durationOverhead;
		System.out.println("Running Time for Comb Sort (random list of size 1000): " + runningTime);

		// c). size of 10000
		startTime = System.currentTimeMillis();

		numIters = 300;
		for (int i = 0; i < numIters; i++) {
			//generate a random list
			for (int j = 0; j < 10000; j++) {
				listRandom10000[j] = randomGenerator.nextInt();
			}
			//sort it using Comb Sort
			sortAlgorithms.combSort(listRandom10000, 0, 9999);
		}
		endTime = System.currentTimeMillis();
		duration = ((double)(endTime - startTime)) / numIters;

		startTimeOverhead = System.currentTimeMillis();
		for (int i = 0; i < numIters; i++) {
			//generate a random list
			for (int j = 0; j < 10000; j++) {
				listRandom10000[j] = randomGenerator.nextInt();
			}
		}
		endTimeOverhead = System.currentTimeMillis();
		durationOverhead = ((double)(endTimeOverhead - startTimeOverhead)) / numIters;

		runningTime = duration - durationOverhead;
		System.out.println("Running Time for Comb Sort (random list of size 10000): " + runningTime);

		// d). size of 100000
		startTime = System.currentTimeMillis();

		numIters = 200;
		for (int i = 0; i < numIters; i++) {
			//generate a random list
			for (int j = 0; j < 100000; j++) {
				listRandom100000[j] = randomGenerator.nextInt();
			}
			//sort it using Comb Sort
			sortAlgorithms.combSort(listRandom100000, 0, 99999);
		}
		endTime = System.currentTimeMillis();
		duration = ((double)(endTime - startTime)) / numIters;

		startTimeOverhead = System.currentTimeMillis();
		for (int i = 0; i < numIters; i++) {
			//generate a random list
			for (int j = 0; j < 100000; j++) {
				listRandom100000[j] = randomGenerator.nextInt();
			}
		}
		endTimeOverhead = System.currentTimeMillis();
		durationOverhead = ((double)(endTimeOverhead - startTimeOverhead)) / numIters;

		runningTime = duration - durationOverhead;
		System.out.println("Running Time for Comb Sort (random list of size 100000): " + runningTime);
	
		//Sorted list:
		// a). size of 100
		startTime = System.currentTimeMillis();

		numIters = 1000;
		for (int i = 0; i < numIters; i++) {
			//generate a sorted list
			for (int j = 0; j < 100; j++) {
				listSorted100[j] = j;
			}
			//sort it using Comb Sort
			sortAlgorithms.combSort(listSorted100, 0, 99);
		}
		endTime = System.currentTimeMillis();
		duration = ((double)(endTime - startTime)) / numIters;

		startTimeOverhead = System.currentTimeMillis();
		for (int i = 0; i < numIters; i++) {
			//generate a sorted list
			for (int j = 0; j < 100; j++) {
				listSorted100[j] = j;
			}
		}
		endTimeOverhead = System.currentTimeMillis();
		durationOverhead = ((double)(endTimeOverhead - startTimeOverhead)) / numIters;
		runningTime = duration - durationOverhead;
		System.out.println("Running Time for Comb Sort (sorted list of size 100): " + runningTime);
	
		// b). size of 1000
		startTime = System.currentTimeMillis();

		numIters = 500;
		for (int i = 0; i < numIters; i++) {
			//generate a sorted list
			for (int j = 0; j < 1000; j++) {
				listSorted1000[j] = j;
			}
			//sort it using Comb Sort
			sortAlgorithms.combSort(listSorted1000, 0, 999);
		}
		endTime = System.currentTimeMillis();
		duration = ((double)(endTime - startTime)) / numIters;

		startTimeOverhead = System.currentTimeMillis();
		for (int i = 0; i < numIters; i++) {
			//generate a sorted list
			for (int j = 0; j < 1000; j++) {
				listSorted1000[j] = j;
			}
		}
		endTimeOverhead = System.currentTimeMillis();
		durationOverhead = ((double)(endTimeOverhead - startTimeOverhead)) / numIters;
		runningTime = duration - durationOverhead;
		System.out.println("Running Time for Comb Sort (sorted list of size 1000): " + runningTime);

		// c). size of 10000
		startTime = System.currentTimeMillis();

		numIters = 300;
		for (int i = 0; i < numIters; i++) {
			//generate a sorted list
			for (int j = 0; j < 10000; j++) {
				listSorted10000[j] = j;
			}
			//sort it using Comb Sort
			sortAlgorithms.combSort(listSorted10000, 0, 9999);
		}
		endTime = System.currentTimeMillis();
		duration = ((double)(endTime - startTime)) / numIters;

		startTimeOverhead = System.currentTimeMillis();
		for (int i = 0; i < numIters; i++) {
			//generate a sorted list
			for (int j = 0; j < 10000; j++) {
				listSorted10000[j] = j;
			}
		}
		endTimeOverhead = System.currentTimeMillis();
		durationOverhead = ((double)(endTimeOverhead - startTimeOverhead)) / numIters;
		runningTime = duration - durationOverhead;
		System.out.println("Running Time for Comb Sort (sorted list of size 10000): " + runningTime);

		// d). size of 100000
		startTime = System.currentTimeMillis();

		numIters = 200;
		for (int i = 0; i < numIters; i++) {
			//generate a sorted list
			for (int j = 0; j < 100000; j++) {
				listSorted100000[j] = j;
			}
			//sort it using Comb Sort
			sortAlgorithms.combSort(listSorted100000, 0, 99999);
		}
		endTime = System.currentTimeMillis();
		duration = ((double)(endTime - startTime)) / numIters;

		startTimeOverhead = System.currentTimeMillis();
		for (int i = 0; i < numIters; i++) {
			//generate a sorted list
			for (int j = 0; j < 100000; j++) {
				listSorted100000[j] = j;
			}
		}
		endTimeOverhead = System.currentTimeMillis();
		durationOverhead = ((double)(endTimeOverhead - startTimeOverhead)) / numIters;
		runningTime = duration - durationOverhead;
		System.out.println("Running Time for Comb Sort (sorted list of size 100000): " + runningTime);
	
		//Reverse sorted list:
		// a). size of 100
		startTime = System.currentTimeMillis();

		numIters = 1000;
		for (int i = 0; i < numIters; i++) {
			//generate a reversed sorted list
			int curr = 100;
			for (int j = 0; j < 100; j++) {
				listReverse100[j] = curr;
				curr = curr - 1;
			}
			//sort it using Comb Sort
			sortAlgorithms.combSort(listReverse100, 0, 99);
		}
		endTime = System.currentTimeMillis();
		duration = ((double)(endTime - startTime)) / numIters;

		startTimeOverhead = System.currentTimeMillis();
		for (int i = 0; i < numIters; i++) {
			//generate a sorted list
			int curr = 100;
			for (int j = 0; j < 100; j++) {
				listReverse100[j] = curr;
				curr = curr - 1;
			}
		}
		endTimeOverhead = System.currentTimeMillis();
		durationOverhead = ((double)(endTimeOverhead - startTimeOverhead)) / numIters;
		runningTime = duration - durationOverhead;
		System.out.println("Running Time for Comb Sort (Reversed sorted list of size 100): " + runningTime);
	
		// b). size of 1000
		startTime = System.currentTimeMillis();

		numIters = 500;
		for (int i = 0; i < numIters; i++) {
			//generate a reversed sorted list
			int curr = 1000;
			for (int j = 0; j < 1000; j++) {
				listReverse1000[j] = curr;
				curr = curr - 1;
			}
			//sort it using Comb Sort
			sortAlgorithms.combSort(listReverse1000, 0, 999);
		}
		endTime = System.currentTimeMillis();
		duration = ((double)(endTime - startTime)) / numIters;

		startTimeOverhead = System.currentTimeMillis();
		for (int i = 0; i < numIters; i++) {
			//generate a sorted list
			int curr = 1000;
			for (int j = 0; j < 1000; j++) {
				listReverse1000[j] = curr;
				curr = curr - 1;
			}
		}
		endTimeOverhead = System.currentTimeMillis();
		durationOverhead = ((double)(endTimeOverhead - startTimeOverhead)) / numIters;
		runningTime = duration - durationOverhead;
		System.out.println("Running Time for Comb Sort (Reversed sorted list of size 1000): " + runningTime);

		// c). size of 10000
		startTime = System.currentTimeMillis();

		numIters = 300;
		for (int i = 0; i < numIters; i++) {
			//generate a reversed sorted list
			int curr = 10000;
			for (int j = 0; j < 10000; j++) {
				listReverse10000[j] = curr;
				curr = curr - 1;
			}
			//sort it using Comb Sort
			sortAlgorithms.combSort(listReverse10000, 0, 9999);
		}
		endTime = System.currentTimeMillis();
		duration = ((double)(endTime - startTime)) / numIters;

		startTimeOverhead = System.currentTimeMillis();
		for (int i = 0; i < numIters; i++) {
			//generate a sorted list
			int curr = 10000;
			for (int j = 0; j < 10000; j++) {
				listReverse10000[j] = curr;
				curr = curr - 1;
			}
		}
		endTimeOverhead = System.currentTimeMillis();
		durationOverhead = ((double)(endTimeOverhead - startTimeOverhead)) / numIters;
		runningTime = duration - durationOverhead;
		System.out.println("Running Time for Comb Sort (Reversed sorted list of size 10000): " + runningTime);

		// d). size of 100000
		startTime = System.currentTimeMillis();

		numIters = 200;
		for (int i = 0; i < numIters; i++) {
			//generate a reversed sorted list
			int curr = 100000;
			for (int j = 0; j < 100000; j++) {
				listReverse100000[j] = curr;
				curr = curr - 1;
			}
			//sort it using Comb Sort
			sortAlgorithms.combSort(listReverse100000, 0, 99999);
		}
		endTime = System.currentTimeMillis();
		duration = ((double)(endTime - startTime)) / numIters;

		startTimeOverhead = System.currentTimeMillis();
		for (int i = 0; i < numIters; i++) {
			//generate a sorted list
			int curr = 100000;
			for (int j = 0; j < 100000; j++) {
				listReverse100000[j] = curr;
				curr = curr - 1;
			}
		}
		endTimeOverhead = System.currentTimeMillis();
		durationOverhead = ((double)(endTimeOverhead - startTimeOverhead)) / numIters;
		runningTime = duration - durationOverhead;
		System.out.println("Running Time for Comb Sort (Reversed sorted list of size 100000): " + runningTime);

	// 5). Test iterativeMergeSort
		//Random list:
		// a). size of 100
		startTime = System.currentTimeMillis();

		numIters = 1000;
		for (int i = 0; i < numIters; i++) {
			//generate a random list
			for (int j = 0; j < 100; j++) {
				listRandom100[j] = randomGenerator.nextInt();
			}
			//sort it using iterativeMergeSort
			sortAlgorithms.iterativeMergeSort(listRandom100);
		}
		endTime = System.currentTimeMillis();
		duration = ((double)(endTime - startTime)) / numIters;

		startTimeOverhead = System.currentTimeMillis();
		for (int i = 0; i < numIters; i++) {
			//generate a random list
			for (int j = 0; j < 100; j++) {
				listRandom100[j] = randomGenerator.nextInt();
			}
		}
		endTimeOverhead = System.currentTimeMillis();
		durationOverhead = ((double)(endTimeOverhead - startTimeOverhead)) / numIters;

		runningTime = duration - durationOverhead;
		System.out.println("Running Time for iterative Merge Sort (random list of size 100): " + runningTime);
	
		// b). size of 1000
		startTime = System.currentTimeMillis();

		numIters = 500;
		for (int i = 0; i < numIters; i++) {
			//generate a random list
			for (int j = 0; j < 1000; j++) {
				listRandom1000[j] = randomGenerator.nextInt();
			}
			//sort it using iterativeMergeSort
			sortAlgorithms.iterativeMergeSort(listRandom1000);
		}
		endTime = System.currentTimeMillis();
		duration = ((double)(endTime - startTime)) / numIters;

		startTimeOverhead = System.currentTimeMillis();
		for (int i = 0; i < numIters; i++) {
			//generate a random list
			for (int j = 0; j < 1000; j++) {
				listRandom1000[j] = randomGenerator.nextInt();
			}
		}
		endTimeOverhead = System.currentTimeMillis();
		durationOverhead = ((double)(endTimeOverhead - startTimeOverhead)) / numIters;

		runningTime = duration - durationOverhead;
		System.out.println("Running Time for iterative Merge Sort (random list of size 1000): " + runningTime);

		// c). size of 10000
		startTime = System.currentTimeMillis();

		numIters = 300;
		for (int i = 0; i < numIters; i++) {
			//generate a random list
			for (int j = 0; j < 10000; j++) {
				listRandom10000[j] = randomGenerator.nextInt();
			}
			//sort it using iterativeMergeSort Sort
			sortAlgorithms.iterativeMergeSort(listRandom10000);
		}
		endTime = System.currentTimeMillis();
		duration = ((double)(endTime - startTime)) / numIters;

		startTimeOverhead = System.currentTimeMillis();
		for (int i = 0; i < numIters; i++) {
			//generate a random list
			for (int j = 0; j < 10000; j++) {
				listRandom10000[j] = randomGenerator.nextInt();
			}
		}
		endTimeOverhead = System.currentTimeMillis();
		durationOverhead = ((double)(endTimeOverhead - startTimeOverhead)) / numIters;

		runningTime = duration - durationOverhead;
		System.out.println("Running Time for iterative Merge Sort (random list of size 10000): " + runningTime);

		// d). size of 100000
		startTime = System.currentTimeMillis();

		numIters = 200;
		for (int i = 0; i < numIters; i++) {
			//generate a random list
			for (int j = 0; j < 100000; j++) {
				listRandom100000[j] = randomGenerator.nextInt();
			}
			//sort it using iterativeMergeSort
			sortAlgorithms.iterativeMergeSort(listRandom100000);
		}
		endTime = System.currentTimeMillis();
		duration = ((double)(endTime - startTime)) / numIters;

		startTimeOverhead = System.currentTimeMillis();
		for (int i = 0; i < numIters; i++) {
			//generate a random list
			for (int j = 0; j < 100000; j++) {
				listRandom100000[j] = randomGenerator.nextInt();
			}
		}
		endTimeOverhead = System.currentTimeMillis();
		durationOverhead = ((double)(endTimeOverhead - startTimeOverhead)) / numIters;

		runningTime = duration - durationOverhead;
		System.out.println("Running Time for iterative Merge Sort (random list of size 100000): " + runningTime);
	
		//Sorted list:
		// a). size of 100
		startTime = System.currentTimeMillis();

		numIters = 1000;
		for (int i = 0; i < numIters; i++) {
			//generate a sorted list
			for (int j = 0; j < 100; j++) {
				listSorted100[j] = j;
			}
			//sort it using iterativeMergeSort
			sortAlgorithms.iterativeMergeSort(listSorted100);
		}
		endTime = System.currentTimeMillis();
		duration = ((double)(endTime - startTime)) / numIters;

		startTimeOverhead = System.currentTimeMillis();
		for (int i = 0; i < numIters; i++) {
			//generate a sorted list
			for (int j = 0; j < 100; j++) {
				listSorted100[j] = j;
			}
		}
		endTimeOverhead = System.currentTimeMillis();
		durationOverhead = ((double)(endTimeOverhead - startTimeOverhead)) / numIters;
		runningTime = duration - durationOverhead;
		System.out.println("Running Time for iterative Merge Sort (sorted list of size 100): " + runningTime);
	
		// b). size of 1000
		startTime = System.currentTimeMillis();

		numIters = 500;
		for (int i = 0; i < numIters; i++) {
			//generate a sorted list
			for (int j = 0; j < 1000; j++) {
				listSorted1000[j] = j;
			}
			//sort it using iterativeMergeSort
			sortAlgorithms.iterativeMergeSort(listSorted1000);
		}
		endTime = System.currentTimeMillis();
		duration = ((double)(endTime - startTime)) / numIters;

		startTimeOverhead = System.currentTimeMillis();
		for (int i = 0; i < numIters; i++) {
			//generate a sorted list
			for (int j = 0; j < 1000; j++) {
				listSorted1000[j] = j;
			}
		}
		endTimeOverhead = System.currentTimeMillis();
		durationOverhead = ((double)(endTimeOverhead - startTimeOverhead)) / numIters;
		runningTime = duration - durationOverhead;
		System.out.println("Running Time for iterative Merge Sort (sorted list of size 1000): " + runningTime);

		// c). size of 10000
		startTime = System.currentTimeMillis();

		numIters = 300;
		for (int i = 0; i < numIters; i++) {
			//generate a sorted list
			for (int j = 0; j < 10000; j++) {
				listSorted10000[j] = j;
			}
			//sort it using iterativeMergeSort
			sortAlgorithms.iterativeMergeSort(listSorted10000);
		}
		endTime = System.currentTimeMillis();
		duration = ((double)(endTime - startTime)) / numIters;

		startTimeOverhead = System.currentTimeMillis();
		for (int i = 0; i < numIters; i++) {
			//generate a sorted list
			for (int j = 0; j < 10000; j++) {
				listSorted10000[j] = j;
			}
		}
		endTimeOverhead = System.currentTimeMillis();
		durationOverhead = ((double)(endTimeOverhead - startTimeOverhead)) / numIters;
		runningTime = duration - durationOverhead;
		System.out.println("Running Time for iterative Merge Sort (sorted list of size 10000): " + runningTime);

		// d). size of 100000
		startTime = System.currentTimeMillis();

		numIters = 200;
		for (int i = 0; i < numIters; i++) {
			//generate a sorted list
			for (int j = 0; j < 100000; j++) {
				listSorted100000[j] = j;
			}
			//sort it using iterativeMergeSort
			sortAlgorithms.iterativeMergeSort(listSorted100000);
		}
		endTime = System.currentTimeMillis();
		duration = ((double)(endTime - startTime)) / numIters;

		startTimeOverhead = System.currentTimeMillis();
		for (int i = 0; i < numIters; i++) {
			//generate a sorted list
			for (int j = 0; j < 100000; j++) {
				listSorted100000[j] = j;
			}
		}
		endTimeOverhead = System.currentTimeMillis();
		durationOverhead = ((double)(endTimeOverhead - startTimeOverhead)) / numIters;
		runningTime = duration - durationOverhead;
		System.out.println("Running Time for iterative Merge Sort (sorted list of size 100000): " + runningTime);
	
		//Reverse sorted list:
		// a). size of 100
		startTime = System.currentTimeMillis();

		numIters = 1000;
		for (int i = 0; i < numIters; i++) {
			//generate a reversed sorted list
			int curr = 100;
			for (int j = 0; j < 100; j++) {
				listReverse100[j] = curr;
				curr = curr - 1;
			}
			//sort it using iterativeMergeSort
			sortAlgorithms.iterativeMergeSort(listReverse100);
		}
		endTime = System.currentTimeMillis();
		duration = ((double)(endTime - startTime)) / numIters;

		startTimeOverhead = System.currentTimeMillis();
		for (int i = 0; i < numIters; i++) {
			//generate a sorted list
			int curr = 100;
			for (int j = 0; j < 100; j++) {
				listReverse100[j] = curr;
				curr = curr - 1;
			}
		}
		endTimeOverhead = System.currentTimeMillis();
		durationOverhead = ((double)(endTimeOverhead - startTimeOverhead)) / numIters;
		runningTime = duration - durationOverhead;
		System.out.println("Running Time for iterative Merge Sort (Reversed sorted list of size 100): " + runningTime);
	
		// b). size of 1000
		startTime = System.currentTimeMillis();

		numIters = 500;
		for (int i = 0; i < numIters; i++) {
			//generate a reversed sorted list
			int curr = 1000;
			for (int j = 0; j < 1000; j++) {
				listReverse1000[j] = curr;
				curr = curr - 1;
			}
			//sort it using iterativeMergeSort
			sortAlgorithms.iterativeMergeSort(listReverse1000);
		}
		endTime = System.currentTimeMillis();
		duration = ((double)(endTime - startTime)) / numIters;

		startTimeOverhead = System.currentTimeMillis();
		for (int i = 0; i < numIters; i++) {
			//generate a sorted list
			int curr = 1000;
			for (int j = 0; j < 1000; j++) {
				listReverse1000[j] = curr;
				curr = curr - 1;
			}
		}
		endTimeOverhead = System.currentTimeMillis();
		durationOverhead = ((double)(endTimeOverhead - startTimeOverhead)) / numIters;
		runningTime = duration - durationOverhead;
		System.out.println("Running Time for iterative Merge Sort (Reversed sorted list of size 1000): " + runningTime);

		// c). size of 10000
		startTime = System.currentTimeMillis();

		numIters = 300;
		for (int i = 0; i < numIters; i++) {
			//generate a reversed sorted list
			int curr = 10000;
			for (int j = 0; j < 10000; j++) {
				listReverse10000[j] = curr;
				curr = curr - 1;
			}
			//sort it using iterativeMergeSort
			sortAlgorithms.iterativeMergeSort(listReverse10000);
		}
		endTime = System.currentTimeMillis();
		duration = ((double)(endTime - startTime)) / numIters;

		startTimeOverhead = System.currentTimeMillis();
		for (int i = 0; i < numIters; i++) {
			//generate a sorted list
			int curr = 10000;
			for (int j = 0; j < 10000; j++) {
				listReverse10000[j] = curr;
				curr = curr - 1;
			}
		}
		endTimeOverhead = System.currentTimeMillis();
		durationOverhead = ((double)(endTimeOverhead - startTimeOverhead)) / numIters;
		runningTime = duration - durationOverhead;
		System.out.println("Running Time for iterative Merge Sort (Reversed sorted list of size 10000): " + runningTime);

		// d). size of 100000
		startTime = System.currentTimeMillis();

		numIters = 200;
		for (int i = 0; i < numIters; i++) {
			//generate a reversed sorted list
			int curr = 100000;
			for (int j = 0; j < 100000; j++) {
				listReverse100000[j] = curr;
				curr = curr - 1;
			}
			//sort it using iterativeMergeSort
			sortAlgorithms.iterativeMergeSort(listReverse100000);
		}
		endTime = System.currentTimeMillis();
		duration = ((double)(endTime - startTime)) / numIters;

		startTimeOverhead = System.currentTimeMillis();
		for (int i = 0; i < numIters; i++) {
			//generate a sorted list
			int curr = 100000;
			for (int j = 0; j < 100000; j++) {
				listReverse100000[j] = curr;
				curr = curr - 1;
			}
		}
		endTimeOverhead = System.currentTimeMillis();
		durationOverhead = ((double)(endTimeOverhead - startTimeOverhead)) / numIters;
		runningTime = duration - durationOverhead;
		System.out.println("Running Time for iterative Merge Sort (Reversed sorted list of size 100000): " + runningTime);

	// 6). Test Hybrid Sort
		//Random list:
		// a). size of 100
		startTime = System.currentTimeMillis();

		numIters = 1000;
		for (int i = 0; i < numIters; i++) {
			//generate a random list
			for (int j = 0; j < 100; j++) {
				listRandom100[j] = randomGenerator.nextInt();
			}
			//sort it using Hybrid Sort
			sortAlgorithms.hybridSort(listRandom100, 0, 99);
		}
		endTime = System.currentTimeMillis();
		duration = ((double)(endTime - startTime)) / numIters;

		startTimeOverhead = System.currentTimeMillis();
		for (int i = 0; i < numIters; i++) {
			//generate a random list
			for (int j = 0; j < 100; j++) {
				listRandom100[j] = randomGenerator.nextInt();
			}
		}
		endTimeOverhead = System.currentTimeMillis();
		durationOverhead = ((double)(endTimeOverhead - startTimeOverhead)) / numIters;

		runningTime = duration - durationOverhead;
		System.out.println("Running Time for Hybrid Sort (random list of size 100): " + runningTime);
	
		// b). size of 1000
		startTime = System.currentTimeMillis();

		numIters = 500;
		for (int i = 0; i < numIters; i++) {
			//generate a random list
			for (int j = 0; j < 1000; j++) {
				listRandom1000[j] = randomGenerator.nextInt();
			}
			//sort it using Hybrid Sort
			sortAlgorithms.hybridSort(listRandom1000, 0, 999);
		}
		endTime = System.currentTimeMillis();
		duration = ((double)(endTime - startTime)) / numIters;

		startTimeOverhead = System.currentTimeMillis();
		for (int i = 0; i < numIters; i++) {
			//generate a random list
			for (int j = 0; j < 1000; j++) {
				listRandom1000[j] = randomGenerator.nextInt();
			}
		}
		endTimeOverhead = System.currentTimeMillis();
		durationOverhead = ((double)(endTimeOverhead - startTimeOverhead)) / numIters;

		runningTime = duration - durationOverhead;
		System.out.println("Running Time for Hybrid Sort (random list of size 1000): " + runningTime);

		// c). size of 10000
		startTime = System.currentTimeMillis();

		numIters = 300;
		for (int i = 0; i < numIters; i++) {
			//generate a random list
			for (int j = 0; j < 10000; j++) {
				listRandom10000[j] = randomGenerator.nextInt();
			}
			//sort it using Hybrid Sort
			sortAlgorithms.hybridSort(listRandom10000, 0, 9999);
		}
		endTime = System.currentTimeMillis();
		duration = ((double)(endTime - startTime)) / numIters;

		startTimeOverhead = System.currentTimeMillis();
		for (int i = 0; i < numIters; i++) {
			//generate a random list
			for (int j = 0; j < 10000; j++) {
				listRandom10000[j] = randomGenerator.nextInt();
			}
		}
		endTimeOverhead = System.currentTimeMillis();
		durationOverhead = ((double)(endTimeOverhead - startTimeOverhead)) / numIters;

		runningTime = duration - durationOverhead;
		System.out.println("Running Time for Hybrid Sort (random list of size 10000): " + runningTime);

		// d). size of 100000
		startTime = System.currentTimeMillis();

		numIters = 200;
		for (int i = 0; i < numIters; i++) {
			//generate a random list
			for (int j = 0; j < 100000; j++) {
				listRandom100000[j] = randomGenerator.nextInt();
			}
			//sort it using Hybrid Sort
			sortAlgorithms.hybridSort(listRandom100000, 0, 99999);
		}
		endTime = System.currentTimeMillis();
		duration = ((double)(endTime - startTime)) / numIters;

		startTimeOverhead = System.currentTimeMillis();
		for (int i = 0; i < numIters; i++) {
			//generate a random list
			for (int j = 0; j < 100000; j++) {
				listRandom100000[j] = randomGenerator.nextInt();
			}
		}
		endTimeOverhead = System.currentTimeMillis();
		durationOverhead = ((double)(endTimeOverhead - startTimeOverhead)) / numIters;

		runningTime = duration - durationOverhead;
		System.out.println("Running Time for Hybrid Sort (random list of size 100000): " + runningTime);
	
		//Sorted list:
		// a). size of 100
		startTime = System.currentTimeMillis();

		numIters = 1000;
		for (int i = 0; i < numIters; i++) {
			//generate a sorted list
			for (int j = 0; j < 100; j++) {
				listSorted100[j] = j;
			}
			//sort it using Hybrid Sort
			sortAlgorithms.hybridSort(listSorted100, 0, 99);
		}
		endTime = System.currentTimeMillis();
		duration = ((double)(endTime - startTime)) / numIters;

		startTimeOverhead = System.currentTimeMillis();
		for (int i = 0; i < numIters; i++) {
			//generate a sorted list
			for (int j = 0; j < 100; j++) {
				listSorted100[j] = j;
			}
		}
		endTimeOverhead = System.currentTimeMillis();
		durationOverhead = ((double)(endTimeOverhead - startTimeOverhead)) / numIters;
		runningTime = duration - durationOverhead;
		System.out.println("Running Time for Hybrid Sort (sorted list of size 100): " + runningTime);
	
		// b). size of 1000
		startTime = System.currentTimeMillis();

		numIters = 500;
		for (int i = 0; i < numIters; i++) {
			//generate a sorted list
			for (int j = 0; j < 1000; j++) {
				listSorted1000[j] = j;
			}
			//sort it using Hybrid Sort
			sortAlgorithms.hybridSort(listSorted1000, 0, 999);
		}
		endTime = System.currentTimeMillis();
		duration = ((double)(endTime - startTime)) / numIters;

		startTimeOverhead = System.currentTimeMillis();
		for (int i = 0; i < numIters; i++) {
			//generate a sorted list
			for (int j = 0; j < 1000; j++) {
				listSorted1000[j] = j;
			}
		}
		endTimeOverhead = System.currentTimeMillis();
		durationOverhead = ((double)(endTimeOverhead - startTimeOverhead)) / numIters;
		runningTime = duration - durationOverhead;
		System.out.println("Running Time for Hybrid Sort (sorted list of size 1000): " + runningTime);

		// c). size of 10000
		startTime = System.currentTimeMillis();

		numIters = 300;
		for (int i = 0; i < numIters; i++) {
			//generate a sorted list
			for (int j = 0; j < 10000; j++) {
				listSorted10000[j] = j;
			}
			//sort it using Hybrid Sort
			sortAlgorithms.hybridSort(listSorted10000, 0, 9999);
		}
		endTime = System.currentTimeMillis();
		duration = ((double)(endTime - startTime)) / numIters;

		startTimeOverhead = System.currentTimeMillis();
		for (int i = 0; i < numIters; i++) {
			//generate a sorted list
			for (int j = 0; j < 10000; j++) {
				listSorted10000[j] = j;
			}
		}
		endTimeOverhead = System.currentTimeMillis();
		durationOverhead = ((double)(endTimeOverhead - startTimeOverhead)) / numIters;
		runningTime = duration - durationOverhead;
		System.out.println("Running Time for Hybrid Sort (sorted list of size 10000): " + runningTime);

		// d). size of 100000
		startTime = System.currentTimeMillis();

		numIters = 200;
		for (int i = 0; i < numIters; i++) {
			//generate a sorted list
			for (int j = 0; j < 100000; j++) {
				listSorted100000[j] = j;
			}
			//sort it using Hybrid Sort
			sortAlgorithms.hybridSort(listSorted100000, 0, 99999);
		}
		endTime = System.currentTimeMillis();
		duration = ((double)(endTime - startTime)) / numIters;

		startTimeOverhead = System.currentTimeMillis();
		for (int i = 0; i < numIters; i++) {
			//generate a sorted list
			for (int j = 0; j < 100000; j++) {
				listSorted100000[j] = j;
			}
		}
		endTimeOverhead = System.currentTimeMillis();
		durationOverhead = ((double)(endTimeOverhead - startTimeOverhead)) / numIters;
		runningTime = duration - durationOverhead;
		System.out.println("Running Time for Hybrid Sort (sorted list of size 100000): " + runningTime);
	
		//Reverse sorted list:
		// a). size of 100
		startTime = System.currentTimeMillis();

		numIters = 1000;
		for (int i = 0; i < numIters; i++) {
			//generate a reversed sorted list
			int curr = 100;
			for (int j = 0; j < 100; j++) {
				listReverse100[j] = curr;
				curr = curr - 1;
			}
			//sort it using Hybrid Sort
			sortAlgorithms.hybridSort(listReverse100, 0, 99);
		}
		endTime = System.currentTimeMillis();
		duration = ((double)(endTime - startTime)) / numIters;

		startTimeOverhead = System.currentTimeMillis();
		for (int i = 0; i < numIters; i++) {
			//generate a sorted list
			int curr = 100;
			for (int j = 0; j < 100; j++) {
				listReverse100[j] = curr;
				curr = curr - 1;
			}
		}
		endTimeOverhead = System.currentTimeMillis();
		durationOverhead = ((double)(endTimeOverhead - startTimeOverhead)) / numIters;
		runningTime = duration - durationOverhead;
		System.out.println("Running Time for Hybrid Sort (Reversed sorted list of size 100): " + runningTime);
	
		// b). size of 1000
		startTime = System.currentTimeMillis();

		numIters = 500;
		for (int i = 0; i < numIters; i++) {
			//generate a reversed sorted list
			int curr = 1000;
			for (int j = 0; j < 1000; j++) {
				listReverse1000[j] = curr;
				curr = curr - 1;
			}
			//sort it using Hybrid Sort
			sortAlgorithms.hybridSort(listReverse1000, 0, 999);
		}
		endTime = System.currentTimeMillis();
		duration = ((double)(endTime - startTime)) / numIters;

		startTimeOverhead = System.currentTimeMillis();
		for (int i = 0; i < numIters; i++) {
			//generate a sorted list
			int curr = 1000;
			for (int j = 0; j < 1000; j++) {
				listReverse1000[j] = curr;
				curr = curr - 1;
			}
		}
		endTimeOverhead = System.currentTimeMillis();
		durationOverhead = ((double)(endTimeOverhead - startTimeOverhead)) / numIters;
		runningTime = duration - durationOverhead;
		System.out.println("Running Time for Hybrid Sort (Reversed sorted list of size 1000): " + runningTime);

		// c). size of 10000
		startTime = System.currentTimeMillis();

		numIters = 300;
		for (int i = 0; i < numIters; i++) {
			//generate a reversed sorted list
			int curr = 10000;
			for (int j = 0; j < 10000; j++) {
				listReverse10000[j] = curr;
				curr = curr - 1;
			}
			//sort it using Hybrid Sort
			sortAlgorithms.hybridSort(listReverse10000, 0, 9999);
		}
		endTime = System.currentTimeMillis();
		duration = ((double)(endTime - startTime)) / numIters;

		startTimeOverhead = System.currentTimeMillis();
		for (int i = 0; i < numIters; i++) {
			//generate a sorted list
			int curr = 10000;
			for (int j = 0; j < 10000; j++) {
				listReverse10000[j] = curr;
				curr = curr - 1;
			}
		}
		endTimeOverhead = System.currentTimeMillis();
		durationOverhead = ((double)(endTimeOverhead - startTimeOverhead)) / numIters;
		runningTime = duration - durationOverhead;
		System.out.println("Running Time for Hybrid Sort (Reversed sorted list of size 10000): " + runningTime);

		// d). size of 100000
		startTime = System.currentTimeMillis();

		numIters = 200;
		for (int i = 0; i < numIters; i++) {
			//generate a reversed sorted list
			int curr = 100000;
			for (int j = 0; j < 100000; j++) {
				listReverse100000[j] = curr;
				curr = curr - 1;
			}
			//sort it using Hybrid Sort
			sortAlgorithms.hybridSort(listReverse100000, 0, 99999);
		}
		endTime = System.currentTimeMillis();
		duration = ((double)(endTime - startTime)) / numIters;

		startTimeOverhead = System.currentTimeMillis();
		for (int i = 0; i < numIters; i++) {
			//generate a sorted list
			int curr = 100000;
			for (int j = 0; j < 100000; j++) {
				listReverse100000[j] = curr;
				curr = curr - 1;
			}
		}
		endTimeOverhead = System.currentTimeMillis();
		durationOverhead = ((double)(endTimeOverhead - startTimeOverhead)) / numIters;
		runningTime = duration - durationOverhead;
		System.out.println("Running Time for Hybrid Sort (Reversed sorted list of size 100000): " + runningTime);
	
	// 7). Test Bucket Sort
		// Random List:
		// a). size of 100
		Record[] recordRandom100 = new Record[100];

		startTime = System.currentTimeMillis();

		numIters = 1000;
		for (int i = 0; i < numIters; i++) {
			//generate a random list
			for (int j = 0; j < 100; j++) {
				int number = randomGenerator.nextInt((100 - 0) + 1);
				Record rec = new Record(number, "A");
				recordRandom100[j] = rec;
			}
			//sort it using Bucket Sort
			sortAlgorithms.bucketSort(recordRandom100, 0, 99);
		}
		endTime = System.currentTimeMillis();
		duration = ((double)(endTime - startTime)) / numIters;

		startTimeOverhead = System.currentTimeMillis();
		for (int i = 0; i < numIters; i++) {
			//generate a random list
			for (int j = 0; j < 100; j++) {
				int number = randomGenerator.nextInt();
				Record rec = new Record(number, "A");
				recordRandom100[j] = rec;
			}
		}
		endTimeOverhead = System.currentTimeMillis();
		durationOverhead = ((double)(endTimeOverhead - startTimeOverhead)) / numIters;

		runningTime = duration - durationOverhead;
		System.out.println("Running Time for Bucket Sort (random list of size 100): " + runningTime);

		// b). size of 1000
		Record[] recordRandom1000 = new Record[1000];

		startTime = System.currentTimeMillis();

		numIters = 500;
		for (int i = 0; i < numIters; i++) {
			//generate a random list
			for (int j = 0; j < 1000; j++) {
				int number = randomGenerator.nextInt((100 - 0) + 1);
				Record rec = new Record(number, "A");
				recordRandom1000[j] = rec;
			}
			//sort it using Bucket Sort
			sortAlgorithms.bucketSort(recordRandom1000, 0, 999);
		}
		endTime = System.currentTimeMillis();
		duration = ((double)(endTime - startTime)) / numIters;

		startTimeOverhead = System.currentTimeMillis();
		for (int i = 0; i < numIters; i++) {
			//generate a random list
			for (int j = 0; j < 1000; j++) {
				int number = randomGenerator.nextInt();
				Record rec = new Record(number, "A");
				recordRandom1000[j] = rec;
			}
		}
		endTimeOverhead = System.currentTimeMillis();
		durationOverhead = ((double)(endTimeOverhead - startTimeOverhead)) / numIters;

		runningTime = duration - durationOverhead;
		System.out.println("Running Time for Bucket Sort (random list of size 1000): " + runningTime);

		// c). size of 10000
		Record[] recordRandom10000 = new Record[10000];

		startTime = System.currentTimeMillis();

		numIters = 200;
		for (int i = 0; i < numIters; i++) {
			//generate a random list
			for (int j = 0; j < 10000; j++) {
				int number = randomGenerator.nextInt((100 - 0) + 1);
				Record rec = new Record(number, "A");
				recordRandom10000[j] = rec;
			}
			//sort it using Bucket Sort
			sortAlgorithms.bucketSort(recordRandom10000, 0, 9999);
		}
		endTime = System.currentTimeMillis();
		duration = ((double)(endTime - startTime)) / numIters;

		startTimeOverhead = System.currentTimeMillis();
		for (int i = 0; i < numIters; i++) {
			//generate a random list
			for (int j = 0; j < 10000; j++) {
				int number = randomGenerator.nextInt();
				Record rec = new Record(number, "A");
				recordRandom10000[j] = rec;
			}
		}
		endTimeOverhead = System.currentTimeMillis();
		durationOverhead = ((double)(endTimeOverhead - startTimeOverhead)) / numIters;

		runningTime = duration - durationOverhead;
		System.out.println("Running Time for Bucket Sort (random list of size 10000): " + runningTime);

		// d). size of 100000
		Record[] recordRandom100000 = new Record[100000];

		startTime = System.currentTimeMillis();

		numIters = 10;
		for (int i = 0; i < numIters; i++) {
			//generate a random list
			for (int j = 0; j < 100000; j++) {
				int number = randomGenerator.nextInt((100 - 0) + 1);
				Record rec = new Record(number, "A");
				recordRandom100000[j] = rec;
			}
			//sort it using Bucket Sort
			sortAlgorithms.bucketSort(recordRandom100000, 0, 99999);
		}
		endTime = System.currentTimeMillis();
		duration = ((double)(endTime - startTime)) / numIters;

		startTimeOverhead = System.currentTimeMillis();
		for (int i = 0; i < numIters; i++) {
			//generate a random list
			for (int j = 0; j < 100000; j++) {
				int number = randomGenerator.nextInt();
				Record rec = new Record(number, "A");
				recordRandom100000[j] = rec;
			}
		}
		endTimeOverhead = System.currentTimeMillis();
		durationOverhead = ((double)(endTimeOverhead - startTimeOverhead)) / numIters;

		runningTime = duration - durationOverhead;
		System.out.println("Running Time for Bucket Sort (random list of size 100000): " + runningTime);

		// Sorted List:
		// a). size of 100
		Record[] recordSorted100 = new Record[100];

		startTime = System.currentTimeMillis();

		numIters = 1000;
		for (int i = 0; i < numIters; i++) {
			//generate a sorted list
			for (int j = 0; j < 100; j++) {
				int number = j;
				Record rec = new Record(number, "A");
				recordSorted100[j] = rec;
			}
			//sort it using Bucket Sort
			sortAlgorithms.bucketSort(recordSorted100, 0, 99);
		}
		endTime = System.currentTimeMillis();
		duration = ((double)(endTime - startTime)) / numIters;

		startTimeOverhead = System.currentTimeMillis();
		for (int i = 0; i < numIters; i++) {
			//generate a sorted list
			for (int j = 0; j < 100; j++) {
				int number = j;
				Record rec = new Record(number, "A");
				recordSorted100[j] = rec;
			}
		}
		endTimeOverhead = System.currentTimeMillis();
		durationOverhead = ((double)(endTimeOverhead - startTimeOverhead)) / numIters;

		runningTime = duration - durationOverhead;
		System.out.println("Running Time for Bucket Sort (sort list of size 100): " + runningTime);

		// b). size of 1000
		Record[] recordSorted1000 = new Record[1000];

		startTime = System.currentTimeMillis();

		numIters = 500;
		for (int i = 0; i < numIters; i++) {
			//generate a sorted list
			for (int j = 0; j < 1000; j++) {
				int number = j;
				Record rec = new Record(number, "A");
				recordSorted1000[j] = rec;
			}
			//sort it using Bucket Sort
			sortAlgorithms.bucketSort(recordSorted1000, 0, 999);
		}
		endTime = System.currentTimeMillis();
		duration = ((double)(endTime - startTime)) / numIters;

		startTimeOverhead = System.currentTimeMillis();
		for (int i = 0; i < numIters; i++) {
			//generate a sorted list
			for (int j = 0; j < 1000; j++) {
				int number = j;
				Record rec = new Record(number, "A");
				recordSorted1000[j] = rec;
			}
		}
		endTimeOverhead = System.currentTimeMillis();
		durationOverhead = ((double)(endTimeOverhead - startTimeOverhead)) / numIters;

		runningTime = duration - durationOverhead;
		System.out.println("Running Time for Bucket Sort (sorted list of size 1000): " + runningTime);

		// c). size of 10000
		Record[] recordSorted10000 = new Record[10000];

		startTime = System.currentTimeMillis();

		numIters = 200;
		for (int i = 0; i < numIters; i++) {
			//generate a sorted list
			for (int j = 0; j < 10000; j++) {
				int number = j;
				Record rec = new Record(number, "A");
				recordSorted10000[j] = rec;
			}
			//sort it using Bucket Sort
			sortAlgorithms.bucketSort(recordSorted10000, 0, 9999);
		}
		endTime = System.currentTimeMillis();
		duration = ((double)(endTime - startTime)) / numIters;

		startTimeOverhead = System.currentTimeMillis();
		for (int i = 0; i < numIters; i++) {
			//generate a sorted list
			for (int j = 0; j < 10000; j++) {
				int number = j;
				Record rec = new Record(number, "A");
				recordSorted10000[j] = rec;
			}
		}
		endTimeOverhead = System.currentTimeMillis();
		durationOverhead = ((double)(endTimeOverhead - startTimeOverhead)) / numIters;

		runningTime = duration - durationOverhead;
		System.out.println("Running Time for Bucket Sort (sorted list of size 10000): " + runningTime);

		// d). size of 100000
		Record[] recordSorted100000 = new Record[100000];

		startTime = System.currentTimeMillis();

		numIters = 10;
		for (int i = 0; i < numIters; i++) {
			//generate a sorted list
			for (int j = 0; j < 100000; j++) {
				int number = randomGenerator.nextInt((100 - 0) + 1);
				Record rec = new Record(number, "A");
				recordSorted100000[j] = rec;
			}
			//sort it using Bucket Sort
			sortAlgorithms.bucketSort(recordSorted100000, 0, 99999);
		}
		endTime = System.currentTimeMillis();
		duration = ((double)(endTime - startTime)) / numIters;

		startTimeOverhead = System.currentTimeMillis();
		for (int i = 0; i < numIters; i++) {
			//generate a sorted list
			for (int j = 0; j < 100000; j++) {
				int number = j;
				Record rec = new Record(number, "A");
				recordSorted100000[j] = rec;
			}
		}
		endTimeOverhead = System.currentTimeMillis();
		durationOverhead = ((double)(endTimeOverhead - startTimeOverhead)) / numIters;

		runningTime = duration - durationOverhead;
		System.out.println("Running Time for Bucket Sort (sorted list of size 100000): " + runningTime);

		// Reverse List:
		// a). size of 100
		Record[] recordReverse100 = new Record[100];

		startTime = System.currentTimeMillis();

		numIters = 1000;
		for (int i = 0; i < numIters; i++) {
			//generate a reverse list
			int curr = 100;
			for (int j = 0; j < 100; j++) {
				int number = curr;
				Record rec = new Record(number, "A");
				recordReverse100[j] = rec;
				curr = curr - 1;
			}
			//sort it using Bucket Sort
			sortAlgorithms.bucketSort(recordReverse100, 0, 99);
		}
		endTime = System.currentTimeMillis();
		duration = ((double)(endTime - startTime)) / numIters;

		startTimeOverhead = System.currentTimeMillis();
		for (int i = 0; i < numIters; i++) {
			//generate a reverse list
			int curr = 100;
			for (int j = 0; j < 100; j++) {
				int number = curr;
				Record rec = new Record(number, "A");
				recordReverse100[j] = rec;
				curr = curr - 1;
			}
		}
		endTimeOverhead = System.currentTimeMillis();
		durationOverhead = ((double)(endTimeOverhead - startTimeOverhead)) / numIters;

		runningTime = duration - durationOverhead;
		System.out.println("Running Time for Bucket Sort (reverse list of size 100): " + runningTime);

		// b). size of 1000
		Record[] recordReverse1000 = new Record[1000];

		startTime = System.currentTimeMillis();

		numIters = 500;
		for (int i = 0; i < numIters; i++) {
			//generate a reverse list
			int curr = 1000;
			for (int j = 0; j < 1000; j++) {
				int number = curr;
				Record rec = new Record(number, "A");
				recordReverse1000[j] = rec;
				curr = curr - 1;
			}
			//sort it using Bucket Sort
			sortAlgorithms.bucketSort(recordReverse1000, 0, 999);
		}
		endTime = System.currentTimeMillis();
		duration = ((double)(endTime - startTime)) / numIters;

		startTimeOverhead = System.currentTimeMillis();
		for (int i = 0; i < numIters; i++) {
			//generate a reverse list
			int curr = 1000;
			for (int j = 0; j < 1000; j++) {
				int number = curr;
				Record rec = new Record(number, "A");
				recordReverse1000[j] = rec;
				curr = curr - 1;
			}
		}
		endTimeOverhead = System.currentTimeMillis();
		durationOverhead = ((double)(endTimeOverhead - startTimeOverhead)) / numIters;

		runningTime = duration - durationOverhead;
		System.out.println("Running Time for Bucket Sort (reverse list of size 1000): " + runningTime);

		// c). size of 10000
		Record[] recordReverse10000 = new Record[10000];

		startTime = System.currentTimeMillis();

		numIters = 200;
		for (int i = 0; i < numIters; i++) {
			//generate a reverse list
			int curr = 10000;
			for (int j = 0; j < 10000; j++) {
				int number = curr;
				Record rec = new Record(number, "A");
				recordReverse10000[j] = rec;
				curr = curr - 1;
			}
			//sort it using Bucket Sort
			sortAlgorithms.bucketSort(recordReverse10000, 0, 9999);
		}
		endTime = System.currentTimeMillis();
		duration = ((double)(endTime - startTime)) / numIters;

		startTimeOverhead = System.currentTimeMillis();
		for (int i = 0; i < numIters; i++) {
			//generate a reverse list
			int curr = 10000;
			for (int j = 0; j < 10000; j++) {
				int number = curr;
				Record rec = new Record(number, "A");
				recordReverse10000[j] = rec;
				curr = curr - 1;
			}
		}
		endTimeOverhead = System.currentTimeMillis();
		durationOverhead = ((double)(endTimeOverhead - startTimeOverhead)) / numIters;

		runningTime = duration - durationOverhead;
		System.out.println("Running Time for Bucket Sort (reverse list of size 10000): " + runningTime);

		// d). size of 100000
		Record[] recordReverse100000 = new Record[100000];

		startTime = System.currentTimeMillis();

		numIters = 10;
		for (int i = 0; i < numIters; i++) {
			//generate a reverse list
			int curr = 100000;
			for (int j = 0; j < 100000; j++) {
				int number = curr;
				Record rec = new Record(number, "A");
				recordReverse100000[j] = rec;
				curr = curr - 1;
			}
			//sort it using Bucket Sort
			sortAlgorithms.bucketSort(recordReverse100000, 0, 99999);
		}
		endTime = System.currentTimeMillis();
		duration = ((double)(endTime - startTime)) / numIters;

		startTimeOverhead = System.currentTimeMillis();
		for (int i = 0; i < numIters; i++) {
			//generate a sorted list
			int curr = 100000;
			for (int j = 0; j < 100000; j++) {
				int number = curr;
				Record rec = new Record(number, "A");
				recordReverse100000[j] = rec;
				curr = curr - 1;
			}
		}
		endTimeOverhead = System.currentTimeMillis();
		durationOverhead = ((double)(endTimeOverhead - startTimeOverhead)) / numIters;

		runningTime = duration - durationOverhead;
		System.out.println("Running Time for Bucket Sort (reverse list of size 100000): " + runningTime);

	// 8). Test Radix Sort
		// Random List:
		// a). size of 100
		int[] intRandom100 = new int[100];

		startTime = System.currentTimeMillis();

		numIters = 1000;
		for (int i = 0; i < numIters; i++) {
			//generate a random list
			for (int j = 0; j < 100; j++) {
				intRandom100[j] = randomGenerator.nextInt((9999 - 1000) + 1000);
			}
			//sort it using Radix Sort
			sortAlgorithms.radixSort(intRandom100, 0, 99);
		}
		endTime = System.currentTimeMillis();
		duration = ((double)(endTime - startTime)) / numIters;

		startTimeOverhead = System.currentTimeMillis();
		for (int i = 0; i < numIters; i++) {
			//generate a random list
			for (int j = 0; j < 100; j++) {
				intRandom100[j] = randomGenerator.nextInt((9999 - 1000) + 1000);
			}
		}
		endTimeOverhead = System.currentTimeMillis();
		durationOverhead = ((double)(endTimeOverhead - startTimeOverhead)) / numIters;

		runningTime = duration - durationOverhead;
		System.out.println("Running Time for Radix Sort (random list of size 100): " + runningTime);

		// b). size of 1000
		int[] intRandom1000 = new int[1000];

		startTime = System.currentTimeMillis();

		numIters = 500;
		for (int i = 0; i < numIters; i++) {
			//generate a random list
			for (int j = 0; j < 1000; j++) {
				intRandom1000[j] = randomGenerator.nextInt((9999 - 1000) + 1000);
			}
			//sort it using Radix Sort
			sortAlgorithms.radixSort(intRandom1000, 0, 999);
		}
		endTime = System.currentTimeMillis();
		duration = ((double)(endTime - startTime)) / numIters;

		startTimeOverhead = System.currentTimeMillis();
		for (int i = 0; i < numIters; i++) {
			//generate a random list
			for (int j = 0; j < 1000; j++) {
				intRandom1000[j] = randomGenerator.nextInt((9999 - 1000) + 1000);
			}
		}
		endTimeOverhead = System.currentTimeMillis();
		durationOverhead = ((double)(endTimeOverhead - startTimeOverhead)) / numIters;

		runningTime = duration - durationOverhead;
		System.out.println("Running Time for Radix Sort (random list of size 1000): " + runningTime);

		// c). size of 10000
		int[] intRandom10000 = new int[10000];

		startTime = System.currentTimeMillis();

		numIters = 200;
		for (int i = 0; i < numIters; i++) {
			//generate a random list
			for (int j = 0; j < 10000; j++) {
				intRandom10000[j] = randomGenerator.nextInt((9999 - 1000) + 1000);
			}
			//sort it using Radix Sort
			sortAlgorithms.radixSort(intRandom10000, 0, 9999);
		}
		endTime = System.currentTimeMillis();
		duration = ((double)(endTime - startTime)) / numIters;

		startTimeOverhead = System.currentTimeMillis();
		for (int i = 0; i < numIters; i++) {
			//generate a random list
			for (int j = 0; j < 10000; j++) {
				intRandom10000[j] = randomGenerator.nextInt((9999 - 1000) + 1000);
			}
		}
		endTimeOverhead = System.currentTimeMillis();
		durationOverhead = ((double)(endTimeOverhead - startTimeOverhead)) / numIters;

		runningTime = duration - durationOverhead;
		System.out.println("Running Time for Radix Sort (random list of size 10000): " + runningTime);

		// d). size of 100000
		int[] intRandom100000 = new int[100000];

		startTime = System.currentTimeMillis();

		numIters = 100;
		for (int i = 0; i < numIters; i++) {
			//generate a random list
			for (int j = 0; j < 100000; j++) {
				intRandom100000[j] = randomGenerator.nextInt((9999 - 1000) + 1000);
			}
			//sort it using Radix Sort
			sortAlgorithms.radixSort(intRandom100000, 0, 99999);
		}
		endTime = System.currentTimeMillis();
		duration = ((double)(endTime - startTime)) / numIters;

		startTimeOverhead = System.currentTimeMillis();
		for (int i = 0; i < numIters; i++) {
			//generate a random list
			for (int j = 0; j < 100000; j++) {
				intRandom100000[j] = randomGenerator.nextInt((9999 - 1000) + 1000);
			}
		}
		endTimeOverhead = System.currentTimeMillis();
		durationOverhead = ((double)(endTimeOverhead - startTimeOverhead)) / numIters;

		runningTime = duration - durationOverhead;
		System.out.println("Running Time for Radix Sort (random list of size 100000): " + runningTime);

		// Sorted List:
		// a). size of 100
		int[] intSorted100 = new int[100];

		startTime = System.currentTimeMillis();

		numIters = 1000;
		for (int i = 0; i < numIters; i++) {
			//generate a sorted list
			for (int j = 0; j < 100; j++) {
				intSorted100[j] = randomGenerator.nextInt((9999 - 1000) + 1000);
			}
			Arrays.sort(intSorted100);
			//sort it using Radix Sort
			sortAlgorithms.radixSort(intSorted100, 0, 99);
		}
		endTime = System.currentTimeMillis();
		duration = ((double)(endTime - startTime)) / numIters;

		startTimeOverhead = System.currentTimeMillis();
		for (int i = 0; i < numIters; i++) {
			//generate a sorted list
			for (int j = 0; j < 100; j++) {
				intSorted100[j] = randomGenerator.nextInt((9999 - 1000) + 1000);
			}
			Arrays.sort(intSorted100);
		}
		endTimeOverhead = System.currentTimeMillis();
		durationOverhead = ((double)(endTimeOverhead - startTimeOverhead)) / numIters;

		runningTime = duration - durationOverhead;
		System.out.println("Running Time for Radix Sort (sort list of size 100): " + runningTime);

		// b). size of 1000
		int[] intSorted1000 = new int[1000];

		startTime = System.currentTimeMillis();

		numIters = 500;
		for (int i = 0; i < numIters; i++) {
			//generate a sorted list
			for (int j = 0; j < 1000; j++) {
				intSorted1000[j] = randomGenerator.nextInt((9999 - 1000) + 1000);
			}
			Arrays.sort(intSorted1000);
			//sort it using Radix Sort
			sortAlgorithms.radixSort(intSorted1000, 0, 999);
		}
		endTime = System.currentTimeMillis();
		duration = ((double)(endTime - startTime)) / numIters;

		startTimeOverhead = System.currentTimeMillis();
		for (int i = 0; i < numIters; i++) {
			//generate a sorted list
			for (int j = 0; j < 1000; j++) {
				intSorted1000[j] = randomGenerator.nextInt((9999 - 1000) + 1000);
			}
			Arrays.sort(intSorted1000);
		}
		endTimeOverhead = System.currentTimeMillis();
		durationOverhead = ((double)(endTimeOverhead - startTimeOverhead)) / numIters;

		runningTime = duration - durationOverhead;
		System.out.println("Running Time for Radix Sort (sorted list of size 1000): " + runningTime);

		// c). size of 10000
		int[] intSorted10000 = new int[10000];

		startTime = System.currentTimeMillis();

		numIters = 200;
		for (int i = 0; i < numIters; i++) {
			//generate a sorted list
			for (int j = 0; j < 10000; j++) {
				intSorted10000[j] = randomGenerator.nextInt((9999 - 1000) + 1000);
			}
			Arrays.sort(intSorted10000);
			//sort it using Radix Sort
			sortAlgorithms.radixSort(intSorted10000, 0, 9999);
		}
		endTime = System.currentTimeMillis();
		duration = ((double)(endTime - startTime)) / numIters;

		startTimeOverhead = System.currentTimeMillis();
		for (int i = 0; i < numIters; i++) {
			//generate a sorted list
			for (int j = 0; j < 10000; j++) {
				intSorted10000[j] = randomGenerator.nextInt((9999 - 1000) + 1000);
			}
			Arrays.sort(intSorted10000);
		}
		endTimeOverhead = System.currentTimeMillis();
		durationOverhead = ((double)(endTimeOverhead - startTimeOverhead)) / numIters;

		runningTime = duration - durationOverhead;
		System.out.println("Running Time for Radix Sort (sorted list of size 10000): " + runningTime);

		// d). size of 100000
		int[] intSorted100000 = new int[100000];

		startTime = System.currentTimeMillis();

		numIters = 100;
		for (int i = 0; i < numIters; i++) {
			//generate a sorted list
			for (int j = 0; j < 100000; j++) {
				intSorted100000[j] = randomGenerator.nextInt((9999 - 1000) + 1000);
			}
			Arrays.sort(intSorted100000);
			//sort it using Radix Sort
			sortAlgorithms.radixSort(intSorted100000, 0, 99999);
		}
		endTime = System.currentTimeMillis();
		duration = ((double)(endTime - startTime)) / numIters;

		startTimeOverhead = System.currentTimeMillis();
		for (int i = 0; i < numIters; i++) {
			//generate a sorted list
			for (int j = 0; j < 100000; j++) {
				intSorted100000[j] = randomGenerator.nextInt((9999 - 1000) + 1000);
			}
			Arrays.sort(intSorted100000);
		}
		endTimeOverhead = System.currentTimeMillis();
		durationOverhead = ((double)(endTimeOverhead - startTimeOverhead)) / numIters;

		runningTime = duration - durationOverhead;
		System.out.println("Running Time for Radix Sort (sorted list of size 100000): " + runningTime);

		// Reverse List:
		// a). size of 100
		int[] intReverse100 = new int[100];

		startTime = System.currentTimeMillis();

		numIters = 1000;
		for (int i = 0; i < numIters; i++) {
			//generate a reverse list
			for (int j = 0; j < 100; j++) {
				intReverse100[j] = 100 - j;
			}
			//sort it using Radix Sort
			sortAlgorithms.radixSort(intReverse100, 0, 99);
		}
		endTime = System.currentTimeMillis();
		duration = ((double)(endTime - startTime)) / numIters;

		startTimeOverhead = System.currentTimeMillis();
		for (int i = 0; i < numIters; i++) {
			//generate a reverse list
			for (int j = 0; j < 100; j++) {
				intReverse100[j] = 100 - j;
			}
		}
		endTimeOverhead = System.currentTimeMillis();
		durationOverhead = ((double)(endTimeOverhead - startTimeOverhead)) / numIters;

		runningTime = duration - durationOverhead;
		System.out.println("Running Time for Radix Sort (reverse list of size 100): " + runningTime);

		// b). size of 1000
		int[] intReverse1000 = new int[1000];

		startTime = System.currentTimeMillis();

		numIters = 500;
		for (int i = 0; i < numIters; i++) {
			//generate a reverse list
			for (int j = 0; j < 1000; j++) {
				intReverse1000[j] = 1000 - j;
			}
			//sort it using Radix Sort
			sortAlgorithms.radixSort(intReverse1000, 0, 999);
		}
		endTime = System.currentTimeMillis();
		duration = ((double)(endTime - startTime)) / numIters;

		startTimeOverhead = System.currentTimeMillis();
		for (int i = 0; i < numIters; i++) {
			//generate a reverse list
			for (int j = 0; j < 1000; j++) {
				intReverse1000[j] = 1000 - j;
			}
		}
		endTimeOverhead = System.currentTimeMillis();
		durationOverhead = ((double)(endTimeOverhead - startTimeOverhead)) / numIters;

		runningTime = duration - durationOverhead;
		System.out.println("Running Time for Radix Sort (reverse list of size 1000): " + runningTime);

		// c). size of 10000
		int[] intReverse10000 = new int[10000];

		startTime = System.currentTimeMillis();

		numIters = 200;
		for (int i = 0; i < numIters; i++) {
			//generate a reverse list
			for (int j = 0; j < 10000; j++) {
				intReverse10000[j] = 10000 - j;
			}
			//sort it using Radix Sort
			sortAlgorithms.radixSort(intReverse10000, 0, 9999);
		}
		endTime = System.currentTimeMillis();
		duration = ((double)(endTime - startTime)) / numIters;

		startTimeOverhead = System.currentTimeMillis();
		for (int i = 0; i < numIters; i++) {
			//generate a reverse list
			for (int j = 0; j < 10000; j++) {
				intReverse10000[j] = 10000 - j;
			}
		}
		endTimeOverhead = System.currentTimeMillis();
		durationOverhead = ((double)(endTimeOverhead - startTimeOverhead)) / numIters;

		runningTime = duration - durationOverhead;
		System.out.println("Running Time for Radix Sort (reverse list of size 10000): " + runningTime);

		// d). size of 100000
		int[] intReverse100000 = new int[100000];

		startTime = System.currentTimeMillis();

		numIters = 100;
		for (int i = 0; i < numIters; i++) {
			//generate a reverse list
			for (int j = 0; j < 100000; j++) {
				intReverse100000[j] = 100000 - j;
			}
			//sort it using Radix Sort
			sortAlgorithms.radixSort(intReverse100000, 0, 99999);
		}
		endTime = System.currentTimeMillis();
		duration = ((double)(endTime - startTime)) / numIters;

		startTimeOverhead = System.currentTimeMillis();
		for (int i = 0; i < numIters; i++) {
			//generate a reverse list
			for (int j = 0; j < 100000; j++) {
				intReverse100000[j] = 100000 - j;
			}
		}
		endTimeOverhead = System.currentTimeMillis();
		durationOverhead = ((double)(endTimeOverhead - startTimeOverhead)) / numIters;

		runningTime = duration - durationOverhead;
		System.out.println("Running Time for Radix Sort (reverse list of size 100000): " + runningTime);

	}
}