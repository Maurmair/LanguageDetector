package main;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class WriteHashMapToFile {

	public static void writeFile(HashMap<String, Integer> nGram, String outputLanguage) throws IOException{
		final String startFileName = "C:\\Texts\\";
		final String closingFileName = ".txt";
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(
				startFileName+outputLanguage+closingFileName))) {
			for (Map.Entry<String, Integer> entry : nGram.entrySet()) {
				String key = entry.getKey();
				Integer value = entry.getValue();
				bw.write(key + "=" + value.toString()+",");
//				bw.write(key + "= " + value.toString());
//				bw.newLine();
			}	
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
