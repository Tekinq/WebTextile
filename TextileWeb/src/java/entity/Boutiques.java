package entity;

import java.io.Serializable;
import java.util.List;


public class Boutiques implements Serializable{
    
    private int bout_id;
    private String bout_name;
    
    private List<Clothes> clothies;
    
    public Boutiques(){
        
    }

    public Boutiques(int bout_id,List<Clothes> clothies, String bout_name) {
        this.bout_id = bout_id;
        this.bout_name = bout_name;
        this.clothies = clothies;
    }

    public Boutiques(String bout_name){
        this.bout_name = bout_name;
    }

    public int getBout_id() {
        return bout_id;
    }

    public void setBout_id(int bout_id) {
        this.bout_id = bout_id;
    }

    public List<Clothes> getClothies() {
        return clothies;
    }

    public void setClothies(List<Clothes> clothies) {
        this.clothies = clothies;
    }

    public String getBout_name() {
        return bout_name;
    }
    
    public void setBout_name(String bout_name) {
        this.bout_name = bout_name;
    }

}
