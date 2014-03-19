package eerf.wrapper;


public class Worker {

    private Storage storage;
    private State state;

    Worker(Storage storage) {
        this.storage = storage;

        // initial state
        changeState(new IdleState(this, this.storage));
    }

    void changeState(State state) {
        this.state = state;
    }

    public State.Status statusScan() throws StateException {
        return state.output();
    }

    public void clear() throws StateException {
        state.clear();
    }

    public void execTask(String id, String input) throws StateException {
        state.exec(id, input);
    }

}
