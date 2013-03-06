/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdk_allfighters.sprite;

import java.awt.HeadlessException;
import javax.swing.JFrame;

/**
 *
 * @author MyMac
 */
public class AF_Sprite_Frame extends JFrame {

    public AF_Sprite_Frame() throws HeadlessException {
        super("SDK_AllFighters_Sprite");

        this.setSize(800, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
    }

}
