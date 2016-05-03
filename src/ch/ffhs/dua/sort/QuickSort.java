package ch.ffhs.dua.sort;

public class QuickSort 
{
	
	/**
	 * Sortiert ein Array durch Quicksort.
	 * @param array Zu sortierendes Array.
	 */
	public static void sort(int[] array)
	{
		sort(array, 0, array.length - 1);
	}
	
	/**
	 * Sortiert ein Teilstück eines Arrays durch Quicksort.
	 * @param array Zu sortierenden Array
	 * @param start Index des ersten Elementes des Teils, das sortiert werden muss.
	 * @param end   Index des letzen Elementes des Teils, das sortiert werden muss.
	 */
	public static void sort(int[] array, int start, int end)
	{
		// TODO
		if (array == null || array.length == 0)
			return;
 
		if (start >= end)
			return;
 
		// pick the piv
		int middle = start + (end - start) / 2;
		int piv = array[middle];
 
		// make start < piv and end > piv
		int i = start, j = end;
		while (i <= j) {
			while (array[i] < piv) {
 				i++;
			}
 
			while (array[j] > piv) {
				j--;
			}
 
			if (i <= j) {
				int temp = array[i];
				array[i] = array[j];
				array[j] = temp;
				i++;
				j--;
			}
		}
 
		// recursively sort two sub parts
		if (start < j)
			sort(array, start, j);
 
		if (end > i)
			sort(array, i, end);
	}
	
	/** 
	 * Schwellwert, bei welcher Arraygrösse in der Rekursion InsertSort 
	 * statt Quicksort aufgerufen werden sollte. 
	 */
	static int THRESHOLD = 10; // TODO finden Sie einen sinnvollen Wert
	
	/**
	 * Modifiziertes Quicksorts.
	 * Wenn die Grösse des zu sortierenden Arrays in der Rekursion 
	 * einen Schwellwert unterschreitet, wird InsertSort statt Quicksort 
	 * aufgerufen.
	 * @param array Zu sortierendes Array
	 */
	public static void sortPlus(int[] array)
	{
		sortPlus(array, 0, array.length - 1);
	}

	/**
	 * Modifiziertes Quicksorts zum SOrtieren eines Teilstücks eines Arrays.
	 * Wenn die Grösse des zu sortierenden Arrays in der Rekursion 
	 * einen Schwellwert unterschreitet, wird InsertSort statt Quicksort 
	 * aufgerufen.
	 * @param array Zu sortierendes Array
	 * @param start Index des ersten  Elementes des zu sortierenden teilstücks.
	 * @param end   Index des letzten Elementes des zu sortierenden teilstücks.
	 */
	public static void sortPlus(int[] array, int start, int end)
	{
		// TODO
		int size = start - end + 1;
	    if (size < 10)
	      InsertSort.sort(array, start, end);
	    else {
	      int mid = findpiv(array, start, end);
	      int part = partition(array, start, end,mid);
	      sortPlus(array, start, part - 1);
	      sortPlus(array, part + 1, end);
	    }
	}

	/**
	 * Hilfsmethode für Quicksort. 
	 * Ein Teilstück eines Arrays wird geteilt, so dass alle Elemente,
	 * die kleiner als ein gewisses piv-Elements sind, links stehen
	 * und alle Elemente, die grösser als das piv-Element rechts stehen.
	 * @param array Array zum Umordnen.
	 * @param start Indes des ersten  Elements des Teilstücks, das geteilt werden muss.
	 * @param end   Index des letztes Elements des Teilstücks, das geteilt werden muss.
	 * @param piv   Index des PiotElements
	 * @return Index des Piot-Element nach der Partitionierung.
	 */
	static int partition(int[] array, int start, int end, int piv)
	{
		// TODO Verwenden Sie diese Methode für Quicksort
		int startPtr = start;
	    int endPtr = end - 1;
	    while (true) {
	      while (array[++startPtr] < piv)
	        ;
	      while (array[--endPtr] > piv)
	        ;
	      if (startPtr >= endPtr)
	        break;
	      else
	        swap(array, startPtr, endPtr);
	    }
	    swap(array, startPtr, end - 1);
		return -1;
	}
	
	/**
	 * Hilfsmethode zum Vertauschen zweier Array-Elemente
	 * @param array
	 * @param a
	 * @param b
	 */
	static void swap(int[] array, int a, int b)
	{
		int tmp = array[a];
		array[a] = array[b];
		array[b] = tmp;
	}
	
	/**
	 * Hilfsmethode zum Finden eines piv-Elementes für Quicksort.
	 * Zu einem Array und den zwei Indices start und end wird 
	 * der Index eines möglichen piv-Elementes angegeben 
	 * @param array
	 * @param start
	 * @param end
	 * @return Index eines piv-Elementes
	 */
	static int findpiv(int[] array, int start, int end)
	{
		// TODO
		int mid = (start + end) / 2;

	    if (array[start] > array[mid])
	      swap(array, start, mid);

	    if (array[start] > array[end])
	      swap(array, start, end);

	    if (array[mid] > array[end])
	      swap(array, mid, end);

	    swap(array, mid, end - 1);
	    
		return -1;
	}
}
