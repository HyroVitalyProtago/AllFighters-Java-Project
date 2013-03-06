/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdk_allfighters.sprite;

import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import modele.fighters.Fighter;
import modele.objects.FSprite;
import sdk_allfighters.fighter.AF_PanelCaracteristiques;
import sdk_allfighters.tools.CaracteristiqueFactory;
import sdk_allfighters.tools.MyJTextField;

/**
 *
 * @author MyMac
 */
public class AF_Sprite_PanelCaracteristiques extends JPanel {

    private AF_Sprite_Frame frame;
    private ArrayList<MyJTextField> textFields = new ArrayList<MyJTextField>();

    public AF_Sprite_PanelCaracteristiques(AF_Sprite_Frame frame) {
        this.frame = frame;

        this.setLayout(new GridLayout(2, 2));

        String patternName = "([a-z]|[A-Z]|[0-9]|-|_)*";
        String patternInteger = "[0-9]*";

        FSprite sprite = this.frame.getSprite();
        try {
            // -- NAME --
            textFields.add(CaracteristiqueFactory.getInstance().StringCaracteristique(this, sprite, "Name",
                    FSprite.class.getMethod("setName", String.class), FSprite.class.getMethod("getName", null), patternName));

            // -- SPEED --
            textFields.add(CaracteristiqueFactory.getInstance().IntegerCaracteristique(this, sprite, "Speed",
                    FSprite.class.getMethod("setSpeed", String.class), FSprite.class.getMethod("getSpeed", null), patternInteger));

        } catch (NoSuchMethodException ex) {
            Logger.getLogger(AF_PanelCaracteristiques.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SecurityException ex) {
            Logger.getLogger(AF_PanelCaracteristiques.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void refresh() {

        FSprite sprite = this.frame.getSprite();
        if (sprite == null) {
            return;
        }

        for (MyJTextField jTextField : textFields) {
            jTextField.refresh();
        }

    }

}
