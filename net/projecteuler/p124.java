package net.projecteuler;

import java.util.HashMap;
import java.util.TreeSet;

import lib.Utils;

class Data implements Comparable {
	int rad = 1;
	long value;
	public Data(long i) {
		value = i;
		HashMap<Long, Integer> info = new HashMap<Long, Integer>();
		Utils.getPrimeDivisors(i, info);
		for (Long base:info.keySet()) {
			rad *= base;
		}
	}
	@Override
	public int compareTo(Object o) {
		if (rad == ((Data)o).rad)
			return (int)(value - ((Data)o).value);
		else
			return rad - ((Data)o).rad;
	}
	public long getValue() {
		return value;
	}
}

public class p124 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TreeSet<Data> tree = new TreeSet<Data>();
		for (int i = 1; i <= 100000;i++)
			tree.add(new Data(i));
		for (int i = 1; i <= 10000; i++)
			System.out.println(tree.pollFirst().getValue());
	}
}
