package eerf.wrapper;

class IdleState extends BaseState {

    IdleState(Worker worker, Storage storage) {
        super(worker, storage);
    }

    @Override
    public Status output() throws StateException {
        return new Status(StatusName.IDLE, storage.getId());
    }

    @Override
    public void exec(String id, String input) throws StateException {
        storage.setId(id);
        // input data is fed to an external program input

        System.out.println("Executing new task with \"" + input + "\" data");
    }
}
