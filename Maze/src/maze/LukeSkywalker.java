/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maze;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author burakdursun
 */
public class LukeSkywalker {
    private int tileX,tileY;
    private Image luke;
    public LukeSkywalker() {
        ImageIcon img = new ImageIcon("C:\\Users\\burakdursun\\Desktop\\Maze\\Sky.png");
        luke=img.getImage();
       
        tileX=6;
        tileY=5;
        
    }
    public Image getLuke(){
        return luke;
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
