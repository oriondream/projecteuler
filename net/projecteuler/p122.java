package net.projecteuler;

public class p122 {
	final int maxnumber	= 20000;

	int process(int n) {
		int[] v    = new int[maxnumber];
		int[] last = new int[maxnumber];

		for (int i = 0; i < v.length; i++)
			v[i] = Integer.MAX_VALUE;

		int i, j, l;

		v[1] = 0; v[2] = 1;
		last[1] = 0; last[2] = 1;
		for (i = 2; i <= n; i++) {
			j = i;
			while (j > 0) {
				l = i+j;
				if (l <= n && v[i]+1 < v[l]) {
					v[l] = v[i] + 1;
					last[l] = i;
				}
				j = last[j];
			}
		}
		return v[n];
	}

	public p122() {
		int sum = 0;
		for (int i = 2; i <=
			200; i++)
			sum += process(i);
		System.out.println(sum);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new p122();
	}
}
