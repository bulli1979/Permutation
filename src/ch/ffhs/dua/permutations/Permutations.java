package ch.ffhs.dua.permutations;

public class Permutations {
	/**
	 * Erzeugt ein Array von allen Permutationen von {0,1,2,3,...,n-1}.
	 * 
	 * @param n
	 *            Anzahl Elemente in einer Permutation.
	 * @return Ein Array von Permutationen; jede Permutation ist ein Array von
	 *         Integern.
	 */
	public static int[][] permutations(int n) {
		if (n == 0) {
			return new int[0][0];
		}
		int count = getLength(n);
		int[][] result = new int[count][n];
		int[] base = buildBase(n);
		permuteHelper(base,0,result,0);
		return result;
	}

	private static int permuteHelper(int[] array, int index, int[][] result,int count){
		//Im letzten Element muss nichts merputiert werden
		if(index >= array.length - 1){ 
			//Clone im Array speichern und count 1 nach oben zählen
			result[count] = array.clone();
			count++;
	        return count;
	    }
		//Jeder Index im Subarray wird durchlaufen
	    for(int i = index; i < array.length; i++){ 
	    	 swap(array,index,i);
	        //Rekursiver aufruf
	        count = permuteHelper(array, index+1,result,count);
	        //Swap rückgängig machen
	        swap(array,index,i);
	    }
	    return count;
	}

	static int getLength(int n) {

		int count = 1;
		for (int i = 2; i <= n; i++) {
			count *= i;
		}
		return count;
	}

	static int[] buildBase(int n) {
		int[] base = new int[n];
		for (int i = 0; i < n; i++) {
			base[i] = i;
		}
		return base;
	}

	// Folgende Hilfsmethode ist wahrscheinlich nÃ¼tzlich
	/**
	 * Vertauscht zwei Elemente eines Arrays.
	 * 
	 * @param array
	 * @param index1
	 * @param index2
	 */
	static void swap(int[] array, int index1, int index2) {
		int tmp = array[index1];
		array[index1] = array[index2];
		array[index2] = tmp;
	}

}
