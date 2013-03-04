/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TakeshiYamamoto;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.io.IOException;
import modele.objects.Box;
import modele.objects.Box_Type;
import modele.objects.FImage;
import modele.objects.FSprite;
import serializer.SerializerImg;
import serializer.SerializerSprite;

/**
 *
 * @author MyMac
 */
public class MakeWalk_Takeshi_Yamamoto {
    
    private static final String location = "../SpriteAllFighters/TakeshiYamamoto/Walk/";
    private static final SerializerImg serializer = new SerializerImg();
    
    public static void exec() throws IOException {
        make1();
        make2();
        make3();
        make4();
        make5();
        make6();        
        
        int[][] map = {{0,0},{5,0},{2,0},{7,0},{15,0},{10,0}};
        FSprite walk = new FSprite("Walk", new Point(0,0), new Dimension(0,0), 15);
        for (int i = 1; i <= 6; i++) {
            FImage  image = serializer.recup(location+i);
            image.setLocation(map[i-1][0], map[i-1][1]);
            walk.addSubImage(image);
        }
        SerializerSprite ss = new SerializerSprite();
        ss.exec(walk, location+"Walk");
    }
    
    public static void make1() throws IOException {
        FImage image = new FImage(0, 0, location+"1.png");        
        image.addBox(new Box(Box_Type.HITTABLE, new Rectangle(29,1,34,89)));
        serializer.exec(image, location+"1");
    }
    public static void make2() throws IOException {
        FImage image = new FImage(0, 0, location+"2.png");        
        image.addBox(new Box(Box_Type.HITTABLE, new Rectangle(23,2,36,88)));
        image.addBox(new Box(Box_Type.HITTABLE, new Rectangle(58,64,18,24)));
        serializer.exec(image, location+"2");
    }
    public static void make3() throws IOException {
        FImage image = new FImage(0, 0, location+"3.png");        
        image.addBox(new Box(Box_Type.HITTABLE, new Rectangle(28,2,27,87)));
        serializer.exec(image, location+"3");
    }
    public static void make4() throws IOException {
        FImage image = new FImage(0, 0, location+"4.png");        
        image.addBox(new Box(Box_Type.HITTABLE, new Rectangle(25,1,34,87)));
        serializer.exec(image, location+"4");
    }
    public static void make5() throws IOException {
        FImage image = new FImage(0, 0, location+"5.png");        
        image.addBox(new Box(Box_Type.HITTABLE, new Rectangle(18,2,36,87)));
        image.addBox(new Box(Box_Type.HITTABLE, new Rectangle(45,64,18,22)));
        serializer.exec(image, location+"5");
    }
    public static void make6() throws IOException {
        FImage image = new FImage(0, 0, location+"6.png");        
        image.addBox(new Box(Box_Type.HITTABLE, new Rectangle(24,1,34,89)));
        serializer.exec(image, location+"6");
    }
}
