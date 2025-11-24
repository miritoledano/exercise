import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
//      עם המספרים  בדיקה של הפונקציה
//        int[] arr = {1, 2, 3, 2, 4, 5, 1, 2};
//        List<List<Integer>> increasingSubarrays = IncreasingSubarrays.findIncreasingSubarrays(arr);
//
//
//        for(int i = 0; i < increasingSubarrays.size(); i++) {
//            System.out.println(increasingSubarrays.get(i));
//        }
        TaskRepository repository = new TaskRepository();
        TaskService service = new TaskService(repository);
        Scanner scanner = new Scanner(System.in);

        // --- הוספת משימות ---
        repository.add(new Task(1, "ללמוד Java", "לסיים פרויקט תרגיל", Task.Status.NEW));
        repository.add(new Task(2, "לכתוב דו״ח", "לסיים דו״ח שבועי", Task.Status.IN_PROGRESS));
        repository.add(new Task(3, "לקנות מצרכים", "לחנות", Task.Status.NEW));

        System.out.println("רשימת כל המשימות:");
        printTasks(repository.listAll());

        // --- סימון משימה כ-DONE ---
        System.out.println("\nמסמנים את משימה 1 כ-DONE...");
        service.markTaskAsDone(1);
        printTasks(repository.listAll());

        // --- חיפוש משימות לפי מחרוזת ---
        System.out.println("\nחיפוש משימות שמכילות את המילה 'דו״ח':");
        List<Task> searchResult = service.searchTasks("דו״ח");
        printTasks(searchResult);

        // --- מיון משימות לפי סטטוס ---
        System.out.println("\nרשימת משימות ממוינת לפי סטטוס:");
        List<Task> sortedTasks = service.getTasksSortedByStatus();
        printTasks(sortedTasks);

        // --- מחיקת משימה ---
        System.out.println("\nמוחקים את המשימה עם ID = 2...");
        repository.delete(2);
        printTasks(repository.listAll());

        scanner.close();
    }

    // פונקציה עזר להדפסת רשימת משימות
    private static void printTasks(List<Task> tasks) {
        for (Task task : tasks) {
            System.out.println(task);
        }
    }




}
