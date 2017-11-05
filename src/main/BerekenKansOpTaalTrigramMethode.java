package main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

@SuppressWarnings("unused")
public class BerekenKansOpTaalTrigramMethode {
	
	@SuppressWarnings("null")
	public static void berekenKansTrigrammen() throws IOException{		
				
		String gebruikersInput = krijgEnVerwerkGebruikersInput.ontvangGebruikersInvoerTekst();
		
		List<Double> kansenTri = new ArrayList<Double>(); 
		List<Double> kansenBi = new ArrayList<Double>(); 
		
		Double noemer = (double) 1;
		Double teller = (double) 1;
		Double kansOpNL = (double) 1;
		Double kansOpDU = (double) 1;
		Double kansOpIT = (double) 1;
		Double kansOpEN = (double) 1;
		Double kansOpFR = (double) 1;
		Double kansOpSP = (double) 1;
		Double eersteKeer = (double) 1;
		
		HashMap<String, Double> kansOpTalen = new HashMap<String, Double>();
		
		HashMap<String, Double> gebruikersInputTrigram = krijgEnVerwerkGebruikersInput.gebruikersInputTrigram(gebruikersInput);
		HashMap<String, Double> gebruikersInputBigram = krijgEnVerwerkGebruikersInput.gebruikersInputBigram(gebruikersInput);
		
		HashMap<String, Double> nederlandsTri = new HashMap<String, Double>();
		HashMap<String, Double> nederlandsBi = new HashMap<String, Double>();
		HashMap<String, Double> duitTri = new HashMap<String, Double>();
		HashMap<String, Double> duitsBi = new HashMap<String, Double>();
		HashMap<String, Double> engelsTri = new HashMap<String, Double>();
		HashMap<String, Double> engelsBi= new HashMap<String, Double>();
		HashMap<String, Double> fransTri = new HashMap<String, Double>();
		HashMap<String, Double> fransBi = new HashMap<String, Double>();
		HashMap<String, Double> iteliaansTri = new HashMap<String, Double>();
		HashMap<String, Double> iteliaansBi= new HashMap<String, Double>();
		HashMap<String, Double> spaansTri = new HashMap<String, Double>();
		HashMap<String, Double> spaansBi = new HashMap<String, Double>();
		
		nederlandsTri.putAll(GenereerNGrams.getNGram(3, "HarryPotterNederlands"));
		nederlandsBi.putAll(GenereerNGrams.getNGram(2, "HarryPotterNederlands"));				
		duitTri.putAll(GenereerNGrams.getNGram(3, "HarryPotterDuits"));
		duitsBi.putAll(GenereerNGrams.getNGram(2, "HarryPotterDuits"));
		engelsTri.putAll(GenereerNGrams.getNGram(3, "HarryPotterEngels"));
		engelsBi.putAll(GenereerNGrams.getNGram(2, "HarryPotterEngels"));	
		fransTri.putAll(GenereerNGrams.getNGram(3, "HarryPotterFrans"));
		fransBi.putAll(GenereerNGrams.getNGram(2, "HarryPotterFrans"));	
		iteliaansTri.putAll(GenereerNGrams.getNGram(3, "HarryPotterIteliaans"));
		iteliaansBi.putAll(GenereerNGrams.getNGram(2, "HarryPotterIteliaans"));	
		spaansTri.putAll(GenereerNGrams.getNGram(3, "HarryPotterSpaans"));
		spaansBi.putAll(GenereerNGrams.getNGram(2, "HarryPotterSpaans"));	
		
		kansOpNL = berekenKansOpTaal(kansenTri, kansenBi, noemer, teller, gebruikersInputTrigram, gebruikersInputBigram,
				nederlandsTri, nederlandsBi);
		kansOpDU = berekenKansOpTaal(kansenTri, kansenBi, noemer, teller, gebruikersInputTrigram, gebruikersInputBigram,
				duitTri, duitsBi);
		kansOpEN = berekenKansOpTaal(kansenTri, kansenBi, noemer, teller, gebruikersInputTrigram, gebruikersInputBigram,
				engelsTri, engelsBi);
		kansOpFR = berekenKansOpTaal(kansenTri, kansenBi, noemer, teller, gebruikersInputTrigram, gebruikersInputBigram,
				fransTri, fransBi);
		kansOpIT = berekenKansOpTaal(kansenTri, kansenBi, noemer, teller, gebruikersInputTrigram, gebruikersInputBigram,
				iteliaansTri, iteliaansBi);
		kansOpSP = berekenKansOpTaal(kansenTri, kansenBi, noemer, teller, gebruikersInputTrigram, gebruikersInputBigram,
				spaansTri, spaansBi);
		
		kansOpTalen.put("Nederlands", kansOpNL);
		kansOpTalen.put("Duits", kansOpDU);
		kansOpTalen.put("Engels", kansOpEN);
		kansOpTalen.put("Frans", kansOpFR);
		kansOpTalen.put("Italiaans", kansOpIT);
		kansOpTalen.put("Spaans", kansOpSP);
		
		Double uitkomst = Double.valueOf(0);
		String antwoord = "";
		
		for (Map.Entry<String, Double> entry : kansOpTalen.entrySet()) {
			if (entry.getValue() > uitkomst) {
				uitkomst = entry.getValue();
				antwoord = entry.getKey();
			}
		}
		System.out.println(antwoord);
	}
	
	

	private static Double berekenKansOpTaal(List<Double> kansenTri, List<Double> kansenBi, Double noemer, Double teller,
			HashMap<String, Double> gebruikersInputTrigram, HashMap<String, Double> gebruikersInputBigram,
			HashMap<String, Double> nederlandsTri, HashMap<String, Double> nederlandsBi) {
		Double kansOpTaal;
		for (Map.Entry<String, Double> entry : nederlandsTri.entrySet()) {	
			if (gebruikersInputTrigram.containsKey(entry.getKey())) {
				kansenTri.add(entry.getValue());
			}
		}
		
		for (Double i : kansenTri) {
			noemer *= i;
		}
		
		for (Map.Entry<String, Double> entry : nederlandsBi.entrySet()) {	
			if (gebruikersInputBigram.containsKey(entry.getKey())) {
				kansenBi.add(entry.getValue());
			}
		}
		
		for (Double i : kansenBi) {
			teller *= i;
		}
		
		kansOpTaal = noemer / teller;
		return kansOpTaal;
	}	
}