package dao;

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
public class ClothesDAO extends DBConnection {
    
    public Clothes findByID(int id) {
        Clothes c = null;
        try {
            Statement st = this.connect().createStatement();

            String query = "select * from clothes where id=" + id;

            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                c = (new Clothes(rs.getInt("id"),rs.getString("cloth_names")));
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return c;
    }
    
    public void createClothes(Clothes cl) {

        try {
            Statement st = this.connect().createStatement();

            System.out.println("-------test");
            String query = "insert into clothes (cloth_names) values ('"+ cl.getCloth_names()+ "')";

            System.out.println(query);
            st.executeUpdate(query);

            System.out.println("-------test");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void delete(Clothes cl){
        
        try {
            Statement st = this.connect().createStatement();
            String query2 = "delete from clothes where id='"+cl.getId()+"'";
            st.executeUpdate(query2);
            
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void update(Clothes entity) {
        try {
            Statement st = this.connect().createStatement();
            String query2 = "update clothes set cloth_names='"+entity.getCloth_names()+"' where id= "+entity.getId();
            st.executeUpdate(query2);
            
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public List<Clothes> getClothesList() {
        
        List<Clothes> clothesList = new ArrayList<>();
        
        try {

            Statement st = this.connect().createStatement();

            String query2 = "select * from clothes order by id asc";
            ResultSet rs = st.executeQuery(query2);

            
            while (rs.next()) {
                clothesList.add(new Clothes(rs.getInt("id"),rs.getString("cloth_names")));
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return clothesList;
    }
    
    public List<Clothes> getClothesMonoList(Clothes entity) {

        List<Clothes> clothesMonoList = new ArrayList<>();

        try {

            Statement st = this.connect().createStatement();

            String query2 = "select * from clothes where cloth_names='" + entity.getCloth_names()+ "'";
            ResultSet rs = st.executeQuery(query2);

            while (rs.next()) {
                clothesMonoList.add(new Clothes(rs.getInt("id"),rs.getString("cloth_names")));
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return clothesMonoList;
    }
}
