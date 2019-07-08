package net.projecteuler;

public class p68 {
	int[] inner, outer;
	
	boolean checkOK() {
		if (6 + inner[0] + inner[1] != outer[0] + inner[1] + inner[2]
		  ||outer[0] + inner[1] + inner[2] != outer[1] + inner[2] + inner[3]
		  ||outer[1] + inner[2] + inner[3] != outer[2] + inner[3] + inner[4]
		  ||outer[2] + inner[3] + inner[4] != outer[3] + inner[4] + inner[0]
		  ||outer[3] + inner[4] + inner[0] != 6 + inner[0] + inner[1])
			return false;
		else
			return true;	
	}
	
	boolean nextPermutation(int[] A) {
		int i = A.length - 2;
		while (i >= 0 && A[i] > A[i+1]) {
			--i;
		}
		if (i >= 0) {
			// so a[i] < a[i+1]
			int t;
			for (t = A.length - 1; A[t] < A[i]; --t);
			
			int tmp = A[i];
			A[i] = A[t];
			A[t] = tmp;
			
			int r = i+1;
			int s = A.length - 1;
			while (r <= s) {
				tmp  = A[r];
				A[r] = A[s];
				A[s] = tmp;
				++r;
				--s;
			}				
			
			return true;
		}
		else {
			return false;
		}			
	}
	
	public p68() {
		boolean inner_updated = true, outer_updated = true;
		
		outer = new int[] {7,8,9,10};

		do {			   
			inner = new int[] {1,2,3,4,5};
			do {
				if (checkOK()) {
					System.out.println(6+" "+inner[0]+" "+inner[1]+" , "+
							           outer[0] + ' ' + inner[1] + ' ' + inner[2] + " , " +
                               		   outer[1] + ' ' + inner[2] + ' ' + inner[3] + " , " +
                               		   outer[2] + ' ' + inner[3] + ' ' + inner[4] + " , " +
                               		   outer[3] + ' ' + inner[4] + ' ' + inner[0]
					);
				}
				
				inner_updated = nextPermutation(inner);
			} while (inner_updated);
			outer_updated = nextPermutation(outer);
		} while (outer_updated);
	}
	public static void main(String[] args) {
		new p68();
	}
}
