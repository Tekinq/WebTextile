package controller;

import dao.StocksDAO;
import entity.Stocks;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;


@Named(value = "stocksBean")
@SessionScoped
public class StocksBean implements Serializable {
    
    private Stocks entity;
    private StocksDAO dao;
    private List<Stocks> list;
    private List<Stocks> monoList;
    
    
    public StocksBean() {
    }
    
    public void create() {
        this.getDao().createStocks(entity);
        this.entity = new Stocks();
    }
    
    public void delete(Stocks s){
        this.getDao().delete(s);
    }
    
    public void update(){
        this.getDao().update(this.entity);
        this.entity = new Stocks();
    }
    public void updateForm(Stocks s){
        this.entity = s;
    }
    
    public Stocks getEntity() {
        if (this.entity == null) {
            this.entity = new Stocks();
        }
        return entity;
    }
    
    public void setEntity(Stocks entity) {
        this.entity = entity;
    }
    
    public StocksDAO getDao() {
        if (this.dao == null) {
            this.dao = new StocksDAO();
        }
        return dao;
    }
    
    public void setDao(StocksDAO dao) {
        this.dao = dao;
    }
    
    public List<Stocks> getList() {
        this.list = this.getDao().getStocksList();
        return list;
    }
    
    public void setList(List<Stocks> list) {
        this.list = list;
    }
    
    public List<Stocks> getMonoList() {
        this.monoList = this.getDao().getStocksMonoList(entity);
        return monoList;
    }
    
    public void setMonoList(){
        this.monoList = monoList;
    }
}
