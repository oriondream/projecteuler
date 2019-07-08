package net.projecteuler;


public class p71 {
	int gcd(int x,int y) {
		if (x == 0)
			return y;
		else
			if (x < y)
				return gcd(y%x,x);
			else 
				return gcd(x%y,y);
	}
	public p71() {
		double max = 0;
		int ymax = 0;
		for (int y = 9; y <= 1000000; y++) {
			int x = (3*y - 1)/7;
			if (x/(double)y > max) {
				max = x/(double)y;
				ymax = x / gcd(x,y);
			}
		}
		System.out.println(ymax);
	}
	public static void main(String[] args) {
		new p71();
	}
}
