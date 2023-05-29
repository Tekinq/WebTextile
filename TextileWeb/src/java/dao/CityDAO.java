package dao;

import entity.City;
import util.DBConnection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CityDAO extends DBConnection {
    
    public City findByID(int id) {
        City c = null;
        try {
            Statement st = this.connect().createStatement();

            String query = "select * from city where id=" + id;

            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                c = new City(rs.getInt("id"), rs.getString("names"));
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return c;
    }

    public void createCity(City c) {
        try {

            Statement st = this.connect().createStatement();

            System.out.println("-------test");
            String query = "insert into city (names) values ('" + c.getNames() + "')";

            System.out.println(query);
            st.executeUpdate(query);

            System.out.println("-------test");

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void delete(City c) {

        try {
            Statement st = this.connect().createStatement();
            String query2 = "delete from city where id='" + c.getId() + "'";
            st.executeUpdate(query2);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void update(City entity) {
        try {
            Statement st = this.connect().createStatement();
            String query2 = "update city set names='" + entity.getNames() + "' where id= " + entity.getId();
            st.executeUpdate(query2);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    //normal okuma
    public List<City> getCityList() {

        List<City> cityList = new ArrayList<>();

        try {

            Statement st = this.connect().createStatement();

            String query2 = "select * from city order by id asc";
            ResultSet rs = st.executeQuery(query2);

            while (rs.next()) {
                cityList.add(new City(rs.getInt("id"), rs.getString("names")));
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return cityList;
    }
    //pagination
    public List<City> getCityList2(int page,int pageSize) {

        List<City> cityList = new ArrayList<>();
        int start = (page-1) * pageSize;
        try {
            
            Statement st = this.connect().createStatement();
            System.out.println("start : "+start);
            System.out.println("pageSize : "+pageSize);
            
            String query2 = "select * from city order by id asc limit " + pageSize + " offset " + start ;
            ResultSet rs = st.executeQuery(query2);

            while (rs.next()) {
                cityList.add(new City(rs.getInt("id"), rs.getString("names")));
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        
        return cityList;
    }
    public List<City> getCityMonoList(City entity) {

        List<City> cityMonoList = new ArrayList<>();

        try {

            Statement st = this.connect().createStatement();

            String query2 = "select * from city where names='" + entity.getNames() + "'";
            ResultSet rs = st.executeQuery(query2);

            while (rs.next()) {
                cityMonoList.add(new City(rs.getInt("id"), rs.getString("names")));
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return cityMonoList;
    }
    
    public int count() {
        int count = 0;

        try {
            
            Statement st = this.connect().createStatement();

            String query = "select count(id) as city_count from city  ";

            ResultSet rs = st.executeQuery(query);
            rs.next();
            count = rs.getInt("city_count");

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        return count;

    }

    
}
