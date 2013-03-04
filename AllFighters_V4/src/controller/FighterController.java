/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import allfighters.AllFighters;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import modele.fighters.Fighter;
import modele.fighters.Fighter_State;
import modele.fighters.action.Jump;
import modele.fighters.action.Move;
import modele.fighters.action.Y_Combo;
import modele.objects.Direction;

/**
 *
 * @author MyMac
 */
public class FighterController extends KeyAdapter {

    protected Fighter fighter;
    //
    protected int nbKeyPressed;
    protected boolean UP;
    protected boolean DOWN;
    protected boolean LEFT;
    protected boolean RIGHT;
    protected boolean Y_Combo;

    public FighterController(Fighter fighter) {
        //fighter.addController(this);
        this.fighter = fighter;

        this.UP = false;
        this.DOWN = false;
        this.LEFT = false;
        this.RIGHT = false;
        this.Y_Combo = false;

        this.nbKeyPressed = 0;

        if (!AllFighters.DEV_SPRITE) {
            //new Run().start();
        }
    }

    public void update() {
        if (FighterController.this.nbKeyPressed == 0) {
            //fighter.setVelocityX(0);
        }

        if (FighterController.this.UP) {
            new Jump(fighter).execIfIsPossible();
            //this.UP = false;
        }
        if (FighterController.this.DOWN) {
        }
        if (FighterController.this.LEFT) {
            new Move(Direction.LEFT, fighter).execIfIsPossible();
        }
        if (FighterController.this.RIGHT) {
            new Move(Direction.RIGHT, fighter).execIfIsPossible();
        }
        if (FighterController.this.Y_Combo) {
            new Y_Combo(fighter).execIfIsPossible();
            this.Y_Combo = false;
        }
    }

    protected static final int KEY_ENTER = 10;
    protected static final int KEY_RETURN = 8;

    @Override
    public void keyPressed(KeyEvent ke) {
        //System.out.println(ke.getKeyCode());        
        switch (ke.getKeyCode()) {
            case KeyEvent.VK_UP:
                if (AllFighters.DEV_SPRITE) {
                    fighter.nextSprite();
                }
                if (!this.UP) {
                    this.UP = true;
                    this.nbKeyPressed++;
                }
                break;
            case KeyEvent.VK_DOWN:
                if (AllFighters.DEV_SPRITE) {
                    fighter.previousSprite();
                }
                if (!this.DOWN) {
                    this.DOWN = true;
                    this.nbKeyPressed++;
                }
                break;
            case KeyEvent.VK_LEFT:
                if (AllFighters.DEV_SPRITE) {
                    fighter.getCurrentSprite().previous();
                }
                if (!this.LEFT) {
                    this.LEFT = true;
                    this.nbKeyPressed++;
                }
                break;
            case KeyEvent.VK_RIGHT:
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
            case KeyEvent.VK_Z:
                /*
                if (!this.Y_Combo) {
                    this.Y_Combo = true;
                    this.nbKeyPressed++;
                }*/
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        //System.out.println(ke.getKeyCode());        
        switch (ke.getKeyCode()) {
            case KeyEvent.VK_UP:
                this.nbKeyPressed--;
                this.UP = false;
                break;
            case KeyEvent.VK_DOWN:
                this.nbKeyPressed--;
                this.DOWN = false;
                break;
            case KeyEvent.VK_LEFT:
                this.nbKeyPressed--;
                this.LEFT = false;
                this.fighter.setVelocityX(0);
                break;
            case KeyEvent.VK_RIGHT:
                this.nbKeyPressed--;
                this.RIGHT = false;
                this.fighter.setVelocityX(0);
                break;
            case KeyEvent.VK_Z:
                this.nbKeyPressed--;
                this.Y_Combo = false;
                break;
        }
    }

    @Override
    public void keyTyped(KeyEvent ke) {
        switch (ke.getKeyChar()) {
            case 'z':
                this.Y_Combo = true;
                break;
        }
    }
}
