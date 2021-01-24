/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maze;

import java.awt.Image;
import javax.swing.ImageIcon;


public class Yoda {
private int tileX,tileY;
private int health;
private Image yoda;
    public Yoda() {
        ImageIcon img = new ImageIcon("C:\\Users\\burakdursun\\Desktop\\Maze\\yoda.png");
        yoda=img.getImage();
       
        tileX=6;
        tileY=5;
        
    }
    
    public Image getYoda(){
        return yoda;
    }
    public void Health(){
        tileX=6;
        tileY=5;
       
      
    }
  
    public int getTileX() {
        return tileX;
    }

    public int getTileY() {
        return tileY;
    }
    
    public void move(int dx,int dy){
        
        tileX+=dx;
        tileY+=dy;
        
    }
}
