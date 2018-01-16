package dao;

import models.User;

import java.util.ArrayList;

/**
 * Інтерфейс призначений для роботи з табличкою user
 */
public interface UserDao {
    /**
     * Метод для пошуку користувача за його логіном і паролем
     *
     * @param login
     * @param password
     * @return
     */
    User findUserByLoginPassword(String login, String password);

    /**
     * Мето для пошуку користувача за його емайлом
     *
     * @param email
     * @return
     */
    User findUserByEmail(String email);

    /**
     * Метод для пошуку корситувача за його id
     *
     * @param id
     * @return
     */
    User findUserByIdUser(long id);

    /**
     * Метод для пошуку всіх корситувачів
     *
     * @return
     */
    ArrayList<User> findAllUser();

    /**
     * Метод для пошуку користувача за його логіном
     *
     * @param login
     * @return
     */
    User findUserByLogin(String login);

    /**
     * Метод для створення нового користувача в базі даних
     *
     * @param login
     * @param email
     * @param password
     * @param numder
     * @param role
     * @return
     */
    User createdUser(String login, String email, String password, String numder, int role);

    /**
     * Метод для блочення і розблочення користувачів
     *
     * @param user
     * @param id
     */
    void editRoleForId(User user, long id);

    /**
     * Метод для редагування даних про користувача
     *
     * @param user
     * @param login
     * @param email
     * @param number
     */
    void editLoginEmailNumberForId(User user, String login, String email, String number);
}
