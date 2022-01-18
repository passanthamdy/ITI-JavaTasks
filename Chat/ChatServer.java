import java.io.IOException;
import java.net.*;

public class ChatServer {
    ServerSocket serverSocket;
    public ChatServer(){
        try {
            serverSocket = new ServerSocket(5005);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        while(true){
            try {
                Socket s=  serverSocket.accept();
                new ChatHandler(s);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args)
{
new ChatServer();
}
}
