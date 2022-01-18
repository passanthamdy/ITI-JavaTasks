package javaDay5;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.*;


public class moveText extends Applet implements KeyListener {
    static int x =15 ;       // The change in the character's x position.
    static int y=15;        // The change in the character's y position.
   // static int posX = 50; // The character's current x position.
    //static int posY = 100; // The character's current y position.    
       public void init(){
      
        addKeyListener(this);
       }
       
            public void keyPressed(KeyEvent e){
                switch (e.getKeyCode()){
                    case KeyEvent.VK_LEFT:
                    x-=15;
                    if (x<0){x=getWidth();}
                    break;
                    case KeyEvent.VK_RIGHT:
                    x+=15;
                    if(x>getWidth()){x=0;}
                    break;
                    case KeyEvent.VK_UP:
                    y-=15;
                    if(y<0){y=getHeight();}
                    break;
                    case KeyEvent.VK_DOWN:
                    y+=15;
                    if(y>getHeight()){y=0;}
                    break;
                }
                repaint();
            

}

public void paint(Graphics g){
    g.drawString("Java", x , y);
    }
    public void keyReleased(KeyEvent e) {
    }

    public void keyTyped(KeyEvent e) {
    }

} 