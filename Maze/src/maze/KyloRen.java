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
public class KyloRen {
    private int tileX,tileY;
    private Image kylo;
    
    private int[][] harita = new int[15][12];
    public int[][] yol = new int[100][2];
    int mesafe = 0;
    
    
    public KyloRen() {
        ImageIcon img = new ImageIcon("C:\\Users\\burakdursun\\Desktop\\Maze\\kylo.png");
        kylo=img.getImage();
       
        
    }
    public Image getKylo(){
        return kylo;
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
    
        public void HedefTakip(int AdimSayisi,int HedefX,int HedefY,Map map) {
        for (int adim = 0; adim < AdimSayisi; adim++) {

            for (int x = 0; x < 15; x++) {
                for (int y = 0; y < 12; y++) {
                    harita[x][y] = 900;
                }
            }
            harita[getTileX()][getTileY()] = 0;
            YolBul(getTileX() - 1, getTileY(), 1, 1,map);
            YolBul(getTileX() + 1, getTileY(), 1, 1,map);
            YolBul(getTileX(), getTileY() - 1, 1, 1,map);
            YolBul(getTileX(), getTileY() + 1, 1, 1,map);
            

          

            mesafe = harita[HedefX][HedefY];
            yol[mesafe][0] = HedefX;
            yol[mesafe][1] = HedefY;
            for (int i = mesafe - 1; i > -1; i--) {
                if (harita[yol[i + 1][0] + 1][yol[i + 1][1]] == i) {
                    yol[i][0] = yol[i + 1][0] + 1;
                    yol[i][1] = yol[i + 1][1];
                } else if (harita[yol[i + 1][0] - 1][yol[i + 1][1]] == i) {
                    yol[i][0] = yol[i + 1][0] - 1;
                    yol[i][1] = yol[i + 1][1];
                } else if (harita[yol[i + 1][0]][yol[i + 1][1] + 1] == i) {
                    yol[i][0] = yol[i + 1][0];
                    yol[i][1] = yol[i + 1][1] + 1;
                } else if (harita[yol[i + 1][0]][yol[i + 1][1] - 1] == i) {
                    yol[i][0] = yol[i + 1][0];
                    yol[i][1] = yol[i + 1][1] - 1;
                }
            }

            move(yol[1][0] - getTileX(), yol[1][1] - getTileY());
           

        }

    }

    public void YolBul(int DegerX, int DegerY, int mesafe, int karakter, Map m) {
        if ((DegerX > -1) && (DegerY > -1) && (DegerX < 14) && (DegerY < 11)) {
            if (karakter == 1 || karakter == 2) {  //kylo ren,stormtrooper
                if ((m.getMap(DegerX, DegerY).equals("1")) && (harita[DegerX][DegerY] > mesafe)) {
                    harita[DegerX][DegerY] = mesafe;
                    YolBul(DegerX - 1, DegerY, mesafe + 1, karakter,m);
                    YolBul(DegerX + 1, DegerY, mesafe + 1, karakter,m);
                    YolBul(DegerX, DegerY - 1, mesafe + 1, karakter,m);
                    YolBul(DegerX, DegerY + 1, mesafe + 1, karakter,m);
                }

            }
            if (karakter == 0) { //darth vader
                if (harita[DegerX][DegerY] > mesafe) {
                    harita[DegerX][DegerY] = mesafe;
                    YolBul(DegerX - 1, DegerY, mesafe + 1, karakter,m);
                    YolBul(DegerX + 1, DegerY, mesafe + 1, karakter,m);
                    YolBul(DegerX, DegerY - 1, mesafe + 1, karakter,m);
                    YolBul(DegerX, DegerY + 1, mesafe + 1, karakter,m);
                }

            }

        }

    }
}
