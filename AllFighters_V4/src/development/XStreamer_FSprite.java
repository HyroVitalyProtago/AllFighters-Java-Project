/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package development;

import modele.objects.FImage;
import modele.objects.FSprite;

/**
 *
 * @author MyMac
 */
public class XStreamer_FSprite extends XStreamer<FSprite> {

    public XStreamer_FSprite() {
        this.alias("FImage", FImage.class);
        this.alias("FSprite", FSprite.class);
    }
    
    @Override
    protected void make(FSprite e) {
        e.remakeAllSubImages();
    }
    
}
