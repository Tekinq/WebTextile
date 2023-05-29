package controller;

import dao.ClothesDAO;
import entity.Clothes;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;


@Named(value = "clothesBean")
@SessionScoped
public class ClothesBean implements Serializable {
    
    private Clothes entity;
    private ClothesDAO dao;
    private List<Clothes> list;
    private List<Clothes> monoList;

    public ClothesBean() {
    }

    public void create() {
        this.getDao().createClothes(entity);
        this.entity = new Clothes();
    }
    public String getTitle(int id){
        //burada veritabani islemi var,onun icin islem;
        Clothes c = this.getDao().findByID(id);
        return c.getCloth_names();
    }
    
    public void delete(Clothes cl) {
        this.getDao().delete(cl);
    }

    public void update() {
        this.getDao().update(this.entity);
        this.entity = new Clothes();
    }

    public void updateForm(Clothes cl) {
        this.entity = cl;
    }

    public Clothes getEntity() {
        if (this.entity == null) {
            this.entity = new Clothes();
        }
        return entity;
    }

    public void setEntity(Clothes entity) {
        this.entity = entity;
    }

    public ClothesDAO getDao() {
        if (this.dao == null) {
            this.dao = new ClothesDAO();
        }
        return dao;
    }

    public void setDao(ClothesDAO dao) {
        this.dao = dao;
    }

    public List<Clothes> getList() {
        this.list = this.getDao().getClothesList();
        return list;
    }

    public void setList(List<Clothes> list) {
        this.list = list;
    }
    
    public List<Clothes> getMonoList() {
        this.monoList = this.getDao().getClothesMonoList(entity);
        return monoList;
    }
    
    public void setMonoList(){
        this.monoList = monoList;
    }
}
