package net.projecteuler;

public class p173 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final int LIMIT = 1000000;		
		int count = 0;
		for (int a = (LIMIT - 4)/4 + 2; a >= 3; a--) {
			for (int t = a - 2; t >= 1; t = t - 2) {
				if (a*a - t*t <= LIMIT) {
					//System.out.println(a+ " " + t + " " + (a*a-t*t));
					++count;
				}
				else
					break;
			}
		}
		System.out.println(count);
	}

}
