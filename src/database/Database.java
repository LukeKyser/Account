package database;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;

/**
 * @author Luke Kyser
 * @version 2017.11.30
 *
 * Change Log:
 * -
 */
public class Database {
    // Final Database Strings
    private static final String DB_SERVER = "localhost";
    private static final String DATABASE = "MusicDB";
    private static final String DB_USERNAME = "javadb";
    private static final String DB_PASSWORD = "javadb";
    private static final String DB_CONNECTION = "jdbc:jtds:sqlserver://"
            + DB_SERVER + "/" + DATABASE + ";user=" + DB_USERNAME + ";password=" + DB_PASSWORD;
    // Private variables
    private Connection mConnection = null;

    public Database() {
        connect();
    }

    private void connect() {
        if (mConnection != null)
            return;
        try {
            mConnection = DriverManager.getConnection(DB_CONNECTION);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void getTable() {
        String query = "SELECT * FROM ARTIST;";
        ArrayList<String> artists = new ArrayList<>();

        try {
            PreparedStatement stmt = mConnection.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                artists.add(rs.getString("Name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < artists.size(); i++) {
            System.out.println("Artist - Name: " + artists.get(i).toString());
        }
    }


}

/*
public class Database {
    // Final Database Strings
    private static final String DB_SERVER = "localhost";
    private static final String DATABASE = "MusicDB";
    private static final String DB_USERNAME = "javadb";
    private static final String DB_PASSWORD = "javadb";
    private static final String DB_CONNECTION = "jdbc:jtds:sqlserver://"
            + DB_SERVER + "/" + DATABASE + ";user=" + DB_USERNAME + ";password=" + DB_PASSWORD;
    // Private variables
    private Connection mConnection = null;

    public Database() {
        connect();
    }

    private void connect() {
        if (mConnection != null)
            return;
        try {
            mConnection = DriverManager.getConnection(DB_CONNECTION);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void getTable() {
        String query = "SELECT * FROM ARTIST;";
        ArrayList<String> artists = new ArrayList<>();

        try {
            PreparedStatement stmt = mConnection.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                artists.add(rs.getString("Name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < artists.size(); i++) {
            System.out.println("Artist - Name: " + artists.get(i).toString());
        }
    }


}
*/
