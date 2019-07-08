package net.projecteuler;

import static lib.Utils.erathosten;
import static lib.Utils.primes;
public class p49 {
	boolean checkDiff(int k) {
		int a = k/1000;
		int b = (k/100)%10;
		int c = (k/10)%10;
		int d = (k%10);
		if (a!=b && b!= c && c!= d && a!=c && a!=d && b!=d)
			return true;
		else
			return false;
	}
	boolean checkPerm(int x, int y, int z) {
		int[] digit = new int[10];
		++digit[x/1000];
		++digit[(x/100)%10];
		++digit[(x/10)%10];
		++digit[x%10];
		
		++digit[y/1000];
		++digit[(y/100)%10];
		++digit[(y/10)%10];
		++digit[y%10];
		
		++digit[z/1000];
		++digit[(z/100)%10];
		++digit[(z/10)%10];
		++digit[z%10];
		
		for (int i = 0; i < 10; i++)
			if (digit[i] % 3 != 0)
				return false;
		
		return true;
	}
	public p49() {
		int i = 0;
		while (primes[i] <= 1000) ++i;
		while (primes[i] < 10000) {
			int x = primes[i];
			for (int gap = 2; x + 2*gap < 10000; gap = gap + 2) {
				int y = x + gap;
				int z = y + gap;
				if (erathosten[y] && erathosten[z] 
				                  && checkPerm(x, y, z)) {
					System.out.println(primes[i] + " " + (primes[i] + gap)+ " " + (primes[i] + 2*gap));
				}
			}
			++ i;
		}
	}
	public static void main(String[] args) {
		// 2969 6299 9629
		new p49();
	}
}