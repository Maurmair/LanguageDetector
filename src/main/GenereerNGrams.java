package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class GenereerNGrams {

	public static void printNGrams(Integer amountN) throws IOException {
	
		String tekst = "";
		Integer totalFrequentie = 0;
		HashMap<String, Integer> trigramns = new HashMap<String, Integer>();		
				
		try (BufferedReader br = new BufferedReader(new FileReader("C:\\Texts\\HarryPotterDutch.txt"))) {
			@SuppressWarnings("unused")
			String line = null;
			
			while ((line = br.readLine()) != null) {
				tekst = tekst + br.readLine();		
			}			
			for (int i = 0; i + 2 < tekst.length(); i++) {								
				String trigram = tekst.substring(i, i + amountN);
				if (!trigramns.containsKey(trigram)) {
					trigramns.put(trigram, 1);
					totalFrequentie ++;
				} else {
					Integer waarde = trigramns.get(trigram);
					waarde += 1;
					trigramns.put(trigram, waarde);
					totalFrequentie ++;
				}
			}
			
			List<Integer> mapValues = new ArrayList<>(trigramns.values());
			List<String> mapKeys = new ArrayList<>(trigramns.keySet());
			Collections.sort(mapValues);
			Collections.sort(mapKeys);
			
			LinkedHashMap<String, Integer> sortedMap = new LinkedHashMap<>();
			
			Iterator<Integer> valueIt = mapValues.iterator();
			while (valueIt.hasNext()) {
				Integer val = valueIt.next();
				Iterator<String> keyIt = mapKeys.iterator();
				
				while (keyIt.hasNext()) {
					String key = keyIt.next();
					Integer comp1 = trigramns.get(key);
					Integer comp2 = val;
					if (comp1.equals(comp2)) {
						keyIt.remove();
						sortedMap.put(key, val);
						break;
					}
				}
			}			
			
			for (Map.Entry<String, Integer> entry : sortedMap.entrySet()) {
				String key = entry.getKey();
				int value = entry.getValue();
				System.out.println(key + " => " + value); 
			}				
		}
	}
}
