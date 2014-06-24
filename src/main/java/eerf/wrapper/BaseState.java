package eerf.wrapper;

abstract class BaseState implements State {

    protected Worker          worker;
    protected Storage         storage;
    protected ExternalProgram externalProgram;

    BaseState(Worker worker, Storage storage, ExternalProgram externalProgram) {
        this.worker = worker;
        this.storage = storage;
        this.externalProgram = externalProgram;
    }


    /**
     * Nominal state comparison. Check only of given state class name equals to compared one.
     */
    public boolean equals(Object obj) {
        State state = (State) obj;
        return this.getClass() == state.getClass();
    }

    @Override
    public void clean() throws StateException {
        throw new StateException("Current state does not support \"clean\" operation");
    }

    @Override
    public void exec(String id, String input) throws StateException {
        throw new StateException("Current state does not support \"exec\" operation");
    }

}
