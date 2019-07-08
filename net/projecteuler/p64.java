package net.projecteuler;

/**
 * Note that:
 * 
 * If R is an irrational number and
 *    x1 + y1*R = x2 + y2*R 
 * then 
 *    x1 = x2 and y1 = y2
 *    
 * @see http://mathworld.wolfram.com/PellEquation.html
 * 
 * @author Administrator
 *
 */
public class p64 {
	static long[] a = new long[10000];
	static long[] x = new long[10000];
	static long[] y = new long[10000];
	/**
	 * 
	 * @param N
	 * @return
	 */
	public static int getPeriod(int N) {
		final double SQRT = Math.sqrt(N);
		a[0] = Math.round(Math.floor(SQRT));
		x[0] = 1;
		y[0] = a[0];
		
		boolean found = false;
		for (int i = 1; !found ; i++) {
			a[i] = Math.round(Math.floor(x[i-1]/(SQRT-y[i-1])));
			x[i] = (N - y[i-1]*y[i-1])/x[i-1];
			y[i] = a[i]*x[i] - (x[i]*x[i-1]*y[i-1])/(N - y[i-1]*y[i-1]);

			if (a[i] == 2*a[0]) {
				return i;
			}
		}
		
		return 0;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int count = 0;
		for (int i = 2; i <= 10000; i++) {
			if (Math.round(Math.sqrt(i)) * Math.round(Math.sqrt(i))!= i) {
				if (getPeriod(i) % 2 == 1) {
					++count;
				}
			}
		}
		System.out.println(count);
	}

}
