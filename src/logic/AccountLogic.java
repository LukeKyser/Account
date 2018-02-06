package logic;

import database.UserDatabase;
import userAccount.UserAccount;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Objects;

public class AccountLogic {
    private UserAccount account;
    private JFrame frame;

    public AccountLogic() {}

    public void createAccount(ArrayList<String> input) {
        account = new UserAccount();
        account.setFirstName(input.get(0));
        account.setLastName(input.get(1));
        account.setEmail(input.get(2));
        account.setStreetAddress(input.get(3));
        account.setCity(input.get(4));
        account.setState(input.get(5));
        account.setZipCode(input.get(6));
        account.setPassword(input.get(7));
    }

    public void submit() {
        UserDatabase db = new UserDatabase();
        db.insertUser(account.getFirstName(), account.getLastName(), account.getEmail(), account.getStreetAddress(), account.getCity(), account.getState(), account.getZipCode(), account.getPassword());
    }

    public boolean getAccountByEmail(String email) {
        UserDatabase db = new UserDatabase();
        account = db.getAccountByEmail(email);
        boolean exists = false;
        if(account != null) {
            exists = true;
        }
        return exists;
    }

    public boolean passwordMatch(String password) {
        boolean match = false;
        if (Objects.equals(account.getPassword(), password)) {
            match = true;
        }
        return match;
    }

    public void printAccountInfo() {
        System.out.println("First Name: " + account.getFirstName());
        System.out.println("Last Name: " + account.getLastName());
        System.out.println("Email: " + account.getEmail());
        System.out.println("Street Address: " + account.getStreetAddress());
        System.out.println("City: " + account.getCity());
        System.out.println("State: " + account.getState());
        System.out.println("Zip Code: " + account.getZipCode());
        System.out.println("Password: " + account.getPassword());
    }
}
