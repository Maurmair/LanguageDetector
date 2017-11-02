package main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

@SuppressWarnings("unused")
public class Main {

	public static void main(String[] args) throws IOException {		
		
		WriteHashMapToFile.writeFile(GenereerNGrams.getNGram(3, "HarryPotterNederlands"), "NLTrigram");
		WriteHashMapToFile.writeFile(GenereerNGrams.getNGram(3, "HarryPotterDuits"), "GETrigram");
		WriteHashMapToFile.writeFile(GenereerNGrams.getNGram(3, "HarryPotterEngels"), "ENTrigram");
		WriteHashMapToFile.writeFile(GenereerNGrams.getNGram(3, "HarryPotterFrans"), "FRTrigram");
		WriteHashMapToFile.writeFile(GenereerNGrams.getNGram(3, "HarryPotterIteliaans"), "ITTrigram");
		WriteHashMapToFile.writeFile(GenereerNGrams.getNGram(3, "HarryPotterSpaans"), "SPTrigram");
		
		WriteHashMapToFile.writeFile(GenereerNGrams.getNGram(2, "HarryPotterNederlands"), "NLBigram");
		WriteHashMapToFile.writeFile(GenereerNGrams.getNGram(2, "HarryPotterDuits"), "GEBigram");
		WriteHashMapToFile.writeFile(GenereerNGrams.getNGram(2, "HarryPotterEngels"), "ENBigram");
		WriteHashMapToFile.writeFile(GenereerNGrams.getNGram(2, "HarryPotterFrans"), "FRBigram");
		WriteHashMapToFile.writeFile(GenereerNGrams.getNGram(2, "HarryPotterIteliaans"), "ITBigram");
		WriteHashMapToFile.writeFile(GenereerNGrams.getNGram(2, "HarryPotterSpaans"), "SPBigram");
		
		WriteHashMapToFile.writeFile(GenereerNGrams.getNGram(1, "HarryPotterNederlands"), "NLUnigram");
		WriteHashMapToFile.writeFile(GenereerNGrams.getNGram(1, "HarryPotterDuits"), "GEUnigram");
		WriteHashMapToFile.writeFile(GenereerNGrams.getNGram(1, "HarryPotterEngels"), "ENUnigram");
		WriteHashMapToFile.writeFile(GenereerNGrams.getNGram(1, "HarryPotterFrans"), "FRUnigram");
		WriteHashMapToFile.writeFile(GenereerNGrams.getNGram(1, "HarryPotterIteliaans"), "ITUnigram");
		WriteHashMapToFile.writeFile(GenereerNGrams.getNGram(1, "HarryPotterSpaans"), "SPUnigram");
	}
}
