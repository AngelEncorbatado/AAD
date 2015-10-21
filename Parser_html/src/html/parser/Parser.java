package html.parser;

import java.io.File;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class Parser {

	public static void main(String args[]) {

		
		Document htmlFile = null;
		try {
			htmlFile = Jsoup.parse(new File("personas.html"), "UTF-8");
		} catch (IOException e) {
			// TODO Auto-generated catch block e.printStackTrace();
		} 
		String title = htmlFile.title();
		System.out.println("Título : " + title);
		
		String h1 = htmlFile.getElementsByTag("h1").text();
		System.out.println("H1 : " + h1);				
		
		Element tabla = htmlFile.getElementById("tabla");
		System.out.println("Tabla: " + tabla.getAllElements().get(0));

	}

}
