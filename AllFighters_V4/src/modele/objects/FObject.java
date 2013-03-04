/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modele.objects;

import allfighters.AllFighters;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.io.Serializable;
import java.util.ArrayList;
import modele.Room;

/**
 *
 * @author MyMac
 */
public class FObject implements Serializable {

    //public static final int MAX_SPEED_X = 5;
    //public static final int MAX_SPEED_Y = 5;
    //
    public static final double GRAVITY = 0.1;
    public boolean gravity;
    //
    protected String name;
    protected int currentSprite;
    protected ArrayList<FSprite> sprites;
    protected boolean visible;
    protected boolean solid;
    //
    protected double dx;
    protected double dy;
    //
    protected double x;
    protected double y;
    protected double width;
    protected double height;

    public FObject(String name, ArrayList<FSprite> sprites, boolean visible, boolean solid) {
        //super(0, 0, 0, 0);
        this.name = name;
        this.currentSprite = 0;
        this.sprites = sprites;
        this.visible = visible;
        this.solid = solid;
        //this.traj = null;

        this.dx = 0;
        this.dy = 0;

        this.gravity = false;
    }

    public FObject(String name, ArrayList<FSprite> sprites) {
        this(name, sprites, true, true);
    }

    public FObject(String name) {
        this(name, new ArrayList<FSprite>());
    }

    public boolean isSolid() {
        return solid;
    }

    public void setSolid(boolean solid) {
        this.solid = solid;
    }

    public void remakeAllSprite() {
        for (FSprite sprite : sprites) {
            sprite.remakeAllSubImages();
        }
    }

    public void addSprite(FSprite sprite) {
        this.sprites.add(sprite);
        //updateSize();
    }

    public void nextSprite() {
        this.currentSprite = (this.currentSprite + 1) % this.sprites.size();
        //updateSize();
    }

    public void previousSprite() {
        int x = this.currentSprite - 1;
        if (x < 0) {
            x = this.sprites.size() - 1;
        }
        this.currentSprite = x;
        //updateSize();
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public void resetAllSprite() {
        for (FSprite sprite : sprites) {
            sprite.resetTime();
        }
    }

    public void setCurrentSprite(int currentSprite) {
        if (currentSprite != this.currentSprite) {
            getCurrentSprite().resetTime();
            this.currentSprite = currentSprite;
        }
        //updateSize();

    }

    public FSprite getCurrentSprite() {
        if (this.sprites.size() > 0) {
            return this.sprites.get(this.currentSprite);
        } else {
            return null;
        }
    }

    public int getNumCurrentSprite() {
        return this.currentSprite;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }
    public void setLocation(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Point getLocation() {
        return new Point((int)x, (int)y);
    }

    public void setVelocityX(double dx) {
        this.dx = dx;
    }

    public double getVelocityX() {
        return dx;
    }

    public void setVelocityY(double dy) {
        this.dy = dy;
    }

    public double getVelocityY() {
        return dy;
    }

    public Rectangle getBounds() {
        return new Rectangle((int)x, (int)y, (int)width, (int)height);
    }
    public void setSize(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public boolean collide(FObject obj) {
        Rectangle r1 = this.getBounds();
        Rectangle r2 = obj.getBounds();
        return r1.intersects(r2);
    }

    public void collideHorizontal() {
        this.dx = 0;
    }

    public void collideVertical() {
        this.dy = 0;
    }

    public void updateSize() {
        if (this.getCurrentSprite() != null) {
            Rectangle r1 = this.getCurrentSprite().getBounds();

            //this.x = r1.x;
            //this.y = r1.y;
            this.width = r1.width;
            this.height = r1.height;

        }
    }

    public void setX(double x) {
        this.x = x;
    }
    public void setY(double y) {
        this.y = y;
    }

    // DRAW
    public void drawContour(Graphics g) {
        g.setColor(Color.CYAN);
        g.fillRect(0, 0, (int)this.width, (int)this.height);
    }
    public void draw(Room room, Graphics g) {
        int y = room.getHeight() - (int)this.y - (int)this.height;

        g.translate((int)this.x, y);

        if (AllFighters.SHOW_BOXS) {
            drawContour(g);
        }

        if (isVisible()) {
            this.getCurrentSprite().draw(this, g);
        }

        g.translate((int)-this.x, -y);

    }

    public String getName() {
        return name;
    }

    
}
