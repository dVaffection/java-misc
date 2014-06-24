package eerf.wrapper;


public class Worker {

    private State state;

    Worker(Storage storage, ExternalProgram externalProgram) {

        // initial state
        changeState(new IdleState(this, storage, externalProgram));
    }

    void changeState(State state) {
        this.state = state;
    }

    public State.Status scan() {
        return state.output();
    }

    public void clean() throws StateException {
        state.clean();
    }

    public void exec(String id, String input) throws StateException {
        state.exec(id, input);
    }

}
