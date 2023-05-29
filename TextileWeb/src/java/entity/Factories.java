package entity;

import java.io.Serializable;

/**
 *
 * @author yalci
 */
public class Factories implements Serializable{
    
    private int factory_id;
    private City city;
    private String factory_name;
    
    public Factories() {
        
    }

    public Factories(int factory_id, City city, String factory_name) {
        this.factory_id = factory_id;
        this.city = city;
        this.factory_name = factory_name;
    }

    public int getFactory_id() {
        return factory_id;
    }

    public void setFactory_id(int factory_id) {
        this.factory_id = factory_id;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public String getFactory_name() {
        return factory_name;
    }

    public void setFactory_name(String factory_name) {
        this.factory_name = factory_name;
    }
    
    
     
}
