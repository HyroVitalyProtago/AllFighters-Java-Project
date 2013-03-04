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
public abstract class MakeY_Combo_Takeshi_Yamamoto {
    
    private static final String location = "../SpriteAllFighters/TakeshiYamamoto/Y_Combo/";
    private static final SerializerImg serializer = new SerializerImg();
    
    public static void exec() throws IOException {
        make1();
        make2();
        make3();
        make4();
        make5();
        make6();
        make7();
        make8();
        make9();
        make10();
        make11();
        make12();
        make13();
        
        int[][] map = {{4,0},{21,0},{21,0},{25,0},{25,0},{23,0},{0,0},{7,0},{4,0},{7,2},{7,2},{7,2},{7,2}};
        FSprite y_combo_begin = new FSprite("Y_Combo_Begin", new Point(0,-5), new Dimension(0,0), 15);
        for (int i = 1; i <= 3; i++) {
            FImage  image = serializer.recup(location+i);
            image.setLocation(map[i-1][0], map[i-1][1]);
            y_combo_begin.addSubImage(image);
        }
        SerializerSprite ss = new SerializerSprite();
        ss.exec(y_combo_begin, location+"Y_Combo_Begin");
        
        //END
        FSprite y_combo_end = new FSprite("Y_Combo_End", new Point(0,-5), new Dimension(0,0), 10);
        for (int i = 3; i <= 5; i++) { //13
            FImage  image = serializer.recup(location+i);
            image.setLocation(map[i-1][0], map[i-1][1]);
            y_combo_end.addSubImage(image);
        }
        ss.exec(y_combo_end, location+"Y_Combo_End");
        
        //Forward y
        FSprite forward_y = new FSprite("Forward_Y", new Point(0,-5), new Dimension(0,0), 10);
        for (int i = 5; i <= 13; i++) { //13
            FImage  image = serializer.recup(location+i);
            image.setLocation(map[i-1][0], map[i-1][1]);
            forward_y.addSubImage(image);
        }
        ss.exec(forward_y, location+"Forward_Y");
    }
    
