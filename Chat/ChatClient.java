import java.awt.*;
import java.awt.event.*;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.*;

import javax.swing.*;
public class ChatClient extends JFrame implements Runnable{
    
    JTextArea ta;
    JScrollPane scroll;
    JTextField tf ;
    JButton okButton;
    Socket s;
    DataInputStream dis ;
    PrintStream ps;

    public ChatClient(){
        ta = new JTextArea(20,50);
        scroll = new JScrollPane(ta);
        tf = new JTextField(40);
         okButton = new JButton("Send");
        try {
            s = new Socket(InetAddress.getLocalHost(),5005);
            dis = new DataInputStream(s.getInputStream());
            ps = new PrintStream(s.getOutputStream());
        }
         catch (UnknownHostException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } 
        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        this.setLayout(new FlowLayout());

        // get from client and append in text area instaed of get from textarea
        okButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                String message = tf.getText();
                ps.println(message);
            //ta.append(tf.getText()+"\n");
            tf.setText("");
            }
            });
            add(scroll);
            add(tf);
            add(okButton);
            new Thread(this).start();

           
            
        
        
    }

    public static void main(String args[]) {
        ChatClient chatclient = new ChatClient();
        chatclient.setSize(600, 400);
        chatclient.setResizable(false);
        chatclient.setVisible(true);
      }
      @SuppressWarnings("deprecation")

    public void run(){
        while (true) {
            try {
              String message = dis.readLine();
              ta.append(message + "\n");
            } catch (IOException e) {
            
            }
          }
    }

}
