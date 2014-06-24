package eerf.wrapper;

public interface ExternalProgram {

    public void start(String input);

    public boolean isWorking();

    public boolean wasTerminated();

    public boolean hasOutput();

    public String getOutput();

    public void cleanIO();

}
