package entity;

import java.io.Serializable;

/**
 *
 * @author yalci
 */
public class Clothes implements Serializable {

    private int id;
    private String cloth_names;

    public Clothes() {

    }

    public Clothes(int id, String cloth_names) {
        this.id = id;
        this.cloth_names = cloth_names;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCloth_names() {
        return cloth_names;
    }

    public void setCloth_names(String cloth_names) {
        this.cloth_names = cloth_names;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Clothes other = (Clothes) obj;
        return this.id == other.id;
    }

    @Override
    public String toString() {
        return cloth_names;
    }
    
    

}
