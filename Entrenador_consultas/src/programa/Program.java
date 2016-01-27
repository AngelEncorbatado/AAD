package programa;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

public class Program {

	public static void main(String[] args) {

		Session session = HibernateUtilities.getSessionFactory().openSession();

		IntroducirDatos(session);

		session.beginTransaction();
		
		Query query = session.getNamedQuery("Todos");

		/*Query query = session.createQuery(
				"from Usuario")
				.setFirstResult(2).setMaxResults(1);*/

		List<Usuario> usuarios = query.list();

		for (Usuario u : usuarios) {
			System.out.println(u.getNombre());
		}

		session.getTransaction().commit();

		session.close();

		HibernateUtilities.getSessionFactory().close();

	}

	public static void IntroducirDatos(Session session) {

		session.beginTransaction();

		Usuario u;

		u = CreaUsuario("Pepe", 30, 100, "primera sesión", "segunda sesión");
		session.save(u);

		u = CreaUsuario("Paco", 50, 200, "carrera popular", "media maratón");
		session.save(u);

		u = CreaUsuario("Manolo", 35, 150, "entrenamiento", "carrera");
		session.save(u);

		session.getTransaction().commit();

	}

	public static Usuario CreaUsuario(String nombre, int objetivo, int total,
			String h1, String h2) {

		Usuario u = new Usuario();
		u.setNombre(nombre);
		u.getDatoskm().setObjetivo(objetivo);
		u.getDatoskm().setTotal(total);
		u.addHistorial(new Historial(new Date(), h1));
		u.addHistorial(new Historial(new Date(), h2));

		return u;

	}

}
