package eerf.wrapper;

abstract class BaseState implements State {

    protected Storage storage;
    protected Worker worker;

    BaseState(Worker worker, Storage storage) {
        this.worker = worker;
        this.storage = storage;
    }

    @Override
    public void clear() throws StateException {
        throw new StateException("Current state does not support \"clear\" operation");
    }

    @Override
    public void exec(String id, String input) throws StateException {
        throw new StateException("Current state does not support \"exec\" operation");
    }

}
