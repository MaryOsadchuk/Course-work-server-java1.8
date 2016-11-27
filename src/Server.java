import data.*;

import java.util.Scanner;

/**
 * Created by Vladimir on 27.11.2016.
 */
public class Server {
   private int id = 0;
   private String  user="";
   private String  password="";



    public static void main(String[] args) {
       SQLiteJDBC r = new SQLiteJDBC();
        Scanner in = new Scanner(System.in);

        //int user =in.nextInt();
        //int id;
        String  username="usedqwdqr";
        String  password="sadwqdwqsay";
        //r.addUser(1,"abra",password);

        boolean flag = r.isPresent("fake");

        if (flag==true){System.out.println("Present");} else{System.out.println("Not Present");}
        //id= r.getID(username);
       // username=r.getName(id);
        //password=r.getPassword(id);
        //r.deleteUser(0);
       // System.out.println(id);
     //       r.printAllList();
    }

}
