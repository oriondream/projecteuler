package net.projecteuler;


public class p39 {
	public int[] solve(int N) {
		int count = 0;
		for (int k = 1; k < Math.sqrt(N); k++) {
			if (N%k == 0 && N <= 2*k*k)
				++count;
		}
		int[] result = new int[count];
		count = 0;
		for (int k = 1; k < Math.sqrt(N); k++) {
			if (N%k == 0 && N < 2*k*k) {
				result[count] = k*k + (N/k-k)*(N/k-k);
				++count;
			}
		}
		return result;
	}
	public static void main (String[] args) {
		new p39();
	}
	public p39() {
		int maxCount = 0;
		int maxS = 0;
		
		for (int S = 1; S <= 1000; S++)
			if (S%2 == 0) {
				boolean[] marker = new boolean[S];
				int Sover2 = S/2;
				for (int k = 1; k <= Math.sqrt(Sover2); k++) {
					if (Sover2 % k == 0) {
						int[] res = solve(Sover2/k);
						for (int l = 0; l < res.length; l++) {
							marker[k*res[l]] = true;
						}
					}
				}
				int count = 0;
				for (int t = 1; t < marker.length; t++)
					if (marker[t]) ++count;
				System.out.println(S + " -> "+count);
				if (count >= maxCount) {
					maxCount = count;
					maxS = S;
				}
			}
		System.out.println(maxS + " : " +maxCount);
	}
}
