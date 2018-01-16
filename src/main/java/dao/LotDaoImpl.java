package dao;

import models.Lot;

import java.sql.*;
import java.util.ArrayList;

/**
 * Клас, що реалізує методи інтерфейсу LotDao
 */
public class LotDaoImpl implements LotDao {
    @Override
    public ArrayList<Lot> viewsLots(){
        DataSource dataSource = new DataSource();
        try (Connection con = dataSource.createConnection();
             Statement stmt = con.createStatement();
             ResultSet rs2 = stmt.executeQuery("SELECT * FROM lot ;");
        ) {
            ArrayList<Lot> lots=new ArrayList<>();
            while (rs2.next()) {
                Lot lot = new Lot(
                        rs2.getLong("id"),
                        rs2.getString("jpg"),
                        rs2.getString("name"),
                        rs2.getString("price"),
                        rs2.getString("category")
                );
                int i=0;
                int j=0;

                for (Lot lot1:lots) {
                    i=0;
                    if(lot.getCategory().equals(lot1.getCategory())&&lot.getName().equals(lot1.getName())){
                        i++;
                    }
                }
                if(i==j) {
                    lots.add(lot);
                }


            }
            return lots;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Lot findLotId(int id) {
        DataSource dataSource = new DataSource();
        try (Connection con = dataSource.createConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM sombra.lot where id=\""+id+"\";");) {
            if(rs.next()){
                Lot lot = new Lot(
                        rs.getLong("id"),
                        rs.getString("jpg"),
                        rs.getString("name"),
                        rs.getString("price"),
                        rs.getString("category")
                );

                return lot;

            }

        }  catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<Lot> findLotCategory(String category) {
        DataSource dataSource = new DataSource();
        try (Connection con = dataSource.createConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM sombra.lot where category=\""+category+"\"GROUP BY name;");)
        {
            ArrayList<Lot> lots=new ArrayList<>();
            while (rs.next()) {
                Lot lot = new Lot(
                        rs.getLong("id"),
                        rs.getString("jpg"),
                        rs.getString("name"),
                        rs.getString("price"),
                        rs.getString("category")
                );
                lots.add(lot);
            }
            return lots;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<Lot> findLotCategory() {
        DataSource dataSource = new DataSource();
        try (Connection con = dataSource.createConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM sombra.lot GROUP BY category ;");)
        {
            ArrayList<Lot> lots=new ArrayList<>();
            while (rs.next()) {
                Lot lot = new Lot(
                        rs.getLong("id"),
                        rs.getString("jpg"),
                        rs.getString("name"),
                        rs.getString("price"),
                        rs.getString("category")
                );
                lots.add(lot);
            }
            return lots;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<Lot> findLotName(String name) {
        DataSource dataSource = new DataSource();
        try (Connection con = dataSource.createConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM sombra.lot where name=\""+name+"\"GROUP BY category;");)
        {
            ArrayList<Lot> lots=new ArrayList<>();
            while (rs.next()) {
                Lot lot = new Lot(
                        rs.getLong("id"),
                        rs.getString("jpg"),
                        rs.getString("name"),
                        rs.getString("price"),
                        rs.getString("category")
                );
                lots.add(lot);
            }
            return lots;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<Lot> findLotCategoryName(String category, String name) {
        DataSource dataSource = new DataSource();
        try (Connection con = dataSource.createConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM sombra.lot where category=\"" + category + "\" and name=\"" + name + "\";");)
        {
            ArrayList<Lot> lots=new ArrayList<>();
            while (rs.next()) {
                Lot lot = new Lot(
                        rs.getLong("id"),
                        rs.getString("jpg"),
                        rs.getString("name"),
                        rs.getString("price"),
                        rs.getString("category")
                );
                lots.add(lot);
            }
            return lots;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
