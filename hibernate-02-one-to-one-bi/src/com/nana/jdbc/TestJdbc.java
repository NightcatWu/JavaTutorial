package com.nana.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

    public static void main(String[] arg) {

        String jdbcUrl = "jdbc:mysql://192.168.1.230/hb-01-one-to-one-uni?userSSL=false&serverTimezone=UTC";
        String user = "Cat"; 
        String pass = "100281";

        try {

            System.out.println("Connect to data: " + jdbcUrl);

            Connection myConn = DriverManager.getConnection(jdbcUrl, user, pass);

            System.out.println("Connection successful!");

        } catch (Exception exc) {
            exc.printStackTrace();
        }

    }

}
