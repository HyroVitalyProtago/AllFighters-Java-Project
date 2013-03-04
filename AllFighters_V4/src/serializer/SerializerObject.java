/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package serializer;


import modele.objects.FObject;
/**
 *
 * @author MyMac
 */
public class SerializerObject extends Serializer<FObject> {

    public SerializerObject() {
        super("onj");
    }

    @Override
    public void updateObject(FObject e) {
        e.remakeAllSprite();
    }
    
    
    
}
