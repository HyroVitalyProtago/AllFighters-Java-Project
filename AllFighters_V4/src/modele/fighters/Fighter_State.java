/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modele.fighters;

/**
 *
 * @author MyMac
 */
public enum Fighter_State {
    intro, 
    stance1,
    stance2,
    walk, 
    run, 
    jump_up,
    jump_down, //fall
    guard, 
    turn,
    guard_jump,
    turn_jump,
    win, 
    lose, 
    hit,
    stunned, 
    y_combo_begin,
    y_combo_end,
    forward_y, //en avant
    run_y, 
    up_y,
    jump_y,
    x, 
    run_x, 
    up_x, 
    jump_x,
    jump_x_down,
    special1, 
    special2, 
    special3,
    getup;
}
