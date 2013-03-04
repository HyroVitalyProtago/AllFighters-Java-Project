/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import java.awt.Graphics;
import javax.swing.JPanel;
import modele.Jeu;

/**
 *
 * @author MyMac
 */
public class Dessin extends JPanel {

    private Jeu jeu;

    public Dessin(Jeu jeu) {        
        this.jeu = jeu;
    }
    /*
    public void updateSize() {
        this.room.setWidth(this.getWidth());
        this.room.setHeight(this.getHeight());
    }
    */
    @Override
    public void paint(Graphics grphcs) {
        
        //Graphics2D g = (Graphics2D) grphcs;
        //g.translate(0, this.getHeight());
        //g.scale(1.0, -1.0);
        
        this.jeu.draw(grphcs); // DRAW & UPDATE
    }        
    
}
