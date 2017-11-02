package main;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Scanner;

@SuppressWarnings("unused")
public class krijgEnVerwerkGebruikersInput {

	public static Hashtable<String, Double> ontvangGebuikersinput() {
		Hashtable<String, Double> alleGrammen = new Hashtable<String, Double>();
		HashMap<String, Double> gebruikersInvoerTrigrammen = new HashMap<String, Double>();
		HashMap<String, Double> gebruikersInvoerBigrammen = new HashMap<String, Double>();		
		HashMap<String, Double> gebruikersInvoerUnigrammen = new HashMap<String, Double>();
		
		Scanner reader = new Scanner(System.in);
		System.out.println("Voer tekst in voor taalherkenning: ");
		String gebruikersInput = reader.nextLine();
		System.out.println(gebruikersInput);
		reader.close();

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
		
		for (int i = 0; i + 2 < gebruikersInput.length(); i++) {								
			String bigram = gebruikersInput.substring(i, i + 2);
			if (!gebruikersInvoerBigrammen.containsKey(bigram)) {
				gebruikersInvoerBigrammen.put(bigram, (double) 1);
			} else {
				Double waarde = gebruikersInvoerBigrammen.get(bigram);
				waarde = waarde + 1;
				gebruikersInvoerBigrammen.put(bigram, waarde);				
			}
		}
		
		for (int i = 0; i + 2 < gebruikersInput.length(); i++) {								
			String unigram = gebruikersInput.substring(i, i + 1);
			if (!gebruikersInvoerUnigrammen.containsKey(unigram)) {
				gebruikersInvoerUnigrammen.put(unigram, (double) 1);
			} else {
				Double waarde = gebruikersInvoerUnigrammen.get(unigram);
				waarde = waarde + 1;
				gebruikersInvoerUnigrammen.put(unigram, waarde);				
			}
		}
		alleGrammen.putAll(gebruikersInvoerTrigrammen);
		alleGrammen.putAll(gebruikersInvoerBigrammen);
		alleGrammen.putAll(gebruikersInvoerUnigrammen);
		System.out.println(alleGrammen.toString());
		return alleGrammen;
	}

}
