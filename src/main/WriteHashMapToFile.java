package main;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


public class WriteHashMapToFile {

	
	

	public static void writeFile() throws IOException{
		final String FILENAME = "C:\\Texts\\HashMapHPDutch.txt";
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILENAME))) {

			String content = "This is the content to write into file\n";

			bw.write(content);

			// no need to close it.
			//bw.close();

			System.out.println("Done");

		} catch (IOException e) {

			e.printStackTrace();

		}
//		try {
//			final String FILENAME = "C:\\Texts\\HashMapHPDutch.txt";
//			BufferedWriter bw = null;
//			FileWriter fw = null;
//			String content = "This is the contenasdddddddddddddddt to write into file";
//
//			fw = new FileWriter(FILENAME);
//			bw = new BufferedWriter(fw);
//			bw.write(content);
//
//			System.out.println("Done");
//
//		} catch (IOException e) {
//
//			e.printStackTrace();
//
//		} finally {
//
//			try {
//
//				if (bw != null)
//					bw.close();
//
//				if (fw != null)
//					fw.close();
//
//			} catch (IOException ex) {
//
//				ex.printStackTrace();
//
//			}
//
//		}
	}
	
}
