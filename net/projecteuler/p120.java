package net.projecteuler;

public class p120 {
	static int findMax(int a) {
		int max = 2;
		for (int n = 0; n <= 2*a; n++) {
			if ((2*n*a) % (a*a) > max)
				max = (2*n*a) % (a*a);
		}
		return max;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int sum = 0;
		for (int i = 3; i <=1000; i++)
			sum += findMax(i);
		System.out.println(sum);
	}

}
