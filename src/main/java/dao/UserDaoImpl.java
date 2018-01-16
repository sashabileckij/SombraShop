package dao;

import models.User;

import java.sql.*;
import java.util.ArrayList;

/**
 * Клас, що реалізує методи інтерфейсу UserDao
 */
public class UserDaoImpl implements UserDao {

    @Override
    public User findUserByLoginPassword(String login, String password) {
        DataSource dataSource = new DataSource();
        try (Connection con = dataSource.createConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM sombra.users where login=\""+login+"\" and password=\""+password+"\";");) {
            if(rs.next()){
                User user = new User(
                        rs.getLong("id"),
                        rs.getString("login"),
                        rs.getString("email"),
                        rs.getString("password"),
                        rs.getString("number"),
                        rs.getString("role")
                );
                return user;
            }
        }  catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public User findUserByEmail(String email) {
        DataSource dataSource = new DataSource();
        try (Connection con = dataSource.createConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM sombra.users where email=\""+email+"\";");) {
            if(rs.next()){
                User user = new User(
                        rs.getLong("id"),
                        rs.getString("login"),
                        rs.getString("email"),
                        rs.getString("password"),
                        rs.getString("number"),
                        rs.getString("role")
                );
                return user;
            }
        }  catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public User findUserByLogin(String login) {
        DataSource dataSource = new DataSource();
        try (Connection con = dataSource.createConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM sombra.users where login=\""+login+"\";");) {
            if(rs.next()){
                User user = new User(
                        rs.getLong("id"),
                        rs.getString("login"),
                        rs.getString("email"),
                        rs.getString("password"),
                        rs.getString("number"),
                        rs.getString("role")
                );
                return user;
            }
        }  catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public User findUserByIdUser(long id) {
        DataSource dataSource = new DataSource();
        try (Connection con = dataSource.createConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM sombra.users where id=\""+id+"\";");) {
            if(rs.next()){
                User user = new User(
                        rs.getLong("id"),
                        rs.getString("login"),
                        rs.getString("email"),
                        rs.getString("password"),
                        rs.getString("number"),
                        rs.getString("role")
                );
                return user;
            }
        }  catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<User> findAllUser() {
        DataSource dataSource = new DataSource();
        try (Connection con = dataSource.createConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM sombra.users;");)
        {
            ArrayList<User> users=new ArrayList<>();
            while (rs.next()) {
                User user = new User(
                        rs.getLong("id"),
                        rs.getString("login"),
                        rs.getString("email"),
                        rs.getString("password"),
                        rs.getString("number"),
                        rs.getString("role")
                );
                users.add(user);
            }
            return users;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public User createdUser(String login, String email, String password, String numder, int role) {
        DataSource dataSource = new DataSource();
        PreparedStatement stmt = null;
        try (Connection con = dataSource.createConnection()) {
            stmt = con.prepareStatement("INSERT INTO users(users.login,users.email,users.password," +
                    "users.number,users.role) VALUE ('" + login + "','" + email + "','" + password + "','"
                    + numder + "','" +role+ "');");
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void editRoleForId(User user, long id) {
        DataSource dataSource = new DataSource();
        PreparedStatement stmt = null;
        if(user.getRole().equals("0")) {
            try (Connection con = dataSource.createConnection()) {
                stmt = con.prepareStatement("UPDATE users" +
                        " SET users.role=\"" + "1" + "\" WHERE users.id=\"" + id + "\";");

                stmt.execute();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(user.getRole().equals("1")){
            try (Connection con = dataSource.createConnection()) {
                stmt = con.prepareStatement("UPDATE users" +
                        " SET users.role=\"" + "0" + "\" WHERE users.id=\"" + id + "\";");

                stmt.execute();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void editLoginEmailNumberForId(User user, String login, String email, String number) {
        DataSource dataSource = new DataSource();
        PreparedStatement stmt = null;
        try (Connection con = dataSource.createConnection()) {
            stmt = con.prepareStatement("UPDATE users" +
                    " SET users.login=\"" + login  + "\",users.email=\"" + email  + "\",users.number=\""+number+"\" WHERE users.email=\"" + user.getEmail() + "\";");

            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
