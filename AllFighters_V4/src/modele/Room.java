/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.awt.Color;
import java.awt.Graphics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modele.fighters.Fighter;
import modele.objects.FImage;
import modele.objects.FObject;

/**
 *
 * @author MyMac
 */
public class Room {
    
    private String name;
    private ArrayList<FObject> objects;
    private int snapX;
    private int snapY;
    private boolean snap;
    private int width;
    private int height;
    //this.speed = 30;
    private FImage background;
    // Backgrounds
    /*
     * this.drawBackgroundColor = true; this.visibleWhenRoomStart = false;
     * this.foregroundImage = false; this.background = nil; this.tileHor = true;
     * this.x = 0; this.tileVert = true; this.y = 0; this.stretch = false;
     * this.horSpeed = 0; this.vertSpeed = 0;
     */
    //private static final int z_kill = -200;
    
    public Room(String name, int width, int height) {
        this.name = name;
        this.objects = new ArrayList<FObject>();
        this.snapX = width / 20;
        this.snapY = height / 20;
        this.snap = true;
        this.width = width;
        this.height = height;
        
        try {
            this.background = new FImage(-400, 0, "../SpriteAllFighters/Background.png");
        } catch (IOException ex) {
            Logger.getLogger(Room.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void addObject(FObject obj, int x, int y) {
        obj.setLocation(x, y);
        //obj.updateSize();
        this.objects.add(obj);
    }
    
    public void addWall(int x, int y, int width, int height) {
        FObject obj = new FObject("Wall");
        obj.setVisible(false);
        obj.setLocation(x, y);
        obj.setSize(width, height);
        addObject(obj, x, y);
    }
    
    public void setWidth(int width) {
        this.width = width;
    }
    
    public int getWidth() {
        return width;
    }
    
    public void setHeight(int height) {
        this.height = height;
    }
    
    public int getHeight() {
        return height;
    }
    
    public void drawFond(Graphics g) {
        if (this.background == null) {
            g.setColor(Color.GRAY);
            g.fillRect(0, 0, this.getWidth(), this.getHeight());
        } else {
            this.background.draw(g);
        }
    }
    
    public void drawSnap(Graphics g) {
        g.setColor(Color.BLACK);
        if (this.snap) {
            for (int i = 0; i <= this.width / this.snapX; i++) {
                g.drawLine(i * this.snapX, 0, i * this.snapX, this.height);
            }
            for (int i = 0; i <= this.height / this.snapY; i++) {
                g.drawLine(0, i * this.snapY, this.width, i * this.snapY);
            }
        }
    }
    
    public void draw(Graphics g) {
        
        drawFond(g);
        
        if (allfighters.AllFighters.SHOW_SNAP) {
            drawSnap(g);
        }
        
        for (FObject object : objects) {
            //DRAW
            object.draw(this, g);
            
            update(object);
        }
        
    }
    
    public void update(FObject object) {
        // UPDATE
        if (object instanceof Fighter) {
            Fighter fighter = (Fighter) object;
            fighter.update(); // COMPORTEMENT
            updateFighter(fighter); // COLLISION            
            fight(fighter);// COMBAT
        }
    }
    
    private void fight(Fighter f) {
        for (FObject object : objects) {
            if (object instanceof Fighter && f != (Fighter)object) {
                Fighter ennemi = (Fighter)object;
                if (f.intersect(ennemi)) { // Si il y a collision entre les sprites des fighters
                    //System.out.println("ENNEMIES INTERSECTION");
                    
                    boolean result = f.fight(ennemi);
                    
                    if (result) {
                        //System.out.println("INFLIGE DES DEGATS");
                        f.infligerDegats(ennemi);
                        
                        //Ajouter un petit effet au point d'impact ********************************************************
                        
                        if (ennemi.getLife() <= 0) {
                            //this.objects.remove(ennemi);
                        }
                        
                    }
                    
                }
            }
        }
    }
    
    private boolean collide(FObject obj) {
        
        boolean collide = false;
        int i = 0;
        while (i < this.objects.size() && !collide) {
            FObject object = this.objects.get(i);
            if (object != obj && !(object instanceof Fighter)) { // Pas de collision entre fighter
                collide = obj.collide(object);
                if (collide) {
                    //System.out.println("COLLIDE WITH "+object.name);
                }
            }
            i++;
        }
        
        return collide;
    }
    
    private FObject collision(FObject obj) {
        FObject collision = null;
        boolean collide = false;
        int i = 0;
        while (i < this.objects.size() && !collide) {
            FObject object = this.objects.get(i);
            if (object != obj) {
                collide = obj.collide(object);
                if (collide) {
                    collision = object;
                    //System.out.println("COLLIDE WITH "+object.name);
                }
            }
            i++;
        }
        
        return collision;
    }
    
    private void updateFighter(Fighter obj) {

        //if (obj.getY() <= z_kill) obj.setY(700);
        
        // apply gravity

        if (obj.gravity) {
            //System.out.println(obj.getVelocityY());
            obj.setVelocityY(obj.getVelocityY() - obj.GRAVITY);
        }


        // change x
        double dx = obj.getVelocityX();
        double oldX = obj.getX();
        double newX = oldX + dx;
        
        obj.setX(newX);
        if (!collide(obj)) {
            //obj.setX(newX);
        } else {
            if (dx < 0) {
                obj.setX(collision(obj).getX() + collision(obj).getWidth());
            } else if (dx > 0) {
                obj.setX((int) collision(obj).getX() - obj.getWidth());
            } else {
                obj.setX(oldX);
            }
            obj.collideHorizontal();
        }

        // change y
        double dy = obj.getVelocityY();
        double oldY = obj.getY();
        double newY = oldY + dy;
        
        obj.setY(newY);
        if (!collide(obj)) {
            obj.setY(newY);
            if (dy < 0) {
                obj.setOnGround(false);
            }
        } else {
            if (dy < 0) {
                obj.setOnGround(true);
                obj.setY(collision(obj).getY() + collision(obj).getHeight());
            } else if (dy > 0) {
                obj.setY(collision(obj).getY() - obj.getHeight());
            } else {
                obj.setY(oldY);
            }
            obj.collideVertical();
        }
        
        
        
    }
}
