package tn.esprit.bookstore.utilities;
import java.util.regex.*;

public class RegexTests {

    public static  boolean isAvalidCategory (String str)    {

       return Pattern.matches("[[A-Za-z]+[\\u0020_&]*]+",str);


    }
    public  static boolean containsOnlyLettersAndSpaces(String str)
    {
        return Pattern.matches("[[A-Z-a-z]+\\u0020]+",str);
    }
    public static boolean IsvalidIsbn( String isbn)
    {
        return (isbn.length()==0 || Pattern.matches("[0-9(-)$]+",isbn));
    }
    public static  Boolean isValidMail(String mail)
    {
        return Pattern.matches("^[A-Za-z0-9+_.-]+@(.+)$",mail);
    }
    public static Boolean isValidPrice(String price)
    {
        return Pattern.matches("[0-9]+([,.][0-9]{1,2})?",price);
    }

    public static boolean isAvalidPhone (String str)
    {
        return (str.length()==0 || Pattern.matches("[0-9(-)$]+",str));
    }
    String passwordPattern = "^(?=.*[0-9])"
            + "(?=.*[a-z])(?=.*[A-Z])"
            + "(?=.*[@#$%^&+=])"
            + "(?=\\S+$).{8,20}$";
    public static boolean isValidPassword (String str)
    {
        return (Pattern.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&-+=()])(?=\\\\S+$).{8,20}$",str));
    }

}