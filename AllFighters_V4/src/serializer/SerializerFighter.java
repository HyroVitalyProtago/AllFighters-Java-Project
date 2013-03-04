/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package serializer;

import modele.fighters.Fighter;

/**
 *
 * @author MyMac
 */
public class SerializerFighter extends Serializer<Fighter> {

    public SerializerFighter() {
        super("fighter");
    }

    @Override
    public void updateObject(Fighter e) {
        e.remakeAllSprite();
    }
    
}
