/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TakeshiYamamoto;

import java.awt.Dimension;
import java.awt.Point;
import modele.objects.FImage;
import modele.objects.FSprite;
import serializer.SerializerImg;
import serializer.SerializerSprite;

/**
 *
 * @author MyMac
 */
public class MakeJump_Takeshi_Yamamoto {
    
    private static final String location = "../SpriteAllFighters/TakeshiYamamoto/Jump/";
    private static final SerializerImg serializer = new SerializerImg();
    
    public static void exec() {
        FSprite jump1 = new FSprite("Jump1", new Point(0,0), new Dimension(0,0), 15);
        for (int i = 1; i <= 2; i++) {
            FImage  image = serializer.recup(location+i);
            image.setLocation(0, 0);
            jump1.addSubImage(image);
        }
        SerializerSprite ss = new SerializerSprite();
        ss.exec(jump1, location+"Jump1");
        
        FSprite jump2 = new FSprite("Jump2", new Point(0,0), new Dimension(0,0), 15);
        for (int i = 3; i <= 4; i++) {
            FImage  image = serializer.recup(location+i);
            image.setLocation(0, 0);
            jump2.addSubImage(image);
        }
        ss.exec(jump2, location+"Jump2");
        
        FSprite jump3 = new FSprite("Jump3", new Point(0,0), new Dimension(0,0), 15);
        for (int i = 5; i <= 6; i++) {
            FImage  image = serializer.recup(location+i);
            image.setLocation(0, 0);
            jump3.addSubImage(image);
        }
        ss.exec(jump3, location+"Jump3");
    }
    
}
