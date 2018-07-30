package com.bank.bankdetails.repository;

import com.bank.bankdetails.model.Bank;
import com.bank.bankdetails.util.Constants;
import com.bank.bankdetails.util.PropertyUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by Ajay on 7/27/2018.
 */
public class Database {
    //private final static String url = "jdbc:postgresql://127.0.0.1/bankdb";
    private final static String SLASH = "/";
    private static String DB_USER = null;
    private static String DB_PASSWORD = null;
    private static String DB_HOSTNAME = null;
    private static String DB_DRIVER = null;
    private static String DB_NAME = null;


    private static Connection conn = null;

    private static void setVariables() throws Exception {
        final Properties properties = PropertyUtil.setProperties(Constants.RESOURCES_PATH + Constants.DB_VAR_PROPERTIES);
        DB_USER = PropertyUtil.getPropertyValue(properties, "DB_USER");
        DB_PASSWORD = PropertyUtil.getPropertyValue(properties, "DB_PASSWORD");
        DB_HOSTNAME = PropertyUtil.getPropertyValue(properties, "DB_HOSTNAME");
        DB_DRIVER = PropertyUtil.getPropertyValue(properties, "DB_DRIVER");
        DB_NAME = PropertyUtil.getPropertyValue(properties, "DB_NAME");
    }

    public static Connection getConnection() throws Exception {
        setVariables();
        try {
            if (conn == null) {
                conn = DriverManager.getConnection(DB_DRIVER + SLASH + SLASH + DB_HOSTNAME + SLASH + DB_NAME, DB_USER, DB_PASSWORD);
                System.out.println("Connected to the DB server successfully.");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return conn;
    }

    public static void save(Bank bank) {
        try (PreparedStatement preparedStatement = getConnection().prepareStatement("INSERT INTO bank VALUES (?,?,?,?,?)")) {
            preparedStatement.setString(1, bank.getName());
            preparedStatement.setString(2, bank.getPostBank());
            preparedStatement.setString(3, bank.getEuroCity());
            preparedStatement.setString(4, bank.getCommerzBank());
            preparedStatement.setString(5, bank.getRaiffeisenBank());

            preparedStatement.execute();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Bank fetchData(String bankIdentifier) {
        ResultSet resultSet;
        Bank bank = null;
        try (Connection connection = getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM bank WHERE commerzbank = ? ");
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

        } catch (Exception e) {
            e.printStackTrace();
        }
        return bank;
    }
}
