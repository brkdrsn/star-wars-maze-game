package maze;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author burakdursun
 */
public class Board extends JPanel implements ActionListener {

    public String adres = "C:\\Users\\burakdursun\\Desktop\\Maze";
    private Timer timer;
    private int click;

    private int HedefX = 0, HedefY = 0;
    private int[][] harita = new int[15][12];
    private int[][] yol = new int[100][2];
    public int end = 0, mesafe = 0, YolCizim = 0;

    private Map m;
    private Yoda y;
    private LukeSkywalker sky;
    private DarthVader darth;
    private Stormtrooper storm;
    private KyloRen kylo;
    private Image cup, apng, bpng, cpng, dpng, epng, health, health1, oksag, okust, okalt, oksol, can;
    private JButton yoda, sk;
    private int healthh = 6, healthh2 = 3;
    private JLabel lb;
      String[] karakter={"Karakter:Stormtrooper,Kapi:A","Karakter:Stormtrooper,Kapi:B","Karakter:Stormtrooper,Kapi:C","Karakter:Stormtrooper,Kapi:D","Karakter:Stormtrooper,Kapi:E"};
      String[] k1={"Karakter:Darth Vader,Kapi:A","Karakter:Darth Vader,Kapi:B","Karakter:Darth Vader,Kapi:C","Karakter:Darth Vader,Kapi:D","Karakter:Darth Vader,Kapi:E",};
      String[] k2={"Karakter:Kylo Ren,Kapi:A","Karakter:Kylo Ren,Kapi:B","Karakter:Kylo Ren,Kapi:C","Karakter:Kylo Ren,Kapi:D","Karakter:Kylo Ren,Kapi:E",};
    public Board() {

        ImageIcon img8 = new ImageIcon(adres + "\\health.png");
        health = img8.getImage();
        ImageIcon img11 = new ImageIcon(adres + "\\fhealth.png");
        health1 = img11.getImage();
        ImageIcon imgg8 = new ImageIcon(adres + "\\cantxt.png");
        can = imgg8.getImage();
        ImageIcon img7 = new ImageIcon(adres + "\\oksag.png");
        oksag = img7.getImage();
        ImageIcon imgg = new ImageIcon(adres + "\\oksol.png");
        oksol = imgg.getImage();
        ImageIcon img6 = new ImageIcon(adres + "\\okust.png");
        okust = img6.getImage();
        ImageIcon img9 = new ImageIcon(adres + "\\okalt.png");
        okalt = img9.getImage();
        ImageIcon img = new ImageIcon(adres + "\\cup.png");
        ImageIcon img1 = new ImageIcon(adres + "\\a.png");
        cup = img.getImage();
        apng = img1.getImage();
        ImageIcon img2 = new ImageIcon(adres + "\\b.png");
        bpng = img2.getImage();
        ImageIcon img3 = new ImageIcon(adres + "\\c.png");
        cpng = img3.getImage();
        ImageIcon img4 = new ImageIcon(adres + "\\d.png");
        dpng = img4.getImage();
        ImageIcon img5 = new ImageIcon(adres + "\\e.png");
        epng = img5.getImage();
        
        m = new Map();
        y = new Yoda();
        sky = new LukeSkywalker();
        darth = new DarthVader();
        kylo = new KyloRen();
        storm = new Stormtrooper();
        addKeyListener(new Al());
        addKeyListener(new All());

        setFocusable(true);
        timer = new Timer(25, this);
        timer.start();
        ImageIcon yodapng = new ImageIcon(adres + "\\bigyoda.png");
        ImageIcon skypng = new ImageIcon(adres + "\\bigsky.png");

        sk = new JButton("", skypng);

        yoda = new JButton("", yodapng);
        setLayout(new FlowLayout());
        add(yoda);
        add(sk);
        lb = new JLabel("↔     Master Yoda     ↔                                                                           ↔     Luke Skywalker     ↔");

        add(lb);

        yoda.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent me) {

            }

            @Override
            public void mousePressed(MouseEvent me) {

            }

            @Override

            public void mouseReleased(MouseEvent e) {

                click = 1;

                removeAll();
            }

            @Override
            public void mouseEntered(MouseEvent me) {

            }

