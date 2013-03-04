/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import allfighters.AllFighters;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import modele.fighters.Fighter;
import modele.fighters.Fighter_State;

/**
 *
 * @author MyMac
 */
public class FighterController1 extends FighterController {

    public FighterController1(Fighter fighter) {
        super(fighter);
    }
    
    @Override
    public void keyPressed(KeyEvent ke) {
        //System.out.println(ke.getKeyCode());        
        switch (ke.getKeyCode()) {
            case KeyEvent.VK_W:
                if (AllFighters.DEV_SPRITE) {
                    fighter.nextSprite();
                }
                if (!this.UP) {
                    this.UP = true;
                    this.nbKeyPressed++;
                }
                break;
            case KeyEvent.VK_S:
                if (AllFighters.DEV_SPRITE) {
                    fighter.previousSprite();
                }
                if (!this.DOWN) {
                    this.DOWN = true;
                    this.nbKeyPressed++;
                }
                break;
            case KeyEvent.VK_A:
                if (AllFighters.DEV_SPRITE) {
                    fighter.getCurrentSprite().previous();
                }
                if (!this.LEFT) {
                    this.LEFT = true;
                    this.nbKeyPressed++;
                }
                break;
            case KeyEvent.VK_D:
                if (AllFighters.DEV_SPRITE) {
                    fighter.getCurrentSprite().next();
                }
                if (!this.RIGHT) {
                    this.RIGHT = true;
                    this.nbKeyPressed++;
                }
                break;
            case KEY_ENTER:
                fighter.nextSprite();
                break;
            case KEY_RETURN:
                fighter.previousSprite();              
                break;
            case KeyEvent.VK_E:
                if (!this.Y_Combo) {
                    this.Y_Combo = true;
                    this.nbKeyPressed++;
                }
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        //System.out.println(ke.getKeyCode());        
        switch (ke.getKeyCode()) {
            case KeyEvent.VK_W:
                this.nbKeyPressed--;
                this.UP = false;
                break;
            case KeyEvent.VK_S:
                this.nbKeyPressed--;
                this.DOWN = false;
                break;
            case KeyEvent.VK_A:
                this.nbKeyPressed--;
                this.LEFT = false;
                this.fighter.setVelocityX(0);
                break;
            case KeyEvent.VK_D:
                this.nbKeyPressed--;
                this.RIGHT = false;
                this.fighter.setVelocityX(0);
                break;
            case KeyEvent.VK_E:
                this.nbKeyPressed--;
                this.Y_Combo = false;
                break;
        }
    }

    @Override
    public void keyTyped(KeyEvent ke) {
        //System.out.println(ke.getKeyCode());
    }
}
