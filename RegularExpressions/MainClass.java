package RegularExpressions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainClass {
    public static void main(String[] args) {
        // \\d - one digit
        //
        // + - 1 or more
        // * - 0 or more
        // ? - 0 or 1 character before
        //
        // (x|y|z) - one character from many characters
        // [abcde] = (a|b|c|d|e)
        // [a-zA-Z] - all english letters
        // [0-9] - \\d
        // [^abc] - all characters instead of a,b,c
        //
        // . - any character
        //
        // {2} - 2 characters before
        // {2, } - more than 2 characters
        // {2, 4} - from 2 to 4 characters
        //
        // \\w - one letter
        // \\w = [a-zA-Z]
        //
        //  Don't forget about special characters and regular characters
        //
        //

        String urlA = "https://www.google.com";
        String urlB = "(https|http)://www\\..+\\.(com|ru)";

        System.out.println(">> " + urlA.matches(urlB));

        String lettersA = "abcdef";
        String lettersB = "\\w+";

        System.out.println(">> " + lettersA.matches(lettersB));

        String numbersA = "d123347";
        String numbersB = "[asd]*\\d{4,6}";

        System.out.println(">> " + numbersA.matches(numbersB));

        // PATTERN AND MATCHER

        String text = "dasdasdas dsa amogus@gmail.com dasdsadjkalsdas sajkdlaks dsajkl 132312312 jdksljdlks terminator@yandex.ru &^%$#$%^&*()";

        Pattern email = Pattern.compile("(\\w+)@(gmail|yandex)\\.(com|ru)");
        Matcher matcher = email.matcher(text);

        while (matcher.find())
            System.out.println(">> " + matcher.group(1));

    }
}
