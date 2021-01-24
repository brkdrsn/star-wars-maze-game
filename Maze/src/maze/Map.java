package maze;

import java.awt.*;
import java.io.*;
import java.util.Scanner;

import javax.swing.ImageIcon;

/**
 *
 * @author burakdursun
 */
public class Map {

    private Scanner m;
    private FileReader fr;
    private String Map[] = new String[14];
    
    private Image patch,wall;

    public Map() {
        
        try {
            m = new Scanner(new File("C:\\Users\\burakdursun\\Desktop\\Maze\\Harita.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("Harita Yüklenirken Hata oluştu.");
        }
        openFile();
        readFile();
        closeFile();

    }

    public Image getPatch() {
        return patch;
    }

    public Image getWall() {
        return wall;
    }

    public String getMap(int x, int y) {
        String index = Map[y].substring(x, x + 1);
        for(int i=0;i<Map.length;i++){
            /*if(Map[i].indexOf("0")){
              
            Map[i].split(" ");}
            */
        }
        //Map[y].split(" ");
        return index;
    }

    public void openFile() {
        try {
            m = new Scanner(new File("C:\\Users\\burakdursun\\Desktop\\Maze\\Harita1.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("Harita Yüklenirken Hata oluştu.");
        }
    }

    public void readFile() {
        while (m.hasNext()) {
           
            for (int i = 0; i < 11; i++) {
                
                Map[i] = m.next();
                //System.out.println(Map[i]);
           }
        }
    }

    public void closeFile() {
        m.close();
    }

}
