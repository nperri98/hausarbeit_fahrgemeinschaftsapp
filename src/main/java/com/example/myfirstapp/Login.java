package com.example.myfirstapp;

import android.os.StrictMode;

import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;

public  class  Login {
    private static final String DB_USERNAME ="android";
    private static final String DB_PASSWORD ="admin";
    private static final String IP= "localhost";
    private static final String SQL="Select * FROM user";

    private Array resUsernames;
    private Array resPasswords;


    public String login(String username, String password){
      DbConnection con = new DbConnection(IP,DB_USERNAME,DB_PASSWORD);
      String erg ="";

      try {
          con.connect();
          ResultSet res = con.executeQuery(SQL);
           //resUsernames= res.getArray("username");
           //resPasswords=res.getArray("password");
          while(res.next())
          {erg +=res.getString("username");}
          con.close();
      }catch (SQLException throwables) {
          throwables.printStackTrace();
      }
      return erg;
    }
}
