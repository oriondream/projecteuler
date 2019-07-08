package net.projecteuler;

import java.util.TreeSet;

public class p61 {
	InOutData[][] P = new InOutData[9][10000];

	void initInOut() {
		for (int p = 0; p <= 8; p++)
			for (int i = 0; i < 10000; i++)
				P[p][i] = null;
		
		for (int i = 0, P3 = 0; P3 < 10000; i++, P3 = i*(i+1)/2) 
			if (P3 > 1000 && P3%100 > 10) {
				P[3][P3] = new InOutData();
			}
		for (int i = 0, P4 = 0; P4 < 10000; i++, P4 = i*i) 
			if (P4 > 1000 && P4%100 > 10) {
				P[4][P4] = new InOutData();
			}
		for (int i = 0, P5 = 0; P5 < 10000; i++, P5 = i*(3*i-1)/2) 
			if (P5 > 1000 && P5%100 > 10) {
				P[5][P5] = new InOutData();
			}
		for (int i = 0, P6 = 0; P6 < 10000; i++, P6 = i*(2*i-1)) 
			if (P6 > 1000 && P6%100 > 10) {
				P[6][P6] = new InOutData();
			}
		for (int i = 0, P7 = 0; P7 < 10000; i++, P7 = i*(5*i-3)/2) 
			if (P7 > 1000 && P7%100 > 10) {
				P[7][P7] = new InOutData();
			}
		for (int i = 0, P8 = 0; P8 < 10000; i++, P8 = i*(3*i-2)) 
			if (P8 > 1000 && P8%100 > 10) {
				P[8][P8] = new InOutData();
			}
	}

	void initNumbers() {
		for (int p = 3; p <= 8; p++)
			for (int i = 0; i < 10000; i++)
				if (P[p][i] != null) {
					int right = i % 100;
					int left = i/100;
					
					for (int xp = 3; xp <= 8; xp++)
						if (xp != p)
							for (int t = 10; t <= 99; t++) {
								int newNum = right * 100 + t;
								if (P[xp][newNum] != null) {
									P[xp][newNum].in.add(i);
									P[p][i].out.add(newNum);
								}
								newNum = t*100 + left;
								if (P[xp][newNum] != null) {
									P[xp][newNum].out.add(i);
									P[p][i].in.add(newNum);
								}
							}
				}
	}

	void removeNoInOut() {
		for (int p = 3; p <= 8; p++)
			for (int i = 0; i < 10000; i++) 
				if (P[p][i] != null && (P[p][i].in.size() == 0 || P[p][i].out.size() == 0))
					P[p][i] = null;
	}
	
	void print() {
		for (int p = 3; p <= 8; p++) {
			for (int i = 0; i < 10000; i++) { 
				if (P[p][i] != null) {
					System.out.println(i + " ");
					System.out.print("\t");
					for(Integer I:P[p][i].in)
						System.out.print(I+" ");
					System.out.println();
					System.out.print("\t");
					for(Integer I:P[p][i].out)
						System.out.print(I+" ");
					System.out.println();
				}
			}
			System.out.println();
		}
	}
	
	int[] marker = new int[9]; 
	
	int length = 0;
	
	boolean found = false;
	
	void search(int degree, int number) {
		if (found)
			return;
		
		marker[degree] = number;
		
		++ length;
		
		if (length == 6) {
			if (number % 100 == marker[8]/100) {
				found = true;
				int sum = 0;
				for (int i = 3; i <= 8; i++) {
					System.out.print(marker[i]+ " ");
					sum+= marker[i];
				}
				System.out.println(sum);
				
			}
		}
		else {
			for (Integer i:P[degree][number].out)
				for (int d = 3; d <= 8; d++)
					if (marker[d] == 0 && P[d][i] != null)
						search(d, i);
		}
		marker[degree] = 0;
		-- length;
	}
	
	void initMarker() {
		for (int i = 0; i < marker.length; i++) {
			marker[i] = 0;
		}
	}
	
	public p61() {
		initInOut();
		initNumbers();
		removeNoInOut();
		//print();
		initMarker();
		for (int i = 9999; i >= 1010; i--)
			if (P[8][i] !=  null) {
				search(8,i);
			}
	}
	
	public static void main(String[] args) {
		new p61();
	}
}

class InOutData {
	public TreeSet<Integer> in = new TreeSet<Integer>();
	public TreeSet<Integer> out = new TreeSet<Integer>();
}

