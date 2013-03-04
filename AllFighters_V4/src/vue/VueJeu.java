/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author MyMac
 */
public class VueJeu extends JFrame {

    private Run r;
    private JPanel panel;
    private ArrayList<ActionListener> actions;
    
    public VueJeu(Dessin v, int width, int height) {
        
        this.panel = v;
        this.add(v);
        
        this.setSize(width,height);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        
        //v.updateSize();
        
        this.requestFocus();
        
        this.actions = new ArrayList<ActionListener>();
        
        r = new Run();                
        
    }
    
    public void start() {
        r.start();
    }
    
    public void addActionListener(ActionListener a) {
        this.actions.add(a);
    }
    
    public class Run extends Thread {

        public Run() {
        }        
        
        @Override
        public void run() {
            while (true) {
                //VueJeu.this.addWindowListener(null);
                for (ActionListener actionListener : actions) {
                    actionListener.actionPerformed(null);
                }
                VueJeu.this.panel.repaint();
                VueJeu.this.panel.updateUI();
                try {
                    this.sleep(2);
                    //this.sleep(100);
                } catch (InterruptedException ex) {
                    Logger.getLogger(VueJeu.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        }
        
    }
    
}
