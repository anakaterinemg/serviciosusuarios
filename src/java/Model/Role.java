/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author annie
 */
public class Role {
    
    private short idRole;
    private String name;
    
    /**
     * Este el constructor vacío
    **/  
    public Role(){};
    
    /**
     * Este el constructor con parámetros
     * @param id Este es el id del rol del objeto
     * @param name Este es el nombre del rol del objeto
    **/    
    public Role(short id, String name){
       this.idRole= id;
       this.name= name;
    };
    
    /**
     * Este método permite obtener el id del rol del objeto
     * @return El id del rol del objeto
    **/
    public short getIdRole(){        
        return this.idRole; 
    }
    
    /**
     * Este método permite obtener el nombre del rol del objeto
     * @return El nombre del rol del objeto
    **/
    public String getName(){        
        return this.name; 
    }    

    public void setIdRole(short idRole) {
        this.idRole = idRole;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
}
