
import java.util.ArrayList;
import java.util.Scanner;
public class Login {
    Scanner scanner = new Scanner(System.in);
    ArrayList<User> list = new ArrayList<>();
    ArrayList<Book> booklist = new ArrayList<>();
    ArrayList<UserBookMaintain>userBookMaintains = new ArrayList<>();
    public void login() {
        while (true) {
            System.out.println("            Welcome                   ");
            System.out.println();
            System.out.println("1.USER ");
            System.out.println("2.ADMIN ");
            System.out.println("3.EXIT");
            System.out.println("Enter your choice ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                   UserAction.userlogin(scanner,list,booklist,userBookMaintains);
                    break;
                case 2:
                    AdminAction.adminlogin(scanner,list,booklist);
                    break;
                case 3:
                    System.out.println("Exiting......");
                    return;
            }
        }
    }



}

