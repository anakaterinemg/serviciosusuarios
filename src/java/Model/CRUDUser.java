/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

//import java.sql.ResultSet;
import java.util.List;
import java.sql.SQLException;

/**
 *
 * @author annie
 */
public interface CRUDUser {
    
    
    
     public void insertUser(User dataUser)throws SQLException;
     public void updateUser(User dataUser)throws SQLException;
     public List searchUser(String name)throws SQLException;
     public List searchUsers()throws SQLException;
     public int isExist(String name) throws SQLException;
     public void delete(short idUser)throws SQLException;
    
}
