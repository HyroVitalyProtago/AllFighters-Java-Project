/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modele.fighters;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import development.XStreamer_FSprite;
import java.io.IOException;
import modele.comportements.Comportement_Takeshi_Yamamoto;
import modele.objects.FImage;
import modele.objects.FSprite;
import serializer.SerializerSprite;

/**
 *
 * @author MyMac
 */
public class Takeshi_Yamamoto extends Fighter {

    public Takeshi_Yamamoto() throws IOException {
        super("Takeshi_Yamamoto");
        this.create();
    }

    public void create() throws IOException {
        makeIntro();
        makeStance();
        //makeWalk();
        //makeRun();
        //makeJump();
        //makeY_Combo();
        //makeHit();
        //this.setCurrentSprite(18);
        this.resetAllSprite();
        this.setComportement(new Comportement_Takeshi_Yamamoto(this));
        this.setSize(25, 90);
    }
    public final int speed = Fighter.SPEED_SPRITE;
    private static final String location = "../SpriteAllFighters/TakeshiYamamoto/";

    public void makeIntro() throws IOException {
        int[][] map = {{56, 0}, {56, 0}, {56, 0}, {0, 0}, {0, 0}, {10, 0}};
        FSprite intro = Fighter.makeSpriteWithSubImages("Intro", location + "Intro/", 6, map);

        FSprite introR = intro.clone();
        introR.setX(-55);

        FSprite introL = intro.clone().reverse();
        introL.setX(-28);

        FSprite[] sprites = {introR, introL};
        this.addSprites(Fighter_State.intro, sprites);
    }

    public void makeStance() throws IOException {

        FSprite stance1 = new XStreamer_FSprite().load(location+ "/Stance/Stance1");

        FSprite stance1R = stance1.clone();
        stance1R.setX(-38);

        FSprite stance1L = stance1.clone().reverse();
        stance1L.setX(-16);

        FSprite[] sprites1 = {stance1R, stance1L};
        this.addSprites(Fighter_State.stance1, sprites1);

        FSprite stance2 = new XStreamer_FSprite().load(location+ "/Stance/Stance2");

        FSprite stance2R = stance2.clone();
        stance2R.setX(-39);

        FSprite stance2L = stance2.clone().reverse();
        stance2L.setX(-15);

        FSprite[] sprites2 = {stance2R, stance2L};
        this.addSprites(Fighter_State.stance2, sprites2);
    }

    public void makeWalk() throws IOException {
        //int[][] map = {{0,0},{5,0},{2,0},{7,0},{15,0},{10,0}};
        //Sprite walk = Fighter.makeSpriteWithSubImages("Walk", location+"Walk/", 6, map);
        //walk.setSpeed(speed);
        SerializerSprite ss = new SerializerSprite();
        FSprite walk = ss.recup(location + "Walk/" + "Walk");


        FSprite walkR = walk.clone();
        walkR.setX(-38);

        FSprite walkL = walk.clone().reverse();
        walkL.setX(-16);

        //this.addSprite(walkR);
        //this.addSprite(walkL);
        FSprite[] sprites = {walkR, walkL};
        this.addSprites(Fighter_State.walk, sprites);
    }

    public void makeRun() throws IOException {
        int[][] map = {{0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}};
        FSprite run = Fighter.makeSpriteWithSubImages("Run", location + "Run/", 6, map);

        FSprite runR = run.clone();
        runR.setX(-38);

        FSprite runL = run.clone().reverse();
        runL.setX(-25);

        //this.addSprite(runR);
        //this.addSprite(runL);
        FSprite[] sprites = {runR, runL};
        this.addSprites(Fighter_State.run, sprites);
    }

