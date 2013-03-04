/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modele.fighters;

import allfighters.AllFighters;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.Map;
import java.util.TreeMap;
import modele.Room;
import modele.comportements.Comportement;
import modele.objects.Direction;
import modele.objects.FImage;
import modele.objects.FObject;
import modele.objects.FSprite;

/**
 *
 * @author MyMac
 */
public class Fighter extends FObject implements Serializable {

    private static final int SPEED = 3;
    //
    private static final int JUMP_FORCE = 6;
    private boolean onGround;
    //COMMANDE
    //private FighterController fighterController;
    private Map<Fighter_State, FSprite[]> map; // Sprite[2] Right - Left
    //
    private Fighter_State state;
    // Caracteristiques
    private Direction dir;
    // Comportement
    private Comportement comportement;
    // ...
    private Fighter_State enchainement = null;
    private boolean aToucheUnEnnemi = false;
    //private int timeOnGroundBetweenJumpAndFall = 10; //remove
    //
    private int life;
    private int power;
    //
    private int force = 5;
    private int resistance = 1;

    public Fighter(String name) {
        super(name);
        this.onGround = true;
        this.gravity = true;
        this.state = Fighter_State.stance1;

        this.life = 300;
        this.power = 300;

        this.map = new EnumMap<Fighter_State, FSprite[]>(Fighter_State.class);
    }

    public Fighter(String name, ArrayList<FSprite> sprites) {
        super(name, sprites);
    }

    public Fighter(String name, ArrayList<FSprite> sprites, boolean visible, boolean solid) {
        super(name, sprites, visible, solid);
    }

    public void addSprites(Fighter_State state, FSprite[] sprites) {
        if (sprites.length != 2) {
            throw new IllegalArgumentException();
        }
        this.map.put(state, sprites);
    }

    @Override
    public void addSprite(FSprite sprite) {
        throw new UnsupportedOperationException();
    }

    public Fighter_State getEnchainement() {
        return enchainement;
    }

    public void setEnchainement(Fighter_State enchainement) {
        this.enchainement = enchainement;
    }

    @Override
    public FSprite getCurrentSprite() {
        //Permet la gestion de l'affichage lorsque le fighter se fait touche en l'air
        if (this.getState() == Fighter_State.hit && !isOnGround()) {
            if (this.getVelocityY() > 0) {
                return this.map.get(Fighter_State.jump_up)[this.dir.getValue()];
            } else {
                return this.map.get(Fighter_State.jump_down)[this.dir.getValue()];
            }
        } else {
            return this.map.get(this.state)[this.dir.getValue()];
        }
    }

    public void setComportement(Comportement comportement) {
        this.comportement = comportement;
    }

    public boolean isOnGround() {
        return onGround;
    }

    public void setOnGround(boolean onGround) {
        if (!this.onGround && onGround) {
            //this.timeOnGroundBetweenJumpAndFall = 0; //remove
            this.setState(Fighter_State.getup);
        }
        this.onGround = onGround;
    }

    public int getLife() {
        return life;
    }

    public int getPower() {
        return power;
    }

    public void update() { // UPDATE COMPORTEMENT
        if (!allfighters.AllFighters.DEV_SPRITE) {
            this.comportement.update();
            //this.timeOnGroundBetweenJumpAndFall++;
        }
    }

    public Direction getDir() {
        return dir;
    }

    public void setDir(Direction dir) {
        this.dir = dir;
    }

    public void setState(Fighter_State state) {
        if (state != this.state) {
            getCurrentSprite().resetTime();
            aToucheUnEnnemi = false;
            this.state = state;
        }
    }

    public Fighter_State getState() {
        return state;
    }

    public boolean intersect(Fighter ennemi) {
        FSprite spr = this.getCurrentSprite().clone();
        FSprite spr1 = ennemi.getCurrentSprite().clone();

        spr.x = (int) this.x + spr.x;
        spr.y = (int) this.y + spr.y;
        spr1.x = (int) ennemi.x + spr1.x;
        spr1.y = (int) ennemi.y + spr1.y;

        return spr.intersects(spr1);
    }

    public boolean fight(Fighter ennemi) {
        // 0 si personne ne s'attaque
        // 1 si il attaque l'ennemi

        FSprite spr = this.getCurrentSprite().clone();
        FSprite spr1 = ennemi.getCurrentSprite().clone();

        spr.x = (int) this.x + spr.x;
        spr.y = (int) this.y + spr.y;
        spr1.x = (int) ennemi.x + spr1.x;
        spr1.y = (int) ennemi.y + spr1.y;

        //System.out.println("FIGHTER : intersects = "+spr.intersects(spr1));
        //System.out.println(spr);
        //System.out.println(spr1);

        //Effectuer verification orientation de l'attaquant par rapport a l'ennemi
        if (this.x < ennemi.x && this.dir == Direction.LEFT)
            return false;
        if (this.x > ennemi.x && this.dir == Direction.RIGHT)
            return false;
        
        return spr.fight(ennemi, spr1);

    }

