package OldCode;

import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


public class SavedCrit {

	/*
	 * Input fra GUI, save in .txt
	 * 
	 * save the following:
	 * - Person
	 * - capasity
	 * - projector
	 * - blackboard
	 * - teleslynge (hearing aid)
	 * 
	 * Save in one line with sepperators
	 */
	
	private static void writeToFile(String input) {
		//Writing to file
		//The name of the file to open
		String writeFileName = "Dokumenter IKKE KODE/savedCriterias.txt";
				
		try {
			// Assume default encoding
			FileWriter fileWriter = new FileWriter(writeFileName, true);
			//Always wrap FileWirter in BufferedWriter
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			
			//Note that write() does not automatically
			//append a newline character
			bufferedWriter.write(input);
			bufferedWriter.newLine();
			//bufferedWriter.write("This is Per's test");
			//bufferedWriter.newLine();
					
			// Always close files
			bufferedWriter.close();
		}
		catch(IOException ex) {
			System.out.println("Error writing to file '"
		                + writeFileName + "'");
			// Or we could just do this:
			// ex.printStackTrace();
		}
	}
	
		
	public static String setPersonCriterias(String name, int capasity, boolean projector,
			boolean blackboard, int hours, boolean hearingAid) {
		return "" + name + " : " + capasity + " : " + projector + " : " + blackboard + " : " + hours + " : " + hearingAid;
	}
	
	
	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		System.out.println("What is your name? ");
		String name = reader.nextLine();
		String crit = setPersonCriterias(name, 260, true, true, 4, true);
		writeToFile(crit);
		System.out.println("All went well");
	
	}
}

