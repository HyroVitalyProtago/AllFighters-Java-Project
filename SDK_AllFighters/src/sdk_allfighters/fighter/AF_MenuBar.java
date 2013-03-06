/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdk_allfighters.fighter;

import javax.swing.JMenuBar;

/**
 *
 * @author MyMac
 */
public class AF_MenuBar extends JMenuBar {

    private AF_Frame frame;
    private AF_MenuFichier mf;

    public AF_MenuBar(AF_Frame frame) {
        this.mf = new AF_MenuFichier(frame);
        this.add(this.mf);
        this.frame = frame;
    }

    public AF_MenuFichier getMenuFichier() {
        return this.mf;
    }

}
