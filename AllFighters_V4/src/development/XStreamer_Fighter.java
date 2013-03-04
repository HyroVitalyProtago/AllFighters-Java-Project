/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package development;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import modele.fighters.Fighter;
import modele.objects.FImage;
import modele.objects.FSprite;

/**
 *
 * @author MyMac
 */
public class XStreamer_Fighter extends XStreamer<Fighter> {

    public XStreamer_Fighter() {
        this.alias("FImage", FImage.class);
        this.alias("FSprite", FSprite.class);
        this.alias("Fighter", Fighter.class);
    }

    @Override
    protected void make(Fighter fighter) {
        for (FSprite[] sprites : fighter.getSprites()) {
            for (FSprite fSprite : sprites) {
                fSprite.remakeAllSubImages();
            }
        }
    }
}
