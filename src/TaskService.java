import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TaskService {

    private TaskRepository repository;
//הזרקת תלות לשימוש בדיפדנסלי אינדקשן
    public TaskService(TaskRepository repository) {

        this.repository = repository;
    }
//    פונקציה שמקבלת ID של משימה ומשנה את הסטטוס שלה להושלם
public void markTaskAsDone(int id) {
    Task task = repository.getById(id);
    if (task != null) {
        task.setStatus(Task.Status.DONE);
        repository.update(task); // שומר את השינוי בקובץ
        System.out.println("Task with id " + id + " marked as DONE successfully.");
    } else {
        System.out.println("Error: Task with id " + id + " not found. Cannot mark as DONE.");
    }
}

    //    פונקציה שמקבלת מחרוזת ומחפשת אותה או בכותרת או בתאור
    public List<Task> searchTasks(String keyword) {
        List<Task> result = new ArrayList<>();
        for (Task task : repository.listAll()) {
            if (task.getTitle().toLowerCase().contains(keyword.toLowerCase()) ||
                    task.getDescription().toLowerCase().contains(keyword.toLowerCase())) {
                result.add(task);
            }
        }
        return result;
    }
//    פונקציה שמחזירה רשימה ממוינת לפי הסטטוס וזה לפי הסדר שבו ה ENUM הוגדר מראש
    public List<Task> getTasksSortedByStatus() {
        List<Task> tasks = new ArrayList<>(repository.listAll());
        tasks.sort(Comparator.comparing(Task::getStatus));
        return tasks;
    }

}
