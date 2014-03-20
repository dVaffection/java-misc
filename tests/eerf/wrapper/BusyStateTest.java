package eerf.wrapper;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class BusyStateTest {

    Worker          worker;
    ExternalProgram externalProgram;
    Storage         storage;
    State           state;

    @Before
    public void setUp() {
        worker = mock(Worker.class);
        storage = mock(Storage.class);
        externalProgram = mock(ExternalProgram.class);

        state = new BusyState(worker, storage, externalProgram);
    }

    @Test
    public void programWasTerminated() {
        when(externalProgram.wasTerminated()).thenReturn(true);

        State.Status actualStatus = state.output();

        Assert.assertSame(State.StatusName.TERMINATED, actualStatus.getName());

        State newState = new TerminatedState(worker, storage, externalProgram);
        verify(worker, times(1)).changeState(eq(newState));
    }

    @Test
    public void programNotWorkingAndHasOutput() {
        when(externalProgram.wasTerminated()).thenReturn(false);
        when(externalProgram.isWorking()).thenReturn(false);
        when(externalProgram.hasOutput()).thenReturn(true);

        State.Status actualStatus = state.output();

        Assert.assertSame(State.StatusName.OUTPUT, actualStatus.getName());

        State newState = new OutputState(worker, storage, externalProgram);
        verify(worker, times(1)).changeState(eq(newState));
    }

    @Test(expected = RuntimeException.class)
    public void programNotWorkingAndHasNoOutput() {
        when(externalProgram.wasTerminated()).thenReturn(false);
        when(externalProgram.isWorking()).thenReturn(false);
        when(externalProgram.hasOutput()).thenReturn(false);

        State.Status actualStatus = state.output();
    }

    @Test
    public void continueWorking() {
        when(externalProgram.wasTerminated()).thenReturn(false);
        when(externalProgram.isWorking()).thenReturn(true);

        State.Status actualStatus = state.output();

        // state remains the same
        Assert.assertSame(State.StatusName.BUSY, actualStatus.getName());
    }

    @Test(expected = StateException.class)
    public void clean() throws StateException {
        state.clean();
    }

    @Test(expected = StateException.class)
    public void exec() throws StateException {
        state.exec("does-not-matter", "does-not-matter");
    }
}
