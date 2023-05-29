package entity;

import java.io.Serializable;

public class Employees implements Serializable{

    private Long emp_id;
    private Long workplace_id;
    private String first_name;
    private String last_name;
    private String phone;

    public Employees(){
        
    }

    public Employees(Long emp_id, String first_name, String last_name, String phone,Long workplace_id) {
        this.emp_id = emp_id;
        this.workplace_id = workplace_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.phone = phone;
    }
    
    public Employees(String first_name,String last_name,String phone){
        this.first_name = first_name;
        this.last_name = last_name;
        this.phone = phone;
    }
    
    public Long getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(Long emp_id) {
        this.emp_id = emp_id;
    }

    public Long getWorkplace_id() {
        return workplace_id;
    }

    public void setWorkplace_id(Long workplace_id) {
        this.workplace_id = workplace_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Employees{" + "emp_id=" + emp_id +", first_name=" + first_name + ", last_name=" + last_name + ", phone=" + phone + '}';
    }
    
    
    
    
}
