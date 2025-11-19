import org.apache.log4j.Logger;

public class PasteCommand implements Command {
    final static Logger logger = Logger.getLogger(PasteCommand.class);

    @Override
    public void execute() {
        logger.info("Executing PasteCommand .............");
    }
}
