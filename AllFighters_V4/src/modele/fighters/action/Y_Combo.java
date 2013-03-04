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
public class Y_Combo extends Action {

    public Y_Combo(Fighter fighter) {
        super(fighter);
    }

    @Override
    public boolean isPossible() {
        Fighter_State[] states = {Fighter_State.stance1, 
            Fighter_State.stance2, 
            Fighter_State.run, 
            Fighter_State.walk,
            Fighter_State.y_combo_begin};
        return stateIn(states);
    }

    @Override
    public void exec() {
        if (this.fighter.getState() != Fighter_State.y_combo_begin) {
            this.fighter.setState(Fighter_State.y_combo_begin);
        } else {
            // Si le joueur appui lors de "la fin du sprite y_combo_begin"
            if (this.fighter.isaToucheUnEnnemi()) {
                this.fighter.setEnchainement(Fighter_State.forward_y);
            }
        }
    }
    
}
