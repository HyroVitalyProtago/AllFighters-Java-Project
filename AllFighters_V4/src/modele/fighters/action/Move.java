/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modele.fighters.action;

import modele.fighters.Fighter;
import modele.fighters.Fighter_State;
import modele.objects.Direction;

/**
 *
 * @author MyMac
 */
public class Move extends Action {

    private Direction dir;

    public Move(Direction dir, Fighter fighter) {
        super(fighter);
        this.dir = dir;
    }
    
    @Override
    public boolean isPossible() {
        Fighter_State[] states = {Fighter_State.stance1, 
            Fighter_State.stance2, 
            Fighter_State.run, 
            Fighter_State.walk, 
            Fighter_State.jump_up, 
            Fighter_State.jump_down};
        return stateIn(states);
    }

    @Override
    public void exec() {
        this.fighter.move(dir);
    }
    
}
