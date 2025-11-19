import org.apache.log4j.Logger;

public class CopyCommand implements Command {
    final static Logger logger = Logger.getLogger(CopyCommand.class);

    @Override
    public void execute() {
        logger.info("Executing CopyCommand .............");
    }
}
