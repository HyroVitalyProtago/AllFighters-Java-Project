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
public class Jump extends Action {

    public Jump(Fighter fighter) {
        super(fighter);
    }
    
    @Override
    public boolean isPossible() {
        Fighter_State[] states = {Fighter_State.stance1, 
            Fighter_State.stance2, 
            Fighter_State.run, 
            Fighter_State.walk};
        return stateIn(states);
    }

    @Override
    public void exec() {
        this.fighter.jump();
    }
    
}
