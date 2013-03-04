/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package development;

import com.thoughtworks.xstream.XStream;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.io.IOException;
import java.util.ArrayList;
import modele.objects.Box;
import modele.objects.Box_Type;
import modele.objects.FImage;
import modele.objects.FSprite;

/**
 *
 * @author MyMac
 */
public abstract class Make_Takeshi_Yamamoto {

    private static final String aboluteLocation = "../SpriteAllFighters/TakeshiYamamoto/";
    private static String location;
    private static ArrayList<String> images = new ArrayList<String>();

    public static void main(String args[]) throws IOException {

        make_Stance();
        reset();
        //make_Y_Combo();
        //make_Walk();
        //make_Jump();

    }
    
    private static void reset() {
        images.clear();
        location = null;
    }

    public static void make_Stance() throws IOException {
        Make_Takeshi_Yamamoto.location = aboluteLocation+"Stance/";        

        // PART1
        int[] tmp = {1, 2, 2, 0, 2, 2};
        int[] tmp1 = {0, 2, 4, 6, 4, 2};
        for (int i = 1; i <= 6; i++) {
            makePartOfStance(i, tmp[i - 1], tmp1[i - 1]);
        }

        FSprite spr = new FSprite("Stance1", new Point(0, 0), new Dimension(0, 0), 10);
        int[][] map1 = {{1, 0}, {0, 0}, {0, 0}, {2, 0}, {0, 0}, {0, 0}};
        for (int i = 1; i <= 6; i++) {
            FImage image = (FImage) new XStreamer_FImage().fromXML(images.get(i - 1));
            image.setLocation(map1[i - 1][0], map1[i - 1][1]);
            spr.addSubImage(image);
        }
        new XStreamer_FSprite().save(spr, location+"Stance1");

        
        // PART2
        int[] map = {3,-2,-5,-2,3,2};
        for (int i = 7; i <= 12; i++) {
            makePartOfStance(i, map[i-7],0);
        }
        
        FSprite spr2 = new FSprite("Stance2", new Point(0,0), new Dimension(0,0), 10);
        int[][] map2 = {{0,0},{5,0},{8,0},{5,0},{0,0},{1,0}};
        for (int i = 1; i <= 6; i++) {
            FImage image = (FImage) new XStreamer_FImage().fromXML(images.get(i-1));
            image.setLocation(map2[i-1][0], map2[i-1][1]);
            spr2.addSubImage(image);
        }
        new XStreamer_FSprite().save(spr, location+"Stance2");
    }

    private static void makePartOfStance(int num, int adpt, int adpt1) throws IOException {
        FImage image = new FImage(0, 0, location + num + ".png");
        int x = 60;
        image.addBox(new Box(Box_Type.HITTABLE, new Rectangle(x + adpt, 0 + adpt1, 13, image.height - adpt1)));
        image.addBox(new Box(Box_Type.HITTABLE, new Rectangle(x - 10 + adpt, 10 + adpt1, 10, (image.height / 2) - adpt1)));
        image.addBox(new Box(Box_Type.HITTABLE, new Rectangle(x - 20 + adpt, 30 + adpt1, 10, (image.height / 3) - adpt1)));
        image.addBox(new Box(Box_Type.HITTABLE, new Rectangle(x - 30 + adpt, 40 + adpt1, 10, (image.height / 3) - adpt1)));
        image.addBox(new Box(Box_Type.HITTABLE, new Rectangle(x - 40 + adpt, 65 + adpt1, 10, (image.height / 5) - adpt1)));
        
        String xml = new XStreamer_FImage().toXml(image);
        images.add(xml);
        //serializer.exec(image, location+num);
    }
}
