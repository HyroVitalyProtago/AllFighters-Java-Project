
// http://jmugen.googlecode.com/svn/trunk/JMugen/src/org/lee/mugen/core/

package allfighters;

import controller.FighterController;
import controller.FighterController1;
import development.Make_Takeshi_Yamamoto;
import java.io.IOException;
import java.util.ArrayList;
import modele.IA;
import modele.Jeu;
import modele.Joueur;
import modele.fighters.Fighter;
import modele.fighters.Takeshi_Yamamoto;
//import vue.Article1;

/**
 *
 * @author MyMac
 */
public class AllFighters {

    public static final int WIDTH = 1024;
    public static final int HEIGHT = 720;
    
    public static final boolean SHOW_SNAP = false;
    public static final boolean SHOW_BOXS = true;
    public static final boolean SHOW_BOXS_FIGHTER = false;
    public static final boolean DEV_SPRITE = false;
    
    public static void main(String[] args) throws IOException {
        startAllFighters();
        //startOpenGL(args);
        //Make_Takeshi_Yamamoto.main(args);
    }    
    
    public static void startAllFighters() throws IOException {
        //Img img = new Img(new Point(0,0), "/Users/MyMac/Desktop/SpriteAllFighters/TakeshiYamamoto/Intro/1.png");
        //SerializerImg.exec(img, "Intro1");
                        
        Fighter fighter = new Takeshi_Yamamoto();
        FighterController fc = new FighterController(fighter);                
        Joueur j1 = new Joueur(fighter, fc);
        
        Fighter fighter1 = new Takeshi_Yamamoto();
        FighterController fc1 = new FighterController1(fighter1);
        //ArrayList<Fighter> ennemies = new ArrayList<Fighter>();
        //ennemies.add(fighter);
        //Joueur j2 = new IA(fighter1, ennemies);
        Joueur j2 = new Joueur(fighter1, fc1);
        
        Jeu jeu = new Jeu();
        
        jeu.setJoueur(j1, 75, 50);
        jeu.addJoueur(j2);
        
        jeu.start();
    }
    public static void startOpenGL(String[] args) {
        //Article1.main(args);
    }
        
}
