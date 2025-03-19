
import java.util.ArrayList;
import java.util.Scanner;

public class AdminAction {
    public static void adminlogin(Scanner scanner, ArrayList<User>list,ArrayList<Book>booklist)
    {
        System.out.println("Enter your adminId");
        String adminId = scanner.next();
        System.out.println("Enter your adminpass");
        String adminPass = scanner.next();
        Admin admin = new Admin("1","2");
        if(adminId.equals(admin.adminID))
        {
            if(adminPass.equals(admin.adminPass)) {
                System.out.println("Successfully login");
               labele: while (true) {
                    System.out.println("1.Add user");
                    System.out.println("2.Delete user");
                    System.out.println("3.View user");
                    System.out.println("4.Add Book");
                    System.out.println("5.View all Book");
                    System.out.println("6.Specific book search");
                    System.out.println("7.Remove Book");
                    System.out.println("8.Exit");
                    System.out.println("Enter your choice :");
                    int choice = scanner.nextInt();
                    AdminAction adminAction = new AdminAction();
                    switch (choice)
                    {
                        case 1:
                            adminAction.adduser(scanner,list);
                            break;
                        case 2 :
                            adminAction.deleteUser(scanner,list);
                            break;
                        case 3:
                            adminAction.viewAll_User(list);
                            break;
                        case 4:
                            adminAction.addBook(scanner,booklist);
                            break;
                        case 5 :
                            AdminAction.view_all_book(booklist);
                            break;
                        case 6:
                            AdminAction.Specific_book_search(booklist,scanner);
                            break;
                        case 7:
                            adminAction.removeBook(booklist,scanner);
                            break;
                        case 8:
                            System.out.println("Exit.....");
                            break labele;
                    }
                }
            }
        }else {
            System.out.println("INCORRECT ADMIN ID......");
        }

    }
    public void adduser(Scanner scanner,ArrayList<User>list) {
        System.out.println("Enter the name");
        String name = scanner.next();
        System.out.println("Enter the userId");
        String userId = scanner.next();
        if (!list.isEmpty()) {
            for (User n : list) {
                if (userId.equals(n.userid)) {
                    System.out.println("User already exits!!!");
                    return;
                }

            }
        }
            System.out.println("Enter the roll_No");
            String roll_no = scanner.next();
            User user = new User(name, userId, roll_no);
            list.add(user);
            System.out.println("Add user successfully!!!!");


    }
    public void deleteUser(Scanner scanner,ArrayList<User>list)
    {
        System.out.println("Enter the user_ID :");
        String userid = scanner.next();
        boolean user = false;
        for(User l : list)
        {
            if(l.userid.equals(userid))
            {
                list.remove(l);
                user = true;
                System.out.println(userid + " Successfully removed !!!");
               if(!user)
               {
                   System.out.println("User Not found!!!1");
                   break;
               }
               break;
            }

        }

    }

    public void viewAll_User(ArrayList<User>list)
    {
       for(User l : list)
       {
           System.out.println(l);
       }
    }
    public void addBook(Scanner scanner ,ArrayList<Book>booklist)
    {
        System.out.println("Enter the book Name :");

        String bookname = scanner.next();

        System.out.println("Enter the book author :");

        String bookauthor = scanner.next();

        System.out.println("Enter the book id :");

        String book_ID = scanner.next();

        System.out.println("Published year :");
        int year = scanner.nextInt();
        System.out.println("Enter the Book count ");
        int bookcount = scanner.nextInt();
        Book book = new Book(bookname,bookauthor,book_ID,year,bookcount);
        booklist.add(book);
        System.out.println("Successfully book will added!!!");
    }
    public static void view_all_book(ArrayList<Book>booklist)
    {
        System.out.println("Available Book are :");
        for(Book book: booklist)
        {
            System.out.println(book);
        }
    }
    public static void Specific_book_search(ArrayList<Book>booklist,Scanner scanner)
    {
        System.out.println("Enter the book_ID:");
        String book_id = scanner.next();
        boolean specficbook = false;
        for(Book b : booklist)
        {
            if(book_id.equals(b.book_ID))
            {
                System.out.println(b);
                specficbook = true;
                break;
            }



        }
        if(!specficbook) {
        System.out.println("BOOK NOT FOUND!!!!");
    }
    }
    public void removeBook(ArrayList<Book>booklist,Scanner scanner)
    {
        System.out.println("Enter the bookId :");
        String bookid = scanner.next();
        boolean book = false;
       for(Book  b : booklist)
        {
            if(bookid.equals(b.book_ID))
            {
                booklist.remove(b);
                book = true;
                System.out.println("Successfully book  was removed ");
                if(!book) {
                    System.out.println("BOOK NOT FOUND!!!!");
                    break;
                }
                break;
            }

        }
    }

}
