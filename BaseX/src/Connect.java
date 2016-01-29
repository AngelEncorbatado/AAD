
import java.io.IOException;

import org.basex.server.ClientSession;

public class Connect {

	public static void main(String[] args) {
		
		//String BBDD = "personas2";
		ClientSession session = null;
		try {
			// Abrimos la sesión
			session = new ClientSession("localhost", 1984, "admin", "admin");
			//session.execute("open " + BBDD);
			
			String cad = "for $c in doc('personas')/personas/persona return $c/nombre";
			//String cad = "//personas/persona/nombre";

			// Ejecutamos la consulta
			System.out.println("Ejecutamos consulta: " + cad);
			System.out.println(session.query(cad).execute());
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally { // Cerramos la sesión
			try {
				if (session != null)
					session.close();
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}
	}

}
