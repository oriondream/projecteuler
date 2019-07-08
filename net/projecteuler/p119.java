package net.projecteuler;

import java.math.BigInteger;
import java.util.TreeSet;

public class p119 {
	static boolean check(BigInteger K) {
		String s = K.toString();
		if (s.length() < 2)
			return false;
		long sum = 0;
		for (int i = 0; i < s.length(); i++) {
			sum += s.charAt(i) - '0';
		}
		if (sum == 1)
			return false;
		BigInteger bisum = new BigInteger(Long.toString(sum));
		BigInteger N = BigInteger.ONE;
		while (N.compareTo(K) < 0)
			N = N.multiply(bisum);
		if (N.equals(K))
			return true; 
		else
			return false;
	}
	public class Data implements Comparable<Data> {
		private BigInteger base;
		private BigInteger power;
		private BigInteger value;
		void upgrade() {
			power = power.add(BigInteger.ONE);
			value = value.multiply(base);
		}
		public Data(int base, int power) {
			this.base  = new BigInteger(Integer.toString(base));
			this.power = new BigInteger(Integer.toString(power));
			value = BigInteger.ONE;
			for (int i = 1; i <= power; i++) {
				value = value.multiply(this.base);
			}
		}
		public BigInteger getBase() {
			return base;
		}
		public BigInteger getPower() {
			return power;
		}
		public BigInteger getValue() {
			return value;
		}
		@Override
		public int compareTo(Data arg0) {
			BigInteger v = arg0.getValue();
			BigInteger b = arg0.getBase();
			if (value.equals(v)) {
				if (base.equals(b)) {
					return 0;
				}
				else {
					if (base.compareTo(b) < 0) {
						return -1;
					}
					else {
						return 1;
					}
				}
			}
			else {
				if (value.compareTo(v) < 0) {
					return -1;
				}
				else {
					return 1;
				}
			}
		}
	}
	public p119() {
		TreeSet<Data> list = new TreeSet<Data>();
		
		TreeSet<BigInteger> results = new TreeSet<BigInteger>();
		
		for (int i = 2; i <= 100000; i++) {
			list.add(new Data(i,2));
		}
		int count = 0;
		while (results.size() < 30) {
			Data d = list.pollFirst();
			if (check(d.getValue()) && !results.contains(d.getValue())) {
				results.add(d.getValue());
				++count;
				System.out.println(count + ": " + d.getValue());
			}
			d.upgrade();
			list.add(d);
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new p119();
	}

}
