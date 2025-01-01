package org.example.L04;

import java.sql.*;

public class Db {

    private static final String URL = "jdbc:mysql://localhost:3306";
    private static final String USER = "root";
    private static final String PASSWORD = "*******";

    // region
    /**
     * Создание базы personsdb
     */
    public static void createBase() throws SQLException {
        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD)) {
            Statement statement = con.createStatement();
//            statement.execute("DROP SCHEMA `personsdb` ;");
            statement.execute("CREATE DATABASE IF NOT EXISTS personsdb;");
            statement.execute("CREATE TABLE IF NOT EXISTS personsdb.persons " +
                    "(id INT AUTO_INCREMENT PRIMARY KEY, " +
                    "firstname VARCHAR(45), lastname VARCHAR(45));");
            statement.execute("INSERT INTO personsdb.persons (firstname, lastname)\n"
                    + "VALUES ('Иванова','Мария');");
            statement.execute("INSERT INTO personsdb.persons (firstname, lastname)\n"
                    + "VALUES ('Петрова','Олеся');");
            statement.execute("INSERT INTO personsdb.persons (firstname,lastname)\n"
                    + "VALUES ('Сидорова','Дарья');");

            ResultSet set = statement.executeQuery("SELECT * FROM personsdb.persons;");
            while (set.next()) {
                System.out.println(set.getString(3) + " "
                        + set.getString(2) + " " + set.getInt(1));
            }
        }
    }

    // endregion
}
