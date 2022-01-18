
import java.applet.Applet;
//import java.awt.*;

import java.awt.event.*;
import java.awt.Graphics;
import java.util.*;

//import javafx.scene.effect.Light.Point;

import java.awt.Color;


public class DrawLines extends Applet implements MouseListener, MouseMotionListener {
   int startX, startY,endX,endY;
   

   
    List <Shape>linesLst=new ArrayList<Shape>(); 
  
  public class Shape{
    int x1,y1,x2,y2;
  }
    public void init(){
       startX=startY=endX=endY=0;
        addMouseListener(this);
        addMouseMotionListener(this);
    }
    public void paint(Graphics g){
        g.drawLine( startX ,startY , endX , endY );
        for(Shape shape:linesLst){
            g.drawLine( shape.x1 , shape.y1 ,shape.x2 , shape.y2 );
          }
    }
   
    public void mouseClicked(MouseEvent e){ 
        
     
       // repaint();
    }
    public void mouseDragged (MouseEvent e){
     endX=e.getX();
     endY=e.getY();
     if ((startX != endX)&& (startY != endY)){
         repaint();
     }
    }
    
    public void mouseReleased(MouseEvent e) {
        endX=e.getX();
        endY=e.getY();
        if ((startX != endX)&& (startY != endY)){
            Shape line = new Shape();
            line.x1=startX;
            line.y1=startY;
            line.x2=endX;
            line.y2=endY;
            linesLst.add(line);
            repaint();

        }
    }

    public void mouseExited(MouseEvent event) {
    }

    public void mouseEntered(MouseEvent event) {
    }

    public void mousePressed(MouseEvent e) {
        startX=e.getX();
        startY=e.getY();
    }

    public void mouseMoved(MouseEvent event) {
    }
}
