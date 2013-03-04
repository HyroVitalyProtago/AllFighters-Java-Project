/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modele.objects;

import allfighters.AllFighters;
import java.awt.*;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modele.fighters.Fighter;

/**
 *
 * @author MyMac
 */
public class FSprite extends Rectangle implements Serializable {

    private String name;
    private ArrayList<FImage> subImages;
    private int speed;
    private int time; // GESTION de l'animation
    private int nbFoisJoue;
    private boolean ok; // GESTION de nbFoisJoue

    public FSprite(String name, Point pos, Dimension dim, ArrayList<FImage> subImages, int speed) {
        super(pos, dim);
        this.name = name;
        this.subImages = subImages;
        this.speed = speed;
        this.time = 0;

        this.nbFoisJoue = 0;
        this.ok = false;
    }
    public FSprite(String name, Point pos, Dimension dim, int speed) {
        this(name, pos, dim, new ArrayList<FImage>(), speed);
    }

    public void setSubImages(ArrayList<FImage> subImages) {
        this.subImages = subImages;
        updateSize();
    }
    public ArrayList<FImage> getSubImages() {
        return subImages;
    }
    public void addSubImage(FImage img) {
        // Exception en fonction de la taille de l'image
        this.subImages.add(img);
        updateSize();
    }

    public void resetTime() {
        this.time = 0;
        this.nbFoisJoue = 0;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void next() {
        int taille = this.subImages.size();
        this.time = (this.time + 100) % (taille * 100);
        System.out.println("SubImage " + ((this.time / 100) + 1));
    }
    public void previous() {
        int taille = this.subImages.size();

        int nextTime = (this.time - 100) % (taille * 100);
        if (nextTime < 0) {
            nextTime = (taille * 100) - 1;
        }
        this.time = nextTime;
        System.out.println("SubImage " + ((this.time / 100) + 1));
    }

    public FSprite reverse() {
        // Retourne le sprite inverse verticalement
        String name = this.name.substring(0, this.name.length() - 1);
        name += "L";

        FSprite spr = new FSprite(name, this.getLocation(), this.getSize(), this.speed);

        ArrayList<FImage> subimages = new ArrayList<FImage>();
        for (int i = 0; i < this.subImages.size(); i++) {
            subimages.add(this.subImages.get(i).reverse(this));
        }

        spr.setSubImages(subimages);

        //spr.x = - this.x;

        return spr;
    }

    public FImage getCurrentImg() {
        int i = (int) ((double) this.time / (double) 100);
        //System.out.println(i);
        return this.subImages.get(i);
    }

    private void updateSize() {
        //System.out.println("SPRITE: UPDATE SIZE ");

        //this.x = minX();
        this.width = width();
        //this.y = minY();
        this.height = height();
    }

    private int minX() {
        int minX = this.subImages.get(0).x;
        for (FImage img : subImages) {
            if (minX > img.x) {
                minX = img.x;
            }
        }
        return minX + this.x;
    }
    private int minY() {
        int minY = this.subImages.get(0).y;
        for (FImage img : subImages) {
            if (minY > img.y) {
                minY = img.y;
            }
        }
        return minY + this.y;
    }
    private int width() {
        int[] x = {this.subImages.get(0).x, this.subImages.get(0).width};
        for (FImage img : subImages) {
            if (x[0] + x[1] < img.x + img.width) {
                x[0] = img.x;
                x[1] = img.width;
            }
        }
        //System.out.println((this.x + x[0] + x[1]) + " - " + minX());
        return (this.x + x[0] + x[1]) - minX();
    }
    private int height() {
        int[] y = {this.subImages.get(0).y, this.subImages.get(0).height};
        for (FImage img : subImages) {
            if (y[0] + y[1] < img.y + img.height) {
                y[0] = img.y;
                y[1] = img.height;
            }
        }
        //System.out.println((this.x + x[0] + x[1]) + " - " + minX());
        return (this.y + y[0] + y[1]) - minY();
    }

    public int getNbFoisJoue() {
        return nbFoisJoue;
    }
    public void resetNbFoisJoue() {
        nbFoisJoue = 0;
    }

    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }

    public boolean fight(Fighter f,FSprite ennemi) {
        FImage img = this.getCurrentImg().clone();
        FImage img1 = ennemi.getCurrentImg().clone();

        img.x = this.x + img.x;
        //img.y = this.y + img.y;
        img1.x = ennemi.x + img1.x;
        //img1.y = ennemi.y + img1.y;

        if (img.intersects(img1)) {
            //System.out.println("SPRITE : intersects = "+img.intersects(img1));
            //System.out.println((int) ((double) this.time / (double) 100));
            return img.fight(f,img1);
        } else {
            //System.out.println("Sprite : IMG = "+(int) ((double) this.time / (double) 100));
        }

        return false;
    }

    public void remakeAllSubImages() {
        for (FImage image : subImages) {
            try {
                image.makeBufferedImg();
            } catch (IOException ex) {
                Logger.getLogger(FSprite.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public FSprite clone() {
        FSprite spr = new FSprite(this.name, this.getLocation(), this.getSize(), speed);
        ArrayList<FImage> subImages = new ArrayList<FImage>();
        for (FImage img : this.subImages) {
            subImages.add(img.clone());
        }
        spr.setSubImages(subImages);
        spr.time = this.time;
        spr.nbFoisJoue = this.nbFoisJoue;
        spr.ok = this.ok;
        return spr;
    }

    // DRAW
    public void drawContour(Graphics g) {
        g.setColor(Color.YELLOW);
        g.drawRect(0, 0, width, height);
    }
    public void draw(FObject obj, Graphics g) {

        //int x = this.x - (this.width/3); // FOR DRAWING
        int y = (int)obj.height - this.y - this.height;

        g.translate(x, y);

        if (AllFighters.SHOW_BOXS_FIGHTER) {
            drawContour(g);
            //drawContourMax(g);
        }

        getCurrentImg().draw(this, g);
        g.translate(-x, -y);

        //translate(x, 0);

        int taille = this.subImages.size();

        if (!AllFighters.DEV_SPRITE) {
            this.time += this.speed;
        }

        // BEGIN GESTION DE NBFOIS JOUE
        if ((int) ((double) this.time / (double) 100) == taille && !ok) { //increment nbFoisJoue quand dernier sprite
            ok = true;
            nbFoisJoue++;
            for (FImage image : subImages) {
                image.resetBoxs();
            }
            //System.out.println(nbFoisJoue);
        }
        if (!((int) ((double) this.time / (double) 100) == taille) && ok) {
            ok = false;
        }
        // END

        this.time = this.time % (taille * 100);

        //translate(-x, 0);

    }

    public String getName() {
        return name;
    }
    
}
