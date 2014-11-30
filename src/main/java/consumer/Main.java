package consumer;

public class Main {

    public static void main(String... args) {
        Handler handler = new Handler();
        Factory factory = new Factory();

        factory.register("loud", handler::sayItLoud, new Response());
        factory.call("loud");
    }

}
