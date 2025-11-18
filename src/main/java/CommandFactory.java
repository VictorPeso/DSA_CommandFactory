import java.util.HashMap;
import java.util.ResourceBundle;

public class CommandFactory {
    private static CommandFactory instance;
    private HashMap<String, ResourceBundle> data;


    private CommandFactory(){
        data = new HashMap<String,ResourceBundle>();
    }

    public static CommandFactory getInstance(){
        if (instance == null) instance = new CommandFactory();
        return instance;
    }

    public void clear() {
        instance = null;
    }
}
