package net.projecteuler;


public class p43 {
	byte[] primes= {2, 3, 5, 7, 11, 13, 17};
	
	boolean[][] d = new boolean[7][1000];
	
	boolean ok(int i) {
		int hundreds = i / 100;
		int tens = (i/10) % 10;
		int ones = i% 10;
		return (hundreds != tens && tens != ones && ones != hundreds);
	}
	
	int count[] = new int[10];
	
	boolean[] used = new boolean[10];
	
	long number;
	long sum = 0;
	void attempt(int trio, int primeID) {
		if (primeID == 7) {
			System.out.println(number);
			sum += number;
		}
		else {
			int head = trio % 100;
			for (int digit = 0; digit <= 9; digit ++)
				if (!used[digit] && d[primeID][head*10 + digit]) {
					used[digit] = true;
					number = number*10 + digit;
					attempt(head*10 + digit, primeID+1);
					number = number/10;
					used[digit] = false;
				}
		}
	}
	
	public p43() {
		for (int i = 0; i <= 999; i++)
			if (ok(i)) {
				for (int t = 0; t < primes.length; t++) {
					if (i % primes[t] == 0) d[t][i] = true;
				}
			}
		for (int i = 102; i <= 987; i++)
			if (ok(i)) {
				used[i/100] = true;
				used[i%10] = true;
				used[(i/10)%10] = true;
				number = i;
				attempt(i, 0);
				used[i/100] = false;
				used[i%10] = false;
				used[(i/10)%10] = false;
			}
		System.out.println("Sum: " + sum);
	}
	public static void main(String[] args) {
		new p43();
	}
}
