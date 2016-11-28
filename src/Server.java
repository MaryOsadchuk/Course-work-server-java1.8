import data.*;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by Vladimir on 27.11.2016.
 */
public class Server {
//   private int id = 0;
  // private String  user="";
  // private String  password="";

public static final  int PORT = 29757;

 private ServerSocket serversocket = null;


    public void setSocketConnection() {
        Socket socket=new Socket();
        try {
            serversocket = new ServerSocket(PORT);
            System.out.println("Server connection was fully created");

            socket = serversocket.accept();
        }catch(IOException e){

        }
        while (true) {

            try {



                System.out.println("Connection was fully accepted");
                try (
                        InputStream in = socket.getInputStream();
                        OutputStream out = socket.getOutputStream();) {
                    byte[] buf = new byte[32 * 1024];
                    int readBytes = in.read(buf);
                    String exitmessage = new String(buf, 0, readBytes);
                    System.out.println("Client>" + exitmessage);

                    out.write(exitmessage.getBytes());
                    out.flush();
                }


            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                System.out.println("Not real");
            }

        }
    }







    public static void main(String[] args) {
        /*   SQLiteJDBC r = new SQLiteJDBC();
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





        //       r.printAllList();*/

        Server a = new Server();

        a.setSocketConnection();


    }

}
