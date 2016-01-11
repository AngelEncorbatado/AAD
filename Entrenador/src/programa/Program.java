package programa;
import org.hibernate.Session;


public class Program {

	public static void main(String[] args) {

		System.out.println("Hola");
		
		Session session = HibernateUtilities.getSessionFactory().openSession();		
		/*session.beginTransaction();
		
		Usuario u = new Usuario();
		u.setNombre("Manolo");
		u.setObjetivo(30);
		u.setTotal(100);
		
		session.save(u);
		
		session.getTransaction().commit();	*/
		
		session.beginTransaction();
		
		Usuario u = session.get(Usuario.class, 1);
		System.out.println("Hemos recuperado "+u.getNombre()+" "+u.getObjetivo());
		
		session.getTransaction().commit();
		
		session.close();	
		HibernateUtilities.getSessionFactory().close();

	}

}
