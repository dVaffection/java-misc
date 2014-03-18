package eerf.wrapper;


import com.google.gson.Gson;

public class Worker {

    private Storage storage;
    private State state;

    Worker(Storage storage) {
        this.storage = storage;

        // initial state
        state = new IdleState(this.storage);
    }

    public String output() {
        Gson gson = new Gson();
        String out;

        try {
            State.Status status = state.output();
            out = gson.toJson(status);
        } catch (StateException e) {
            out = gson.toJson(e.getMessage());
        }

        return out;
    }

}
