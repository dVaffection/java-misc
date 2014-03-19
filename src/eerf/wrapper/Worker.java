package eerf.wrapper;


public class Worker {

    private Storage storage;
    private State state;

    Worker(Storage storage, ExternalProgram externalProgram) {
        this.storage = storage;

        // initial state
        changeState(new IdleState(this, this.storage, externalProgram));
    }

    void changeState(State state) {
        this.state = state;
    }

    public State.Status scan() throws StateException {
        return state.output();
    }

    public void clean() throws StateException {
        state.clean();
    }

    public void exec(String id, String input) throws StateException {
        state.exec(id, input);
    }

}
