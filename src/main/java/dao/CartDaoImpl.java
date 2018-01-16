package dao;

import models.Cart;
import models.User;

import java.sql.*;
import java.util.ArrayList;

/**
 * Клас, що реалізує методи інтерфейсу CartDao
 */
public class CartDaoImpl implements CartDao {
    @Override
    public ArrayList<Cart> findCartById(long id_user) {
        DataSource dataSource = new DataSource();
        try (Connection con = dataSource.createConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM sombra.cart WHERE cart.id_user=\"" + id_user + "\" AND cart.role=\"" + 3 + "\";");) { //SQL запит для пошуку лотів в кошику
            ArrayList<Cart> carts = new ArrayList<>();
            while (rs.next()) {
                Cart cart = new Cart(
                        rs.getInt("id"),
                        rs.getInt("id_user"),
                        rs.getInt("id_lot"),
                        rs.getInt("role")
                );
                carts.add(cart);
            }
            return carts;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void addCartByIdLotIdUser(String id_lot, User user) {
        DataSource dataSource = new DataSource();
        PreparedStatement stmt = null;

        try (Connection con = dataSource.createConnection()) {
            stmt = con.prepareStatement("INSERT INTO cart(cart.id_lot,cart.id_user,cart.role) VALUE ('" + id_lot + "','" + 3 + "','" + user.getId() + "');");
            stmt.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void editCarRoleById(String lot_id, String role, User user) {
        DataSource dataSource = new DataSource();
        PreparedStatement stmt = null;

        try (Connection con = dataSource.createConnection()) {
            stmt = con.prepareStatement("UPDATE cart" +
                    " SET cart.role=\"" + role + "\" WHERE cart.id_lot=\"" + lot_id + "\" AND cart.id_user=\"" + user.getId() + "\";");

            stmt.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
