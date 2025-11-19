import java.util.HashMap;
import java.util.ResourceBundle;
import org.apache.log4j.Logger;

public class CommandFactory {

    private static CommandFactory instance;
    private static int num;
    final static Logger logger = Logger.getLogger(CommandFactory.class);

    private CommandFactory(){
        num = 0;
    }

    public static CommandFactory getInstance() {
        if (instance == null ) instance = new CommandFactory();
        return instance;
    }

    public void clear() { instance = null; }

    public static Command getCommand(String cmd) {
        try {
            Command command = switch (cmd) {
                case "CopyCommand"  -> new CopyCommand();
                case "PasteCommand" -> new PasteCommand();
                default             -> throw new ClassNotFoundException("Command not found: " + cmd);
            };
            if (cmd.equals("CopyCommand") || cmd.equals("PasteCommand")) {
                num = 1;
            }
            return command;

        } catch (ClassNotFoundException e) {
            logger.info("Command not found: " + cmd);
            throw new RuntimeException(e);
        }
    }

    public int numCommands() {
        return num;
    }

//    public static Command getCommand(String name) {
//        Command c = null;
//        if (name.equals("C1")) c = new C1();
//        else c = new C2();
//        return c;
//    }
//
//    public static Command getCommand2(String name){
//        Command cmd = null;
//        Class c = null;
//        try {
//            c = Class.forName("eetac.ea.patterns.factory."+name);
//                    cmd=(Command)c.newInstance();
//        } catch (Exception e) {
//            e.printStackTrace();}
//        return cmd;
//    }

}
