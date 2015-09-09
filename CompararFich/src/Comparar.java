import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Comparar {

	static boolean compararContenido(File f1, File f2) throws IOException {
		
		//Definicion de variables de inicio
		String str1 = "";
		String str2 = "";
		String str10 = "";
		String str20 = "";
		
		FileReader fichero1 = new FileReader(f1);
		FileReader fichero2 = new FileReader(f2);

		BufferedReader bf1 = new BufferedReader(fichero1);
		BufferedReader bf2 = new BufferedReader(fichero2);

		// compara linea por linea
		while (str1 != null || str2 != null) {
			str1 = bf1.readLine();
			str2 = bf2.readLine();

			str10 = str10 + str1;
			str20 = str20 + str2;

		}

		System.out.println(str10);
		System.out.println(str20);

		if (str10.matches(str20) == true) {
			fichero1.close();
			fichero2.close();
			bf1.close();
			bf2.close();
			
			return true;
		}
		
		fichero1.close();
		fichero2.close();
		bf1.close();
		bf2.close();

		return false;

	}

	public static void main(String[] args) throws IOException {
		
		File fitxer1 = new File("fichero.txt");
		File fitxer2 = new File("fichero2.txt");
		
		boolean ret=compararContenido(fitxer1,fitxer2);
		
		System.out.println("El valor tornat es "+ret);		
		

	}

}
