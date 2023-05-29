package dao;

import entity.Stocks;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;

public class StocksDAO extends DBConnection {

    public void createStocks(Stocks s) {
        try {

            Statement st = this.connect().createStatement();

            System.out.println("-------test");
            String query = "insert into stocks (cloth_id,stock) values ('" + s.getCloth_id()+ "','"+ s.getStock()+ "')";

            System.out.println(query);
            st.executeUpdate(query);

            System.out.println("-------test");

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void delete(Stocks s) {

        try {
            Statement st = this.connect().createStatement();
            String query2 = "delete from stocks where stock_id='" + s.getStock_id()+ "'";
            st.executeUpdate(query2);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    
     public void update(Stocks entity) {
        try {
            Statement st = this.connect().createStatement();
            System.out.println("update girdi");
            String query2 = "update stocks set stock='" + entity.getStock()+ "' , cloth_id='" + entity.getCloth_id()+ "' where stock_id= " + entity.getStock_id();
            st.executeUpdate(query2);
            System.out.println("update cikti");

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public List<Stocks> getStocksList() {

        List<Stocks> stocksList = new ArrayList<>();

        try {

            Statement st = this.connect().createStatement();

            String query2 = "select * from stocks order by stock_id asc";
            ResultSet rs = st.executeQuery(query2);

            while (rs.next()) {
                stocksList.add(new Stocks(rs.getLong("stock_id"), rs.getLong("cloth_id"),rs.getString("stock")));
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return stocksList;
    }
    
    public List<Stocks> getStocksMonoList(Stocks entity) {

        List<Stocks> stocksMonoList = new ArrayList<>();

        try {

            Statement st = this.connect().createStatement();
            System.out.println("cagirmaya girdi");
            String query2 = "select * from stocks where stock='" + entity.getStock()+ "'";
            ResultSet rs = st.executeQuery(query2);
            System.out.println("cagirmaya cikti");

            while (rs.next()) {
                stocksMonoList.add(new Stocks(rs.getLong("stock_id"), rs.getLong("cloth_id"),rs.getString("stock")));
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return stocksMonoList;
    }
}
