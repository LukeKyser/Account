package database;

import userAccount.UserAccount;

import java.sql.*;

import static resources.Constants.DB_CONNECTION;

/**
 * @author Luke Kyser
 * @version 2017.11.30
 *
 * Change Log:
 * -
 */
public class UserDatabase {
    // Private variables
    private Connection mConnection = null;

    public UserDatabase() {
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

    public void insertUser(String firstName, String lastName, String email, String address,
                           String city, String state, String zip, String password) {
        String query =  "INSERT INTO USER_ACCOUNT " +
                "(FirstName, LastName, Email, StreetAddress, City, State, ZipCode, Password) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
        try {
            PreparedStatement stmt = mConnection.prepareStatement(query);
            stmt.setString(1, firstName);
            stmt.setString(2, lastName);
            stmt.setString(3, email);
            stmt.setString(4, address);
            stmt.setString(5, city);
            stmt.setString(6, state);
            stmt.setString(7, zip);
            stmt.setString(8, password);
            stmt.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public UserAccount getAccountByEmail(String email) {
        String query = "SELECT * FROM USER_ACCOUNT WHERE Email = ?;";
        UserAccount account = null;

        try {
            PreparedStatement stmt = mConnection.prepareStatement(query);
            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();
            account = new UserAccount();
            while (rs.next()) {
                account.setFirstName(rs.getString("FirstName"));
                account.setLastName(rs.getString("LastName"));
                account.setEmail(rs.getString("Email"));
                account.setStreetAddress(rs.getString("StreetAddress"));
                account.setCity(rs.getString("City"));
                account.setState(rs.getString("State"));
                account.setZipCode(rs.getString("ZipCode"));
                account.setPassword(rs.getString("Password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if(account.getFirstName() == null) {
            account = null;
        }

        return account;
    }


}