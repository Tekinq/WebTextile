package controller;

import dao.FactoriesDAO;
import entity.Factories;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author yalci
 */
@Named(value = "factoriesBean")
@SessionScoped
public class FactoriesBean implements Serializable {

    private Factories entity;
    private FactoriesDAO dao;
    private List<Factories> list;
    private List<Factories> monoList;

    public FactoriesBean() {
    }

    public void create() {
        this.getDao().createFactories(entity);
        this.entity = new Factories();
    }

    public void delete(Factories f) {
        this.getDao().delete(f);
    }

    public void update() {
        this.getDao().update(this.entity);
        this.entity = new Factories();
    }

    public void updateForm(Factories f) {
        this.entity = f;
    }

    public Factories getEntity() {
        if (this.entity == null) {
            this.entity = new Factories();
        }
        return entity;
    }

    public void setEntity(Factories entity) {
        this.entity = entity;
    }

    public FactoriesDAO getDao() {
        if (this.dao == null) {
            this.dao = new FactoriesDAO();
        }
        return dao;
    }

    public void setDao(FactoriesDAO dao) {
        this.dao = dao;
    }

    public List<Factories> getList() {
        this.list = this.getDao().getFactoriesList();
        return list;
    }

    public void setList(List<Factories> list) {
        this.list = list;
    }

    public List<Factories> getMonoList() {
        this.monoList = this.getDao().getFactoriesMonoList(entity);
        return monoList;
    }
    
    public void setMonoList(){
        this.monoList = monoList;
    }
}
