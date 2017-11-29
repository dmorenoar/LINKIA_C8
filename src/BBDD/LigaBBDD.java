/*
 * Gestor de conexiones y consultas a la BBDD
 */
package BBDD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import models.Entrenador;
import models.Pokemon;

/**
 *
 * @author dmorenoar
 */
public class LigaBBDD {
    
    Connection conn;
    
    private void conectar() throws SQLException{
        String url = "jdbc:mysql://localhost:3306/ligapokemon";
        String user = "linkia";
        String pass = "12345";
        
        conn = DriverManager.getConnection(url, user, pass);
 
    }
    
    
    public void registrarPokemon(Pokemon p){
        
        //Hacer inser utilizando PreparedStatement y el nombre del objeto Entrenador
        
    }
    
    
    public List<Entrenador> selectEntrenadores() throws SQLException{
        List<Entrenador> listEntrenadores = new ArrayList<>();
        
        conectar();
        
        String query = "SELECT * FROM Entrenador";
        Statement st = conn.createStatement();
        
        ResultSet rs = st.executeQuery(query);
        
        while(rs.next()){
            String nombre = rs.getString("nombre");
            String telefono = rs.getString("telefono");
            String sexo = rs.getString("sexo");
            int edad = rs.getInt("edad");
            int experiencia = rs.getInt("experiencia");
            String especialidad = rs.getString("especialidad");
            
            Entrenador e = new Entrenador(nombre, telefono, sexo, edad, experiencia, especialidad);
            listEntrenadores.add(e);
        }
        
        st.close();
        rs.close();
        desconectar();
        
        return listEntrenadores;
        
    }
    
    
    public void insertarEntrenador(Entrenador e) throws SQLException{
        conectar();
        
        String query = "Insert into entrenador values(?,?,?,?,?,?);";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, e.getNombre());
        ps.setString(2, e.getTelefono());
        ps.setString(3,e.getSexo());
        ps.setInt(4, e.getEdad());
        ps.setInt(5, e.getExperiencia());
        ps.setString(6, e.getEspecialidad());
        
        ps.executeUpdate();
        
        ps.close();
        desconectar();
        
    }
    
    
    
    private void desconectar() throws SQLException{
        //Cubrir cerrar la conexion antes de desconectar por si alguien quiere abrirla
        if(conn != null){
            conn.close();
        }
    }
    
}
