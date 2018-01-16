package models;

/**
 * Клас який описує кошик
 */
public class Cart {

    private int id;
    private int id_user;
    private int id_lot;
    private int role;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public int getId_lot() {
        return id_lot;
    }

    public void setId_lot(int id_lot) {
        this.id_lot = id_lot;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public Cart(int id, int id_user, int id_lot, int role) {
        this.id = id;
        this.id_user = id_user;
        this.id_lot = id_lot;
        this.role = role;
    }

    public Cart() {
    }

    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", id_user=" + id_user +
                ", id_lot=" + id_lot +
                ", role=" + role +
                '}';
    }
}
