package marshaller.persona;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

public class Marshaller {
	
	private Document dom = null;
	private ArrayList<Persona> personas = null;

	public Marshaller(ArrayList<Persona> p) {
		personas = p;
	}
	
	public void crearDocumento() {
		// creamos una factory
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		try {
			// creamos un documentbuilder
			DocumentBuilder db = dbf.newDocumentBuilder();

			// creamos una instancia de DOM 
			dom = db.newDocument();		
		}catch(ParserConfigurationException pce) {
			pce.printStackTrace();
		}

	}
	
	public void crearArbolDOM() {

		// creamos el elemento raíz "personas"
		Element docEle = dom.createElement("personas");
		dom.appendChild(docEle);

		// recorremos
		Iterator it = personas.iterator();
		while (it.hasNext()) {
			Persona e = (Persona) it.next();
			// para cada objeto persona creamos el elemento <persona> y lo añadimos a la raíz
			Element personaEle = setPersona(e);
			docEle.appendChild(personaEle);
		}

	}
	
	private Element setPersona(Persona p) {

		// creamos el elemento persona
		Element PersonaEle = dom.createElement("persona");

		// creamos el elemento nombre y el nodo de texto y lo añadimos al elemento persona
		Element nombreEle = dom.createElement("nombre");		
		Text nombreTexto = dom.createTextNode(p.getNombre());
		nombreEle.appendChild(nombreTexto);
		PersonaEle.appendChild(nombreEle);

		// creamos el elemento edad y el nodo de valor entero y lo añadimos al elemento persona
		Element edadEle = dom.createElement("edad");
		Text edadTexto = dom.createTextNode(Integer.toString(p.getEdad()));
		edadEle.appendChild(edadTexto);
		PersonaEle.appendChild(edadEle);
		
		return PersonaEle;
	}
	
	public void escribirDocumentAXml(File file) throws TransformerException {

		// creamos una instacia para escribir el resultado
		Transformer trans = TransformerFactory.newInstance().newTransformer();
		trans.setOutputProperty(OutputKeys.INDENT, "yes");

		// especificamos dónde escribimos y la fuente de datos
		StreamResult result = new StreamResult(file);
		DOMSource source = new DOMSource(dom);
		trans.transform(source, result);

	}

}