    public boolean isaToucheUnEnnemi() {
        return aToucheUnEnnemi;
    }

    public void jump() {
        onGround = false;
        setVelocityY(JUMP_FORCE);
        setState(Fighter_State.jump_up);
    }

    @Override
    public Fighter clone() {
        ArrayList<FSprite> sprites = (ArrayList<FSprite>) this.sprites.clone();
        return new Fighter(name + "_clone", sprites, visible, solid);
    }

    public void move(Direction dir) {
        if (dir == Direction.LEFT) {
            this.setVelocityX(-SPEED);
        } else if (dir == Direction.RIGHT) {
            this.setVelocityX(SPEED);
        }
    }

    public void move(Direction dir, double speed) {
        if (dir == Direction.LEFT) {
            this.setVelocityX(-speed);
        } else if (dir == Direction.RIGHT) {
            this.setVelocityX(speed);
        }
    }

    public void draw(Room room, Graphics g) {
        int y = room.getHeight() - (int) this.y - (int) this.height;

        g.translate((int) this.x, y);

        if (AllFighters.SHOW_BOXS_FIGHTER) {
            drawContour(g);
        }

        if (isVisible()) {
            this.getCurrentSprite().draw(this, g);
        }

        // INFOS BEGIN
        g.setColor(Color.WHITE);
        //g.drawString("position : {"+this.x+", "+this.y+"]", 0, -30);
        //g.drawString("currentSprite : "+this.currentSprite, 0, -20);
        //g.drawString(""+this.isOnGround(), 0, -20);
        //g.drawString("LIFE = " + this.life, 0, -10);
        // INFOS END

        g.translate((int) -this.x, -y);
    }

    public void infligerDegats(Fighter f) {
        aToucheUnEnnemi = true;
        f.setDir(this.dir.inverse());
        f.recevoirDegats(this.force);
    }

    public void recevoirDegats(int degats) {
        if ((degats - resistance) > 0) {
            this.life -= (degats - resistance);
            //if (this.isOnGround()) {            
            this.state = Fighter_State.hit;
            //}
        }
    }
    // SYSTEM MAKE FIGHTER
    public static final int SPEED_SPRITE = 10;

    public static FSprite makeSpriteWithSubImages(String spriteName, String location, int nbSubImages) throws IOException {
        //Extension des sous-images : .png
        FSprite spr = new FSprite(spriteName, new Point(0, 0), new Dimension(32, 32), SPEED_SPRITE);
        for (int i = 1; i <= nbSubImages; i++) {
            spr.addSubImage(new FImage(new Point(0, 0), location + i + ".png"));
        }
        return spr;
    }

    public static FSprite makeSpriteWithSubImages(String spriteName, String location, int nbSubImages, int nbSubImgMin) throws IOException {
        //Extension des sous-images : .png
        FSprite spr = new FSprite(spriteName, new Point(0, 0), new Dimension(32, 32), SPEED_SPRITE);
        for (int i = nbSubImgMin; i < nbSubImgMin + nbSubImages; i++) {
            spr.addSubImage(new FImage(new Point(0, 0), location + i + ".png"));
        }
        return spr;
    }

    public static FSprite makeSpriteWithSubImages(String spriteName, String location, int nbSubImages, int[][] map) throws IOException {
        //Extension des sous-images : .png
        //Map = x et y de chaque sous-images
        FSprite spr = new FSprite(spriteName, new Point(0, 0), new Dimension(32, 32), SPEED_SPRITE);
        for (int i = 1; i <= nbSubImages; i++) {
            spr.addSubImage(new FImage(new Point(map[i - 1][0], map[i - 1][1]), location + i + ".png"));
        }
        return spr;
    }

    public static FSprite makeSpriteWithSubImages(String spriteName, String location, int nbSubImages, int nbSubImgMin, int[][] map) throws IOException {
        //Extension des sous-images : .png
        //Map = x et y de chaque sous-images
        FSprite spr = new FSprite(spriteName, new Point(0, 0), new Dimension(32, 32), SPEED_SPRITE);
        int j = 0;
        for (int i = nbSubImgMin; i < nbSubImgMin + nbSubImages; i++) {
            spr.addSubImage(new FImage(new Point(map[j][0], map[j][1]), location + i + ".png"));
            j++;
        }
        return spr;
    }
}
