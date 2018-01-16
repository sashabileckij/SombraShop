package dao;

import models.City;

import java.util.ArrayList;

/**
 * Інтерфейс призначений для роботи з табличкою cities
 */

public interface CityDao {
    /**
     * Метод для створення нового міста в базі даних
     *
     * @param name
     * @return
     */
    City createdCity(String name);

    /**
     * Метод для пошуку всіх міст
     *
     * @return
     */
    ArrayList<City> findAllCity();

    /**
     * Метод для пошуку всіх міст по id
     *
     * @param id
     * @return
     */
    City findCityById(String id);

    /**
     * Мето для блокування та розблукування міста
     *
     * @param city
     */
    void editCityRole(City city);
}
