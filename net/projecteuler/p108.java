package net.projecteuler;

public class p108 {
	public static void main(String[] args) {
		long c = 1;
		boolean found = false;
		while (!found) {
			int solutions = 0;
			for (long a = c+1; a <= 2*c; a++) {
				if (a*c % (a-c) == 0) {
					++solutions;
				}
			}
			System.out.println(c+": "+solutions);
			if (solutions >= 100) {
				for (long a = c+1; a <= 2*c; a++) {
					if ((a*c) % (a-c) == 0) {
						long b = (a*c) / (a-c);
						System.out.println("1/"+a + " + 1/"+b+" = 1/"+c);
					}
				}
				System.out.println(solutions);
				System.exit(0);
			}
			++c;
		}
	}
}
