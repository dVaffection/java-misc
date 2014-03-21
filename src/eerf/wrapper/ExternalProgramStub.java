package eerf.wrapper;

import java.util.Date;

public class ExternalProgramStub implements ExternalProgram {

    private long timeOfWork;
    private long startedTime;

    /**
     * @param timeOfWork in milliseconds
     */
    public ExternalProgramStub(int timeOfWork) {
        this.timeOfWork = timeOfWork;
    }

    @Override
    public void start(String input) {
        if (isWorking()) {
            String message = "Program is working";
            throw new ExternalProgramException(message);
        }

        Date date = new Date();
        startedTime = date.getTime();
    }

    @Override
    public boolean isWorking() {
        Date date = new Date();
        long time = date.getTime();

        return startedTime != 0 && startedTime + timeOfWork > time;
    }

    @Override
    public boolean wasTerminated() {
        return false;
    }

    @Override
    public boolean hasOutput() {
        return startedTime != 0 && !isWorking();
    }

    @Override
    public String getOutput() {
        if (!hasOutput()) {
            String message = "Output is not ready yet";
            throw new ExternalProgramException(message);
        }

        return null;
    }

    @Override
    public void cleanIO() {
        // cleaning
    }
}