            @Override
            public void mouseExited(MouseEvent me) {

            }
        });
        sk.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent me) {
                //.setVisible(false);
            }

            @Override
            public void mousePressed(MouseEvent me) {

            }

            @Override

            public void mouseReleased(MouseEvent e) {
                click = 0;
                removeAll();
            }

            @Override
            public void mouseEntered(MouseEvent me) {

            }

            @Override
            public void mouseExited(MouseEvent me) {

            }
        });
        
        
       darth.move(12, 0);
        kylo.move(4,0);
        storm.move(0,5);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        
        repaint();

    }

    @Override
    public void paint(Graphics g) {

        super.paint(g);

        if (!yoda.isDisplayable()) {

            g.translate(190, 170);
            {
                for (int row = 0; row < 11; row++) {
                    for (int col = 0; col < 14; col++) {
                        Color color;
                        if (m.getMap(col, row).equals("1")) {
                            g.setColor(Color.cyan);
                            g.fillRect(30 * col, 30 * row, 30, 30);

                        }
                        if (m.getMap(col, row).equals("0")) {
                            g.setColor(Color.DARK_GRAY);
                            g.fillRect(30 * col, 30 * row, 30, 30);
                        }
                        for (int i = 1; i < darth.mesafe; i++) {
                            if (darth.yol[i][0] == col && darth.yol[i][1] == row) {
                                g.setColor(Color.RED);
                                g.fillRect(30 * col, 30 * row, 30, 30);
                            }
                        }
                       
                       for (int i = 1; i < kylo.mesafe; i++) {
                            if (kylo.yol[i][0] == col && kylo.yol[i][1] == row) {
                                g.setColor(Color.ORANGE);
                                g.fillRect(30 * col, 30 * row, 30, 30);
                            }
                        }
                        for (int i = 1; i < storm.mesafe; i++) {
                            if (storm.yol[i][0] == col && storm.yol[i][1] == row) {
                                g.setColor(Color.PINK);
                                g.fillRect(30 * col, 30 * row, 30, 30);
                            }
                        }
                        
                        g.setColor(Color.BLACK);
                        g.drawRect(30 * col, 30 * row, 30, 30);

                    }
                }
            }
            g.drawImage(cup, 425, 265, this);

            g.drawImage(can, 180, -111, null);
            g.drawImage(apng, 0, 150, null);
            g.drawImage(oksag, -30, 150, null);
            g.drawImage(bpng, 120, 0, null);
            g.drawImage(okalt, 120, -30, null);
            g.drawImage(cpng, 360, 0, null);
            g.drawImage(okalt, 360, -30, null);
            g.drawImage(dpng, 390, 150, null);
            g.drawImage(oksol, 420, 150, null);
            g.drawImage(epng, 120, 300, null);
            g.drawImage(okust, 120, 330, null);

        }

        if (click == 1 && !yoda.isDisplayable()) {

            g.drawImage(y.getYoda(), (y.getTileX() * 30), (y.getTileY() * 30), null);
            if ((darth.getTileX() == y.getTileX() && darth.getTileY() == y.getTileY()) || (storm.getTileX() == y.getTileX() && storm.getTileY() == y.getTileY()) || (kylo.getTileX() == y.getTileX() && kylo.getTileY() == y.getTileY())) {

                y.Health();
                --healthh;

            }
            if (healthh == 6) {
                g.drawImage(health, 300, -100, null);
                g.drawImage(health, 340, -100, null);
                g.drawImage(health, 380, -100, null);
            }
            if (healthh == 5) {
                g.drawImage(health, 300, -100, null);
                g.drawImage(health, 340, -100, null);
                g.drawImage(health1, 380, -100, null);
            }
            if (healthh == 4) {
                g.drawImage(health, 300, -100, null);
                g.drawImage(health, 340, -100, null);

            }
            if (healthh == 3) {
                g.drawImage(health, 300, -100, null);
                g.drawImage(health1, 340, -100, null);
            }
            if (healthh == 2) {
                g.drawImage(health, 300, -100, null);
            }
            if (healthh == 1) {
                g.drawImage(health1, 300, -100, null);

            }
            if (healthh == 0) {
                healthh--;
                while (1 == 1) {
                    JOptionPane.showMessageDialog(null, "GAME OVER", "GAME OVER", 2);
                    break;
                }
            }

        }
        if (click == 1 || click == 0 && !yoda.isDisplayable()) {
           
          g.drawImage(darth.getDarth(), (darth.getTileX() * 30), (darth.getTileY() * 30), null);
           
          g.drawImage(kylo.getKylo(), (kylo.getTileX() * 30), (kylo.getTileY() * 30), null);
            
            g.drawImage(storm.getStorm(), (storm.getTileX() * 30), (storm.getTileY() * 30), null);
            
            
        }

        if (click == 0 && !sk.isDisplayable()) {
            g.drawImage(sky.getLuke(), (sky.getTileX() * 30), (sky.getTileY() * 30), null);
            if ((darth.getTileX() == sky.getTileX() && darth.getTileY() == sky.getTileY()) ||(storm.getTileX() == sky.getTileX() && storm.getTileY() == sky.getTileY())||(kylo.getTileX() == sky.getTileX() && kylo.getTileY() == sky.getTileY())) {
                sky.Health();
                --healthh2;

            }
            if (healthh2 == 3) {
                g.drawImage(health, 300, -100, null);
                g.drawImage(health, 340, -100, null);
                g.drawImage(health, 380, -100, null);
            }

            if (healthh2 == 2) {
                g.drawImage(health, 300, -100, null);
                g.drawImage(health, 340, -100, null);
            }

            if (healthh2 == 1) {
                g.drawImage(health, 300, -100, null);
            }

            if (healthh2 == 0) {
                healthh2--;
                while (1 == 1) {
                    JOptionPane.showMessageDialog(null, "GAME OVER", "GAME OVER", 2);
                    break;
                }
            }

        }
    }

    public class Al extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {
            int keycode = e.getKeyCode();
            if (keycode == KeyEvent.VK_UP && click == 1) {
                if (m.getMap(y.getTileX(), y.getTileY() - 1).equals("1") && y.getTileY() > 0) {
                    y.move(0, -1);
                    darth.HedefTakip(1,y.getTileX(),y.getTileY(),m);
                    
                    kylo.HedefTakip(2,y.getTileX(),y.getTileY(),m);
                    storm.HedefTakip(1,y.getTileX(),y.getTileY(),m);
                    
                }
            }
            if (keycode == KeyEvent.VK_DOWN && click == 1) {
                if (m.getMap(y.getTileX(), y.getTileY() + 1).equals("1") && y.getTileY() < 12) {
                    y.move(0, 1);
                    darth.HedefTakip(1,y.getTileX(),y.getTileY(),m);
                    kylo.HedefTakip(2,y.getTileX(),y.getTileY(),m);
                    storm.HedefTakip(1,y.getTileX(),y.getTileY(),m);
                }
            }
            if (keycode == KeyEvent.VK_LEFT && click == 1) {
                if (m.getMap(y.getTileX() - 1, y.getTileY()).equals("1") && y.getTileX() > 0) {
                    y.move(-1, 0);
                    darth.HedefTakip(1,y.getTileX(),y.getTileY(),m);
                     kylo.HedefTakip(2,y.getTileX(),y.getTileY(),m);
                    storm.HedefTakip(1,y.getTileX(),y.getTileY(),m);
                }
            }
            if (keycode == KeyEvent.VK_RIGHT && click == 1) {
                if (m.getMap(y.getTileX() + 1, y.getTileY()).equals("1") && y.getTileX() < 14) {
                    y.move(1, 0);
                    darth.HedefTakip(1,y.getTileX(),y.getTileY(),m);
                     kylo.HedefTakip(2,y.getTileX(),y.getTileY(),m);
                    storm.HedefTakip(1,y.getTileX(),y.getTileY(),m);
                }
            }
            OyunKontrol();
        }
    }

    public class All extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {
            int keycode = e.getKeyCode();
            if (keycode == KeyEvent.VK_UP && click == 0) {
                if (!m.getMap(sky.getTileX(), sky.getTileY() - 1).equals("0") && sky.getTileY() > 0) {
                    sky.move(0, -1);
                    darth.HedefTakip(1,sky.getTileX(),sky.getTileY(),m);
                    kylo.HedefTakip(2,sky.getTileX(),sky.getTileY(),m);
                    storm.HedefTakip(1,sky.getTileX(),sky.getTileY(),m);
                }
            }
            if (keycode == KeyEvent.VK_DOWN && click == 0) {
                if (!m.getMap(sky.getTileX(), sky.getTileY() + 1).equals("0") && sky.getTileY() < 12) {
                    sky.move(0, 1);
                    darth.HedefTakip(1,sky.getTileX(),sky.getTileY(),m);
                    kylo.HedefTakip(2,sky.getTileX(),sky.getTileY(),m);
                    storm.HedefTakip(1,sky.getTileX(),sky.getTileY(),m);
                }
            }
            if (keycode == KeyEvent.VK_LEFT && click == 0) {
                if (!m.getMap(sky.getTileX() - 1, sky.getTileY()).equals("0") && sky.getTileX() > 0) {
                    sky.move(-1, 0);
                    darth.HedefTakip(1,sky.getTileX(),sky.getTileY(),m);
                    kylo.HedefTakip(2,sky.getTileX(),sky.getTileY(),m);
                    storm.HedefTakip(1,sky.getTileX(),sky.getTileY(),m);
                }
            }
            if (keycode == KeyEvent.VK_RIGHT && click == 0) {
                if (!m.getMap(sky.getTileX() + 1, sky.getTileY()).equals("0") && sky.getTileX() < 14) {
                    sky.move(1, 0);
                    darth.HedefTakip(1,sky.getTileX(),sky.getTileY(),m);
                    kylo.HedefTakip(2,sky.getTileX(),sky.getTileY(),m);
                    storm.HedefTakip(1,sky.getTileX(),sky.getTileY(),m);
                }
            }
            OyunKontrol();
        }
    }

    public void OyunKontrol() {
        if (((y.getTileX() == 13) && (y.getTileY() == 9)) && (end == 0)) {
            JOptionPane.showMessageDialog(null, "GOOD GAME", "GOOD GAME!", 1);
            end = 1;
        }
        if (sky.getTileX() == 13 && sky.getTileY() == 9 && end == 0) {
            JOptionPane.showMessageDialog(null, "GOOD GAME", "GOOD GAME", 1);
            end = 1;
        }
    }

    public void HedefTakip(int AdimSayisi) {
        for (int adim = 0; adim < AdimSayisi; adim++) {

            for (int x = 0; x < 15; x++) {
                for (int y = 0; y < 12; y++) {
                    harita[x][y] = 900;
                }
            }
            /*harita[darth.getTileX()][darth.getTileY()] = 0;
            YolBul(darth.getTileX() - 1, darth.getTileY(), 1, 0);
            YolBul(darth.getTileX() + 1, darth.getTileY(), 1, 0);
            YolBul(darth.getTileX(), darth.getTileY() - 1, 1, 0);
            YolBul(darth.getTileX(), darth.getTileY() + 1, 1, 0);*/
            

            if (click == 0) {
                HedefX = sky.getTileX();
                HedefY = sky.getTileY();
            } else if (click == 1) {
                HedefX = y.getTileX();
                HedefY = y.getTileY();
            }

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

            darth.move(yol[1][0] - darth.getTileX(), yol[1][1] - darth.getTileY());
            storm.move(yol[1][0] - storm.getTileX(), yol[1][1] - storm.getTileY());
            kylo.move(yol[1][0] - kylo.getTileX(), yol[1][1] - kylo.getTileY());

        }

    }

    /*public void YolBul(int DegerX, int DegerY, int mesafe, int karakter) {
        if ((DegerX > -1) && (DegerY > -1) && (DegerX < 14) && (DegerY < 11)) {
            if (karakter == 1 || karakter == 2) {  //kylo ren,stormtrooper
                if ((m.getMap(DegerX, DegerY).equals("1")) && (harita[DegerX][DegerY] > mesafe)) {
                    harita[DegerX][DegerY] = mesafe;
                    YolBul(DegerX - 1, DegerY, mesafe + 1, karakter);
                    YolBul(DegerX + 1, DegerY, mesafe + 1, karakter);
                    YolBul(DegerX, DegerY - 1, mesafe + 1, karakter);
                    YolBul(DegerX, DegerY + 1, mesafe + 1, karakter);
                }

            }
            if (karakter == 0) { //darth vader
                if (harita[DegerX][DegerY] > mesafe) {
                    harita[DegerX][DegerY] = mesafe;
                    YolBul(DegerX - 1, DegerY, mesafe + 1, karakter);
                    YolBul(DegerX + 1, DegerY, mesafe + 1, karakter);
                    YolBul(DegerX, DegerY - 1, mesafe + 1, karakter);
                    YolBul(DegerX, DegerY + 1, mesafe + 1, karakter);
                }

            }

        }

    }*/
}
