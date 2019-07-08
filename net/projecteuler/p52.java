package net.projecteuler;


public class p52 {
	boolean ok(int N) {
		int[] digit = new int[10];
		for (int i = 1; i <= 6; i++) {
			int num = N*i;
			while (num > 0) {
				++digit[num % 10];
				num /= 10;
			}
		}
		for (int i = 0; i <= 9; i++) {
			if (digit[i] % 6 != 0)
				return false;
		}
		return true;
	}
	public p52() {
		int N = 100;
		boolean found = false;
		while (!found) {
			if (ok(N)) {
				for (int i = 1; i <= 6; i++) {
					System.out.print(N*i + " ");
				}
				System.out.println();
			}
			++N;
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new p52();
	}

}
