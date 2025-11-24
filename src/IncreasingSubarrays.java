import java.util.ArrayList;
import java.util.List;

public class IncreasingSubarrays {
    public static List<List<Integer>> findIncreasingSubarrays(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        if (arr.length == 0) return result;
//יצירת רשימה זמנית לרצף הנוכחי העולה
        List<Integer> current = new ArrayList<>();
        current.add(arr[0]);

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i - 1]) {
                current.add(arr[i]);
            } else {
                // אם יש לי רצף של שני איברים לפחות אני מוסיפה אותו
                if (current.size() > 1) {
                    result.add(new ArrayList<>(current));
                }
//                לנקות את הרשימה
                current.clear();
//                עכשיו מתחילים מהאחרון שאני עומדת עליו
                current.add(arr[i]);
            }
        }

        // הוספת הרצף האחרון
        if (current.size() > 1) {
            result.add(new ArrayList<>(current));
        }

        return result;
    }
}
