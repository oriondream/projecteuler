package net.projecteuler;


public class p97 {
	long calLimit() {
		long result = 1;
		for (int t = 1; t <=10; t++) {
			result*=10;
		}
		return result;
	}
	public p97() {
		long i = 1;
		long limit = calLimit();
		for (long t = 1; t <= 7830457; t++) {
			i*=2;
			if (i > limit)
				i = i% limit;
		}
		System.out.println(i);
		System.out.println(i*28433+1);
	}
	public static void main(String[] args) {
		new p97();
	}
}
