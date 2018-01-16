package dao;

import models.Lot;

import java.util.ArrayList;

/**
 * Інтерфейс призначений для роботи з табличкою lot
 */
public interface LotDao {
    /**
     * Метод для виведення всіх лотів
     *
     * @return
     */
    ArrayList<Lot> viewsLots();

    /**
     * Метод для мпошука лота по його id
     *
     * @param id
     * @return
     */
    Lot findLotId(int id);

    /**
     * Метод для пошуку лота за категорією
     *
     * @param category
     * @return
     */
    ArrayList<Lot> findLotCategory(String category);

    /**
     * Метод для пошуку лотів за категорією та сортування по категоріях
     *
     * @return
     */
    ArrayList<Lot> findLotCategory();

    /**
     * Метод для пошуку лотів за іменем
     *
     * @param name
     * @return
     */
    ArrayList<Lot> findLotName(String name);

    /**
     * Метод для пошуку лотів за категорією і ім'ям
     *
     * @param category
     * @param name
     * @return
     */
    ArrayList<Lot> findLotCategoryName(String category, String name);
}
