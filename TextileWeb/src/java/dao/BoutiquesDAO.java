/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Boutiques;
import entity.Clothes;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;
import java.sql.ResultSet;

/**
 *
 * @author yalci
 */
public class BoutiquesDAO extends DBConnection {
    
    private ClothesDAO clothesDao;

    public void createBoutiques(Boutiques b) {
        try {

            java.sql.Statement st = this.connect().createStatement();

            System.out.println("-------create girdi");
            String query = "insert into boutiques (bout_name) values ('" + b.getBout_name() + "')";
            st.executeUpdate(query);
            ResultSet rs = st.executeQuery("select max(bout_id) as mid from boutiques");
            rs.next();
            
            int boutiques_id = rs.getInt("mid");
            for(Clothes cat : b.getClothies()){
                query = "insert into boutiques_clothes (boutiques_id,clothes_id) values (" + boutiques_id + "," + cat.getId()+ ")";
                st.executeUpdate(query);
            }

            System.out.println("------create cikti");

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void update(Boutiques entity) {
        try {
            Statement st = this.connect().createStatement();
            System.out.println("update girdi");
            String query2 = "update boutiques set bout_name='" + entity.getBout_name() + "' where bout_id= " + entity.getBout_id() ;
            System.out.println("update cikti");
            st.executeUpdate(query2);
            st.executeUpdate("delete from boutiques_clothes where boutiques_id="+entity.getBout_id());
            
            
            for(Clothes cat : entity.getClothies()){
                query2 = "insert into boutiques_clothes (boutiques_id,clothes_id) values (" + entity.getBout_id() + "," + cat.getId()+ ")";
                st.executeUpdate(query2);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void delete(Boutiques b) {
        try {
            java.sql.Statement st = this.connect().createStatement();
            String query2 = "delete from boutiques where bout_id=" + b.getBout_id();
            st.executeUpdate(query2);
            st.executeUpdate("delete from boutiques_clothes where boutiques_id="+b.getBout_id());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public List<Boutiques> getBoutiquesList() {
        List<Boutiques> boutiquesList = new ArrayList<>();

        try {
            Statement st = this.connect().createStatement();

            String query2 = "select * from boutiques order by bout_id asc";
            ResultSet rs = st.executeQuery(query2);

            while (rs.next()) {
                boutiquesList.add(new Boutiques(rs.getInt("bout_id"),this.getBoutiquesClothies(rs.getInt("bout_id")),rs.getString("bout_name")));
                
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return boutiquesList;
    }
    
    public List<Clothes> getBoutiquesClothies(int boutiques_id) {
        List<Clothes> list = new ArrayList<>();

        try {
            Statement st = this.connect().createStatement();

            String query = "select * from clothes where id in (select clothes_id from boutiques_clothes where boutiques_id="+boutiques_id+")";

            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                list.add(new Clothes(rs.getInt("id"),rs.getString("cloth_names")));
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;

    }
    
    public List<Boutiques> getBoutiquesMonoList(Boutiques entity) {

        List<Boutiques> boutiquesMonoList = new ArrayList<>();

        try {

            Statement st = this.connect().createStatement();

            String query2 = "select * from boutiques where bout_name='" + entity.getBout_name()+ "'";
            ResultSet rs = st.executeQuery(query2);

            while (rs.next()) {
                boutiquesMonoList.add(new Boutiques(rs.getInt("bout_id"),this.getBoutiquesClothies(rs.getInt("bout_id")),rs.getString("bout_name")));
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return boutiquesMonoList;
    }

    public ClothesDAO getClothesDao() {
        if(clothesDao == null){
            this.clothesDao = new ClothesDAO();
        }
        return clothesDao;
    }

    public void setClothesDao(ClothesDAO clothesDao) {
        this.clothesDao = clothesDao;
    }
    
    

}
