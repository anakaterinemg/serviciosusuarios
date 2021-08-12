/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebServicies;

import Model.User;
import Model.UserDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author annie
 */
@WebService(serviceName = "ServiceUser")
public class ServiceUser {
    
    UserDAO dao;
    
    public ServiceUser(){
        try {
            dao = new UserDAO();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    /**
     * Web service operation
     * @param nombre
     * @return 
     * @throws java.sql.SQLException
     */
    @WebMethod(operationName = "Consulta")
    public List<User> Consultar(@WebParam(name = "nombre") String nombre) {
        //TODO write your implementation code here:
        List<User> data = new ArrayList<User>();
        
        try {
               //dao = new UserDAO();
                System.out.print("Algo................");
                if (nombre == null || nombre.isEmpty()){
                    data = dao.searchUsers(); 
                }
                else{
                    data = dao.searchUser(nombre); 
                }
                  
                System.out.print("Trajo n: "+data.size());
                return data;
        }
        catch (SQLException e){            
            System.out.print("Error en la bd");        
        }
        
        return null;
    }


    /**
     * Web service operation
     */
    @WebMethod(operationName = "Crear")
    public String Crear(@WebParam(name = "idRole") short idRole, @WebParam(name = "name") String name, @WebParam(name = "active") int active) {
        //TODO write your implementation code here:
        User userData = new User();
                
        //if(active==1) {userData.setActive('1');}
        //else  userData.setActive('0'); 
        userData.setActive((char)active); 
        userData.setIdRol(idRole);
        userData.setName(name);
        
        String rta;
        
        try {
            //dao = new UserDAO();
            System.out.print("--- Creo USERDAOOOOOOO.----------");
            dao.insertUser(userData);  
            rta ="Se ha almacenado el nuevo usuario exitosamente";
        } catch (SQLException ex) {
            rta ="No se ha podido podido realizar la operación";
            //Logger.getLogger(ServiceUser.class.getName()).log(Level.SEVERE, null, ex);
        }       
       
        return rta;   
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "Actualizar")
    public String Actualizar(@WebParam(name = "idUser") short idUser, @WebParam(name = "idRole") short idRole, @WebParam(name = "name") String name, @WebParam(name = "active") int active) {
        //TODO write your implementation code here:
        User userData = new User();
        userData.setId(idUser);
        userData.setIdRol(idRole);
        userData.setName(name);
        userData.setActive((char)active);  
        System.out.print("---------------------------------------- ");
        System.out.print("-----------------userData.active-> "+userData.getActive());
        
        String rta;
        
        try {
                //dao = new UserDAO();
                System.out.print("--- Actualizó USERDAOOOOOOO.----------");
                dao.updateUser(userData);  
                rta ="Se ha actualizado el usuario exitosamente";
        } catch (SQLException ex) {
            rta ="No se pudo actualizar el usuario";
            //Logger.getLogger(ServiceUser.class.getName()).log(Level.SEVERE, null, ex);
        }     
        
        return rta;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "Eliminar")
    public String Eliminar(@WebParam(name = "idUser") short idUser) {
        //TODO write your implementation code here:
        String rta;
        
        try {
               // dao = new UserDAO();
                //System.out.print("--- Eliminó USERDAOOOOOOO.----------");
                dao.delete(idUser);  
                rta ="Se ha eliminado el usuario exitosamente";
        } catch (SQLException ex) {
            rta ="No se pudo eliminar el usuario";
            //Logger.getLogger(ServiceUser.class.getName()).log(Level.SEVERE, null, ex);
        }     
        
        return rta;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "ValidarExiste")
    public int ValidarExiste(@WebParam(name = "name") String name) {
        //TODO write your implementation code here:
        int existe = 0;
        System.out.println("Entro por ValidarExiste---name------- "+name); 
        existe = dao.isExist(name);        
        System.out.println("Entro por ValidarExiste"+name+", REsultado -> "+existe); 
           
        return existe;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "ObtenerUsuario")
    public String ObtenerUsuario() {
        //TODO write your implementation code here:
        return null;
    }
    
    

    
    
}
