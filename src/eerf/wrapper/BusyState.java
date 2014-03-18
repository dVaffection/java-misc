package eerf.wrapper;

class BusyState extends BaseState {

    BusyState(Storage storage) {
        super(storage);
    }

    @Override
    public Status output() throws StateException {
        return new Status(StatusName.BUSY, storage.getId());
    }
}
