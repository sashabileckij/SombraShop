package dao;

import models.City;

import java.sql.*;
import java.util.ArrayList;

/**
 * Клас, що реалізує методи інтерфейсу CityDao
 */
public class CityDaoImpl implements CityDao {

    @Override
    public City createdCity(String name) {
        DataSource dataSource = new DataSource();
        PreparedStatement stmt = null;
        try (Connection con = dataSource.createConnection()) {
            stmt = con.prepareStatement("INSERT INTO cities(cities.name,cities.role) VALUE ('" + name + "','" + 1 + "');");
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public ArrayList<City> findAllCity() {
        DataSource dataSource = new DataSource();
        try (Connection con = dataSource.createConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM sombra.cities;");) {
            ArrayList<City> cities = new ArrayList<>();
            while (rs.next()) {
                City city = new City(
                        rs.getLong("id"),
                        rs.getString("name"),
                        rs.getInt("role")
                );
                cities.add(city);
            }
            return cities;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public City findCityById(String id) {
        DataSource dataSource = new DataSource();
        try (Connection con = dataSource.createConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM sombra.cities where id=\"" + id + "\";");) {
            if (rs.next()) {
                City city = new City(
                        rs.getLong("id"),
                        rs.getString("name"),
                        rs.getInt("role")
                );
                return city;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public void editCityRole(City city) {
        DataSource dataSource = new DataSource();
        PreparedStatement stmt = null;
        if (city.getRole() == 0) {
            try (Connection con = dataSource.createConnection()) {
                stmt = con.prepareStatement("UPDATE cities" +
                        " SET cities.role=\"" + "1" + "\" WHERE cities.id=\"" + city.getId() + "\";");
                stmt.execute();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (city.getRole() == 1) {
            try (Connection con = dataSource.createConnection()) {
                stmt = con.prepareStatement("UPDATE cities" +
                        " SET cities.role=\"" + "0" + "\" WHERE cities.id=\"" + city.getId() + "\";");

                stmt.execute();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
