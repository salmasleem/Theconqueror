package engine;
import java.io.*;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Read {
		public static ArrayList<String[]> readFile(String path) throws IOException{
		String currentLine = "";
		FileReader fileReader= new FileReader(path);
		BufferedReader br = new BufferedReader(fileReader);
		ArrayList<String[]> arr = new ArrayList<String[]>();
		while ((currentLine = br.readLine()) != null) {
			String[] elements = currentLine.split(",");
			arr.add(elements);
			
		}
		br.close();
		return arr;
		
		}
		
		public static void main(String[] args) throws IOException{
			readFile("cairo_army.csv");
			
		}
//	public static void readFile(String path) throws IOException{
//		String currentLine = "";
//		FileReader fileReader= new FileReader(path);
//		BufferedReader br = new BufferedReader(fileReader);
//		while ((currentLine = br.readLine()) != null) {
//		System.out.println(currentLine);
//		// Parsing the currentLine String
//		}
//		}
//		public static void main(String[] args) throws IOException{
//		readFile("cairo_army.csv");
//		
//		}
		

}
