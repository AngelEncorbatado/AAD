package streams;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Streams {

	public static void main(String[] args) throws IOException {
		
		FileReader fr = new FileReader("entrada.txt");
			
		int c;
		
		FileWriter fw = new FileWriter("salida.txt");
		
		System.out.print("He leído ");		
		while((c=fr.read())!=-1){
			System.out.print((char)c);
			fw.write(c);
		}
		
		fr.close();
		fw.close();		

	}

}
