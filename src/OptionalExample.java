import java.util.Optional;

public class OptionalExample {
    public Optional<Integer> getLength(String s){
        if (s == null) {
            return Optional.empty();
        }
        return Optional.of(s.length());
    }
    public static void main(String[] args) {
        OptionalExample opt = new OptionalExample();
        System.out.println(opt.getLength("hello").orElse(0));
        System.out.println(opt.getLength(null).orElse(0));
    }
}
