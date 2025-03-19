import java.sql.Time;
import java.util.ArrayList;
import java.util.Scanner;

public class UserAction {

    public static void userlogin(Scanner scanner, ArrayList<User> list, ArrayList<Book> booklist, ArrayList<UserBookMaintain> userBookMaintains) {
        System.out.println("Enter the user ID :");
        String userid = scanner.next();
        for (User u : list) {
            if (u.userid.equals(userid)) {
                System.out.println("Enter your roll_no :");
                String roll_no = scanner.next();
                if (roll_no.equals(u.roll_no)) {
                    System.out.println("Successfully Login !!!!");
                    while (true) {
                        System.out.println("1.View Available book in library ");
                        System.out.println("2.Specific book search");
                        System.out.println("3.Get book");
                        System.out.println("4.Return book");
                        System.out.println("5.Issue book");
                        System.out.println("6.Exit");
                        System.out.println("Enter your choice : ");
                        int choice = scanner.nextInt();
                        switch (choice) {
                            case 1:
                                AdminAction.view_all_book(booklist);
                                break;
                            case 2:
                                AdminAction.Specific_book_search(booklist, scanner);
                                break;
                            case 3:
                                UserAction.getBook(booklist, scanner, userBookMaintains);
                                break;
                            case 4:
                                UserAction.returnBook(userBookMaintains, scanner, booklist);
                                break;
                            case 5:
                                UserAction.issueBook(userBookMaintains);
                                break;
                            case 6:
                                System.out.println("Exiting....");
                                return;

                        }
                    }

                } else {
                    System.out.println("Roll-NO is wrong!!!!!");
                }
            } else {
                System.out.println("User ID  is wrong!!!!");
            }
            break;
        }
        System.out.println("User not Found!!!");

    }

    public static void getBook(ArrayList<Book> booklist, Scanner scanner, ArrayList<UserBookMaintain> userBookMaintains) {
        System.out.println("Enter the book ID ");
        String bookid = scanner.next();
        boolean getbook = false;
        for (Book b : booklist) {
            if (bookid.equals(b.book_ID)) {
                System.out.println("How many books do you want");
                int bookcount = scanner.nextInt();
                if(b.book_count>=bookcount) {
                    b.book_count -= bookcount;
                    UserBookMaintain userBookMaintain = new UserBookMaintain(b, bookcount);
                    userBookMaintains.add(userBookMaintain);
                    getbook = true;
                    System.out.println("Successfully you get the book");
                    System.out.println("Thank you!!!!");
                    break;
                }else{
                    System.out.println("BOOK out of stock!!!");
                }
            }

        }
        if(!getbook) {
            System.out.println("Book  not found!!!");
        }
    }

    public static void issueBook(ArrayList<UserBookMaintain> userBookMaintains) {
        System.out.println("           Detail of issue book             ");
        for (UserBookMaintain u : userBookMaintains) {
            System.out.println(u);
        }

    }

    public static void returnBook(ArrayList<UserBookMaintain> userBookMaintains, Scanner scanner, ArrayList<Book> booklist) {
        issueBook(userBookMaintains);
        System.out.println("Do you want to return the book press 1 otherwise 2 to exit");
        int num = scanner.nextInt();
        switch (num) {
            case 1:
                System.out.println("Enter the book  ID :");
                String bookid = scanner.next();
                boolean returnbook = false;
                for (UserBookMaintain u : userBookMaintains) {

                        if (bookid.equals(u.getbook.book_ID)) {
                            for(Book b : booklist) {
                                b.book_count += u.bookcount;
                            }
                            userBookMaintains.remove(u);
                            returnbook = true;
                            System.out.println("Successfully book will be returned!!!");
                            break;
                        }
                        break;
                }
                if(! returnbook)
            {
                System.out.println("BOOK NOT FOUND!!!!");
                break;
            }
                break;
            case 2:
                System.out.println("Exit..");
                break;
        }

    }
}
