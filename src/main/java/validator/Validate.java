package validator;

import java.util.Arrays;
import java.util.List;

public class Validate {
    public static boolean hasRestrictedCharacters (String input){
        List<Character> restrictedChars = Arrays.asList('\\', '<', '>', '*', '?', '/', '"','|');
        return input.chars().mapToObj(ch -> (char)ch).anyMatch(ch -> restrictedChars.contains(ch));
    }
}
