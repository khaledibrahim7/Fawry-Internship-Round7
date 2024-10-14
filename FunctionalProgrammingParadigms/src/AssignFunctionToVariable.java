import java.util.function.BiFunction;

public class AssignFunctionToVariable {

    public static void main(String[] args) {
        BiFunction<Integer,Integer,Integer> add = (a,b) -> a+b;


        System.out.println(add.apply(10,52));

    }

}
