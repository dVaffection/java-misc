package consumer;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class Factory {

    private Map<String, CallbackContainer> callbacks = new HashMap<>();

    public void register(String key, Consumer<Object> callback, Object response) {
        callbacks.put(key, new CallbackContainer(callback, response));
    }

    public void call(String key) {
        CallbackContainer callbackContainer = callbacks.get(key);
        if (callbackContainer != null) {
            Consumer<Object> callback = callbackContainer.callback;
            Object response = callbackContainer.response;

            callback.accept(response);
        }
    }

    private static class CallbackContainer {

        public Consumer<Object> callback;
        public Object           response;

        public CallbackContainer(Consumer<Object> callback, Object response) {
            this.callback = callback;
            this.response = response;
        }
    }

}
