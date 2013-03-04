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
public abstract class MakeStance_Takeshi_Yamamoto {
    
    private static final String location = "../SpriteAllFighters/TakeshiYamamoto/Stance/";
    private static final SerializerImg serializer = new SerializerImg();
    
    public static void exec() throws IOException {
        makePart1();
        makePart2();
    }
    
    private static void makePart1() throws IOException {
        int[] tmp = {1,2,2,0,2,2};
        int[] tmp1 = {0,2,4,6,4,2};
        for (int i = 1; i <= 6; i++) {
            makePart(i,tmp[i-1], tmp1[i-1]);
        }
        
        FSprite spr = new FSprite("Stance1", new Point(0,0), new Dimension(0,0), 10);
        int[][] map1 = {{1,0},{0,0},{0,0},{2,0},{0,0},{0,0}};
        for (int i = 1; i <= 6; i++) {
            FImage image = serializer.recup(location+i);
            image.setLocation(map1[i-1][0], map1[i-1][1]);
            //System.out.println(image);
            spr.addSubImage(image);
        }
        SerializerSprite ss = new SerializerSprite();
        ss.exec(spr, location+"Stance1");
    }
    private static void makePart2() throws IOException {
        int[] map = {3,-2,-5,-2,3,2};
        for (int i = 7; i <= 12; i++) {
            makePart(i, map[i-7],0);
        }
        
        FSprite spr = new FSprite("Stance2", new Point(0,0), new Dimension(0,0), 10);
        int[][] map2 = {{0,0},{5,0},{8,0},{5,0},{0,0},{1,0}};
        for (int i = 1; i <= 6; i++) {
            FImage image = serializer.recup(location+(i+6));
            image.setLocation(map2[i-1][0], map2[i-1][1]);
            //System.out.println(image);
            spr.addSubImage(image);
        }
        SerializerSprite ss = new SerializerSprite();
        ss.exec(spr, location+"Stance2");
    }
    private static void makePart(int num, int adpt, int adpt1) throws IOException {
        FImage image = new FImage(0, 0, location+num+".png");
        int x = 60;
        image.addBox(new Box(Box_Type.HITTABLE, new Rectangle(x+adpt, 0+adpt1, 13, image.height-adpt1)));
        image.addBox(new Box(Box_Type.HITTABLE, new Rectangle(x-10+adpt, 10+adpt1, 10, (image.height/2)-adpt1)));
        image.addBox(new Box(Box_Type.HITTABLE, new Rectangle(x-20+adpt, 30+adpt1, 10, (image.height/3)-adpt1)));
        image.addBox(new Box(Box_Type.HITTABLE, new Rectangle(x-30+adpt, 40+adpt1, 10, (image.height/3)-adpt1)));
        image.addBox(new Box(Box_Type.HITTABLE, new Rectangle(x-40+adpt, 65+adpt1, 10, (image.height/5)-adpt1)));
        
        serializer.exec(image, location+num);
    }    
    
}
