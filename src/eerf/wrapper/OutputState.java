package eerf.wrapper;

class OutputState extends BaseState {

    OutputState(Storage storage) {
        super(storage);
    }

    @Override
    public Status output() throws StateException {
        // assumes that output data is taken from an external program execution result

        return new Status(StatusName.OUTPUT, storage.getId(), "output data");
    }

    @Override
    public void clear() throws StateException {
        System.out.println("Clearing previous task output");
    }

}
