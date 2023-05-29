package dao;

import entity.Employees;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;

public class EmployeesDAO extends DBConnection {

    public void createEmployees(Employees e) {
        try {

            Statement st = this.connect().createStatement();

            System.out.println("-------test");
            String query = "insert into employees (first_name,last_name,phone,workplace_id) values ('" + e.getFirst_name() + "','" + e.getLast_name() + "','" + e.getPhone() + "','" + e.getWorkplace_id() + "')";

            System.out.println(query);
            st.executeUpdate(query);

            System.out.println("-------test");

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void delete(Employees e) {

        try {
            Statement st = this.connect().createStatement();
            String query2 = "delete from employees where emp_id='" + e.getEmp_id() + "'";
            st.executeUpdate(query2);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void update(Employees entity) {
        try {
            Statement st = this.connect().createStatement();
            System.out.println("update girdi");
            String query2 = "update employees set first_name='" + entity.getFirst_name() + "' , last_name='" + entity.getLast_name() + "' , phone='" + entity.getPhone() + "' , workplace_id='" + entity.getWorkplace_id() + "' where emp_id= " + entity.getEmp_id();
            st.executeUpdate(query2);
            System.out.println("update cikti");

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public List<Employees> getEmployeesList() {

        List<Employees> employeesList = new ArrayList<>();

        try {

            Statement st = this.connect().createStatement();

            String query2 = "select * from employees order by emp_id asc";
            ResultSet rs = st.executeQuery(query2);

            while (rs.next()) {
                employeesList.add(new Employees(rs.getLong("emp_id"), rs.getString("first_name"), rs.getString("last_name"), rs.getString("phone"), rs.getLong("workplace_id")));
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return employeesList;
    }
    
    public List<Employees> getEmployeesMonoList(Employees entity) {

        List<Employees> employeesMonoList = new ArrayList<>();

        try {

            Statement st = this.connect().createStatement();
            System.out.println("cagirmaya girdi");
            String query2 = "select * from employees where first_name='" + entity.getFirst_name()+ "'";
            ResultSet rs = st.executeQuery(query2);
            System.out.println("cagirmaya cikti");

            while (rs.next()) {
                employeesMonoList.add(new Employees(rs.getLong("emp_id"), rs.getString("first_name"), rs.getString("last_name"), rs.getString("phone"), rs.getLong("workplace_id")));
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return employeesMonoList;
    }

}
