package Verified;

import java.util.regex.Pattern;

public class Verified {
    public boolean verifiedPassword(String password) {
        String regex = "^[A-Z][a-zA-Z0-9]{7,}$";
        boolean result = Pattern.matches(regex,password);
        return result;
    }

    public boolean verifiedPhoneNumber(String phoneNumber) {
        String regex = "^[0-9]{10}$";
        boolean result = Pattern.matches(regex,phoneNumber);
        return result;
    }
}
