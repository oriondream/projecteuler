package net.projecteuler;


public class p92 {
	int value(int n) {
		int sum = 0;
		while (n != 0) {
			sum += (n%10)*(n%10);
			n /= 10;
		}
		if (sum == 1 || sum == 89)
			return sum;
		else
			return value(sum);
	}
	
	int dem = 0;
	
	int[] V = new int[81*7 + 1];
	
	void first_stage() {
		for (int i = 1; i <= 81*7; i++) {
			V[i] = value(i);
			if (V[i] == 89) ++dem;
		}
	}
	
	void second_stage() {
		for (int i = 81*7 + 1; i < 10000000; i++) {
			int n = i;
			int sum = 0;
			while (n != 0) {
				sum += (n%10)*(n%10);
				n /= 10;
			}
			if (V[sum] == 89)
				++dem;
		}
		System.out.println(dem);
	}
	
	public p92() {
		first_stage();
		second_stage();
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new p92();
	}

}
