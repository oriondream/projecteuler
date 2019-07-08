package net.projecteuler;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class Sudoku {
	boolean[][] fillRow = null;
	boolean[][] fillCol = null;
	boolean[][][] fillSquare = null;
	int[][] m = new int[9][9];
	
	boolean unsolved = true;
	
	public int[][] solve(int[][] puzzle) {
		fillRow = new boolean[9][10];
		fillCol =  new boolean[9][10];
		fillSquare = new boolean[3][3][10];

		unsolved = false;
		
		for (int r = 0; r < 9; r++)
			for (int c = 0; c < 9; c++) {
				m[r][c] = puzzle[r][c];
				if (m[r][c] != 0) {
					fillRow[r][m[r][c]] = true;
					fillCol[c][m[r][c]] = true;
					fillSquare[r/3][c/3][m[r][c]] = true;
				}
				else {
					unsolved = true;
				}
			}

		if (unsolved)
			search();
		
		return m;
	}
	
	void search() {
		int leastChoice = 10;
		int newR = 0;
		int newC = 0;
		
		for (int r = 0; r < 9; r++) {
			for (int c = 0; c < 9; c++) { 
				if (m[r][c] == 0) {
					int count = 9;
					for (int v = 1; v <= 9; v++)
						if (fillRow[r][v] || fillCol[c][v] || fillSquare[r/3][c/3][v])
							--count;
					
					if (count < leastChoice) {
						leastChoice = count;
						newR = r;
						newC = c;
					}
					
					if (leastChoice == 1) {
						break;
					}
				}		
			}
			if (leastChoice == 1) {
				break;
			}
		}
		
		if (leastChoice == 10) {
			unsolved = false;
			return;
		}
		else {
			// The best place to try is found 
			for (int v = 1; v <= 9; v++) {
				if (!(fillRow[newR][v] || fillCol[newC][v] || fillSquare[newR/3][newC/3][v])) {
					m[newR][newC] = v;
					
					boolean saveR = fillRow[newR][v];
					boolean saveC = fillCol[newC][v];
					boolean saveS = fillSquare[newR/3][newC/3][v];
					
					fillRow[newR][v] = true;
					fillCol[newC][v] = true;
					fillSquare[newR/3][newC/3][v] = true;
					
					search();
					if (!unsolved) {
						return;
					}
					
					m[newR][newC] = 0;
					
					fillRow[newR][v] = saveR;
					fillCol[newC][v] = saveC;
					fillSquare[newR/3][newC/3][v] = saveS;
				}
			}
		}
	}
}

public class p96 {
	public p96() {
		int[][] S = {
		{0,0,3,0,2,0,6,0,0},
		{9,0,0,3,0,5,0,0,1},
		{0,0,1,8,0,6,4,0,0},
		{0,0,8,1,0,2,9,0,0},
		{7,0,0,0,0,0,0,0,8},
		{0,0,6,7,0,8,2,0,0},
		{0,0,2,6,0,9,5,0,0},
		{8,0,0,2,0,3,0,0,9},
		{0,0,5,0,1,0,3,0,0}
		};
		int[][] res = new Sudoku().solve(S);
		for (int r = 0; r < res.length; r++) {
			for (int c = 0; c < res[r].length; c++) {
				System.out.print(res[r][c]+" ");
				if ((c+1)%3 == 0)
					System.out.print(' ');
			}
			System.out.println();
			if ((r+1)%3==0) {
				System.out.println();
			}
		}
		System.out.println(res[0][0]*100 + res[0][1]*10 + res[0][2]);
		String filename = "E:/Administrator's Documents/My Projects/Algorithm/src/net/projecteuler/sudoku.txt";
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(filename));
			String str = null;
			int sum = 0;
			while ((str = br.readLine()) != null) {
				int[][] A = new int[9][9];
				for (int r = 0; r < 9; r++) {
					str = br.readLine();
					for (int c = 0; c < 9; c++) {
						A[r][c] = str.charAt(c) - '0';
					}
				}					
				int[][] R = new Sudoku().solve(A);
				sum += R[0][0]*100 + R[0][1]*10 + R[0][2]; 
			}
			System.out.println(sum);
		}
		catch(IOException e) {
			System.out.println(e.getMessage());
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new p96();
	}

}
