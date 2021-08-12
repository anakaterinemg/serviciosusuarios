/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author annie
 */
public class UserDAO implements CRUDUser {
   
    private ConnectionDB conx= new ConnectionDB();
    private Connection con;
    private Statement stm;
    
    public UserDAO() throws SQLException{ 
      
      this.con = conx.getConnection();
    }
    
    /**
     * Este método permite insertar un nuevo usuario en la bd
     * @param dataUser Es el objeto con los datos del usuario a insertar
     * @throws java.sql.SQLException
    **/  
    @Override
    public void insertUser(User dataUser) throws SQLException{
        
        System.out.print("--- iNCIANDO insertUser----------");
        System.out.print("--- name---->"+dataUser.getName());
        System.out.print("--- Activo---->"+dataUser.getActive());
        
        this.stm = this.con.createStatement();
                
        String sql = "INSERT INTO usuario (`id_rol`,`nombre`,`activo`) "
                     + "VALUES("+dataUser.getIdRol()+",'"
                     +dataUser.getName()+"','"
                     +dataUser.getActive()+"')";
        
        System.out.print("Intentando insertar-> "+sql);
        
        this.stm.executeUpdate(sql);  
    }
    
    /**
     * Este método permite actualizar los datos de un usuario en la bd
     * @param dataUser Es el objeto con los datos del usuario a actualizar
     * @throws java.sql.SQLException
    **/      
    @Override
    public void updateUser(User dataUser) throws SQLException{
        
        this.stm = this.con.createStatement();   
        
        System.out.print("Entró a updateUser----------------> ");
        
        String sql = "UPDATE usuario "
                + "SET id_rol = "+dataUser.getIdRol()+", "
                + " nombre = '"+dataUser.getName()+"', "
                + " activo = '"+(char)dataUser.getActive()+"'"
                + " WHERE id_usuario = "+dataUser.getId();
        
        System.out.print("Sql-> "+sql);
        
        this.stm.executeUpdate(sql);
        this.stm.close();
        
    }
    
    
    /**
     * Este método permite buscar un usuario por el nombre
     * @param name Es un texto que puede estar contenido en el nombre del usuario a buscar
     * @return Resultado de la busqueda
     * @throws java.sql.SQLException
    **/     
    @Override
    public List searchUser(String name) throws SQLException{
        
        PreparedStatement ps;
        this.stm = this.con.createStatement();
        String sql = "SELECT * FROM usuario WHERE nombre like '%"+name+"%'";
        List<User> users = new ArrayList();
        
        System.out.print("Entro a..........searchUser");
        System.out.print("SQL-> "+ sql);
        
        try{ 
              ps = this.con.prepareStatement(sql);
              ResultSet rs = ps.executeQuery();
              User findUser;
              char []activo;             
              
              while(rs.next()){  
                System.out.print("Encontroó 1+ ............."); 
                findUser = new User();            
                activo= rs.getString("activo").toCharArray();  
                
                findUser.setId(Short.parseShort(rs.getString("id_usuario")));
                findUser.setIdRol(Short.parseShort(rs.getString("id_rol")));
                findUser.setName(rs.getString("nombre"));                                   
                findUser.setActive(activo[0]);  
                            
                users.add(findUser);
              }  
              
              rs.close(); 
              ps.close();
              
              System.out.print("Cantidad de usuarios enocntrados: "+users.size());
        }
        catch(NumberFormatException | SQLException e){
        }
                  
        return users;
    }
    
    /**
     * Este método permite buscar un usuario por el nombre
     * @return Resultado de la busqueda
     * @throws java.sql.SQLException
    **/     
    @Override
    public List searchUsers() throws SQLException{
        
        PreparedStatement ps;
        this.stm = this.con.createStatement();
        String sql = "SELECT * FROM usuario";
        List<User> users = new ArrayList();
        
        System.out.print("Entro a..........searchUsers");
        System.out.print("SQL-> "+ sql);
        
        try{ 
              ps = this.con.prepareStatement(sql);
              ResultSet rs = ps.executeQuery();
              User findUser;
              char []activo;             
              
              while(rs.next()){  
                System.out.print("Encontroó 1+ ............."); 
                findUser = new User();            
                activo= rs.getString("activo").toCharArray();  
                
                findUser.setId(Short.parseShort(rs.getString("id_usuario")));
                findUser.setIdRol(Short.parseShort(rs.getString("id_rol")));
                findUser.setName(rs.getString("nombre"));                                   
                findUser.setActive(activo[0]);  
                            
                users.add(findUser);
              }   
              
              rs.close(); 
              ps.close();
              
              System.out.print("Cantidad de usuarios enocntrados: "+users.size());
        }
        catch(NumberFormatException | SQLException e){
        }                  
        return users;
    }
    
    
    
    @Override
    public void delete(short idUser)throws SQLException{
         
        this.stm = this.con.createStatement();
        String sql = "DELETE FROM usuario WHERE id_usuario ="+idUser;
               
        System.out.print("Intentando insertar-> "+sql);
        
        this.stm.execute(sql); 
        this.stm.close(); 
              
    
    }
    
    @Override
    public int isExist(String name) {
        
        int esta=0;        
        PreparedStatement ps;
        String sql = "SELECT id_usuario FROM usuario WHERE nombre = '"+name+"'";   
        System.out.println("isExsite SQL-> "+sql);
        try{ 
              ps = this.con.prepareStatement(sql);
              ResultSet rs = ps.executeQuery(); 
             //int row=rs.getRow();
              
              if(rs.next()){  
                  esta = 1; 
                  System.out.println("Si existe el nombre-> "+esta);
              }
              /**while(rs.next()){
                  String nameFind=rs.getString("cont");
                  esta = 1;                 
              } */
              rs.close(); 
              ps.close();
        }
        catch(NumberFormatException | SQLException e){
        }               
        return esta;
    }
        
}
