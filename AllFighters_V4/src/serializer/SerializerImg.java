/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package serializer;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import modele.objects.FImage;

/**
 *
 * @author MyMac
 */
public class SerializerImg {

    public static void exec(FImage img, String name) {
        try {
            FileOutputStream fichier = new FileOutputStream(name + ".afimg");
            ObjectOutputStream oos = new ObjectOutputStream(fichier);
            oos.writeObject(img);
            oos.flush();
            oos.close();
        } catch (java.io.IOException e) {
            //e.printStackTrace();
        }

    }

    public static FImage recup(String name) {
        try {
            FileInputStream fichier = new FileInputStream(name+".afimg");
            ObjectInputStream ois = new ObjectInputStream(fichier);
            FImage img = (FImage) ois.readObject();
            img.makeBufferedImg();
            return img;
        } catch (java.io.IOException e) {
            //e.printStackTrace();
        } catch (ClassNotFoundException e) {
            //e.printStackTrace();
        }
        return null;
    }
}
