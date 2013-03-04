/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modele.objects;

/**
 *
 * @author MyMac
 */
public enum Direction {
    UP,LEFT,RIGHT,DOWN;
    
    public int getValue() {
        if (this == LEFT) {
            return 1;
        } else if (this == RIGHT) {
            return 0;
        }
        return -1;
    }
    
    public Direction inverse() {
        if (this == LEFT) {
            return RIGHT;
        } else if (this == RIGHT) {
            return LEFT;
        } else if (this == UP) {
            return DOWN;
        } else {
            return UP;
        }
    }
}
