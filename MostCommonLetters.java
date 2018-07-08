

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class MostCommonLetters {
	
	private static final int MAX_DIEZI = 20;

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String text = sc.nextLine();
		HashMap<Character, Integer> letters = new HashMap<>();
		for(int i = 0; i < text.length(); i++) {
			char c = text.charAt(i);
			if(Character.isAlphabetic(c)) {
				c = Character.toLowerCase(c);
				if(letters.containsKey(c)) {
					letters.put(c, letters.get(c)+1);
				}
				else {
					letters.put(c, 1);
				}
			}
		}
		
		ArrayList<Entry<Character, Integer>> entries = new ArrayList<>();
		entries.addAll(letters.entrySet());
		Collections.sort(entries, new Comparator<Entry<Character, Integer>>() {
			@Override
			public int compare(Entry<Character, Integer> o1, Entry<Character, Integer> o2) {
				if(o1.getValue() == o2.getValue()) {
					return o1.getKey() - o2.getKey();
				}
				return o2.getValue() - o1.getValue();
			}
		});
		
		System.out.println("Most common letters: ");
		System.out.println();
		
		int maxOccurances = 0;
		for(Entry<Character, Integer> e : entries) {
			if(maxOccurances == 0) {
				maxOccurances = e.getValue();
			}
			int currentOccurances = e.getValue();
			System.out.print(e.getKey() + " - " + e.getValue() + "  ");
			for(int i = 0; i < (MAX_DIEZI*currentOccurances)/maxOccurances; i++) {
				System.out.print("#");
			}
			System.out.println();
		}
	}
}
