/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdk_allfighters.fighter;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicBorders;
import modele.fighters.Fighter;
import modele.objects.FSprite;

/**
 *
 * @author MyMac
 */
public class AF_PanelListOfSprites extends JPanel {

    //private Fighter fighter;
    private AF_Frame frame;

    private JPanel mainPanel;
    private JToolBar toolBar;

    public AF_PanelListOfSprites(AF_Frame frame) {
        this.frame = frame;

        this.setLayout(new BorderLayout());
        this.setBorder(BorderFactory.createTitledBorder(" Liste des sprites "));

        this.mainPanel = new JPanel(new FlowLayout());
        this.toolBar = new JToolBar();
        toolBar.setFloatable(false);

        this.add(mainPanel, BorderLayout.CENTER);
        this.add(toolBar, BorderLayout.SOUTH);

        ImageIcon ii = new ImageIcon("./ressources/add.png");
        JButton add = new JButton("Ajouter", ii);
        toolBar.add(add);

        ImageIcon ii2 = new ImageIcon("./ressources/edit.png");
        JButton edit = new JButton("Éditer", ii2);
        edit.setEnabled(false);
        toolBar.add(edit);

        ImageIcon ii3 = new ImageIcon("./ressources/remove.png");
        JButton remove = new JButton("Supprimer", ii3);
        remove.setEnabled(false);
        toolBar.add(remove);

        toolBar.setEnabled(false);

    }
/*
    public AF_PanelListOfSprites(Fighter fighter) {
        this();
        this.fighter = fighter;
        refresh();
    }
*/
    public void refresh() {
        Fighter fighter = this.frame.getFighter();
        if (fighter == null) return;
        this.mainPanel.removeAll();
        for (FSprite[] sprites : fighter.getSprites()) {
            for (FSprite fSprite : sprites) {
                this.mainPanel.add(new JLabel(fSprite.getName()));
            }
        }
    }

}
