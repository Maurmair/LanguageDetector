package main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

@SuppressWarnings("unused")
public class Main {

	public static void main(String[] args) throws IOException {		

		GenereerNGrams.printNGrams(2);
		GenereerNGrams.printNGrams(3);
		GenereerNGrams.printNGrams(1);
		
		WriteHashMapToFile.writeFile();
	}
}
