package net.projecteuler;

public class p145 {
	static boolean OK(int i) {
		if (i % 10 == 0)
			return false;

		int t = 1;
		
		while (t <= i)
			t*=10;
		t/=10;
		
		int sum = i;
		int a = 1;
		while (i > 0) {
			sum += (i/t)*a;
			i = i%t;
			t /= 10;
			a*=10;
		}			
		
		while (sum %2 == 1) {
			sum /= 10;
		}

		if (sum == 0)
			return true;
		else
			return false;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		System.out.println(OK(60));
//		System.exit(0);
		int count = 0;
		for (int i = 1; i <= 1000000000; i++) {
			if (OK(i)) {
				++count;
			}
		}
		System.out.println(count);
	}

}
