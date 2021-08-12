/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebServicies;

import Model.RolDAO;
import Model.Role;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;


/**
 *
 * @author annie
 */
@WebService(serviceName = "ServiceRol")
public class ServiceRol {
    
    RolDAO dao;

    /**
     * Web service operation
     * @return 
     */
    @WebMethod(operationName = "Listar")
    public List<Role> Listar() {
        //TODO write your implementation code here:
        List<Role> data = new ArrayList<Role>();
        System.out.print("Listar roles................");
        
        try {
                dao = new RolDAO();
                System.out.print("Algo................");
                data = dao.searchRole();   
                System.out.print("Trajo n: "+data.size());
                return data;
        }
        catch (SQLException e){            
            System.out.print("Error en la bd");        
        }
        
        return null;
    }

    

    
    
}
