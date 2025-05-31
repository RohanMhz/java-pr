import java.util.function.BiFunction;

public class Greetings {
    public static void main(String[] args) {
        BiFunction<Integer, Integer, Integer> add = (a, b) -> a + b;

        System.out.println(add.apply(40, 44));
    }
}
