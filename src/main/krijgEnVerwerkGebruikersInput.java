package main;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Scanner;

@SuppressWarnings("unused")
public class krijgEnVerwerkGebruikersInput {	
	
	public static HashMap<String, Double> gebruikersInputTrigram(String gebruikersInput){
		HashMap<String, Double> gebruikersInvoerTrigrammen = new HashMap<String, Double>();
		
		for (int i = 0; i + 2 < gebruikersInput.length(); i++) {								
			String trigram = gebruikersInput.substring(i, i + 3);
			if (!gebruikersInvoerTrigrammen.containsKey(trigram)) {
				gebruikersInvoerTrigrammen.put(trigram, (double) 1);
			} else {
				Double waarde = gebruikersInvoerTrigrammen.get(trigram);
				waarde = waarde + 1;
				gebruikersInvoerTrigrammen.put(trigram, waarde);				
			}
		}
		return gebruikersInvoerTrigrammen;
	}
	
	public static HashMap<String, Double> gebruikersInputBigram(String gebruikersInput){
		HashMap<String, Double> gebruikersInvoerBigrammen = new HashMap<String, Double>();
		
		for (int i = 0; i + 2 < gebruikersInput.length(); i++) {								
			String trigram = gebruikersInput.substring(i, i + 2);
			if (!gebruikersInvoerBigrammen.containsKey(trigram)) {
				gebruikersInvoerBigrammen.put(trigram, (double) 1);
			} else {
				Double waarde = gebruikersInvoerBigrammen.get(trigram);
				waarde = waarde + 1;
				gebruikersInvoerBigrammen.put(trigram, waarde);				
			}
		}
		return gebruikersInvoerBigrammen;
	}
	
	public static HashMap<String, Double> gebruikersInputUnigram(String gebruikersInput){
		HashMap<String, Double> gebruikersInvoerUnigrammen = new HashMap<String, Double>();
		
		for (int i = 0; i + 2 < gebruikersInput.length(); i++) {								
			String trigram = gebruikersInput.substring(i, i + 1);
			if (!gebruikersInvoerUnigrammen.containsKey(trigram)) {
				gebruikersInvoerUnigrammen.put(trigram, (double) 1);
			} else {
				Double waarde = gebruikersInvoerUnigrammen.get(trigram);
				waarde = waarde + 1;
				gebruikersInvoerUnigrammen.put(trigram, waarde);				
			}
		}
		return gebruikersInvoerUnigrammen;
	}
	
	static String ontvangGebruikersInvoerTekst(){
		Scanner reader = new Scanner(System.in);
		System.out.println("Voer tekst in voor taalherkenning: ");
		String gebruikersInput = reader.nextLine().toLowerCase();
		System.out.println(gebruikersInput);
		reader.close();
		return gebruikersInput;
	}
}
