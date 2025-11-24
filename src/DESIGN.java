import java.time.LocalDate;
import java.util.List;

public class DESIGN {

//1. Books (ספרים)
//----------------
//    GET    /books                 - קבלת רשימת כל הספרים
//    GET    /books/{id}            - קבלת פרטי ספר ספציפי לפי מזהה
//    POST   /books                 - יצירת ספר חדש
//    PUT    /books/{id}            - עדכון פרטי ספר קיים
//    DELETE /books/{id}            - מחיקת ספר
//
//2. Users (משתמשים)
//-------------------
//    GET    /users                 - קבלת רשימת כל המשתמשים
//    GET    /users/{id}            - קבלת פרטי משתמש ספציפי
//    POST   /users                 - יצירת משתמש חדש
//    PUT    /users/{id}            - עדכון פרטי משתמש
//    DELETE /users/{id}            - מחיקת משתמש
//
//3. Borrowing (השאלות)
//----------------------
//    GET    /borrowings            - קבלת כל השאלות
//    GET    /borrowings/{id}       - קבלת פרטי השאלה ספציפית
//    POST   /borrowings            - השאלת ספר למשתמש
//    PUT    /borrowings/{id}       - עדכון השאלה
//    DELETE /borrowings/{id}       - מחיקת השאלה


    public class BookDTO {
        private String title;       // שם הספר (חובה)
        private String author;
        private String serialNumber; // מספר סידורי ייחודי (חובה)
        private int totalCopies;    //
        private boolean available = true;

        // ניתן להוסיף בונים, גטרים וסטרים לפי הצורך
    }

    public class UserDTO {
        private String username;             // שם המשתמש (חובה)
        private String idNumber;             // מספר זהות (חובה)
        private String email;
        private List<BookDTO> borrowedBooks;
        private String subscriptionType;
        private double balance;

        public class BorrowDTO {
            private int userId;          // מזהה המשתמש(חובה)
            private int bookId;          // מזהה הספר(חובה)
            private LocalDate borrowDate;
            private LocalDate dueDate;
            private String status;

        }
//2
//        מחלקת משתמש
//אחראית לייצג את המשתמש שביצע הזמנות ותשלומים.
//
//מחלקת הזמנות
//אחראית לנהל את פרטי ההזמנה שבוצעה.
//
//מחלקת תשלום
//אחראית לנהל את פרטי התשלום של המשתמש עבור ההזמנה.
//
//איך מוודאים שהתשלום קשור להזמנה הנכונה:
//
//בכל תשלום יש שדה orderId שמציין עבור איזו הזמנה התשלום בוצע.
//
//יש לוודא ש-orderId של התשלום תואם ל-orderId של ההזמנה.
//
//בנוסף, ניתן לבדוק ש-userId של המשתמש שביצע את ההזמנה תואם ל-userId שביצע את התשלום.
}}
