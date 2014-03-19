package eerf.wrapper;

class OutputState extends BaseState {

    OutputState(Worker worker, Storage storage) {
        super(worker, storage);
    }

    @Override
    public Status output() throws StateException {
        // assumes that output data is taken from an external program execution result

        return new Status(StatusName.OUTPUT, storage.getId(), "output data");
    }

    @Override
    public void clear() throws StateException {
        System.out.println("Previous task data cleaned, state changed to Idle");

        worker.changeState(new IdleState(worker, storage));
    }

}
