package controller;

import dao.EmployeesDAO;
import entity.Employees;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;


@Named(value = "employeesBean")
@SessionScoped
public class EmployeesBean implements Serializable {

    private Employees entity;
    private EmployeesDAO dao;
    private List<Employees> list;
    private List<Employees> monoList;
    
    public EmployeesBean() {
    }

    public void create() {
        this.getDao().createEmployees(entity);
        this.entity = new Employees();
    }
    
    public void delete(Employees e){
        this.getDao().delete(e);
    }
    
    public void update(){
        this.getDao().update(this.entity);
        this.entity = new Employees();
    }
    public void updateForm(Employees e){
        this.entity = e;
    }
    
    public Employees getEntity() {
        if (this.entity == null) {
            this.entity = new Employees();
        }
        return entity;
    }

    public void setEntity(Employees entity) {
        this.entity = entity;
    }

    public EmployeesDAO getDao() {
        if (this.dao == null) {
            this.dao = new EmployeesDAO();
        }
        return dao;
    }

    public void setDao(EmployeesDAO dao) {
        this.dao = dao;
    }

    public List<Employees> getList() {
        this.list = this.getDao().getEmployeesList();
        return list;
    }

    public void setList(List<Employees> list) {
        this.list = list;
    }
    
    public List<Employees> getMonoList() {
        this.monoList = this.getDao().getEmployeesMonoList(entity);
        return monoList;
    }
    
    public void setMonoList(){
        this.monoList = monoList;
    }
    
    
}
