package net.projecteuler;

public class p108a {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int count = 0;
		int n = 1260;
		for (int x=n+1; x <= n*n; x++) 
				if ((n*x) % (x-n) == 0) {
					int y = (n*x) / (x-n); 
					if (x <= y) {
						System.out.println("1/"+x + " + 1/"+y+" = 1/"+n);
						++count;
					}
					else {
						break;
					}
				}
		System.out.println(count);
	}
}