    public void makeJump() throws IOException {
        SerializerSprite ss = new SerializerSprite();

        //Sprite jump = Fighter.makeSpriteWithSubImages("Jump1", location+"Jump/", 2);
        //jump.setSpeed(speed);
        FSprite jump = ss.recup(location + "Jump/" + "Jump1");

        FSprite jumpR = jump.clone();
        jumpR.setX(-53);

        FSprite jumpL = jump.clone().reverse();
        jumpL.setX(-10);

        //this.addSprite(jumpR);
        //this.addSprite(jumpL);
        FSprite[] sprites = {jumpR, jumpL};
        this.addSprites(Fighter_State.jump_up, sprites);

        //Sprite jump2 = Fighter.makeSpriteWithSubImages("Jump2", location+"Jump/", 2, 3);
        //jump2.setSpeed(speed);

        FSprite jump2 = ss.recup(location + "Jump/" + "Jump2");

        FSprite jumpR2 = jump2.clone();
        jumpR2.setX(-20);

        FSprite jumpL2 = jump2.clone().reverse();
        jumpL2.setX(-17);

        //this.addSprite(jumpR2);
        //this.addSprite(jumpL2);
        FSprite[] sprites2 = {jumpR2, jumpL2};
        this.addSprites(Fighter_State.jump_down, sprites2);

        //Sprite jump3 = Fighter.makeSpriteWithSubImages("Jump3", location+"Jump/", 2, 5);
        //jump3.setSpeed(speed);

        FSprite jump3 = ss.recup(location + "Jump/" + "Jump3");
        jump3.setSpeed(speed - 2);

        FSprite jumpR3 = jump3.clone();
        jumpR3.setX(-25);

        FSprite jumpL3 = jump3.clone().reverse();
        jumpL3.setX(-25);

        //this.addSprite(jumpR3);
        //this.addSprite(jumpL3);
        FSprite[] sprites3 = {jumpR3, jumpL3};
        this.addSprites(Fighter_State.getup, sprites3);
    }

    public void makeY_Combo() throws IOException {
        //int[][] map = {{4,0},{21,0},{21,0},{25,0},{25,0},{23,0},{0,0},{7,0},{4,0},{7,2},{7,2},{7,2},{7,2}};
        //Sprite y_combo = Fighter.makeSpriteWithSubImages("Y_Combo", location+"Y_Combo/", 13, map);
        //y_combo.setSpeed(speed+5);
        //y_combo.setY(-5);

        FSprite y_combo_begin = new SerializerSprite().recup(location + "Y_Combo/" + "Y_Combo_Begin");

        FSprite y_comboR = y_combo_begin.clone();
        y_comboR.setX(-48);


        FSprite y_comboL = y_combo_begin.clone().reverse();
        //y_comboL.setX(-84);
        y_comboL.setX(-54);

        //this.addSprite(y_comboR);
        //this.addSprite(y_comboL);
        FSprite[] sprites = {y_comboR, y_comboL};
        this.addSprites(Fighter_State.y_combo_begin, sprites);

        //END
        FSprite y_combo_end = new SerializerSprite().recup(location + "Y_Combo/" + "Y_Combo_End");
        y_combo_end.setSpeed(speed - 3);

        FSprite y_combo_endR = y_combo_end.clone();
        y_combo_endR.setX(-48);


        FSprite y_combo_endL = y_combo_end.clone().reverse();
        //y_combo_endL.setX(-84);
        y_combo_endL.setX(-36);

        FSprite[] sprites2 = {y_combo_endR, y_combo_endL};
        this.addSprites(Fighter_State.y_combo_end, sprites2);

        //Forward_y
        FSprite forward_y = new SerializerSprite().recup(location + "Y_Combo/" + "Forward_Y");
        forward_y.setSpeed(speed);

        FSprite forward_yR = forward_y.clone();
        forward_yR.setX(-48);


        FSprite forward_yL = forward_y.clone().reverse();
        forward_yL.setX(-84);
        //forward_yL.setX(-36);

        FSprite[] sprites3 = {forward_yR, forward_yL};
        this.addSprites(Fighter_State.forward_y, sprites3);
    }

    public void makeHit() throws IOException {
        int[][] map = {{0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {20, 0}, {20, 0}, {20, 0}, {20, 0}, {20, 0}, {20, 0}, {20, 0}};
        FSprite hit = Fighter.makeSpriteWithSubImages("Hit", location + "Hit/", 2, map); //Il faudra charger les sprites
        hit.setSpeed(speed - 5);
        hit.setY(-9);

        FSprite hitR = hit.clone();
        hitR.setX(-45);

        FSprite hitL = hit.clone().reverse();
        hitL.setX(-15);

        //this.addSprite(hitR);
        //this.addSprite(hitL);
        FSprite[] sprites = {hitR, hitL};
        this.addSprites(Fighter_State.hit, sprites);
    }
}
