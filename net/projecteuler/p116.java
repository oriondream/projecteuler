package net.projecteuler;

public class p116 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final int MAX = 50;
		long[]r = new long[MAX+1];
		long[]g = new long[MAX+1];
		long[]b = new long[MAX+1];
		r[1] = 1;
		r[2] = 2;
		for (int i = 3; i <= MAX; i++) {
			r[i] = r[i-1] + r[i-2];
			System.out.println(r[i]);
		}
		g[1] = 1;
		g[2] = 1;
		g[3] = 2;
		for (int i = 4; i <= MAX; i++)
			g[i] = g[i-1] + g[i-3];
		b[1] = 1;
		b[2] = 1;
		b[3] = 1;
		b[4] = 2;
		for (int i = 5; i <= MAX; i++)
			b[i] = b[i-1] + b[i-4];
		System.out.println(r[MAX]+g[MAX]+b[MAX] - 3);
	}

}
