import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TaskRepository {

    private List<Task> tasks = new ArrayList<>();
//    יצירת קובץ גייסון
    private final String filePath = "tasks.json";

    // טוען את הקובץ פעם אחת כשנוצר repository
//    המטרה היא שבכלפעם יעתיק ל TASK את מה שנימצא בקובץ
    public TaskRepository() {
        loadFromFile();
    }
//פונקצית הוספת משימה
    public void add(Task task) {
        boolean exists = tasks.stream().anyMatch(t -> t.getId() == task.getId());
        if (!exists) {
            tasks.add(task);
            saveToFile();
        } else {
            System.out.println("Task with id " + task.getId() + " already exists. Skipping add.");
        }
    }
//פונקצית עדכון משימה
    public void update(Task updatedTask) {
        boolean found = false;
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).getId() == updatedTask.getId()) {
                tasks.set(i, updatedTask);
                saveToFile();
                found = true;
                System.out.println("Task with id " + updatedTask.getId() + " updated successfully.");
                break;
            }
        }
        if (!found) {
            System.out.println("Error: Task with id " + updatedTask.getId() + " not found. Update failed.");
        }
    }
//פונקצית מחיקה
    public void delete(int id) {
        boolean removed = tasks.removeIf(t -> t.getId() == id);
        if (removed) {
            saveToFile();
            System.out.println("Task with id " + id + " deleted successfully.");
        } else {
            System.out.println("Error: Task with id " + id + " not found. Delete failed.");
        }
    }
//קבלת משימה לפי ה ID שלה
    public Task getById(int id) {
        for (Task t : tasks) {
            if (t.getId() == id) return t;
        }
        System.out.println("Error: Task with id " + id + " not found.");
        return null;
    }

//קבלת רשימת של המשימות
    public List<Task> listAll() {
        return new ArrayList<>(tasks);
    }

    // שמירה בקובץ JSON של כל משימה
    private void saveToFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filePath))) {
            writer.println("[");
            for (int i = 0; i < tasks.size(); i++) {
                Task t = tasks.get(i);
                writer.println("  {");
                writer.println("    \"id\": " + t.getId() + ",");
                writer.println("    \"title\": \"" + t.getTitle() + "\",");
                writer.println("    \"description\": \"" + t.getDescription() + "\",");
                writer.println("    \"status\": \"" + t.getStatus() + "\"");
                writer.print("  }");
                if (i < tasks.size() - 1) writer.println(",");
                else writer.println();
            }
            writer.println("]");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // פונקצית טעינת הקובץ לתוך ה TASK שלי כדי שישמר בזכרון
    private void loadFromFile() {
        tasks.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            int id = 0;
            String title = "";
            String description = "";
            Task.Status status = Task.Status.NEW;

            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (line.startsWith("\"id\"")) {
                    id = Integer.parseInt(line.split(":")[1].trim().replace(",", ""));
                } else if (line.startsWith("\"title\"")) {
                    title = line.split(":")[1].trim().replace("\"", "").replace(",", "");
                } else if (line.startsWith("\"description\"")) {
                    description = line.split(":")[1].trim().replace("\"", "").replace(",", "");
                } else if (line.startsWith("\"status\"")) {
                    status = Task.Status.valueOf(line.split(":")[1].trim().replace("\"", ""));
                    tasks.add(new Task(id, title, description, status));
                }
            }
        } catch (IOException e) {
            System.out.println("No existing file found, starting with empty task list.");
        }
    }
}
