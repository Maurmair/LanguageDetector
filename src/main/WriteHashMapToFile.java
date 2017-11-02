package main;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;


public class WriteHashMapToFile {

	public static void writeFile(HashMap<String, Double> hashMap, String outputLanguage) throws IOException{
		final String startFileName = "C:\\Texts\\";
		final String closingFileName = ".txt";
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(
				startFileName+outputLanguage+closingFileName))) {
			for (Entry<String, Double> entry : hashMap.entrySet()) {
				String key = entry.getKey();
				Double value = entry.getValue();
				bw.write(key + "=" + value.toString()+",");
//				bw.write(key + "= " + value.toString());
//				bw.newLine();
			}	
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
