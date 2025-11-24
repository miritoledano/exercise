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
        private int idBo;    //        חובה
        private String title;       //  חובה
        private String author;
        private String serialNumber; // חובה
        private int totalCopies;    //
        private boolean available = true;


    }

    public class UserDTO {
        private int idUs; //        חובה
        private String username;             // שם המשתמש (חובה)
        private String idNumber;             // מספר זהות (חובה)
        private String email;
        private List<BookDTO> borrowedBooks;
        private String subscriptionType;
        private double balance;
    }

    public class BorrowDTO {
        private int idBr; //        חובה
        private int userId;          // מזהה המשתמש חובה
        private int bookId;          // מזהה הספר חובה
        private LocalDate borrowDate;
        private LocalDate dueDate;
        private String status;

    }
//2
public class User {
    private int idUser;
    private String fullName;
    private String email;
}
    public class Order {
        private int idOrder;
        private int userId;
        private LocalDate orderDate;
        private double totalAmount;
    }
    public class Payment {
        private int idPayment;
        private int orderId;
        private int userId;
        private double amount;
        private LocalDate paymentDate;
    }


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
//orderId של התשלום == orderId של ההזמנה

//userId של התשלום == userId של ההזמנה
}
