package dao;

import entity.City;
import entity.Factories;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;
import java.sql.ResultSet;

/**
 *
 * @author yalci
 */
public class FactoriesDAO extends DBConnection{
    
    private CityDAO cityDao;
    
    public void createFactories(Factories f) {
        
        try {

            Statement st = this.connect().createStatement();
            
            System.out.println("-------test");
            String query = "insert into factories (factory_name,city_id) values ('" + f.getFactory_name()+ "','" + f.getCity().getId()+ "')";
            
            System.out.println(query);
            st.executeUpdate(query);
            
            System.out.println("-------test");

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void delete(Factories f) {
        
        try {
            Statement st = (Statement) this.connect().createStatement();
            String query2 = "delete from factories where factory_id='"+f.getFactory_id()+"'";
            st.executeUpdate(query2);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void update(Factories entity) {
        try {
            Statement st = this.connect().createStatement();
            System.out.println("update girdi");
            String query2 = "update factories set factory_name='" + entity.getFactory_name()+ "' , city_id='" + entity.getCity().getId()+ "' where factory_id= " + entity.getFactory_id();
            st.executeUpdate(query2);
            System.out.println("update cikti");

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    public List<Factories> getFactoriesList() {
        
        List<Factories> factoriesList = new ArrayList<>();
        
        try {
            
            Statement st = (Statement) this.connect().createStatement();
            
            String query2 = "select * from factories order by factory_id asc";
            ResultSet rs = st.executeQuery(query2);
            
            while (rs.next()) {
                City c = this.getCityDao().findByID(rs.getInt("city_id"));
                factoriesList.add(new Factories(rs.getInt("factory_id"),c,rs.getString("factory_name")));
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return factoriesList;
    }

    public List<Factories> getFactoriesMonoList(Factories entity) {

        List<Factories> factoriesMonoList = new ArrayList<>();

        try {

            Statement st = this.connect().createStatement();
            System.out.println("cagirmaya girdi");
            String query2 = "select * from factories where factory_name='" + entity.getFactory_name()+ "'";
            ResultSet rs = st.executeQuery(query2);
            System.out.println("cagirmaya cikti");

            while (rs.next()) {
                City c = this.getCityDao().findByID(rs.getInt("city_id"));
                factoriesMonoList.add(new Factories(rs.getInt("factory_id"),c,rs.getString("factory_name")));
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return factoriesMonoList;
    }

    public CityDAO getCityDao() {
        if(cityDao == null){
            this.cityDao = new CityDAO();
        }
        return cityDao;
    }

    public void setCityDao(CityDAO cityDao) {
        this.cityDao = cityDao;
    }

    
    
    
}
