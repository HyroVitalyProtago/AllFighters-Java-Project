/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import allfighters.AllFighters;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import vue.Dessin;
import vue.VueJeu;

/**
 *
 * @author MyMac
 */
public class Jeu {

    private static int WIDTH = AllFighters.WIDTH;
    private static int HEIGHT = AllFighters.HEIGHT;
    private Room room;
    private VueJeu vue;
    private Joueur joueur;
    private ArrayList<Joueur> joueurs;

    public Jeu() {
        room = new Room("Test", WIDTH, HEIGHT);
        room.addWall(-400, 0, WIDTH + 400 + 400, 25);
        room.addWall(-400, HEIGHT - 25, WIDTH + 400 + 400, 25);
        room.addWall(-400, 0, 25, HEIGHT);
        room.addWall(WIDTH + 400 - 25, 0, 25, HEIGHT);
        room.addWall(300, 50, 25, 25);
        room.addWall(500, 200, 100, 25);
        room.addWall(200, 350, 100, 25);

        this.joueurs = new ArrayList<Joueur>();
    }

    public void setJoueur(Joueur j, int x, int y) {
        this.joueur = j;
        room.addObject(joueur.getFighter(), 125, 50);
        vue = new VueJeu(new Dessin(this), WIDTH, HEIGHT + 25);
        vue.addKeyListener(joueur.getController());
        //vue.start();
        this.joueurs.add(j);
    }

    public void addJoueur(Joueur j) {
        room.addObject(j.getFighter(), -200, 50);
        if (j.getController() != null) {
            vue.addKeyListener(j.getController());
        }
        this.joueurs.add(j);
    }

    public void start() {
        vue.addActionListener(new JoueurUpdateControl(this));
        vue.start();
    }

    public class JoueurUpdateControl implements ActionListener {

        private Jeu j;

        public JoueurUpdateControl(Jeu j) {
            this.j = j;
        }

        @Override
        public void actionPerformed(ActionEvent ae) {
            j.joueurUpdateControl();
        }
    }

    public void joueurUpdateControl() {
        for (Joueur joueur : joueurs) {
            joueur.updateControl();
        }
    }

    public void draw(Graphics grphcs) {
        //ZOOM        
        Graphics2D g = (Graphics2D) grphcs;
        //g.scale(2, 2);
        int x, y;

        //CAMERA AVEC SCALE 2,2
        //x = this.joueur.getLocation().x - WIDTH/4;
        //y = this.joueur.getLocation().y - (int)((double)HEIGHT/1.5);

        //CAMERA SANS SCALE
        x = this.joueur.getLocation().x - WIDTH / 2;
        y = this.joueur.getLocation().y - HEIGHT / 2;

        //BACKGROUND GRIS
        g.setColor(Color.GRAY);
        g.fillRect(0, 0, WIDTH, HEIGHT + 25);

        g.translate(-x, y);
        this.room.draw(g);
        g.translate(x, -y);

        //DRAW LIFE
        g.setColor(Color.DARK_GRAY);
        g.fillRect(25, 25, 300, 10);

        g.setColor(Color.RED);
        g.fillRect(25, 25, this.joueur.getFighter().getLife(), 10);

        g.setColor(Color.BLACK);
        g.drawRect(25, 25, 300, 10);

        //DRAW POWER        
        g.setColor(Color.DARK_GRAY);
        g.fillRect(25, 45, 300, 10);

        g.setColor(Color.BLUE);
        g.fillRect(25, 45, this.joueur.getFighter().getPower(), 10);

        g.setColor(Color.BLACK);
        g.drawRect(25, 45, 300, 10);
    }
}
