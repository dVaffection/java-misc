package eerf.wrapper;

class BusyState extends BaseState {

    BusyState(Worker worker, Storage storage, ExternalProgram externalProgram) {
        super(worker, storage, externalProgram);
    }

    /**
     * BUSY state may lead us to either TERMINATED or OUTPUT state or remain itself (BUSY).
     * !IMPORTANT! if external program status was changed do not forget to update new state in the worker instance
     *
     * @return Status
     */
    public Status output() {
        if (externalProgram.wasTerminated()) {
            State terminatedState = new TerminatedState(worker, storage, externalProgram);
            worker.changeState(terminatedState);
            return terminatedState.output();
        } else if (!externalProgram.isWorking()) {

            if (externalProgram.hasOutput()) {
                State outputState = new OutputState(worker, storage, externalProgram);
                worker.changeState(outputState);
                return outputState.output();
            } else {
                String message = "External program is not working, was not terminated and does not have output";
                throw new RuntimeException(message);
            }

        } else {
            // continue working by default
            return new Status(StatusName.BUSY, storage.getId());
        }
    }
}
