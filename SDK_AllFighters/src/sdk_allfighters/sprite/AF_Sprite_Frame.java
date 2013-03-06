/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdk_allfighters.sprite;

import java.awt.GridLayout;
import java.awt.HeadlessException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import modele.objects.FSprite;
import sdk_allfighters.fighter.AF_Panel;
import sdk_allfighters.fighter.AF_PanelCaracteristiques;

/**
 *
 * @author MyMac
 */
public class AF_Sprite_Frame extends JFrame {

    private FSprite sprite;

    public AF_Sprite_Frame() throws HeadlessException {
        super("SDK_AllFighters_Sprite");




        this.setSize(800, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
    }

    public AF_Sprite_Frame(FSprite sprite) throws HeadlessException {
        this();
        this.sprite = sprite;
    }

    private JPanel mainPanel;
    private AF_Sprite_PanelCaracteristiques caracteristiques;
    //private JPanel listOfImages;

    public void refresh() {
        if (mainPanel != null)
            this.remove(mainPanel);

        mainPanel = new JPanel(new GridLayout(1, 2));

        JPanel container = new JPanel(new GridLayout(2, 1));
        caracteristiques = new AF_Sprite_PanelCaracteristiques(this);
        container.add(caracteristiques);
        //listOfSprite = new AF_PanelListOfSprites(this);
        //container.add(listOfSprite);

        mainPanel.add(container);

        //this.panel = new AF_Panel(this);
        //mainPanel.add(this.panel);

        mainPanel.setVisible(true);

        this.add(mainPanel);
    }

    // ******************************** GETTERS & SETTERS ********************************

    public FSprite getSprite() {
        return sprite;
    }

    public void setSprite(FSprite sprite) {
        this.sprite = sprite;
        this.refresh();
        caracteristiques.refresh();
        this.setVisible(true);
    }

    // ***********************************************************************************

}
