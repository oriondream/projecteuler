package net.projecteuler;

import static lib.Utils.isPrime;
import static lib.Utils.primes;
public class p60 {
	final int SEARCH = 5;
	long[] list = new long[SEARCH];
	long concat(long a, long b) {
		int tens = 1;
		
		while (tens < b) {
			a *= 10;
			tens *= 10;
		}
		
		return a+b;
	}
	
	int solutionCount = 0;
	int LIMIT = 2864;
	
	int currentSum = 0;
	//TODO: optimize using pairs OK primes
	void tryPrime(int index, int count) {
		int p = primes[index];
		
		currentSum += p;
		if (currentSum <= 26033) {
			list[count] = p;
			
			if (count == SEARCH - 1) {
				++solutionCount;
				int sum = 0;
				for (int i = 0; i < list.length; i++)
					sum += list[i];
				System.out.print(sum+": ");
				for (int i = 0; i < list.length; i++)
					System.out.print(list[i]+" ");
				System.out.println();
				if (sum < LIMIT) resetLimit(sum);
			}
			else 
			for (int i = index + 1; i < LIMIT; i++) 
				if (primes[i] != 5){
				
					boolean ok = true;
					
					for (int j = 0; j <= count; j++) 
						if (!isPrime(concat(list[j], primes[i])) || !isPrime(concat(primes[i], list[j]))) {
							ok = false;
							break;
						}
						
					if (ok) {
						tryPrime(i, count+1);
					}
				}
		}
		currentSum -= p;
	}
	void find(int n) {
		int i;
		for (i = 0; primes[i] <= n; i++);
		System.out.println(i);
		System.exit(0);
	}
	void resetLimit(int n) {
		int i;
		for (i = 0; primes[i] <= n; i++);
		LIMIT = i;
	}
	
	public p60() {
		//find(26033);
		for (int i = 0; i < LIMIT; i++) 
			if (primes[i] != 5 && primes[i] != 2){
				tryPrime(i,0);
			}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new p60();
	}

}
