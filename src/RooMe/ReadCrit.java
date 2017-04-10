package RooMe;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadCrit {

	private static void readFromFile() {

		//Reding from file
		// The name of the file to open
		String fileName = "Dokumenter IKKE KODE/savedCriterias.txt";
		
		// This will reference one line at a time
		String line = null;
		
		try {
			// FileReader reads texts files in the default encoding
			FileReader fileReader = new FileReader(fileName);
			
			// Always wrap FileReader in Buffered Reader
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			
			while((line = bufferedReader.readLine()) != null) {
				System.out.println(line);
				String[] parts = line.split(" : ");
				String name = parts[0];
				int capasity = Integer.parseInt(parts[1]);
				Boolean projector = Boolean.valueOf(parts[2]);
				Boolean blackBoard = Boolean.valueOf(parts[3]);
				int hours = Integer.parseInt(parts[4]);
				Boolean hearingAid = Boolean.valueOf(parts[5]);
				System.out.println(name);
				System.out.println(capasity);
				System.out.println(projector);
			}
			
			// Always close files
			bufferedReader.close();
		}
		catch(FileNotFoundException exe) {
			System.out.println("Unable to open file '" + fileName + "'");
		}
		catch(IOException exe) {
			System.out.println("Error reading file '" + fileName + "'");
		}
	}
	
	public static void main(String[] args) {
		readFromFile();
	}
}
