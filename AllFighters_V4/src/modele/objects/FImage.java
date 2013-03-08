/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modele.objects;

import allfighters.AllFighters;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import modele.fighters.Fighter;

/**
 *
 * @author MyMac
 */
public class FImage extends Rectangle implements Serializable {

    private String location;
    private transient BufferedImage img;
    private ArrayList<Box> boxs;
    //private Point pointChaud;

    private FImage(BufferedImage img, Point point) {
        super(point, new Dimension(img.getWidth(), img.getHeight()));
        this.img = img;

        this.boxs = new ArrayList<Box>();
    }
    public FImage(Point point, String location) throws IOException {
        this(ImageIO.read(new File(location)), point);
        this.location = location;
    }
    public FImage(int i, int i1, String location) throws IOException {
        this(new Point(i, i1), location);
    }

    public void addBox(Box b) {
        this.boxs.add(b);
    }
    public ArrayList<Box> getBoxs() {
        return boxs;
    }
    private void setBoxs(ArrayList<Box> boxs) {
        this.boxs = boxs;
    }

    public void makeBufferedImg() throws IOException {
        this.img = ImageIO.read(new File(location));
    }
    public FImage reverse(FSprite spr) {
        BufferedImage bi = new BufferedImage(this.width, this.height, BufferedImage.TYPE_INT_ARGB);
        for (int i = 1; i < this.height; i++) {
            for (int j = 1; j < this.width; j++) {
                //System.out.println(this.img.getRGB(this.width - j, i));
                bi.setRGB(j, i, this.img.getRGB(this.width - j, i));
            }
        }
        Point p = new Point(spr.getBounds().width - this.width - this.x, this.y);

        ArrayList<Box> boxs = new ArrayList<Box>();
        for (Box box : this.boxs) {
            Box tmp = new Box(box.getType(), box);
            tmp.x = this.width - box.width - box.x;
            boxs.add(tmp);
        }

        FImage img = new FImage(bi, p);
        img.setBoxs(boxs);

        return img;
    }
    @Override
    public FImage clone() {
        FImage img = new FImage(this.img, this.getLocation());
        img.setBoxs(boxs);
        //img.pointChaud = this.pointChaud;
        return img;
    }

    // fight : fonction qui cherche les collision entre les hitboxs de deux images
    // retourne 0 si aucune collsions
    // +1 si l'image "touche"
    public boolean fight(Fighter f,FImage ennemi) {
        boolean result = false;

        Box tmp;
        for (Box box : boxs) {
            tmp = box.clone();
            tmp.x = this.x + tmp.x;
            tmp.y = this.y + tmp.y;
            //System.out.println("Image : box "+box.getType());
            //System.out.println("Image : box_contains = "+box.contains(f));
            if (tmp.getType() == Box_Type.ATTACKING && !box.contains(f)) {
                for (Box box1 : ennemi.boxs) {
                    box1 = box1.clone();
                    box1.x = ennemi.x + box1.x;
                    box1.y = ennemi.y + box1.y;
                    if (box1.getType() == Box_Type.HITTABLE && tmp.intersects(box1)) {
                        box.addFighter(f);
                        return true;
                    }
                }
            }
        }

        return result;
    }

    public void resetBoxs() {
        for (Box box : boxs) {
            box.resetFighters();
        }
    }

    // DRAW
    public void drawBounds(Graphics g) {
        g.setColor(Color.WHITE);
        g.drawRect(0, 0, width, height);
    }
    public void drawBoxs(Graphics g) {
        for (Box box : boxs) {
            box.draw(g);
        }
    }
    public void draw(FSprite spr, Graphics g) {
        int y = spr.height - this.y - this.height;

        //System.out.println(spr.height+" - "+this.y+" - "+this.height);

        g.translate(x, y);

        if (AllFighters.SHOW_BOXS_FIGHTER) {
            drawBounds(g);
            drawBoxs(g);
        }

        g.drawImage(this.img, 0, 0, null);

        g.translate(-x, -y);
    }
    public void draw(Graphics g) {
        g.drawImage(this.img, x, y, null);
        //drawBounds(g);
        drawBoxs(g);
    }

    @Override
    public String toString() {
        String s = "";
        for (Box box : boxs) {
            s += "Box : "+box.toString();
        }
        return s;
    }



}
