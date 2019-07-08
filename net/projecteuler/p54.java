package net.projecteuler;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class p54 {
	String[] fixCards(String[] result) {
		for (int i = 0; i < result.length; i++) {
			switch (result[i].charAt(0)) {
			case 'T': result[i] = result[i].replace('T', 'A'); break;
			case 'J': result[i] = result[i].replace('J', 'B'); break;
			case 'Q': result[i] = result[i].replace('Q', 'C'); break;
			case 'K': result[i] = result[i].replace('K', 'D'); break;
			case 'A': result[i] = result[i].replace('A', 'E'); break;
			}
		}
		return result;
	}
	char highCard(String[] cards) {
		char highest = '1';
		for (int i = 0; i < cards.length; i++) {
			if (cards[i].charAt(0) > highest) {
				highest = cards[i].charAt(0); 
			}
		}
		return highest;
	}
	char onePair(String[] cards) {
		for (int i = 0; i < cards.length - 1; i++)
			for (int j = i+1; j < cards.length; j++)
				if (cards[i].charAt(0) == cards[j].charAt(0))
					return cards[i].charAt(0);
		return 0;
	}
	char twoPairs(String[] cards) {
		for (int i = 0; i < cards.length - 1; i++)
			for (int j = i+1; j < cards.length; j++)
				if (cards[i].charAt(0) == cards[j].charAt(0)) {
					for (int x = i+1; x < cards.length-1; x++)
						for (int y = x+1; y < cards.length; y++)
							if (cards[x].charAt(0) == cards[y].charAt(0) && (cards[x].charAt(0) != cards[i].charAt(0))) {
								if (cards[x].charAt(0) > cards[x].charAt(i))
									return cards[x].charAt(0);
								else 
									return cards[x].charAt(i);
							}
				}
		return 0;
	}
	char threeOfAkind(String[] cards) {
		for (int i = 0; i < cards.length - 2; i++)
			for (int j = i+1; j < cards.length - 1; j++)
				if (cards[i].charAt(0) == cards[j].charAt(0))
					for (int k = j+1; k < cards.length; k++)
						if (cards[i].charAt(0) == cards[k].charAt(0)) {
							return cards[i].charAt(0);
						}
		return 0;
	}
	char fullHouse(String[] cards) {
		char[] c = new char[cards.length];
		for (int i = 0; i < c.length; i++)
			c[i] = cards[i].charAt(0);
		// sort
		for (int i = 0; i < c.length - 1; i++) {
			int choice = i;
			for (int j = i+1; j < c.length; j++)
				if (c[j] < c[choice]) 
					choice = j;
			char temp = c[i];
			c[i] = c[choice];
			c[choice] = temp;
		}
		if (c[0] == c[1] && c[1] == c[2] && c[3] == c[4]) {
			return c[0];
		}
		if (c[0] == c[1] && c[2] == c[3] && c[3] == c[4]) {
			return c[3];
		}
		return 0;
	}
	char fourOfAkind(String[] cards) {
		char[] c = new char[cards.length];
		for (int i = 0; i < c.length; i++)
			c[i] = cards[i].charAt(0);
		// sort
		for (int i = 0; i < c.length - 1; i++) {
			int choice = i;
			for (int j = i+1; j < c.length; j++)
				if (c[j] < c[choice]) 
					choice = j;
			char temp = c[i];
			c[i] = c[choice];
			c[choice] = temp;
		}
		if (c[0] == c[1] && c[1] == c[2] && c[2] == c[3]) {
			return c[0];
		}
		if (c[3] == c[4] && c[1] == c[2] && c[2] == c[3]) {
			return c[4];
		}
		return 0;
	}
	char straightFlush(String[] cards) {
		char[] c = new char[cards.length];
		for (int i = 0; i < c.length; i++)
			c[i] = cards[i].charAt(0);
		// sort
		for (int i = 0; i < c.length - 1; i++) {
			int choice = i;
			for (int j = i+1; j < c.length; j++)
				if (c[j] < c[choice]) 
					choice = j;
			char temp = c[i];
			c[i] = c[choice];
			c[choice] = temp;
		}
		// check straight
		int i = 0;
		while (i < c.length - 1) {
			if (c[i] + 1 == c[i+1] || (c[i] == '9' && c[i+1] == 'A')) 
				++i;
			else 
				return 0;
		}
		for (i = 0; i < cards.length - 1; i++)
			if (cards[i].charAt(1) != cards[i+1].charAt(1))
				return 0;
		return highCard(cards);
	}
	boolean royalFlush(String[] cards) {
		char[] c = new char[cards.length];
		for (int i = 0; i < c.length; i++)
			c[i] = cards[i].charAt(0);
		// sort
		for (int i = 0; i < c.length - 1; i++) {
			int choice = i;
			for (int j = i+1; j < c.length; j++)
				if (c[j] < c[choice]) 
					choice = j;
			char temp = c[i];
			c[i] = c[choice];
			c[choice] = temp;
		}
		// check royal
		if (c[0] != 'A' || c[1] != 'B' || c[2] != 'C' || c[3] != 'D' || c[4] != 'E') 
			return false;
		for (int i = 0; i < cards.length - 1; i++)
			if (cards[i].charAt(1) != cards[i+1].charAt(1))
				return false;
		return true;
	}
	char flush(String[] cards) {
		for (int i = 0; i < cards.length-1; i++)
			if (cards[i].charAt(1) != cards[i+1].charAt(1))
				return 0;
		return highCard(cards);
	}
	char straight(String[] cards) {
		char[] c = new char[cards.length];
		for (int i = 0; i < c.length; i++)
			c[i] = cards[i].charAt(0);
		// sort
		for (int i = 0; i < c.length - 1; i++) {
			int choice = i;
			for (int j = i+1; j < c.length; j++)
				if (c[j] < c[choice]) 
					choice = j;
			char temp = c[i];
			c[i] = c[choice];
			c[choice] = temp;
		}
		int i = 0;
		while (i < c.length - 1) {
			if (c[i] + 1 == c[i+1] || (c[i] == '9' && c[i+1] == 'A')) 
				++i;
			else 
				return 0;
		}
		return c[i];
	}
	
	boolean compare(String[] h1, String[] h2) {
		int score1 = 0, score2 = 0;
		char sup1 = 1, sup2 = 1 ;
					
		if (royalFlush(h1)) 
			score1 = 10;
		else if ((sup1 = straightFlush(h1)) != 0) {
			score1 = 9; 
		} else if ((sup1 = fourOfAkind(h1)) != 0) {
			score1 = 8;
		} 
		else if ((sup1 = fullHouse(h1)) != 0) {
			score1 = 7;
		}
		else if ((sup1 = flush(h1)) != 0) {
			score1 = 6;
		}		
		else if ((sup1 = straight(h1)) != 0) {
			score1 = 5;
		}
		else if ((sup1 = threeOfAkind(h1)) != 0) {
			score1 = 4;
		}
		else if ((sup1 = twoPairs(h1)) != 0) {
			score1 = 3;
		}
		else if ((sup1 = onePair(h1)) != 0) {
			score1 = 2;
		}
		else {
			score1 = 1; sup1 = highCard(h1);
		}
		//////////////////////////////////////////
		if (royalFlush(h2)) 
			score2 = 10;
		else if ((sup2 = straightFlush(h2)) != 0) {
			score2 = 9;			
		} else if ((sup2 = fourOfAkind(h2)) != 0) {
			score2 = 8;
		} 
		else if ((sup2 = fullHouse(h2)) != 0) {
			score2 = 7;
		}
		else if ((sup2 = flush(h2)) != 0) {
			score2 = 6;
		}		
		else if ((sup2 = straight(h2)) != 0) {
			score2 = 5;
		}
		else if ((sup2 = threeOfAkind(h2)) != 0) {
			score2 = 4;
		}
		else if ((sup2 = twoPairs(h2)) != 0) {
			score2 = 3;
		}
		else if ((sup2 = onePair(h2)) != 0) {
			score2 = 2;
		}
		else {
			score2 = 1; sup2 = highCard(h2);
		}
		
		if (score1 > score2)
			return true;
		else
			if (score1 == score2)
				if (sup1 > sup2)
					return true;
				else
					if (sup1 == sup2) {
						for (int i = 0; i < h1.length; i++)
							System.out.print(h1[i] + " ");
						System.out.print(" ---- ");
						for (int i = 0; i < h2.length; i++)
							System.out.print(h2[i] + " ");
						System.out.println();
					}
						
		return false;
	}
	
	public p54() {
		try {
			BufferedReader br = new BufferedReader(new FileReader("C:/temp/poker.txt"));
			String str;
			int count = 0;
			while ((str = br.readLine()) != null) {
				String[] a = str.split(" ");
				a = fixCards(a);
				String[] h1 = {a[0], a[1], a[2], a[3], a[4]};
				String[] h2 = {a[5], a[6], a[7], a[8], a[9]};
				
				if (compare(h1, h2)) 
					++count;
			}
			System.out.println(count);
		}
		catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new p54();
	}

}
