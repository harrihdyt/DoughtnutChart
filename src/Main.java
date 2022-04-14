import org.w3c.dom.Text;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.Arc2D;
import java.awt.geom.Rectangle2D;

public class Main extends JPanel {

//    Nama kelompok
//    String [] kelompok= {"Hairul Anwar", "Harri Hidayat", "Muhammad Arip", "Muhammad Hapy Dudin", "Muhammadd Haqqul Rizki"};


//    Field Definition for save date
    String [] label = {"N01", "N02", "N03", "N04", "N05", "N06", "N07", "N08", "N09", "N10"};
    int[] data = {30, 51, 100, 80, 84, 98, 73, 109, 36, 36};
    Color [] warna = {Color.BLUE, Color.RED, Color.GREEN, Color.MAGENTA, Color.blue, Color.ORANGE, Color.LIGHT_GRAY, Color.lightGray, Color.green, Color.magenta};

//    Construstor
    public Main(){
        this.setPreferredSize(new Dimension(300, 300));
        this.setBackground(Color.white);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

//        Penggunaan anti alias
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

//        menghitung total
        float total = 0.0f;
        for (int k = 0; k < data.length; k++)
            total += data[k];

//        Menghitung sudut atau prosentase tiap tiap sektor
        float sudut, awal = 90; //Sudut Donat
        float lx = 220, ly = 70, lw = 10, lh = 10; //Wijaba
        for (int k = 0; k < data.length; k++) {
//Hitung besarnya sudut tiap-tiap sektor
            sudut = 360.0f * data[k] / total;
            Shape sektor = new Arc2D.Float(30, 30, 150, 150, awal, sudut, Arc2D.PIE);

            //Tampilkan (Render) PIE
            g2.setColor(warna[k]);
            g2.fill(sektor);
            awal += sudut;

            //Tampilkan di sebelah kanan
            g2.fill(new Rectangle2D.Float(lx, ly, lw, lh));
            g2.setColor(java.awt.Color.BLACK);
            g2.drawString(label[k], lx+lw+5, ly+lh);
            ly += (lh+5);

            g2.setColor(Color.white);
            g2.fillOval(80, 80, 50, 50); //lingkaran penuh


        }
    }

    public static void main(String args[]){
        // TODO code Nandaka logic here
//Buat frame dengan title sesuai kebutuhan
        JFrame frame = new JFrame ("Doughnut Chart");
        frame.setSize(650,350);
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e)
            {
                System.exit(0);
            }
        });

//tambahkan objek dari PieChart
        Main canvas = new Main();
        frame.getContentPane().add(canvas);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }


}
