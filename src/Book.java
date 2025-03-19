
public class Book {
    String book_name;
    String book_author;
    String book_ID;
    int year ;
    int book_count;
    public  Book(String book_name,String book_author,String book_ID,int year,int book_count)
    {
       this.book_name = book_name;
       this.book_author = book_author;
       this.book_ID = book_ID;
       this.year = year;
       this.book_count =  book_count;
    }
    public String toString()
    {
        return "BOOK_NAME :"+book_name+ "\nBOOK_AUTHOR :"+book_author+ "\nBOOK_ID :"+book_ID+ "\nBOOK_PUBLISHED "+year+"\nBOOK_COUNT :"+book_count+"\n--------------------------------------------------\n";
    }
}









