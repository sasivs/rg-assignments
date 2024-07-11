import java.util.Arrays;
import java.util.List;

public class MethodReferenceExample {
    public static int compareByLength(String s1, String s2){
        return s1.length() - s2.length();
    }
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Hello", "RGs");
        List<String> newNames = Arrays.asList("Hello", "RGs");

        names.sort((s1, s2) -> s1.length()-s2.length());
        newNames.sort(MethodReferenceExample::compareByLength);

        System.out.println("Using Lambda Exp: "+names);
        System.out.println("Using Method Reference: "+newNames);
    }
}
