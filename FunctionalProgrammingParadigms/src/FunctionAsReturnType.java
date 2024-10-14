import java.util.function.Function;

public class FunctionAsReturnType {

    static Function<Integer, Integer> multiplyBy(int x) {
        return y -> x * y;
    }

    public static void main(String[] args) {
        Function<Integer, Integer> doubleNumber = multiplyBy(2);
        Function<Integer, Integer> tripleNumber = multiplyBy(3);

        System.out.println(doubleNumber.apply(4));
        System.out.println(tripleNumber.apply(4));
        System.out.println(multiplyBy(5).apply(6));
    }
}
