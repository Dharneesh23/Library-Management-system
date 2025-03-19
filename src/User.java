import javax.naming.Name;

public class User {
    String name;
    String userid;
    String roll_no;
    public User(String name ,String userid,String roll_no)
    {
       this.name=name;
       this.userid=userid;
       this.roll_no=roll_no;
    }
    public String toString()
    {
        return "NAME :"+name+"\n"+"USER_ID :"+userid+"\n"+"ROLL_NO :"+roll_no+"\n---------------------\n";
    }
}
