package eerf.wrapper;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class WorkerTest {

    Worker          worker;
    ExternalProgram externalProgram;
    Storage         storage;

    @Before
    public void setUp() throws Exception {
        storage = mock(Storage.class);
        externalProgram = mock(ExternalProgram.class);

        worker = new Worker(storage, externalProgram);
    }

    @Test
    public void fromIdleToWorking() {
        when(storage.getId()).thenReturn("123");
        when(externalProgram.wasTerminated()).thenReturn(false);
        when(externalProgram.isWorking()).thenReturn(true);

        State.Status status = null;
        try {
            status = worker.scan();
            Assert.assertSame(State.StatusName.IDLE, status.getName());
        } catch (StateException e) {
            Assert.fail(e.getMessage());
        }


        try {
            worker.clean();
            Assert.fail("Exception was not thrown");
        } catch (StateException e) {
            Assert.assertTrue(true);
        }

        
        try {
            worker.exec("does-not-matter", "does-not-matter");
            status = worker.scan();
            Assert.assertSame(State.StatusName.BUSY, status.getName());
        } catch (StateException e) {
            Assert.fail(e.getMessage());
        }
    }
}
