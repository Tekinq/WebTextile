/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controller;

import dao.CityDAO;
import entity.City;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author yalci
 */
@Named(value = "cityBean")
@SessionScoped
public class CityBean implements Serializable {

    private City entity;
    private CityDAO dao;
    private List<City> list;
    private List<City> monoList;
    private List<City> list2;

    private int page = 1;//bulunduğumuz sayfa
    private int pageSize = 5;//kaç tane veri gösterecez    
    private int pageCount;//sayfa sayısı

    public CityBean() {

    }

    public void create() {
        this.getDao().createCity(entity);
        this.entity = new City();
    }

    public void delete(City c) {
        this.getDao().delete(c);
    }

    public void update() {
        this.getDao().update(this.entity);
        this.entity = new City();
    }

    public void updateForm(City c) {
        this.entity = c;
    }

    public City getEntity() {
        if (this.entity == null) {
            this.entity = new City();
        }
        return entity;
    }

    public void setEntity(City entity) {
        this.entity = entity;
    }

    public CityDAO getDao() {
        if (this.dao == null) {
            this.dao = new CityDAO();
        }
        return dao;
    }

    public void setDao(CityDAO dao) {
        this.dao = dao;
    }

    public List<City> getList() {
        this.list = this.getDao().getCityList();
        return list;
    }

    public void setList(List<City> list) {
        this.list = list;
    }

    public List<City> getMonoList() {
        this.monoList = this.getDao().getCityMonoList(entity);
        return monoList;
    }

    public void setMonoList() {
        this.monoList = monoList;
    }

    public List<City> getList2() {
        this.list2 = this.getDao().getCityList2(page, pageSize);
        return list2;
    }

    public void setList2(List<City> list2) {
        this.list2 = list2;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageCount() {
        this.pageCount = (int) Math.ceil(this.getDao().count() / (double) pageSize);
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public void next() {
        if (this.page == this.getPageCount()) {
            this.page = 1;
        } else {
            this.page++;
        }
    }

    public void previous() {
        if (this.page == 1) {
            this.page = this.getPageCount();
        } else {
            this.page--;
        }
    }

}
