package net.projecteuler;

public class p148 {
	long[] power7;
	void init() {
		long i = 1;
		int n = 0;
		while (i <= 10000000000l) {
			i*=7;
			++n;
		}
		power7 = new long[n];
		power7[0] = 1;
		for (int t = 1; t < power7.length; t++) {
			power7[t] = power7[t-1]*7;
		}
	}
	long count(long row, int i) {
		if (i == 0)
			return 0;
		else {
			long sizeDown  = power7[i]-1 - (row-1)%power7[i]; 
			long countDown = (row-1)/power7[i];
			long countUp   = countDown+1;
			
			return sizeDown*countDown + countUp*count(row%power7[i], i-1);
		}
	}
	public long get(int row) {
		int i = 0;
		while (power7[i+1] <= row-1)
			++i;	
		return count(row, i);
	}
	/**
	 * Return the size of the down triangle of number devise by 7
	 * @param k
	 * @return
	 */
	public long downSize(int k) {
		return power7[k]*(power7[k]-1)/2;
	}
	/**
	 * Returns the sum of numbers starts from 1 
	 * @param k
	 * @return
	 */
	public long succList(long k) {
		return (k+1)*k/2;
	}
	public long countFullSize(int k) {
		if (k <= 1)
			return 0;
		else
			return 21*downSize(k-1)+28*countFullSize(k-1);
	}
	
	static final long TARGET = (long) 1e9;
	
	public long big() {
		int k = 0;
		while (Math.pow(7,k+1) <= TARGET) {
			++k;
		}

		int bulk = ((int) Math.floor(TARGET/Math.pow(7,k)) ) * ((int)Math.pow(7,k));
		System.out.println("Mannually count from "+bulk);
		
		int bulkRows = (int) Math.floor(TARGET/Math.pow(7,k));
		System.out.println("bulkRows "+bulkRows);
		
		long sum = 0;
		
		sum += downSize(k) * succList(bulkRows - 1) + succList(bulkRows)*countFullSize(k);		
		
		// Count the rest rows
		System.out.println("Counting the rest");
		for (int i = bulk + 1; i <= TARGET; i++) {
			sum += get(i);
		}
		
		return sum;
	}
	public p148() {
		init();

		long sum = 0;
		//for (int i = 1; i <= TARGET; i++)
		//	sum+= get(i);
		
		//System.out.println(succList(TARGET) - sum);
		System.out.println(succList(TARGET) - big());
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new p148();
	}

}
