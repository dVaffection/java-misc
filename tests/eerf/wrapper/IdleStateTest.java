package eerf.wrapper;

import org.junit.*;

import static org.mockito.Mockito.*;

public class IdleStateTest {

    Worker          worker;
    ExternalProgram externalProgram;
    Storage         storage;
    State           state;

    @Before
    public void setUp() {
        worker = mock(Worker.class);
        storage = mock(Storage.class);
        externalProgram = mock(ExternalProgram.class);

        state = new IdleState(worker, storage, externalProgram);
    }

    @Test(expected = StateException.class)
    public void clean() throws StateException {
        state.clean();
    }

    @Test
    public void testOutput() {
        when(storage.getId()).thenReturn("123");
        State.Status actualStatus = state.output();

        Assert.assertSame(State.StatusName.IDLE, actualStatus.getName());
        Assert.assertSame("123", actualStatus.getId());
        Assert.assertNull(actualStatus.getOutput());
    }

    @Test
    public void testExec() throws StateException {
        state.exec("123", "input");

        verify(storage, times(1)).setId("123");
        verify(externalProgram, times(1)).start("input");
        State busyState = new BusyState(worker, storage, externalProgram);
        verify(worker).changeState(eq(busyState));
    }
}
