package net.projecteuler;

import java.io.BufferedReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.TreeSet;
import static java.lang.Math.min;
import static java.lang.Math.max;

public class p107 {
	class Edge implements Comparable<Edge> {
		private int u, v, weight;
		public int get_u() {
			return u;
		}
		public int get_v() {
			return v;
		}
		public int get_weight() {
			return weight;
		}
		public Edge(int u, int v, int weight) {
			this.u = u;
			this.v = v;
			this.weight = weight;
		}
		@Override
		public int compareTo(Edge e) {
			if (this.weight == e.weight) {
				if (min(this.u,this.v) == min(e.u,e.v)) 
					if (max(this.u,this.v) == max(e.u,e.v))
						return max(this.u,this.v) - max(e.u,e.v);
					else
						return 0;
				else
					return min(this.u,this.v) - min(e.u,e.v);
			}
			else {
				return this.weight - e.weight;
			}
		}
	}
	
	private TreeSet<Edge> edges = new TreeSet<Edge>();
	
	int vertices = 0;
	
	int all_sum = 0;
	
	void readInput(String filename) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(filename));
			String s;
			while ((s = br.readLine()) != null) {
				String[] token = s.split(",");
				for (int i = 0; i < token.length; i++) {
					if (!token[i].equals("-")) {
						edges.add(new Edge(vertices, i, Integer.parseInt(token[i])));
						all_sum += Integer.parseInt(token[i]);
					}
					while(token[i].length() < 4) {
						token[i] = " " + token[i];
					}
					System.out.print(token[i]);
				}
				System.out.println();
				++vertices;
			}
			System.out.println(vertices);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	int[] tree_id;
	TreeSet<Integer>[] trees;
	
	void update(Edge e) {
		int v_id = tree_id[e.get_v()];
		int u_id = tree_id[e.get_u()];
		for (Integer i:trees[v_id]) {
			tree_id[i] = tree_id[u_id];
		}
		trees[u_id].addAll(trees[v_id]);
		trees[v_id] = null;
	}
	
	void init_tree_id(int vertices) {
		tree_id = new int[vertices+1];
		for (int i = 0; i < vertices; i++) {
			tree_id[i] = i;
		}
	}
	
	void init_trees(int vertices) {
		trees = new TreeSet[vertices];
		for (int i = 0; i < vertices; i++) {
			trees[i] = new TreeSet<Integer>();
			trees[i].add(i);
		}
	}
	
	public p107() {
		readInput("E:/Administrator's Documents/My Projects/Algorithm/src/net/projecteuler/network.txt");
		
		init_tree_id(vertices);
		init_trees(vertices);
		
		int count = 0;
		
		long sum = 0;
		
		do {
			Edge e = edges.pollFirst();
			if (tree_id[e.get_u()] != tree_id[e.get_v()]) {
				update(e);
				sum += e.get_weight();
				++count;
			}
		} while (count < vertices-1);
		System.out.println(all_sum/2);
		System.out.println(sum);
		System.out.println("saved: "+ ((all_sum/2) - sum));
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new p107();
	}

}
