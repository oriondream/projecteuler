package net.projecteuler;

import java.util.TreeSet;

public class p125 {
	public static boolean isPalindrom(Long N) {
		String str = N.toString();
		int i = 0;
		int j = str.length() - 1;
		
		while (i <= j && str.charAt(i) == str.charAt(j)) {
			++i;
			--j;
		}
		
		return (i > j);
	}
	
	public static void main(String[] args) {
		TreeSet<Long> set = new TreeSet<Long>();
		int LIMIT = 100000000;
		long[] A = new long[10000+1];
		
		A[1] = 1;
		A[2] = 5;
		
		int last = 0;
		
		for (int i = 3; i < A.length; i++) {
			A[i] = (long)i*(i+1)*(2*i+1)/6;
			if (A[i] - A[i-2] >= LIMIT) {
				System.out.println("Cut off i="+i+" "+A[i]);
				last = i;
				break;
			}
		}
		int count = 0;
		long sum = 0;
		for (int i = 2; i <= last; i++)
			for (int j = 0; j <= i - 2; j++) {
				if (isPalindrom(A[i]-A[j]) && A[i] - A[j] <= LIMIT && !set.contains(A[i] - A[j])) {
					++count;
					System.out.print("i:"+i+" "+count+":");
					System.out.print(A[i]-A[j]);
					System.out.print(" ");
					System.out.println(A[i]);
					sum += A[i]-A[j];					
					set.add(A[i] - A[j]);
				}
			}
		System.out.println(sum);
	}
}
