/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdk_allfighters;

import java.awt.FlowLayout;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import modele.fighters.Fighter;
import modele.objects.FSprite;

/**
 *
 * @author MyMac
 */
public class AF_PanelListOfSprites extends JPanel {

    private Fighter fighter;

    public AF_PanelListOfSprites() {
        this.setLayout(new FlowLayout());
        this.setBorder(BorderFactory.createTitledBorder(" Liste des sprites "));
    }

    public AF_PanelListOfSprites(Fighter fighter) {
        this();
        this.fighter = fighter;
        refresh();
    }

    public void refresh() {
        if (this.fighter == null) return;
        for (FSprite[] sprites : this.fighter.getSprites()) {
            for (FSprite fSprite : sprites) {
                this.add(new JLabel(fSprite.getName()));
            }
        }
    }

}
