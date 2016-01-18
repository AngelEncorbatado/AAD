package programa;
import java.util.Date;

import org.hibernate.Session;


public class Program {

	public static void main(String[] args) {

		System.out.println("Hola");
		
		Session session = HibernateUtilities.getSessionFactory().openSession();		
		session.beginTransaction();
		
		Usuario u = new Usuario();
		u.setNombre("Pepe");
		u.getDatoskm().setObjetivo(30);		
		u.getDatoskm().setTotal(100);
		u.getHistorial().add(new Historial(new Date(),"primera sesión"));
		u.getHistorial().add(new Historial(new Date(),"segunda sesión"));
		
		session.save(u);
		
		session.getTransaction().commit();	
		
		session.beginTransaction();
		
		Usuario u2 = session.get(Usuario.class, 1);
		System.out.println("Hemos recuperado "+u2.getNombre()+" "+u2.getDatoskm().getObjetivo());
	
		for (Historial historial : u2.getHistorial()){
			System.out.println("Obtengo: "+historial.getFecha()+" "+historial.getSesion());
		}
		
		session.getTransaction().commit();
		
		session.close();	
		HibernateUtilities.getSessionFactory().close();

	}

}
