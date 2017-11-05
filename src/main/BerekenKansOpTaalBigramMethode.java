package main;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import java.util.List;
import java.util.Map;
public class BerekenKansOpTaalBigramMethode {
	public static void berekenKansBigrammen() throws IOException{		
		
		String gebruikersInput = krijgEnVerwerkGebruikersInput.ontvangGebruikersInvoerTekst();
		
		List<Double> kansenBi = new ArrayList<Double>(); 
		List<Double> kansenUni = new ArrayList<Double>(); 
		
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
		
		HashMap<String, Double> gebruikersInputBigram = krijgEnVerwerkGebruikersInput.gebruikersInputBigram(gebruikersInput);
		HashMap<String, Double> gebruikersInputUnigram = krijgEnVerwerkGebruikersInput.gebruikersInputUnigram(gebruikersInput);
		
		HashMap<String, Double> nederlandsBi = new HashMap<String, Double>();
		HashMap<String, Double> nederlandsUni = new HashMap<String, Double>();
		HashMap<String, Double> duitBi = new HashMap<String, Double>();
		HashMap<String, Double> duitsUni = new HashMap<String, Double>();
		HashMap<String, Double> engelBi = new HashMap<String, Double>();
		HashMap<String, Double> engelsUni= new HashMap<String, Double>();
		HashMap<String, Double> fransBi = new HashMap<String, Double>();
		HashMap<String, Double> fransUni = new HashMap<String, Double>();
		HashMap<String, Double> iteliaansBi = new HashMap<String, Double>();
		HashMap<String, Double> iteliaansUni= new HashMap<String, Double>();
		HashMap<String, Double> spaansBi = new HashMap<String, Double>();
		HashMap<String, Double> spaansUni = new HashMap<String, Double>();
		
		nederlandsBi.putAll(GenereerNGrams.getNGram(2, "HarryPotterNederlands"));
		nederlandsUni.putAll(GenereerNGrams.getNGram(1, "HarryPotterNederlands"));				
		duitBi.putAll(GenereerNGrams.getNGram(2, "HarryPotterDuits"));
		duitsUni.putAll(GenereerNGrams.getNGram(1, "HarryPotterDuits"));
		engelBi.putAll(GenereerNGrams.getNGram(2, "HarryPotterEngels"));
		engelsUni.putAll(GenereerNGrams.getNGram(1, "HarryPotterEngels"));	
		fransBi.putAll(GenereerNGrams.getNGram(2, "HarryPotterFrans"));
		fransUni.putAll(GenereerNGrams.getNGram(1, "HarryPotterFrans"));	
		iteliaansBi.putAll(GenereerNGrams.getNGram(2, "HarryPotterIteliaans"));
		iteliaansUni.putAll(GenereerNGrams.getNGram(1, "HarryPotterIteliaans"));	
		spaansBi.putAll(GenereerNGrams.getNGram(2, "HarryPotterSpaans"));
		spaansUni.putAll(GenereerNGrams.getNGram(1, "HarryPotterSpaans"));	
		
		kansOpNL = berekenKansOpTaal(kansenBi, kansenUni, noemer, teller, gebruikersInputBigram, gebruikersInputUnigram,
				nederlandsBi, nederlandsUni);
		kansOpDU = berekenKansOpTaal(kansenBi, kansenUni, noemer, teller, gebruikersInputBigram, gebruikersInputUnigram,
				duitBi, duitsUni);
		kansOpEN = berekenKansOpTaal(kansenBi, kansenUni, noemer, teller, gebruikersInputBigram, gebruikersInputUnigram,
				engelBi, engelsUni);
		kansOpFR = berekenKansOpTaal(kansenBi, kansenUni, noemer, teller, gebruikersInputBigram, gebruikersInputUnigram,
				fransBi, fransUni);
		kansOpIT = berekenKansOpTaal(kansenBi, kansenUni, noemer, teller, gebruikersInputBigram, gebruikersInputUnigram,
				iteliaansBi, iteliaansUni);
		kansOpSP = berekenKansOpTaal(kansenBi, kansenUni, noemer, teller, gebruikersInputBigram, gebruikersInputUnigram,
				spaansBi, spaansUni);
		
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

