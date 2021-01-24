/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maze;

import java.awt.Color;
import javax.swing.*;

/**
 *
 * @author burakdursun
 */
public class Maze {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new Maze();
    }

    public Maze() {
        
        JFrame f=new JFrame();
      
       f.add(new Board());
       
       
        f.setTitle("Star Wars");
        
        f.setSize(800, 600);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
        
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
       
        
    }
    
    
}
