package eerf.wrapper;

class TerminatedState extends BaseState {

    TerminatedState(Storage storage) {
        super(storage);
    }

    @Override
    public Status output() throws StateException {
        return new Status(StatusName.TERMINATED, storage.getId());
    }
}
