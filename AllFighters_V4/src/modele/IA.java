/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.awt.Point;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import modele.fighters.Fighter;
import modele.fighters.action.Jump;
import modele.fighters.action.Move;
import modele.fighters.action.Y_Combo;
import modele.objects.Direction;

/**
 *
 * @author MyMac
 */
public class IA extends Joueur {
    
    private ArrayList<Fighter> ennemies;
    
    public IA(Fighter fighter, ArrayList<Fighter> ennemies) {
        super(fighter, null);
        this.ennemies = ennemies;
        this.chemin = new ArrayList<Point>();
        this.chemin.add(this.fighter.getLocation());
    }

    private boolean dernieresLocationsAnormales(int anormale) {
        Point derniereLocation = this.chemin.get(this.chemin.size()-1);
        int nbDerniereLocation = 0;
        int i = this.chemin.size()-1;
        while (i > 0 && nbDerniereLocation < anormale) {
            Point p = this.chemin.get(i);
            if (!p.equals(derniereLocation)) return false;
            nbDerniereLocation++;
            i--;
        }
        if (nbDerniereLocation == anormale)
            return true;
        else
            return false;
    }
    
    private ArrayList<Point> chemin;
    @Override
    public void updateControl() {
        Fighter ennemi = ennemiLePlusProche();
        
        double distance = this.fighter.getLocation().distance((Point2D) ennemi.getLocation());
        
        //System.out.println(distance);
        
        if (distance > 75) {
            seDirigerVers(ennemi);
            this.chemin.add(this.fighter.getLocation());
            //Si les dernieres Location sont similaire plus de x fois
            if(dernieresLocationsAnormales(175)) {
                new Jump(fighter).execIfIsPossible();
            }
        } else {
            if (this.fighter.getVelocityX() > 0) {
                this.fighter.setVelocityX(0);
            } else {
                new Y_Combo(fighter).execIfIsPossible();
            }
        }
    }
    
    public Fighter ennemiLePlusProche() {
        if (this.ennemies.isEmpty()) {
            return null;
        } else if (this.ennemies.size() == 1) {
            return this.ennemies.get(0);
        } else {
            Fighter ennemiLePlusProche = this.ennemies.get(0);
            for (Fighter ennemi : ennemies) {
                if (this.fighter.getLocation().distance((Point2D) ennemi.getLocation()) < this.fighter.getLocation().distance((Point2D) ennemiLePlusProche.getLocation())) {
                    ennemiLePlusProche = ennemi;
                }
            }
            return ennemiLePlusProche;
        }
    }
    public void seDirigerVers(Fighter f) {        
        if (this.fighter.getLocation().x < f.getLocation().x) {
            new Move(Direction.RIGHT, fighter).execIfIsPossible();
        } else {
            new Move(Direction.LEFT, fighter).execIfIsPossible();
        }
    }
}
