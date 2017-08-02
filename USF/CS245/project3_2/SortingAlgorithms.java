import java.util.Random;
import java.util.LinkedList;
import java.util.ArrayList;

public class SortingAlgorithms implements SortInterface {
// Part 1:
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

//Part 2:
	// 1). Comb Sort
	public void combSort(Comparable[] array, int lowindex, int highindex) {
		int n = highindex - lowindex + 1; //number of elements
		double gapDouble = n / 1.3;
		int gap = (int)gapDouble;
		while (gap != 0) {
			for (int i = lowindex; i + gap <=highindex; i++) {
				if ( array[i].compareTo(array[i + gap]) > 0) {
					swap(array, i, i + gap);
				}
			}
			gapDouble = gap/1.3;
			gap = (int)gapDouble;
		}
	}

	// 2). Iterative Merge Sort
	public void iterativeMergeSort(Comparable[] array) {
		Comparable[] temp = new Comparable[array.length];
		for (int sublistSize = 1; sublistSize < array.length; sublistSize = sublistSize * 2) {
			for (int start = 0; start < array.length; start = start + (2 * sublistSize) ) {
				merge(array, temp, start, start + sublistSize, start + (2 * sublistSize) );
			}
		}
	}

	/** ---------- Helper Methods for iterativeMergerSort -------------- */
    private static void merge(Comparable[] array, Comparable[] temp, int low, int mid, int high) {
    	if (mid >= array.length) {
			return;
		}
		if (high > array.length) {
			high = array.length;
		}
		int i = low;
		int j = mid;
		for (int k = low; k < high; k++) {
			if (i == mid) { //ran out of elements in the i sublist
				temp[k] = array[j];
				j++;
			} else if (j == high) { //ran out of elements in the j sublist
				temp[k] = array[i];
				i++;
			} else if (array[j].compareTo(array[i]) < 0) { //place array[j] in temp, move j
				temp[k] = array[j];
				j++;
			} else { //place array[i] in temp, move i
				temp[k] = array[i];
				i++;
			}
		}
		//copy the result from temp back to array
		for (int k = low; k < high; k++) {
			array[k] = temp[k];
		}
    }
    /** -------------------------------------------------------------- */

    // 3). Hybrid Sort:
    public void hybridSort(Comparable[] array, int lowindex, int highindex) {
    	quickSort2(array, lowindex, highindex);
    }

	/** ---------- Helper Methods for Hybrid Sort -------------- */
	public void quickSort2(Comparable[] arr, int low, int high) {
		int pivot;
		if (low < high) {
			pivot = partition(arr, low, high);
			int sizeLeft = (pivot - 1) - low + 1;
			if (sizeLeft > 20) {
				quickSort2(arr, low, pivot - 1);
			} else {
				insertionSort(arr, low, pivot - 1);
			}
			int sizeRight = high - (pivot + 1) + 1;
			if (sizeRight > 20) {
				quickSort2(arr, pivot + 1, high);
			} else {
				insertionSort(arr, pivot + 1, high);
			}
		}
	}
	public static void insertionSort(Comparable[] array, int lowindex, int highindex) {
		Comparable curr;
		int j;
		for (int i = lowindex + 1; i <= highindex; i++) {
			curr = array[i];
			j = i - 1;
			while (j >= lowindex && (array[j].compareTo(curr) > 0)) {
				array[j + 1] = array[j];
				j--;
			}
			array[j + 1] = curr;
		}
	}
	/** -------------------------------------------------------------- */

	// 4). Bucket Sort
	public void bucketSort(Record[] array, int lowindex, int highindex) {
		bucketSortStatic(array, lowindex, highindex);
	}

	/** ---------- Helper Methods for Bucket Sort -------------- */
	public static void bucketSortStatic(Record[] array, int lowindex, int highindex) {
		int numBuckets = (highindex - lowindex + 1) / 2;
		int maxKey = 0;
		for (int i = lowindex; i <= highindex; i++) {
			if (array[i].key() > maxKey) {
				maxKey = array[i].key();
			}
		}
		int range = maxKey / numBuckets + 1;

		//an array of linkedlist of records 
		LinkedList<Record>[] buckets = new LinkedList[numBuckets];
		
		for (int j = lowindex; j <= highindex; j++) {
			int bucketIndex = array[j].key() / range;
			
			if (buckets[bucketIndex] != null) {
				int pos = 0;
				int size = buckets[bucketIndex].size();
				while (pos < size) {
					if ( (buckets[bucketIndex].get(pos)).key() > array[j].key()) {
						buckets[bucketIndex].add(pos, array[j]);
						break;
					} 
					pos++;
				}
				if (buckets[bucketIndex].size() == size) {
					buckets[bucketIndex].add(pos, array[j]);
				}
			} else {
				//create new LinkedList
				LinkedList<Record> ll = new LinkedList();
				ll.add(0, array[j]);
				buckets[bucketIndex] = ll;
			}
		}
		//use the buckets list to sort the original array
		Record[] temp = new Record[highindex - lowindex + 1];
		int i = 0;
		for (int k = 0; k < buckets.length; k++) {
			if (buckets[k] != null) {
				for (int p = 0; p < buckets[k].size(); p++) {
					temp[i] = buckets[k].get(p);
					i++;
				}
			}
		}		
		int q = 0;
		for (int k = 0; k < array.length; k++) {
			if (k >= lowindex && k <= highindex) {
				array[k] = temp[q];
				q++;
			}
		}
	}
	/** -------------------------------------------------------------- */

	// 5). Radix Sort:
	public void radixSort(int[] array, int lowindex, int highindex) {
		if (highindex == lowindex) {
			return;
		}
		int ndigits = (int) (Math.log10(array[0]) + 1);

		int[] temp = new int[highindex - lowindex + 1];

		int[] count = new int[10];

		for (int i = 0, place = 1; i < ndigits; i++, place *= 10) {
			//initialize count array
			for (int j = 0; j < 10; j++) {
				count[j] = 0;
			}
			//iterate over and fill out count array
			for (int j = lowindex; j <= highindex; j++) {
				int k = (array[j] / place) % 10;
				count[k]++;
			}
			//modified count array
			for (int j = 1; j < 10; j++) {
				count[j] += count[j - 1];
			}
			//result will be in temp
			for (int j = highindex; j >= lowindex; j--) {
				temp[--count[(array[j] / place) % 10]] = array[j];
			}
			//copy the result back 
			int p = 0;
			for (int j = 0; j < array.length; j++) {
				if (j >= lowindex && j <= highindex) {
					array[j] = temp[p];
					p++;
				}
			}

		}

	}

}