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
public class User {
    
    private int id;
    private short idRol;
    private String name;
    private char active;
    
    
    public User(){
       this.id = 0;
    };
    
    /**
     * Este método permite obtener el id del usuario
     * @return El id del usuario
    **/
    public int getId(){        
        return this.id; 
    }
    
    /**
     * Este método permite obtener el id del rol del usuario
     * @return El id del rol del usuario
    **/
    public short getIdRol(){        
        return this.idRol; 
    }
    
    
    /**
     * Este método permite obtener el nombre del usuario del objeto
     * @return El nombre del usuario
    **/
    public String getName(){        
        return this.name; 
    }

    /**
     * Este método permite obtener si el usuario está activo o no
     * @return El nombre del usuario
    **/
    public char getActive(){        
        return this.active; 
    }       

    public void setId(int id) {
        this.id = id;
    }

    public void setIdRol(short idRol) {
        this.idRol = idRol;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setActive(char active) {
        this.active = active;
    }
    
    @Override 
    public String toString(){
       
        return this.name;
    }
    
    
    
}
