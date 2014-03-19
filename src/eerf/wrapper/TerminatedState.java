package eerf.wrapper;

class TerminatedState extends BaseState {

    TerminatedState(Worker worker, Storage storage, ExternalProgram externalProgram) {
        super(worker, storage, externalProgram);
    }

    @Override
    public Status output() {
        return new Status(StatusName.TERMINATED, storage.getId());
    }

    @Override
    public void clean() {
        externalProgram.cleanIO();
        worker.changeState(new IdleState(worker, storage, externalProgram));
    }
}
