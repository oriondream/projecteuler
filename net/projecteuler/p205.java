package net.projecteuler;

public class p205 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		long A[][] = new long[36+1][9+1];
		long B[][] = new long[36+1][6+1];
		
		long[] AccumulativeSumA = new long[36+1];
		long[] AccumulativeSumB = new long[36+1];
		
		// Tinh A
		for (int i=1; i <= 4; i++)
			A[i][1] = 1;
		for (int i=2; i <= 9; i++) {
			for (int j = (i-1); j <= (i-1)*4; j++)
				for (int v = 1; v <= 4; v++)
					A[j+v][i] = A[j+v][i] + A[j][i-1];
		}
		
		// Tinh B		
		for (int i=1; i <= 6; i++) {
			B[i][1] = 1;
		}
		for (int i=2; i <= 6; i++) {
			for (int j = (i-1); j <= (i-1)*6; j++)
				for (int v = 1; v <= 6; v++)
					B[j+v][i] = B[j+v][i] + B[j][i-1];
		}
				
		long sumA = 0;
		for (int i = 1; i <= 36; i++)
			sumA += A[i][9];

		long sumB = 0;
		for (int i = 1; i <= 36; i++)
			sumB += B[i][6];
		
		long sum = 0;
		for (int i = 9; i <= 36; i++) {
			for (int j = 6; j < i; j++)
			sum += A[i][9]*B[j][6];
		}
		
		for (int i = 9; i <= 36; i++)
			System.out.println(A[i][9]);
		
		System.out.println();
		
		for (int i = 6; i <= 36; i++)
			System.out.println(B[i][6]);
		
		System.out.println();
		System.out.println(sum);
		System.out.println(sumA);
		System.out.println(sumB);
		System.out.println((double)sum/(sumA*sumB));
	}
}