    public static void make1() throws IOException {
        FImage image = new FImage(0, 0, location+"1.png");
        image.addBox(new Box(Box_Type.HITTABLE, new Rectangle(70,45,10,image.height-45-5)));
        image.addBox(new Box(Box_Type.HITTABLE, new Rectangle(80,45,5,20)));
        image.addBox(new Box(Box_Type.HITTABLE, new Rectangle(55,50,15,image.height-45-5-25)));
        image.addBox(new Box(Box_Type.HITTABLE, new Rectangle(45,60,10,image.height-45-5-25)));
        image.addBox(new Box(Box_Type.HITTABLE, new Rectangle(35,70,10,10)));
        image.addBox(new Box(Box_Type.HITTABLE, new Rectangle(35,95,10,10)));
        image.addBox(new Box(Box_Type.HITTABLE, new Rectangle(30,100,10,10)));
        serializer.exec(image, location+"1");
    }
    public static void make2() throws IOException {
        FImage image = new FImage(0, 0, location+"2.png");
        image.addBox(new Box(Box_Type.ATTACKING, new Rectangle(30,37,image.width - 30,55)));
        image.addBox(new Box(Box_Type.HITTABLE, new Rectangle(30,42,41,50)));
        image.addBox(new Box(Box_Type.HITTABLE, new Rectangle(46,87,17,25)));
        image.addBox(new Box(Box_Type.HITTABLE, new Rectangle(0,96,18,16)));
        image.addBox(new Box(Box_Type.HITTABLE, new Rectangle(12,87,30,13)));
        serializer.exec(image, location+"2");
    }
    public static void make3() throws IOException {
        FImage image = new FImage(0, 0, location+"3.png");
        image.addBox(new Box(Box_Type.HITTABLE, new Rectangle(30,42,41,50)));
        image.addBox(new Box(Box_Type.HITTABLE, new Rectangle(46,87,17,25)));
        image.addBox(new Box(Box_Type.HITTABLE, new Rectangle(0,96,18,16)));
        image.addBox(new Box(Box_Type.HITTABLE, new Rectangle(12,87,30,13)));
        serializer.exec(image, location+"3");
    }
    public static void make4() throws IOException {
        FImage image = new FImage(0, 0, location+"4.png");
        image.addBox(new Box(Box_Type.HITTABLE, new Rectangle(30,42,41,50)));
        image.addBox(new Box(Box_Type.HITTABLE, new Rectangle(41,87,17,25)));
        image.addBox(new Box(Box_Type.HITTABLE, new Rectangle(0,96,18,16)));
        image.addBox(new Box(Box_Type.HITTABLE, new Rectangle(12,90,30,13)));
        serializer.exec(image, location+"4");
    }
    public static void make5() throws IOException {
        FImage image = new FImage(0, 0, location+"5.png");
        image.addBox(new Box(Box_Type.HITTABLE, new Rectangle(25,37,36,50)));
        image.addBox(new Box(Box_Type.HITTABLE, new Rectangle(41,87,17,25)));
        image.addBox(new Box(Box_Type.HITTABLE, new Rectangle(0,96,18,16)));
        image.addBox(new Box(Box_Type.HITTABLE, new Rectangle(12,85,30,13)));
        serializer.exec(image, location+"5");
    }
    public static void make6() throws IOException {
        FImage image = new FImage(0, 0, location+"6.png");
        image.addBox(new Box(Box_Type.HITTABLE, new Rectangle(23,37,41,50)));
        image.addBox(new Box(Box_Type.HITTABLE, new Rectangle(41,87,17,25)));
        image.addBox(new Box(Box_Type.HITTABLE, new Rectangle(0,96,18,16)));
        image.addBox(new Box(Box_Type.HITTABLE, new Rectangle(12,85,30,13)));
        serializer.exec(image, location+"6");
    }
    public static void make7() throws IOException {
        FImage image = new FImage(0, 0, location+"7.png");
        image.addBox(new Box(Box_Type.HITTABLE, new Rectangle(34,5,19,20)));
        image.addBox(new Box(Box_Type.HITTABLE, new Rectangle(41,26,25,57)));
        image.addBox(new Box(Box_Type.HITTABLE, new Rectangle(23,95,14,16)));
        image.addBox(new Box(Box_Type.HITTABLE, new Rectangle(68,96,18,16)));
        image.addBox(new Box(Box_Type.HITTABLE, new Rectangle(37,73,37,24)));
        serializer.exec(image, location+"7");
    }
    public static void make8() throws IOException {
        FImage image = new FImage(0, 0, location+"8.png");
        image.addBox(new Box(Box_Type.ATTACKING, new Rectangle(45,0,image.width-45,image.height)));
        image.addBox(new Box(Box_Type.HITTABLE, new Rectangle(42,64,54,30)));
        image.addBox(new Box(Box_Type.HITTABLE, new Rectangle(60,93,24,19)));
        image.addBox(new Box(Box_Type.HITTABLE, new Rectangle(12,99,22,13)));
        image.addBox(new Box(Box_Type.HITTABLE, new Rectangle(26,88,30,12)));
        serializer.exec(image, location+"8");
    }
    public static void make9() throws IOException {
        FImage image = new FImage(0, 0, location+"9.png");
        image.addBox(new Box(Box_Type.HITTABLE, new Rectangle(45,64,54,30)));
        image.addBox(new Box(Box_Type.HITTABLE, new Rectangle(63,93,24,19)));
        image.addBox(new Box(Box_Type.HITTABLE, new Rectangle(15,99,22,13)));
        image.addBox(new Box(Box_Type.HITTABLE, new Rectangle(29,88,30,12)));
        serializer.exec(image, location+"9");
    }
    public static void make10() throws IOException {
        FImage image = new FImage(0, 0, location+"10.png");
        image.addBox(new Box(Box_Type.HITTABLE, new Rectangle(42,66,54,30)));
        image.addBox(new Box(Box_Type.HITTABLE, new Rectangle(60,95,24,19)));
        image.addBox(new Box(Box_Type.HITTABLE, new Rectangle(12,101,22,13)));
        image.addBox(new Box(Box_Type.HITTABLE, new Rectangle(26,90,30,12)));
        serializer.exec(image, location+"10");
    }
    public static void make11() throws IOException {
        FImage image = new FImage(0, 0, location+"11.png");
        image.addBox(new Box(Box_Type.HITTABLE, new Rectangle(42,60,48,40)));
        image.addBox(new Box(Box_Type.HITTABLE, new Rectangle(58,95,24,19)));
        image.addBox(new Box(Box_Type.HITTABLE, new Rectangle(12,101,22,13)));
        image.addBox(new Box(Box_Type.HITTABLE, new Rectangle(26,97,30,12)));
        serializer.exec(image, location+"11");
    }
    public static void make12() throws IOException {
        FImage image = new FImage(0, 0, location+"12.png");
        image.addBox(new Box(Box_Type.HITTABLE, new Rectangle(18,67,60,30)));
        image.addBox(new Box(Box_Type.HITTABLE, new Rectangle(56,95,24,19)));
        image.addBox(new Box(Box_Type.HITTABLE, new Rectangle(12,101,22,13)));
        image.addBox(new Box(Box_Type.HITTABLE, new Rectangle(26,97,20,12)));
        serializer.exec(image, location+"12");
    }
    public static void make13() throws IOException {
        FImage image = new FImage(0, 0, location+"13.png");        
        image.addBox(new Box(Box_Type.HITTABLE, new Rectangle(62,51,16,62)));
        image.addBox(new Box(Box_Type.HITTABLE, new Rectangle(50,60,14,32)));
        image.addBox(new Box(Box_Type.HITTABLE, new Rectangle(38,74,14,28)));
        image.addBox(new Box(Box_Type.HITTABLE, new Rectangle(20,99,20,15)));
        serializer.exec(image, location+"13");
    }
}
