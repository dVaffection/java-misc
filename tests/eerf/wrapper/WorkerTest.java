package eerf.wrapper;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class WorkerTest {

    private Worker          worker;
    private ExternalProgram externalProgram;
    private Storage         storage;

    @Before
    public void setUp() throws Exception {
        storage = mock(Storage.class);
        externalProgram = mock(ExternalProgram.class);

        worker = new Worker(storage, externalProgram);
    }

    @Test
    public void fromIdleToBusy() {
        when(storage.getId()).thenReturn("123");
        when(externalProgram.wasTerminated()).thenReturn(false);
        when(externalProgram.isWorking()).thenReturn(true);

        State.Status status = null;
        status = worker.scan();
        Assert.assertSame(State.StatusName.IDLE, status.getName());

        try {
            worker.clean();
            Assert.fail("Exception was not thrown");
        } catch (StateException e) {
        }

        try {
            worker.exec("does-not-matter", "does-not-matter");
            status = worker.scan();
            Assert.assertSame(State.StatusName.BUSY, status.getName());
        } catch (StateException e) {
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void fromBusyToTerminated() {
        worker.changeState(new BusyState(worker, storage, externalProgram));

        when(externalProgram.wasTerminated()).thenReturn(false);
        when(externalProgram.isWorking()).thenReturn(true);

        State.Status status = null;
        status = worker.scan();
        Assert.assertSame(State.StatusName.BUSY, status.getName());

        try {
            worker.clean();
            Assert.fail("Exception expected");
        } catch (StateException e) {
        }

        try {
            worker.exec("does-not-matter", "does-not-matter");
            Assert.fail("Exception expected");
        } catch (StateException e) {
        }


        when(externalProgram.wasTerminated()).thenReturn(true);
        status = worker.scan();
        Assert.assertSame(State.StatusName.TERMINATED, status.getName());
    }

    @Test
    public void fromBusyToOutput() {
        worker.changeState(new BusyState(worker, storage, externalProgram));

        when(externalProgram.wasTerminated()).thenReturn(false);
        when(externalProgram.isWorking()).thenReturn(false);
        when(externalProgram.hasOutput()).thenReturn(true);

        State.Status status = null;
        status = worker.scan();
        Assert.assertSame(State.StatusName.OUTPUT, status.getName());
    }

    @Test
    public void fromOutputToIdle() {
        worker.changeState(new OutputState(worker, storage, externalProgram));

        State.Status status = null;
        status = worker.scan();
        Assert.assertSame(State.StatusName.OUTPUT, status.getName());

        try {
            worker.exec("does-not-matter", "does-not-matter");
            Assert.fail("Exception expected");
        } catch (StateException e) {
        }

        try {
            worker.clean();
        } catch (StateException e) {
            Assert.fail(e.getMessage());
        }

        status = worker.scan();
        Assert.assertSame(State.StatusName.IDLE, status.getName());
    }
}
