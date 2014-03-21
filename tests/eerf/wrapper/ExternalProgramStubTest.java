package eerf.wrapper;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ExternalProgramStubTest {

    ExternalProgram externalProgram;

    @Before
    public void setUp() {
        externalProgram = new ExternalProgramStub(10);
    }

    @Test
    public void testStart() {
        externalProgram.start(null);

        try {
            externalProgram.start(null);
            Assert.fail("Second program start within working period must throw an exception");
        } catch (ExternalProgramException e) {
            Assert.assertTrue(true);
        }
    }

    @Test
    public void testIsWorking() {
        Assert.assertFalse(externalProgram.isWorking());

        externalProgram.start(null);
        Assert.assertTrue(externalProgram.isWorking());
    }

    @Test
    public void testHasOutput() {
        Assert.assertFalse(externalProgram.hasOutput());

        externalProgram.start(null);

        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            Assert.fail(e.getMessage());
        }

        Assert.assertTrue(externalProgram.hasOutput());
    }

    @Test
    public void testGetOutput() {
        try {
            externalProgram.getOutput();
            Assert.fail("Exception must have been thrown");
        } catch (ExternalProgramException e) {
            Assert.assertTrue(true);
        }
    }

}
