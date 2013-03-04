/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modele.fighters.action;

import modele.fighters.Fighter;
import modele.fighters.Fighter_State;

/**
 *
 * @author MyMac
 */
public abstract class Action {
    
    protected Fighter fighter;

    public Action(Fighter fighter) {
        this.fighter = fighter;
    }
    
    public boolean stateIn(Fighter_State[] states) {
        boolean in = false;
        for (Fighter_State fighter_State : states) {
            if (this.fighter.getState() == fighter_State) return true;
        }
        return in;
    }
    
    public abstract boolean isPossible();
    public abstract void exec();
    public void execIfIsPossible() {
        if (isPossible()) {
            exec();
        }
    }
    
}
