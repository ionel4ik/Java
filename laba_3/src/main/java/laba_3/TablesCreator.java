package laba_3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import static laba_3.Credentials.*;


public class TablesCreator {
    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(CONNECTION_URL, USER, PASSWORD)) {

            createEmployeeTable(connection);
            createAnimalTable(connection);
            createMedicineTable(connection);
            createAnimalMedicineTable(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void createAnimalTable(Connection connection) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            String createTableSQL = "CREATE TABLE IF NOT EXISTS animal ("
                    + "id INT AUTO_INCREMENT PRIMARY KEY,"
                    + "name VARCHAR(255) NOT NULL,"
                    + "kind VARCHAR(255),"
                    + "weight FLOAT NOT NULL,"
                    + "height FLOAT NOT NULL,"
                    + "width FLOAT NOT NULL,"
                    + "employee_id INT, "
                    + "FOREIGN KEY (employee_id) REFERENCES employee(id)"
                    + ")";

            statement.executeUpdate(createTableSQL);
        }
    }

    private static void createEmployeeTable(Connection connection) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            String createTableSQL = "CREATE TABLE IF NOT EXISTS employee ("
                    + "id INT AUTO_INCREMENT PRIMARY KEY,"
                    + "name VARCHAR(255) NOT NULL,"
                    + "surname VARCHAR(255),"
                    + "middle_name VARCHAR(255),"
                    + "age INT NOT NULL,"
                    + "phone_number VARCHAR(10) NOT NULL,"
                    + "salary FLOAT NOT NULL,"
                    + "passport_number VARCHAR(10) NOT NULL"
                    + ")";

            statement.executeUpdate(createTableSQL);
        }
    }

    private static void createMedicineTable(Connection connection) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            String createTableSQL = "CREATE TABLE IF NOT EXISTS medicine ("
                    + "id INT AUTO_INCREMENT PRIMARY KEY,"
                    + "name VARCHAR(255) NOT NULL,"
                    + "company VARCHAR(255),"
                    + "country VARCHAR(255),"
                    + "dose_amount FLOAT NOT NULL,"
                    + "price DOUBLE NOT NULL,"
                    + "amount INT NOT NULL,"
                    + "category VARCHAR(255)"
                    + ")";

            statement.executeUpdate(createTableSQL);
        }
    }

    private static void createAnimalMedicineTable(Connection connection) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            String createTableSQL = "CREATE TABLE IF NOT EXISTS animal_medicine ("
                    + "animal_id INT,"
                    + "medicine_id INT,"
                    + "PRIMARY KEY (animal_id, medicine_id),"
                    + "FOREIGN KEY (animal_id) REFERENCES Animal (id),"
                    + "FOREIGN KEY (medicine_id) REFERENCES Medicine (id)"
                    + ")";

            statement.executeUpdate(createTableSQL);
        }
    }
}