/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import controller.FighterController;
import java.awt.Point;
import modele.fighters.Fighter;

/**
 *
 * @author MyMac
 */
public class Joueur {
    
    protected Fighter fighter;
    protected FighterController controller;

    public Joueur(Fighter fighter, FighterController controller) {
        this.fighter = fighter;
        this.controller = controller;
    }

    public Fighter getFighter() {
        return fighter;
    }

    public FighterController getController() {
        return controller;
    }
    
    public Point getLocation() {
        return this.fighter.getLocation();
    }
 
    public void updateControl() {
        this.controller.update();
    }
    
}
