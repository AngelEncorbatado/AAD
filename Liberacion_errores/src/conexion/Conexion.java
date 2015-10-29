package conexion;


import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {

	public static void main(String[] args) throws SQLException {
			
		
		Connection conexion=null;
		Statement instruccion=null;
		ResultSet conjuntoResultados=null;
		String url = "jdbc:mysql://localhost/Prueba";
		String user = "root";
		String pw = "password";

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.err.println("No se encuentra el controlador");
		} 

		// obtenemos la conexión con el DriverManager
		try {
			conexion = DriverManager.getConnection(url, user, pw);
			System.out.println("Conexión realizada usando Drivermanager");
			instruccion = (Statement) conexion.createStatement();
			conjuntoResultados = instruccion.executeQuery("SELECT * FROM TablaPrueba");
			while (conjuntoResultados.next())
				System.out.println("nombre: "+ conjuntoResultados.getObject("Nombre") + " edad "
						+ conjuntoResultados.getObject("edad"));
			
		} catch (SQLException e) {
			if(e.getSQLState().equals("28000"))
				System.out.println("Error de autentificación");
			else 
				throw e;
			e.printStackTrace();
		} finally {
			try{
				if(conjuntoResultados!=null && !conjuntoResultados.isClosed())
					conjuntoResultados.close();
			}catch(SQLException e){
				Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, e);
			}
			try{
				if(instruccion!=null && !instruccion.isClosed())
					instruccion.close();
			}catch(SQLException e){
				
			}
			try{
				if(conexion!=null && !conexion.isClosed())
					conexion.close();
			}catch(SQLException e){
				
			}
		}

		

	}

}
