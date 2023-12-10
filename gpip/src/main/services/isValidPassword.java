package main.services;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class isValidPassword {
    public static boolean validPassword(String password) {
        String regex = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)[A-Za-z\\d]{8,20}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }
}
