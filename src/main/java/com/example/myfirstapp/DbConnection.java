package com.example.myfirstapp;

//import com.mysql.jdbc.Driver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DbConnection {
    private String serverURL;

    private String username;

    private String password;

    private Connection connection;

    public DbConnection(String serverURL, String username, String password){

        this.serverURL = serverURL;
        this.username = username;
        this.password = password;

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception e){
            e.printStackTrace();
        }

    }

    public void connect() throws SQLException {
        connection = DriverManager.getConnection("jdbc:mysql://"+ "192.168.186.1" + ":"+ "3306"+";"+ "databasename="+ "hausarbeit"+";user="+username+";password="+password+";");
    }

    public void executeUpdate(String command) throws SQLException {
        Statement statement = connection.createStatement();
        statement.executeUpdate(connection.nativeSQL(command));
    }
    public ResultSet executeQuery(String command) throws SQLException {
        Statement statement = connection.createStatement();
        return statement.executeQuery(command);
    }

    public void close() throws SQLException{
        connection.close();
    }
}
