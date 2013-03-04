/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modele.objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import modele.fighters.Fighter;

/**
 *
 * @author MyMac
 */
public class Box extends Rectangle {
    
    //public static final int TYPE_HITTABLE_HEAD = 1;
    //public static final int TYPE_HITTABLE_ARMS = 2;
    //public static final int TYPE_HITTABLE_CHEST = 3; //Torse
    //public static final int TYPE_HITTABLE_LEGS = 4;
    //public static final int TYPE_ATTACKING = 0;
    //public static final int TYPE_COUNTER = -1; //Parade
    private ArrayList<Fighter> fightersTouched; // permet de savoir quels sont les fighter qui ont été touché et permet de gérer le fait que la collision ne compte pas plusieurs fois
    private Box_Type type;

    public Box(Box_Type type, Rectangle rctngl) {
        super(rctngl);        
        this.type = type;
        this.fightersTouched = new ArrayList<Fighter>();
    }

    public Box_Type getType() {
        return type;
    }    
    
    public Color getColor() {
        Color c = null;
        switch(type) {
            case COUNTER:
                c = Color.GREEN;
                break;
            case ATTACKING:
                c = Color.RED;
                break;
            case HITTABLE:
                c = Color.BLUE;
                break;
        }
        return c;
    }
    
    public void draw(Graphics g) {
        g.setColor(getColor());
        g.drawRect(x, y, width, height);
    }

    public void addFighter(Fighter f) {
        this.fightersTouched.add(f);
    }
    
    public boolean contains(Fighter f) {        
        return this.fightersTouched.contains(f);
    }
    
    public void resetFighters() {
        this.fightersTouched.clear();
    }
    
    @Override
    public Box clone() {        
        return new Box(type, new Rectangle(x, y, width, height));
    }
    
    
    
}
