public class UserBookMaintain {
    Book getbook;
    int bookcount;
    public UserBookMaintain(Book getbook,int bookcount)
    {
        this.getbook = getbook;
        this.bookcount = bookcount;
    }
    public String toString()
    {
        return "BOOK_NAME :"+getbook.book_name+ "\nBOOK_AUTHOR :"+getbook.book_author+ "\nBOOK_ID :"+getbook.book_ID+ "\nBOOK_PUBLISHED "+getbook.year+ "\nBOOK_COUNT :"+getbook.book_count+"\n--------------------------------------------------\n";
    }
}
