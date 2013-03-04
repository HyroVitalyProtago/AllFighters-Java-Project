/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdk_allfighters;

import javax.swing.JMenuBar;

/**
 *
 * @author MyMac
 */
public class AF_MenuBar extends JMenuBar {

    private AF_Frame frame;
    
    public AF_MenuBar(AF_Frame frame) {
        this.add(new AF_MenuFichier(frame));
        this.frame = frame;
    }    
    
}
