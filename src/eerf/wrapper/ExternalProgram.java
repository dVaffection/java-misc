package eerf.wrapper;

public interface ExternalProgram {

    /**
     * @param input data
     * @throws ExternalProgramException if program can not be started
     */
    public void start(String input) throws ExternalProgramException;

    public boolean isWorking();

    public boolean wasTerminated();

    public boolean hasOutput();

    public String getOutput();

    public void cleanIO();

}
