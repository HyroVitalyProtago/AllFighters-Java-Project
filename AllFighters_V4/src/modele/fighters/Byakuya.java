/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modele.fighters;

import java.awt.Dimension;
import java.awt.Point;
import java.io.IOException;
import modele.objects.FImage;
import modele.objects.FSprite;

/**
 *
 * @author MyMac
 */
public abstract class Byakuya {
    
    private static Fighter byakuya;
    
    public static Fighter create() throws IOException {

        byakuya = new Fighter("Byakuya");
     
        /*
        Sprite intro = new Sprite("Intro", new Point(0, 0), new Dimension(32, 32), 15);
        for (int i = 1; i <= 13; i++) {
            intro.addSubImage(new Img(new Point(0, 0), "/Users/MyMac/Desktop/SpritePacks/Bleach.spritepack/P1I" + i + ".png"));
        }
        byakuya.addSprite(intro);
        
        Sprite run = new Sprite("Run", new Point(0, 0), new Dimension(32, 32), 15);
        for (int i = 1; i <= 6; i++) {
            run.addSubImage(new Img(new Point(0, 0), "/Users/MyMac/Desktop/SpritePacks/Bleach.spritepack/P1R" + i + ".png"));
        }
        byakuya.addSprite(run);
*/
        
        makeIntro();
        makeStand();
        byakuya.addSprite(Fighter.makeSpriteWithSubImages("Run", "/Users/MyMac/Documents/Programmation/SPRITES/Byakuya_sprite/Run/P1R", 6));
        byakuya.addSprite(Fighter.makeSpriteWithSubImages("Run", "/Users/MyMac/Documents/Programmation/SPRITES/Byakuya_sprite/Run/P1R", 6).reverse());
        byakuya.addSprite(Fighter.makeSpriteWithSubImages("Saut", "/Users/MyMac/Documents/Programmation/SPRITES/Byakuya_sprite/Saut/P1J", 6));
        byakuya.addSprite(Fighter.makeSpriteWithSubImages("Saut", "/Users/MyMac/Documents/Programmation/SPRITES/Byakuya_sprite/Saut/P1J", 6).reverse());
        
        byakuya.setCurrentSprite(0);
        
        return byakuya;
    }
    
    private static void makeIntro() throws IOException {
        int [][] map = {{0,0},{0,2},{-1,-2},{-4,-4},{0,-2},{-1,-3},{2,-1},{0,-2},{2,-4},{-3,-2},{-2,-1},{-1,-2},{1,-3}};
        byakuya.addSprite(Fighter.makeSpriteWithSubImages("Intro", "/Users/MyMac/Documents/Programmation/SPRITES/Byakuya_sprite/Intro/P1I", 13, map));
        int [][] map2 = {{0,0},{0,2},{2,-2},{1,-4},{3,-2},{-1,-3},{1,-1},{18,-2},{19,-4},{-13,-2},{-24,-1},{-25,-2},{-20,-3}};
        byakuya.addSprite(Fighter.makeSpriteWithSubImages("IntroL", "/Users/MyMac/Documents/Programmation/SPRITES/Byakuya_sprite/Intro/P1I", 13, map2).reverse());
    }
    
    private static void makeStand() throws IOException {
        int[][] map = {{0,0},{0,2},{-1,-2},{-4,-4},{0,-2},{-1,-3},{2,-1}};
        byakuya.addSprite(Fighter.makeSpriteWithSubImages("Stand", "/Users/MyMac/Documents/Programmation/SPRITES/Byakuya_sprite/Intro/P1I", 7, map));
    }
    
    private static void makeRun() throws IOException {
        
    }
    
    private static void makeJump() throws IOException {
        
    }
}
