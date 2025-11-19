//package edu.upc.eetac.dsa;
//
//import edu.upc.eetac.dsa.command.Command;
//import edu.upc.eetac.dsa.command.CopyCommand;
//import edu.upc.eetac.dsa.command.PasteCommand;
import org.junit.*;
import org.apache.log4j.Logger;

public class CommandFactoryTest {

    CommandFactory cf = null;
    final static Logger logger = Logger.getLogger(CommandFactoryTest.class);

    @Before
    public void setUp() throws Exception {
        cf = CommandFactory.getInstance();
    }

    @After
    public void tearDown() {
        cf.clear();
    }

    @Test
    public void testCopyCommand() throws Exception {
        logger.info(" ********** TEST COPYCOMMAND ********** ");
        Assert.assertEquals(0, cf.numCommands());
        Command copyCommand = cf.getCommand("CopyCommand");
        Assert.assertEquals(copyCommand.getClass(), CopyCommand.class);

        copyCommand = cf.getCommand("CopyCommand");
        Assert.assertEquals(copyCommand.getClass(), CopyCommand.class);
        Assert.assertEquals(1, cf.numCommands());

        copyCommand.execute();

        RuntimeException ex = Assert.assertThrows(RuntimeException.class, () ->
                cf.getCommand("XXXXCommand"));
        Assert.assertEquals(ClassNotFoundException.class, ex.getCause().getClass());
        logger.info(" *************************************** ");
    }


    @Test
    public void testPasteCommand() throws Exception {
        logger.info(" ********** TEST PASTECOMMAND ********** ");
        Assert.assertEquals(0, cf.numCommands());
        Command pasteCommand = cf.getCommand("PasteCommand");
        Assert.assertEquals(pasteCommand.getClass(), PasteCommand.class);

        pasteCommand = cf.getCommand("PasteCommand");
        Assert.assertEquals(pasteCommand.getClass(), PasteCommand.class);
        Assert.assertEquals(1, cf.numCommands());

        pasteCommand.execute();
        logger.info(" *************************************** ");
    }
}
