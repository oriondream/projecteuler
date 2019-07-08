package net.projecteuler;

public class p95 {
	int LIMIT = 1000000;
	int[] next = new int[LIMIT+1];
	int[] depth = new int[LIMIT+1];
	
	boolean loopFound;
	int loopLength;
	int loopDepth;
	int min;
	int minElement;
	int maxLength = 0;
	
	void traverse(int i, int depth) {
		if (this.depth[i] == 0) {
			this.depth[i] = depth;
			if (next[i] < LIMIT) 
				traverse(next[i], depth+1);
			if (loopFound) {
				if(this.depth[i] >= loopDepth) {
					System.out.print(i+" ");
					if (i < min)
						min = i;
				}
			}
			this.depth[i] = -1;
		}
		else {
			if (this.depth[i] != -1) {
				loopLength = depth - this.depth[i]; 
				loopFound = true;
				loopDepth = this.depth[i];
			}
		}
	}
	
	void initNext() {
		for (int i = 1; i <= LIMIT; i++)
			next[i] += 1;
		for (int i = 2; i <= Math.sqrt(LIMIT); i++) {
			if (i*i < LIMIT)
				next[i*i] += i;
			for (int j = i+1; j <= LIMIT/i; j++)
				next[i*j] += (i+j);
		}
	}
	
	public p95() {
		initNext();
		for (int i = 1; i < LIMIT; i++) {
			if (depth[i] == 0) {
				min = Integer.MAX_VALUE;
				loopFound = false;
				traverse(i, 1);
				if (loopFound)
					System.out.println();
				if (loopFound && loopLength >= maxLength) {
					maxLength = loopLength;
					minElement = min;
				}
			}
		}
		System.out.println(maxLength);
		System.out.println(minElement);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new p95();
	}

}
