package eerf.wrapper;

abstract class BaseState implements State {

    protected Worker worker;
    protected Storage storage;
    protected ExternalProgram externalProgram;

    BaseState(Worker worker, Storage storage, ExternalProgram externalProgram) {
        this.worker = worker;
        this.storage = storage;
        this.externalProgram = externalProgram;
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
