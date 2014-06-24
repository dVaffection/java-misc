package eerf.wrapper;

class OutputState extends BaseState {

    OutputState(Worker worker, Storage storage, ExternalProgram externalProgram) {
        super(worker, storage, externalProgram);
    }

    @Override
    public Status output() {
        String output = externalProgram.getOutput();

        return new Status(StatusName.OUTPUT, storage.getId(), output);
    }

    @Override
    public void clean() {
        externalProgram.cleanIO();
        worker.changeState(new IdleState(worker, storage, externalProgram));
    }

}
