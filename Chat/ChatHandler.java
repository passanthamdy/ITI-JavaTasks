import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Vector;

public class ChatHandler extends Thread{
 //   Socket s;
    DataInputStream dis ;
    PrintStream ps;

    static Vector<ChatHandler> clientsVector =new Vector<ChatHandler>();   
    public ChatHandler(Socket cs){
        try {
            dis = new DataInputStream(cs.getInputStream());
            ps = new PrintStream(cs.getOutputStream());

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        clientsVector.add(this);
        start();
    }
    @SuppressWarnings("deprecation")

    public void run(){
        
        while(true){
            String str=null;
            try {
                str = dis.readLine();
                sendMsgToAll(str);  
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            
            }
            
            
        }
    
    }
    
    public void sendMsgToAll(String str){
        for (ChatHandler ch:clientsVector){
            ch.ps.println(str);
        }
    }
}
