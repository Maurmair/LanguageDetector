package main;

import java.io.IOException;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

@SuppressWarnings("unused")
public class BerekenKansOpTaalTrigramMethode {
	
	@SuppressWarnings("null")
	public static void berekenKansTrigrammen() throws IOException{		
				
		String gebruikersInput = krijgEnVerwerkGebruikersInput.ontvangGebruikersInvoerTekst();
		
		Double kansOpTrigram = (double) 1;
		Double kansOpBigram;
		Double tussenResultaat;
		Double eersteKeer = (double) 1;
		
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
		
		for (Map.Entry<String, Double> entry : nederlandsTri.entrySet()) {	
			for (Map.Entry<String, Double> entryTwee : gebruikersInputTrigram.entrySet()) {
				if (entryTwee.getKey() == entry.getKey()) {									
					kansOpTrigram *= entry.getValue();
				}
			}
		}
		System.out.println(kansOpTrigram);
	}
	
	
}


/*
GenereerNGrams.getNGram(3, "HarryPotterNederlands"), "NLTrigram");  
GenereerNGrams.getNGram(3, "HarryPotterDuits"), "GETrigram");       
GenereerNGrams.getNGram(3, "HarryPotterEngels"), "ENTrigram");      
GenereerNGrams.getNGram(3, "HarryPotterFrans"), "FRTrigram");       
GenereerNGrams.getNGram(3, "HarryPotterIteliaans"), "ITTrigram");   
GenereerNGrams.getNGram(3, "HarryPotterSpaans"), "SPTrigram");      
                                                                    
GenereerNGrams.getNGram(2, "HarryPotterNederlands"), "NLBigram");   
GenereerNGrams.getNGram(2, "HarryPotterDuits"), "GEBigram");        
GenereerNGrams.getNGram(2, "HarryPotterEngels"), "ENBigram");       
GenereerNGrams.getNGram(2, "HarryPotterFrans"), "FRBigram");        
GenereerNGrams.getNGram(2, "HarryPotterIteliaans"), "ITBigram");    
GenereerNGrams.getNGram(2, "HarryPotterSpaans"), "SPBigram");       
                                                                    
GenereerNGrams.getNGram(1, "HarryPotterNederlands"), "NLUnigram");  
GenereerNGrams.getNGram(1, "HarryPotterDuits"), "GEUnigram");       
GenereerNGrams.getNGram(1, "HarryPotterEngels"), "ENUnigram");      
GenereerNGrams.getNGram(1, "HarryPotterFrans"), "FRUnigram");       
GenereerNGrams.getNGram(1, "HarryPotterIteliaans"), "ITUnigram");   
GenereerNGrams.getNGram(1, "HarryPotterSpaans"), "SPUnigram");      
*/