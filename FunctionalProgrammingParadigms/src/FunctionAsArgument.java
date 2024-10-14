import java.util.function.Consumer;

public class FunctionAsArgument {

    static void register(String name, Consumer<String> callback) {
        callback.accept(name + "@domain.com");
    }

    static Consumer<String> sendWelcomeMail = mail ->
            System.out.println("Hi " + mail);



    public static void main(String[] args) {
        register("khaled", sendWelcomeMail);
    }
}
