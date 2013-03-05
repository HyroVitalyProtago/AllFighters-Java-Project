/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdk_allfighters;

import com.sun.java.swing.plaf.windows.WindowsBorders;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import modele.objects.FImage;

/**
 *
 * @author MyMac
 */
public class AF_Panel extends JScrollPane {

    private AF_Frame frame;
    private MyPanel panel;

    public AF_Panel(AF_Frame frame) {
        this.frame = frame;

        panel = new MyPanel();
        //this.add(panel);

        this.setViewportView(panel);

        this.setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(8,5,3,5), new LineBorder(Color.LIGHT_GRAY)));

        this.setBackground(new Color(236, 236, 236));

        //this.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        //this.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

    }

    public class MyPanel extends JPanel {

        public MyPanel() {
            //this.setBorder(new EmptyBorder(10, 10, 10, 10));
        }

        public void update() {
            /*
            if (AF_Panel.this.frame != null) {
                FImage image = AF_Panel.this.frame.getImage();
                if (image != null) {
                    this.setSize(image.getSize());
                }
            }
            *
            */
        }

        @Override
        public void paint(Graphics grphcs) {
            super.paint(grphcs);
            /*
            Graphics2D g = (Graphics2D) grphcs;

            g.scale(4, 4);

            FImage image = AF_Panel.this.frame.getImage();
            if (image != null) {
                image.draw(g);
            }
            *
            */
        }
    }

    /*
    @Override
    public void repaint() {
        super.repaint();
        if (this.panel != null) {
            //this.panel.update();
            this.panel.repaint();
        }
    }*/
}
