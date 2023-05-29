package entity;

import java.io.Serializable;


public class Stocks implements Serializable{
    
    private Long stock_id;
    private Long cloth_id;
    private String stock;
    
    public Stocks(){
        
    }
    
    public Stocks(Long stock_id,Long cloth_id, String stock) {
        this.stock_id = stock_id;
        this.cloth_id = cloth_id;
        this.stock = stock;
    }

    public Long getStock_id() {
        return stock_id;
    }

    public void setStock_id(Long stock_id) {
        this.stock_id = stock_id;
    }

    public Long getCloth_id() {
        return cloth_id;
    }

    public void setCloth_id(Long cloth_id) {
        this.cloth_id = cloth_id;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }
    
    
}



