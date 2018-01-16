package dao;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Клас відповідає за завантаження бібіліотеки драйвера, що з'єднує джава і базу даних
 */
public class DataSource {

    Connection connection = null;
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/sombra?autoReconnect=true&useSSL=false&user=root&password=root";

    public DataSource() {
        try {
            Class.forName(JDBC_DRIVER).newInstance();
        } catch (IllegalAccessException | InstantiationException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    /**
     * З'єднується через завантажений драйвер із БД. Об'єкт класу Connection посилає команди із нашої програми до БД
     *
     * @return class Connection що має містить з'єднання із БД
     */
    public Connection createConnection() {
        Connection con = null;
        try {
            if (connection != null) {
                System.out.println("Cant create a New Connection");
            } else {
                con = DriverManager.getConnection(DB_URL);

            }
        } catch (Exception e) {
            System.out.println("Error Occured " + e.toString());
        }
        return con;
    }

}
