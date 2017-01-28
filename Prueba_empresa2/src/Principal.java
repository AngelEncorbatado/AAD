
import java.sql.Date;

import org.hibernate.Session;


public class Principal {
	
public static void main(String[] args) {
		
		//Iniciamos la sesión de Hibernate
		Session session = HibernateUtilities.getSessionFactory().openSession();
					
		session.beginTransaction();
		Pedido p1 = new Pedido("2017-01-15");
		p1.getItem().add(new Item("item1",25));
		p1.getItem().add(new Item("item2",30));	
		
		Pedido p2 = new Pedido("2017-01-15");
		p2.getItem().add(new Item("item3",25));
		p2.getItem().add(new Item("item4",30));	
		//session.save(p1);
		
		//Ejecutamos todo con el commit
		//session.getTransaction().commit();
	
		//Iniciamos la transacción para poder trabajar
		//session.beginTransaction();
		Empresa e1 = new Empresa("empresa1","22",45);
		e1.getDireccion().setCalle("calle nova");
		e1.getDireccion().setPoblacion("Valencia");
		e1.getDireccion().setCp(45686);	
		e1.addPedido(p1);
		e1.addPedido(p2);
							
		session.save(e1);
				
		session.getTransaction().commit();
		
		
		//Cerramos la sesión de Hibernate
		session.close();
		//Cerramos la sesión del Factory
		HibernateUtilities.getSessionFactory().close();
	
	}

}
