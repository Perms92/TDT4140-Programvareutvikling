package OldCode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Subject {
	private String subjectName;
	private String teacher; //this should be a Person object
	private ArrayList relatedClasses = new ArrayList<>();
	private String room; //should be a Room object
	
	public Subject(String name, String teacher) {
		this.subjectName = name;
		this.teacher = teacher;
	}
	
	public ArrayList addRelatedClass(String classes) {
		relatedClasses.add(classes);
		return relatedClasses;
	}
	
	//saving related classes in textfile 
	public static void save(String text) throws FileNotFoundException {
		File fnew = new File("/Users/Creztian/Documents/workspace/RooME/src/Timetable/relatedClasses.txt");
		BufferedWriter writer = null;
		try{
		    writer = new BufferedWriter( new FileWriter(fnew, true)); //true or false turns on/off overwriting
		    writer.write( text + "\n");
		}
		catch ( IOException e){
		}
		finally{
		    try{
		        if ( writer != null)
		        writer.close( );
		    }
		    catch ( IOException e){
		    }
		}
	}
	
	//read from textfile with related classes	
	public static String read() throws IOException {
		String fnew = "/Users/Creztian/Documents/workspace/RooME/src/Timetable/relatedClasses.txt";
		BufferedReader br = new BufferedReader(new FileReader(fnew));
		try {
		    StringBuilder sb = new StringBuilder();
		    String line = br.readLine();

		    while (line != null) {
		        sb.append(line);
		        sb.append(System.lineSeparator());
		        line = br.readLine();
		    }
		    String everything = sb.toString();
		    
		   //testing to print out what we read from the file
		    //System.out.println(everything);
		    return everything;
		} finally {
		    br.close();
		}
	}
	
	public static void main(String[] args) throws IOException{
		save("Komtek");	
		save("Informatikk");
		System.out.println(read());
	}
}
