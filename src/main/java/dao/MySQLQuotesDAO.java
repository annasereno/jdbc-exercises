package dao;

import com.mysql.cj.jdbc.Driver;
import config.Config;
import models.Qoute;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLQuotesDAO {

    private Connection connection = null;

    public void createConnection() {
        System.out.println("Connecting to db...");
        try {
            //register the driver
            DriverManager.registerDriver(new Driver());

            // establish the connection
            connection = DriverManager.getConnection(
                    Config.getURL(),
                    Config.getUser(),
                    Config.getPassword()
            );
        } catch (SQLException sqlx) {
            System.out.println("Error connecting to db..." + sqlx.getMessage());
        }
    }

    ;

    public void closeConnection() {
        System.out.println("Closing db connection...");
        // close the connection
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException sqlx) {
                System.out.println(sqlx.getMessage());
            }
        }
    }

    public List<Qoute> getQuotes() {
//        Connection connection = null;
        List<Qoute> quotes = new ArrayList<>();
        try {

            //create a statement object
            Statement statement = connection.createStatement();

            //execute the statement
            ResultSet resultSet = statement.executeQuery("SELECT * FROM quotes");
            while (resultSet.next()) {
                quotes.add(new Qoute(
                        resultSet.getString("author"),
                        resultSet.getString("content")
                ));
            }
        } catch (SQLException sqlx) {
            System.out.println(sqlx.getMessage());
        }
        return quotes;
    }

}
