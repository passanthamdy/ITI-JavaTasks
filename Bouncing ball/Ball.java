package javaDay5;
import java.applet.Applet;
import java.awt.*;
import java.util.PrimitiveIterator.OfDouble;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class Ball extends Applet implements Runnable {
int x,y;
Thread th;
boolean flagW,flagH,startBtnFlag;
Button startBtn , pauseBtn; 
@SuppressWarnings("deprecation")

public void init() {
    x = 0;
    y = 50;
    flagW = true;
    flagH = true;
    startBtnFlag = true;
    startBtn = new Button("Start");
    pauseBtn = new Button("Pause");
    add(startBtn);
    add(pauseBtn);
    th = new Thread(this);
    startBtn.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent ev) {
            if (startBtnFlag) {
                th.start();
                startBtnFlag = false;
            } else {
                th.resume();
            }
            repaint();
        }
    });
    pauseBtn.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent ev) {
            th.suspend();

        }
    });
}
public void paint(Graphics g) {
    g.setColor(Color.BLUE);
    g.fillOval(x, y, 40, 40);
}
public void run(){

    while(true){
        //ball hit the width
        if(flagW){
            if(x< (getWidth()-40)){
                x  +=15;
               //System.out.println();
                
            }
             else  {
                flagW=false;
                
               
            }
        }
        else{
            if (x > 0) {
                x -= 15;
                repaint();
            } 
            else{
                flagW=true;
            }
        }
            //ball 
         
        if (flagH) {
            if (y < (getHeight() -40)) {
                y += 15;
                //x-=20;
              
            } else {
                flagH = false;
            }
        } 
        else {
            if (y > 0) {
                y += -15;
               // x+=20;
               
            } else  if(y<0){
                flagH = true;
            }
        }
        repaint();
    try {
        Thread.sleep(100);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
}

};
}
