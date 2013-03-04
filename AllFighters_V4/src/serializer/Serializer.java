/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package serializer;

import java.io.*;

/**
 *
 * @author MyMac
 */
public class Serializer <E extends Serializable> {
    
    private String extension;

    public Serializer(String extension) {
        this.extension = extension;
    }
    
    public void exec(E e, String name) {
        try {
            FileOutputStream fichier = new FileOutputStream(name + "."+extension);
            ObjectOutputStream oos = new ObjectOutputStream(fichier);
            oos.writeObject(e);
            oos.flush();
            oos.close();
        } catch (java.io.IOException ex) {
            //ex.printStackTrace();
        }

    }

    public E recup(String name) {
        try {
            FileInputStream fichier = new FileInputStream(name+"."+extension);
            ObjectInputStream ois = new ObjectInputStream(fichier);
            E e = (E) ois.readObject();
            updateObject(e);
            return e;
        } catch (java.io.IOException ex) {
            //ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            //ex.printStackTrace();
        }
        return null;
    }
    
    public void updateObject(E e) {
        
    }
    
}
