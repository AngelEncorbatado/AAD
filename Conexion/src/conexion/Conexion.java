package conexion;


import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class Conexion {

	public static void main(String[] args) {

		Connection conexion;
		String url = "jdbc:mysql://localhost/Prueba";
		String user = "root";
		String pw = "password";

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// obtenemos la conexión con el DriverManager
		try {
			conexion = DriverManager.getConnection(url, user, pw);
			System.out.println("Conexión realizada usando Drivermanager");
			Statement instruccion = (Statement) conexion.createStatement();
			ResultSet conjuntoResultados = instruccion.executeQuery("SELECT * FROM TablaPrueba");
			while (conjuntoResultados.next())
				System.out.println("nombre: "+ conjuntoResultados.getObject("Nombre") + " edad "
						+ conjuntoResultados.getObject("edad"));
			conexion.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// obtenemos el driver del controlador desde el DriverManager
		try {
			Driver driver = DriverManager.getDriver(url);
			Properties properties = new Properties();
			properties.setProperty("user", user);
			properties.setProperty("password", pw);
			conexion = driver.connect(url, properties);
			System.out.println("Conesión realizada usando Driver");
			conexion.close();

		} catch (SQLException ex) {
			System.err.println("Error " + ex.getMessage());
		}

	}

}
