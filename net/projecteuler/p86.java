package net.projecteuler;

public class p86 {
	static boolean isSquare(long n) {
		long sqrt = Math.round(Math.sqrt(n));
		return n == sqrt*sqrt;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int count = 0;
		
		for (int i = 1; count <= 1000000 ; i ++) {
			for (int j = 1; j <= i; j ++) {
				for (int k = 1; k <= j; k ++) {
					int s1 = i*i + (j+k)*(j+k);
					int s2 = j*j + (i+k)*(i+k);
					int s3 = k*k + (i+j)*(i+j);
					
					int min = Math.min(Math.min(s1, s2), s3);
					
					if (isSquare(min)) {
						++count;
					}
				}
			}
			System.out.println(i + " " + count);
		}
	}

}
