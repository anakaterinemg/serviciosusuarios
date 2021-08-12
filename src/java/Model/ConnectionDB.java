/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author annie
 */
public class ConnectionDB {
    
    private Connection con;
    private Statement stm;
    
    /**
     * Este el constructor sin parámetros
     * @throws java.sql.SQLException
    **/  
    public ConnectionDB() throws SQLException{
              
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/user_schema","root","");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConnectionDB.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "No se puede conectar a la base de datos");
        }  
       
    }
    
    /**
     * Este método permite obtener la conexión a la bd
     * @return La conexión creada
    **/  
    public Connection getConnection(){    
        
        return this.con;
    }
    
    /**
     * Este método permite insertar un nuevo usuario en la bd
     * @param dataUser Es el objeto con los datos del usuario a insertar
     * @throws java.sql.SQLException
    **/  
    public void insertUser(User dataUser) throws SQLException{
        
        this.stm = this.con.createStatement();
                
        String sql = "INSERT INTO USER ('id_rol','nombre','activo') "
                     + "VALUES("+dataUser.getIdRol()+",'"
                     +dataUser.getName()+"','"
                     +dataUser.getActive()+"')";
        
        this.stm.executeUpdate(sql);  
    }
    
    /**
     * Este método permite actualizar los datos de un usuario en la bd
     * @param dataUser Es el objeto con los datos del usuario a actualizar
     * @throws java.sql.SQLException
    **/      
    public void updateUser(User dataUser) throws SQLException{
        
        this.stm = this.con.createStatement();        
        
        String sql = "UPDATE usuario "
                + "SET id_rol = "+dataUser.getIdRol()+", "
                + "SET nombre = '"+dataUser.getName()+"', "
                + "SET activo = '"+dataUser.getActive()+"'"
                + "WHERE id_usuario = "+dataUser.getId();
        
        this.stm.executeUpdate(sql);       
        
    }
    
    
    /**
     * Este método permite buscar un usuario por el nombre
     * @param name Es un texto que puede estar contenido en el nombre del usuario a buscar
     * @return Resultado de la busqueda
     * @throws java.sql.SQLException
    **/ 
    
    public ResultSet searchUser(String name) throws SQLException{
        
        this.stm = this.con.createStatement();
        String sql = "SELECT * FROM usuario WHERE nombre like '%"+name+"%'";
        
        ResultSet rs = this.stm.executeQuery(sql);        
                
        return rs;
        
    }
}
