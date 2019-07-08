package net.projecteuler;

import java.util.HashSet;


public class p75 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int result = 0;
		
		for (int L = 12; L <= 1500000; L++) {
			//int x=0, y=0, z=0;
			if (L % 2 == 0) {
				int l = L / 2;

				HashSet<Integer> hs = new HashSet<Integer>();
				
				for (int k = 1; k <= l/6; k++) {
					if (l%k == 0) {
						int xl = l/k;
						for (int m = 2; m < Math.sqrt(xl); m++)
							if (xl % m == 0 && 2*m > xl/m) {								
								int n = xl/m - m;
								
								//x = k*(m*m-n*n);
								//y = k*2*m*n;
								//z = k*(m*m + n*n);								
								
								if (m*m-n*n < 2*m*n) {
									hs.add(k*(m*m-n*n));
								}
								else { 
									hs.add(k*(2*m*n));
								}
								
								if (hs.size() == 2) {									
									break;
								}
							}
						if (hs.size() == 2)
							break;
					}
				}
				
				if (hs.size() == 1) {
					++result;
					//System.out.println(L + ":" + x + " " + y + " "+ z);
				}
			}
		}
			
		System.out.println(result);
	}

}
