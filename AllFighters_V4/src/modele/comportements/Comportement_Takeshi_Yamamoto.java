/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modele.comportements;

import modele.fighters.Fighter;
import modele.fighters.Fighter_State;
import modele.objects.Direction;

/**
 *
 * @author MyMac
 */
public class Comportement_Takeshi_Yamamoto extends Comportement {

    public Comportement_Takeshi_Yamamoto(Fighter fighter) {
        super(fighter);
        fighter.setDir(Direction.RIGHT);
    }
    
    public void update() {
        
        //Ne prend pas en compte le changement de direction
        if (this.fighter.getState() == Fighter_State.hit) {
            this.fighter.setVelocityX(0);
            
            this.fighter.move(fighter.getDir().inverse(), 0.5);
            
            if (this.fighter.getCurrentSprite().getNbFoisJoue() == 1) {
                this.fighter.setVelocityX(0);
                
                if (this.fighter.isOnGround()) {
                    this.fighter.setState(Fighter_State.stance1);
                    update();
                }
            } else {
                return;
            }
        }
        
        //Changement de direction
        if (this.fighter.getVelocityX() > 0) {
            fighter.setDir(Direction.RIGHT);
        } else if (this.fighter.getVelocityX() < 0) {
            fighter.setDir(Direction.LEFT);
        }

        if (this.fighter.getEnchainement() != null) {
            if (this.fighter.getCurrentSprite().getNbFoisJoue() == 1) {
                this.fighter.setState(this.fighter.getEnchainement());
                this.fighter.setEnchainement(null);
                update();
            }
            return;
        }
        
        if (this.fighter.getState() == Fighter_State.forward_y) {
            this.fighter.setVelocityX(0);
            if (this.fighter.getCurrentSprite().getNbFoisJoue() == 1) {                
                this.fighter.setState(Fighter_State.stance1);
                update();
            }
            return;
        }                
        
        if (this.fighter.getState() == Fighter_State.y_combo_begin) {
            this.fighter.setVelocityX(0);
            if (this.fighter.getCurrentSprite().getNbFoisJoue() == 1) {
                this.fighter.setState(Fighter_State.y_combo_end); //par défaut
                update();
            }
            return;
        }
        
        if (this.fighter.getState() == Fighter_State.y_combo_end) {
            this.fighter.setVelocityX(0);
            if (this.fighter.getCurrentSprite().getNbFoisJoue() == 1) {
                this.fighter.setState(Fighter_State.stance1);
                update();
            }
            return;
        }
        
        if (this.fighter.getState() == Fighter_State.getup) {
            this.fighter.setVelocityX(0);
            if (this.fighter.getCurrentSprite().getNbFoisJoue() == 1) {
                this.fighter.setState(Fighter_State.stance1);
                update();
            }
            return;
        }
        
        if (this.fighter.getVelocityY() <= 0 && this.fighter.getState() == Fighter_State.jump_up) {
            this.fighter.setState(Fighter_State.jump_down);
            return;
        }
        
        if (this.fighter.getVelocityY() < 0) {
            this.fighter.setState(Fighter_State.jump_down);
            return;
        }
        
        if (this.fighter.getVelocityX() == 0 && this.fighter.getVelocityY() == 0 && 
                this.fighter.getState() != Fighter_State.stance1 && this.fighter.getState() != Fighter_State.stance2) {
            this.fighter.setState(Fighter_State.stance1);
        } else if (this.fighter.getVelocityX() != 0 && this.fighter.getVelocityY() == 0) {
            this.fighter.setState(Fighter_State.walk);
        } else if (this.fighter.getVelocityY() == 0) {
            if(this.fighter.getState() == Fighter_State.stance1 && this.fighter.getCurrentSprite().getNbFoisJoue() == 3) {
                this.fighter.setState(Fighter_State.stance2);
            } else if(this.fighter.getState() == Fighter_State.stance2 && this.fighter.getCurrentSprite().getNbFoisJoue() == 2) {
                this.fighter.setState(Fighter_State.stance1);
            }
        }
        
    }
    
}
