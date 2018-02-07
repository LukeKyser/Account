package database;

import java.sql.*;
import java.util.ArrayList;

import static resources.Constants.DB_CONNECTION;

/**
 * @author Luke Kyser
 * @version 2017.11.30
 *
 * Change Log:
 * -
 */
public class Database {
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

