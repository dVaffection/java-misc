package eerf.wrapper;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class WorkersManagerTest {

    private WorkersManager workersManager;

    @Before
    public void setUp() {
        workersManager = new WorkersManager();
    }

    @Test
    public void manageWorkers() {
        try {
            workersManager.removeWorker("a worker");
            Assert.fail();
        } catch (RuntimeException e) {

        }


        Worker worker1 = new Worker(new Storage(), new ExternalProgramStub(10));
        Worker worker2 = new Worker(new Storage(), new ExternalProgramStub(10));
        workersManager.addWorker("worker1", worker1);
        workersManager.addWorker("worker2", worker2);


        workersManager.removeWorker("worker1");
        try {
            workersManager.removeWorker("worker1");
            Assert.fail();
        } catch (RuntimeException e) {

        }
        workersManager.removeWorker("worker2");
        try {
            workersManager.removeWorker("worker2");
            Assert.fail();
        } catch (RuntimeException e) {

        }
    }

    @Test
    public void manageTasks() {
        Worker worker1 = new Worker(new Storage(), new ExternalProgramStub(10));
        Worker worker2 = new Worker(new Storage(), new ExternalProgramStub(10));
        workersManager.addWorker("worker1", worker1);
        workersManager.addWorker("worker2", worker2);


        try {
            workersManager.addTask("task1", null);
        } catch (WorkersManagerException e) {
            Assert.fail(e.getMessage());
        }

        try {
            workersManager.addTask("task2", null);
        } catch (WorkersManagerException e) {
            Assert.fail(e.getMessage());
        }

        try {
            workersManager.addTask("task3", null);
            Assert.fail("Task was not supposed to be added");
        } catch (WorkersManagerException e) {

        }

        // -------------------------------------------------------------------------------------------------------------

        try {
            workersManager.removeTask("task1");
            Assert.fail("task must not have been removed because it must have had busy state");
        } catch (WorkersManagerException e) {

        }

        // -------------------------------------------------------------------------------------------------------------

        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            Assert.fail(e.getMessage());
        }

        try {
            workersManager.removeTask("task1");
        } catch (WorkersManagerException e) {
            Assert.fail(e.getMessage());
        }

        try {
            workersManager.removeTask("task2");
        } catch (WorkersManagerException e) {
            Assert.fail(e.getMessage());
        }

        try {
            workersManager.removeTask("task1");
            Assert.fail("task1 must have been already removed");
        } catch (WorkersManagerException e) {

        }
    }

    @Test
    public void getTaskStatus() {
        Worker worker1 = new Worker(new Storage(), new ExternalProgramStub(10));
        workersManager.addWorker("worker1", worker1);


        try {
            workersManager.addTask("task1", null);
        } catch (WorkersManagerException e) {
            Assert.fail(e.getMessage());
        }

        try {
            workersManager.getTaskStatus(null);
            Assert.fail("Such task does not exist, WorkersManagerException must have been thrown");
        } catch (WorkersManagerException e) {

        }

        try {
            State.Status status = workersManager.getTaskStatus("task1");
            Assert.assertSame(State.StatusName.BUSY, status.getName());
        } catch (WorkersManagerException e) {
            Assert.fail(e.getMessage());
        }

        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            Assert.fail(e.getMessage());
        }

        try {
            State.Status status = workersManager.getTaskStatus("task1");
            Assert.assertSame(State.StatusName.OUTPUT, status.getName());
        } catch (WorkersManagerException e) {
            Assert.fail(e.getMessage());
        }
    }

}
