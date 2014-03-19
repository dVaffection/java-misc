package eerf.wrapper;

class IdleState extends BaseState {

    IdleState(Worker worker, Storage storage, ExternalProgram externalProgram) {
        super(worker, storage, externalProgram);
    }

    @Override
    public Status output() {
        return new Status(StatusName.IDLE, storage.getId());
    }

    @Override
    public void exec(String id, String input) {
        storage.setId(id);
        externalProgram.start(input);
        worker.changeState(new BusyState(worker, storage, externalProgram));
    }
}
