import java.util.Random;

import java.io.File;
import java.io.FileNotFoundException;

import java.util.Scanner;
import java.lang.*;

import java.io.PrintWriter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SortingAlgorithms implements SortInterface {

	// 1).Shaker Sort:
	public void shakerSort(Comparable[] array, int lowindex, int highindex) {

		while (lowindex < highindex) {
			//bubble the largest element to the end of the list
			for (int pos = highindex; pos > lowindex; pos--) {
				for (int i = lowindex; i < pos; i++) {
					if (array[i].compareTo(array[i + 1]) > 0 ) {
						Comparable tmp = array[i];
						array[i] = array[i + 1];
						array[i + 1] = tmp;
					}
				}
			}
			//bubble the smallest element to the front of the list
			for (int pos2 = lowindex; pos2 < highindex; pos2++) {
				for (int j = highindex; j > pos2; j--) {
					if (array[j].compareTo(array[j - 1]) < 0 ) {
						Comparable tmp = array[j];
						array[j] = array[j - 1];
						array[j - 1] = tmp;
					}
				}
			}
			lowindex++;
			highindex--;
		}

		//print the result sorted array
		for (Comparable c : array) {
			System.out.print(c + " ");
		}
		System.out.println();
		
	}

	// 2). In-place Heap Sort
	public void heapSort(Comparable[] array, int lowindex, int highindex) {
		//Build the heap:
		Comparable[] tmpArray = new Comparable[highindex - lowindex + 1];
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

		//print the result sorted array
		for (Comparable c : array) {
			System.out.print(c + " ");
		}
		System.out.println();
	}

	/** ----------------Helper Methods for heapSort -------------------- */
	//swap the two given elements
	private void swap(Comparable[] array, int pos1, int pos2) {
		Comparable tmp = array[pos1];
		array[pos1] = array[pos2];
		array[pos2] = tmp;
	}
	//push the value down if necessary
	private void pushdown(Comparable[] array, int size, int position) {
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
	public void buildMaxHeap(Comparable[] array) {
		int n = array.length; //number of elements need to build

		for (int pos = n/2; pos >= 1; pos--) { //start from position n/2
			int i = pos;
			Comparable tmp = array[i - 1];
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
	
	// 3). Randomized Quick Sort
	public void randomizedQuickSort(Comparable[] arr, int lowindex, int highindex) {
		//call helper method
		quickSort(arr, lowindex, highindex);

		//print the result sorted array
		for (Comparable c : arr) {
			System.out.print(c + " ");
		}
		System.out.println();
	}

	/** ---------- Helper Methods for randomizedQuickSort -------------- */
	public void quickSort(Comparable[] arr, int low, int high) {
		int pivot;
		if (low < high) {
			pivot = partition(arr, low, high);
			quickSort(arr, low, pivot - 1);
			quickSort(arr, pivot + 1, high);
		}
	}

	static int partition(Comparable[] arr, int low, int high) {
		Comparable pivot;
		Comparable tmp;
		int max = high;
		Random rand = new Random();
		int random = rand.nextInt((high - low) + 1) + low;

		tmp = arr[random];
		arr[random] = arr[high];
		arr[high] = tmp;
		pivot = arr[high];
		low--;
		do {
			while (arr[++low].compareTo(pivot) < 0)
				;
			while ((low < high) && (arr[--high].compareTo(pivot) > 0) )
				;
			tmp = arr[low];
			arr[low] = arr[high];
			arr[high] = tmp;
		} while (low < high);
		tmp = arr[low];
		arr[low] = arr[max];
		arr[max] = tmp;
		return low;
	}
	/** -------------------------------------------------------------- */

	// 4). External Sort
	public void externalSort(String inputFile, String outputFile, int n, int k) {
		//split into temp files 
		int num = (int)Math.ceil((double)n/k); //get the number of temp files
		String[] listOfFiles = new String[num];
		File inputfile = new File(inputFile);
		try(Scanner input = new Scanner(inputfile)) {
			int count = 1;
			int counter = 0;
			while (input.hasNext()) {
				try{
					String filename = "temp" + count;
					PrintWriter printerWriter = new PrintWriter(filename); 
					listOfFiles[counter] = filename;

					//save elements to a tmp array
					int[] tmp = new int[k];
					int i = 1;
					while (i <= k) {
						if (input.hasNext()) {
							String line = input.nextLine();
							int number = Integer.parseInt(line);
							tmp[i - 1] = number;
						}
						i++;
					}
					//sort the array & write them to the temp file
					quickSort(tmp, 0, k - 1);
					for (Integer a : tmp) {
						if (a != 0) {
							printerWriter.println(a);
						}
					}
					printerWriter.flush();
					printerWriter.close();
					count++;
					counter++;
				} catch (FileNotFoundException fnf) {
					System.out.println(fnf.getMessage());
					return;
				}
				
			}
		} catch (FileNotFoundException fnf) {
			System.out.println(fnf.getMessage());
			return;
		}

		//temporary int array of top numbers in each file
		int[] topNums = new int[num];
		BufferedReader[] br = new BufferedReader[num];
		for (int j = 0; j < num; j++) {
			String s = "";
			try{
				br[j] = new BufferedReader(new FileReader(listOfFiles[j]));
				s = br[j].readLine();
			} catch(IOException e) {
				e.printStackTrace();
			}
			if (s != null) {
				topNums[j] = Integer.parseInt(s);
			} else {
				topNums[j] = Integer.MAX_VALUE;
			}
		}

		//compare elements in topNums & print correct element to outputFile
		try{
			PrintWriter pw = new PrintWriter(outputFile);
			for (int b = 0; b < n; b++) {
				int min = topNums[0];
				int minPointer = 0; //the pointer to the file that contains the min

				for (int c = 0; c < num; c++) {
					if (min > topNums[c]) {
						min = topNums[c];
						minPointer = c;
					}
				}

				pw.println(min);
				String s = br[minPointer].readLine();
				if (s != null) {
					topNums[minPointer] = Integer.parseInt(s);
				} else {
					topNums[minPointer] = Integer.MAX_VALUE;
				}
			}
			for (int c = 0; c < num; c++) {
				br[c].close();
			}
			pw.flush();
			pw.close();
		} catch(FileNotFoundException fnf) {
			System.out.println(fnf.getMessage());
			return;
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

	/** ---------- Helper Methods for externalSort -------------- */
	public static void quickSort(int arr[]) {
		quickSort(arr, 0, arr.length - 1);
	}

	public static void quickSort(int arr[], int low, int high) {
		int pivot;
		if (low < high) {
			pivot = partition(arr, low, high);
			quickSort(arr, low, pivot - 1);
			quickSort(arr, pivot + 1, high);
		}
	}

	static int partition(int arr[], int low, int high) {
		int pivot;
		int tmp;
		int max = high;
		int mid = (low + high) / 2;

		tmp = arr[mid];
		arr[mid] = arr[high];
		arr[high] = tmp;
		pivot = arr[high];
		low--;
		do {
			while (arr[++low] < pivot)
				;
			while ((low < high) && (arr[--high] > pivot))
				;
			tmp = arr[low];
			arr[low] = arr[high];
			arr[high] = tmp;
		} while (low < high);
		tmp = arr[low];
		arr[low] = arr[max];
		arr[max] = tmp;
		return low;
	}
	/** -------------------------------------------------------------- */

	// 5). "RGB" - Sort
	public void rgbSort(String[] array) {
		//counters of RGB
		int rCounter = 0;
		int gCounter = 0;
		int bCounter = 0;

		//get number of occurence for R,G and B
		for (int i = 0; i < array.length; i++) {
			if (array[i].equals("r")) {
				rCounter++;
			}
			else if (array[i].equals("g")) {
				gCounter++;
			}
			else if (array[i].equals("b")) {
				bCounter++;
			}
		}

		//sort
		for (int j = 0; j < array.length; j++) {
			if (j < rCounter) {
				array[j] = "r";
			}
			else if (j < (rCounter + gCounter)) {
				array[j] = "g";
			}
			else {
				array[j] = "b";
			}
		}

		//print the result sorted array
		for (String s : array) {
			System.out.print(s + " ");
		}
		System.out.println();
	}
}


