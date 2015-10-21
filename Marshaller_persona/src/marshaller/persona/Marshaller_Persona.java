package marshaller.persona;

import java.io.File;
import java.util.ArrayList;

import javax.xml.transform.TransformerException;

public class Marshaller_Persona {

	public static void main(String[] args) {
		ArrayList<Persona> personas;

		// cargamos los datos
		personas = new ArrayList<Persona>();
		personas.add(new Persona("Manolo", 20));
		personas.add(new Persona("Pedro", 29));
		
		Marshaller marshaller = new Marshaller(personas);
		
		marshaller.crearDocumento();
		marshaller.crearArbolDOM();
		
		File file = new File("personas.xml");
		
		try {
			marshaller.escribirDocumentAXml(file);
		} catch (TransformerException e) {			
			e.printStackTrace();
		}

	}

}
