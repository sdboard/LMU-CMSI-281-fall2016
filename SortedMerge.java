// SortedMerge.java
class SortedMerge{
	public static void main(String[] args){
		//test arrays
		int[] t1 = new int[5];
		int[] t2 = new int[2];

		//fill test arrays
		for (int i =  0; i < 5; i++){
			if (i < 3) {
				t1[i] = i+1;
			} else {
				t1[i] = 0;
			}
		}
		for (int i = 0; i < 2; i++){
			t2[i] = i+4;
		}

		//print them out
		for (int i = 0; i < t1.length; i++){
			System.out.print(t1[i] + " ");
		}
		System.out.print("\n");
		for (int i = 0; i < t2.length; i++){
			System.out.print(t2[i] + " ");
		}

		merge(t1, t2);
	}
	static void merge(int[] A, int[] B){
		int a = A.length - B.length - 1;
		int b = B.length - 1;
		int c = A.length - 1;
		while ( b >= 0 ){
			if ( a != 0 && A[a-b] > B[b] ){
				A[c] = A[a];
				a--;
			} else {
				A[c] = B[b];
				b--;
			}
			c--;
		}

		//show merged list
		System.out.print("\n");
		for (int i = 0; i < A.length; i++){
			System.out.print(A[i] + " ");
		}
		System.out.print("\n:)\n");
	}
}


