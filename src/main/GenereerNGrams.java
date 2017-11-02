package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class GenereerNGrams {

	public static HashMap<String, Double> getNGram(Integer amountN, String fileName) throws IOException {
		final String startFileName = "C:\\Texts\\";
		final String closingFileName = ".txt";
		String tekst = "";
		Integer totalFrequentie = 0;
		HashMap<String, Double> trigramns = new HashMap<String, Double>();		
		HashMap<String, Double> kansen = new HashMap<String, Double>();
				
		try (BufferedReader br = new BufferedReader(new FileReader(startFileName+fileName+closingFileName))) {
			@SuppressWarnings("unused")
			String line = null;
			
			while ((line = br.readLine()) != null) {
				tekst = tekst + br.readLine();		
			}			
			
			for (int i = 0; i + 2 < tekst.length(); i++) {								
				String trigram = tekst.substring(i, i + amountN);
				if (!trigramns.containsKey(trigram)) {
					trigramns.put(trigram, (double) 1);
					totalFrequentie ++;
				} else {
					Double waarde = trigramns.get(trigram);
					waarde = waarde + 1;
					trigramns.put(trigram, waarde);
					totalFrequentie ++;
				}
			}	
			
//			List<Integer> mapValues = new ArrayList<>(trigramns.values());
//			List<String> mapKeys = new ArrayList<>(trigramns.keySet());
//			Collections.sort(mapValues);
//			Collections.sort(mapKeys);
//			LinkedHashMap<String, Integer> sortedMap = new LinkedHashMap<>();
//			Iterator<Integer> valueIt = mapValues.iterator();
//			while (valueIt.hasNext()) {
//				Integer val = valueIt.next();
//				Iterator<String> keyIt = mapKeys.iterator();
//				while (keyIt.hasNext()) {
//					String key = keyIt.next();
//					Integer comp1 = trigramns.get(key);
//					Integer comp2 = val;
//					if (comp1.equals(comp2)) {
//						keyIt.remove();
//						sortedMap.put(key, val);
//						break;
//					}
//				}
//			}	
			
			
			/*
			 * //Frequenties omzetten naar kansen
					dictionary.forEach(function(value,key){
						var kans = value / (text.length - 2);
						dictionary.set(key,kans);
					});
			 */
			for (Map.Entry<String, Double> entry : trigramns.entrySet()) {				
				String key = entry.getKey();
				Double value = entry.getValue();
				Double kans = value / (tekst.length() - 2);
//				entry.setValue(kans);
				kansen.put(key, kans);
				System.out.println(key + " => " + value);
				System.out.println(key + " => " + kans); 
			}	
//			return sortedMap;
			return kansen;
		}
	}
}
