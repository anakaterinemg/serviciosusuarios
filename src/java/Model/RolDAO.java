/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author annie
 */
public class RolDAO implements CRole{
    
    private ConnectionDB conx;
    private Connection con;
    private Statement stm;
    
    public RolDAO(){   
        try {  
            conx= new ConnectionDB();
            this.con = conx.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(RolDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
      
    }

    @Override
    public List searchRole() throws SQLException {
        
        PreparedStatement ps;
        this.stm = this.con.createStatement();
        String sql = "SELECT * FROM rol";
        List<Role> roles = new ArrayList();
        
        System.out.print("Entro a..........searchRoler");
        System.out.print("SQL-> "+ sql);
        
        try{ 
              ps = this.con.prepareStatement(sql);
              ResultSet rs = ps.executeQuery();
              Role findRole;                         
              
              while(rs.next()){  
                System.out.print("Encontroó 1+ ............."); 
                findRole = new Role();            
                                
                findRole.setIdRole(Short.parseShort(rs.getString("id_rol")));                
                findRole.setName(rs.getString("nombre"));  
                            
                roles.add(findRole);
              }   
              
              System.out.print("Cantidad de roles enocntrados: "+roles.size());
        }
        catch(NumberFormatException | SQLException e){
        }
                  
        return roles;
    }
    
}
