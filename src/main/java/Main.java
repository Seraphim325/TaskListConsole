import com.seraphim.tasklist.config.AppConfig;
import com.seraphim.tasklist.console.ConsoleUI;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(AppConfig.class);
        ConsoleUI ui = context.getBean(ConsoleUI.class);
        ui.consoleMenu();
    }
}
