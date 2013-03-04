/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package serializer;

import modele.objects.FSprite;

/**
 *
 * @author MyMac
 */
public class SerializerSprite extends Serializer<FSprite> {

    public SerializerSprite() {
        super("spr");
    }

    @Override
    public void updateObject(FSprite e) {
        e.remakeAllSubImages();
    }

    
    
}
