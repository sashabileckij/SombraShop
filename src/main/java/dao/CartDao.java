package dao;

import models.Cart;
import models.User;

import java.util.ArrayList;

/**
 * Інтерфейс призначений для роботи з табличкою cart
 */

public interface CartDao {
    /**
     * Метод для пошуку всіх лотів в кошику по id користувача
     *
     * @param id_user
     * @return
     */
    ArrayList<Cart> findCartById(long id_user);

    /**
     * Метод для добавлення в кошик лотів
     *
     * @param id_lot
     * @param user
     */
    void addCartByIdLotIdUser(String id_lot, User user);

    /**
     * Метод для підвердження або видалення пролукта з кошика
     *
     * @param lot_id
     * @param role
     * @param user
     */
    void editCarRoleById(String lot_id, String role, User user);
}
