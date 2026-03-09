import com.seraphim.tasklist.config.AppConfig;
import com.seraphim.tasklist.service.TaskService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(AppConfig.class);
        TaskService service = context.getBean(TaskService.class);
    }
}
