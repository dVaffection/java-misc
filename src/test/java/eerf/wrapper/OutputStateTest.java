package eerf.wrapper;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class OutputStateTest {

    Worker          worker;
    ExternalProgram externalProgram;
    Storage         storage;
    State           state;

    @Before
    public void setUp() {
        worker = mock(Worker.class);
        storage = mock(Storage.class);
        externalProgram = mock(ExternalProgram.class);

        state = new OutputState(worker, storage, externalProgram);
    }

    @Test
    public void output() {
        when(storage.getId()).thenReturn("123");
        when(externalProgram.getOutput()).thenReturn("output");

        State.Status actualStatus = state.output();
        Assert.assertSame(State.StatusName.OUTPUT, actualStatus.getName());
        Assert.assertSame("123", actualStatus.getId());
        Assert.assertSame("output", actualStatus.getOutput());

        verify(externalProgram, times(1)).getOutput();
    }

    @Test
    public void clean() throws StateException {
        state.clean();

        verify(externalProgram, times(1)).cleanIO();

        State busyState = new IdleState(worker, storage, externalProgram);
        verify(worker, times(1)).changeState(eq(busyState));
    }

    @Test(expected = StateException.class)
    public void exec() throws StateException {
        state.exec("does-not-matter", "does-not-matter");
    }
}
