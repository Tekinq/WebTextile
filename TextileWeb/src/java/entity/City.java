package entity;

import java.io.Serializable;

public class City  implements Serializable{

    private int id;
    private String names;

    public City() {
    }

    public City(String names) {
        this.id = id;
        this.names = names;
    }

    public City(int id, String names) {
        this.id = id;
        this.names = names;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    @Override
    public String toString() {
        return "City{" + "id=" + id + ", names=" + names + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + this.id;
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
        final City other = (City) obj;
        return this.id == other.id;
    }
    
    

}
