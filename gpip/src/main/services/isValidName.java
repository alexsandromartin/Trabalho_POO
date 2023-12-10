package main.services;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class isValidName {
    public static boolean validName(String nome) {
        String regex = "^(?!.*\\s{2,})[a-zA-ZÀ-ÖØ-öø-ÿ']{2,}\\s[a-zA-ZÀ-ÖØ-öø-ÿ']{2,}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(nome);
        return matcher.matches();
    }
}
