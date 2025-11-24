
//שתי שאלות CRM שידעתי לא רלוונטי
//public class CRM
//{
//    שאלה 28
//    public static int GetMissingNumber(int[] array)
//    {
//        boolean[] found = new boolean[10]; // מערך בוליאני למעקב אחרי המספרים
//
//        // סימון המספרים שמצויים במערך
//        for (int i = 0; i < array.length; i++)
//        {
//            int number = array[i];
//            found[number - 1] = true; // סימון שהמספר הזה קיים
//        }
//
//        // חיפוש המספר החסר
//        for (int i = 0; i < found.length; i++)
//        {
//            if (!found[i])
//            {
//                return i + 1; // המספר החסר
//            }
//        }
//
//        return -1; // אם לא נמצא מספר חסר
//    }
//
//    שאלה 29
//
//    boolean CheckIfPal(String myTxt)
//    {
//        // מסיר רווחים כדי לבדוק פלינדרום במשפטים
//        myTxt = myTxt.replace(" ", "");
//
//        int left = 0;
//        int right = myTxt.length() - 1;
//
//        while (left < right)
//        {
//            if (myTxt.charAt(left) != myTxt.charAt(right))
//            {
//                return false;
//            }
//
//            left++;
//            right--;
//        }
//
//        return true;
//    }
//
//
//    }
//
