/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modele.comportements;

import modele.fighters.Fighter;

/**
 *
 * @author MyMac
 */
public abstract class Comportement {
    
    protected Fighter fighter;    
    
    public Comportement(Fighter fighter) {
        this.fighter = fighter;
    }

    public abstract void update();
    
}
