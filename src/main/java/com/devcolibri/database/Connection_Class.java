package com.devcolibri.database;

import org.apache.commons.io.FilenameUtils;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.*;
import java.util.Date;
import java.sql.Timestamp;

public class Connection_Class {

    private static final String URL = "jdbc:mysql://192.168.201.1:3306/insta";
    private static final String USER = "root";
    private static final String PASSWORD = "root";
    private static final String REQUEST = "insert into photos1 (Name,Date,Time,Photos1)values(?,?,?,?)";
    private static Connection connection;
    private static Connection_Class dbConnector;

    public Connection_Class() {
        setConnection();
    }

    public void connectMethod(String link) throws SQLException, ClassNotFoundException, IOException {
        Date today = new Date();
        Timestamp currentTime = new Timestamp(today.getTime());
        URL url = new URL(link);
        String filename = FilenameUtils.getName(link);
        try (InputStream input = url.openStream()) {

            PreparedStatement preparedStatement = connection.prepareStatement(REQUEST);
            preparedStatement.setString(1, filename);
            preparedStatement.setTimestamp(2, currentTime);
            preparedStatement.setTimestamp(3, currentTime);
            preparedStatement.setBlob(4, input);
            preparedStatement.execute();
        }catch (IOException | SQLException e) {
            e.printStackTrace();
        }
    }
    public static Connection_Class getInstance() {
        if (dbConnector == null) {
            return dbConnector = new Connection_Class();
        }
        return dbConnector;
    }

    private void setConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}