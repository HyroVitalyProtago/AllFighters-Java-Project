package modele;


/*
 * Trajectoire.java
 *
 * Created on 2 fevrier 2012, 08:24
 *
 * Il faudra sans doute ajouter des methodes dans cette classe.
 */
public class Trajectoire {

    private double t;
    private double x0;
    private double y0;
    private double alpha0;
    private double v0;
    private double g = 0;

    public Trajectoire(int x0, int y0, double v0, double alpha) {

        this.t = 0;

        this.x0 = x0;
        this.y0 = y0;
        this.v0 = v0;
        this.alpha0 = (alpha / 180) * Math.PI;

    }


    public Trajectoire(int x0, int y0, double v0, double alpha,double t) {

        this.t = t;

        this.x0 = x0;
        this.y0 = y0;
        this.v0 = v0;
        this.alpha0 = (alpha / 180) * Math.PI;

    }

    public void setVitesse(double v){
        this.v0=v;
    }

    public double getX0() {
        return this.x0;
    }

    public double getY0() {
        return this.y0;
    }

    public double getNormeVitesse() {
        return Math.sqrt((this.getVX() * this.getVX())
                + (this.getVY() * this.getVY()));
    }

    public double getVX() {
        return (this.v0 * Math.cos(this.alpha0));
    }

    public double getVY() {
        return (-g * this.getTemps() + this.v0 * Math.sin(this.alpha0));
    }

    public double getAngleDegre(){
        double alpha = Math.atan(getVY()/getVX());
        if (getVX() < 0) {
            if (getVY() < 0) {
                alpha -= Math.PI;
            } else {
                alpha += Math.PI;
            }
        }
        return (alpha / Math.PI ) * 180;
    }

    public double getAngle0() {
        return this.alpha0;
    }
    
    public void avancer() {
        this.t++;
    }    

    public double getT(){
        return this.t;
    }

    public void setT(double t) {
        this.t=t;    }

    public double getTemps() {
        return this.t / 25;
    }

    public int abcisseSuivante() {
        return (int) (this.v0 * Math.cos(this.getAngle0()) * this.getTemps() + this.x0);
    }

    public int ordonneeSuivante() {        

        return (int) (-(g / 2) * (this.getTemps() * this.getTemps())
                + this.v0 * Math.sin(this.getAngle0()) * this.getTemps() + this.y0);
    }
    
}
