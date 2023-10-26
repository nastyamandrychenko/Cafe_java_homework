package classes;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class EmailValidator {
   private static final String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
   Pattern pattern = Pattern.compile(regex);
}