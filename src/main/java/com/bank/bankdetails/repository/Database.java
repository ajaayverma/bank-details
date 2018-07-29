package com.bank.bankdetails.repository;

import com.bank.bankdetails.model.Bank;

import java.sql.*;

/**
 * Created by Ajay on 7/27/2018.
 */
public class Database {
    private final static String url = "jdbc:postgresql://127.0.0.1/bankdb";
    private final static String user = "postgres";
    private final static String password = "root";
    private static Connection conn = null;

    public static Connection getConnection() {

        try {
            if (conn == null) {
                conn = DriverManager.getConnection(url, user, password);
                System.out.println("Connected to the PostgreSQL server successfully.");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return conn;
    }

    public static void save(Bank bank) {
        try (PreparedStatement preparedStatement = getConnection().prepareStatement("insert into bank values (?,?,?,?,?)")) {
            preparedStatement.setString(1, bank.getName());
            preparedStatement.setString(2, bank.getPostBank());
            preparedStatement.setString(3, bank.getEuroCity());
            preparedStatement.setString(4, bank.getCommerzBank());
            preparedStatement.setString(5, bank.getRaiffeisenBank());

            preparedStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Bank fetchData(String bankIdentifier) {
        ResultSet resultSet;
        Bank bank = null;
        try (Connection connection = getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from bank where commerzbank = ? ");
            preparedStatement.setString(1, bankIdentifier);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                bank = new Bank(resultSet.getString("name"),
                        resultSet.getString("postbank"),
                        resultSet.getString("eurocity"),
                        resultSet.getString("commerzbank"),
                        resultSet.getString("raiffeisenbank"));
            }
            resultSet.close();
            preparedStatement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bank;
    }
}
