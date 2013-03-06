/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdk_allfighters;

import TakeshiYamamoto.MakeJump_Takeshi_Yamamoto;
import TakeshiYamamoto.MakeStance_Takeshi_Yamamoto;
import TakeshiYamamoto.MakeWalk_Takeshi_Yamamoto;
import TakeshiYamamoto.MakeY_Combo_Takeshi_Yamamoto;
import java.awt.Dimension;
import java.awt.Point;
import java.io.IOException;
import modele.objects.FSprite;
import sdk_allfighters.fighter.AF_Frame;
import sdk_allfighters.sprite.AF_Sprite_Frame;

/**
 *
 * @author MyMac
 */
public class SDK_AllFighters {

    //private static AF_Frame frame;

    public static void main(String[] args) throws IOException {
        //startSDK();
        startSDK_Sprite();
        //makeTakeshiYamamoto();

    }

    public static void startSDK() {
        AF_Frame frame = new AF_Frame();
        frame.construire();
        frame.setVisible(true);
    }

    public static void startSDK_Sprite() {
        AF_Sprite_Frame frame = new AF_Sprite_Frame();
        //frame.construire();
        frame.setSprite(new FSprite("TEST", new Point(0, 0), new Dimension(0,0), 0));

        frame.setVisible(true);
    }

    public static void makeTakeshiYamamoto() throws IOException {
        MakeStance_Takeshi_Yamamoto.exec();
        MakeY_Combo_Takeshi_Yamamoto.exec();
        MakeWalk_Takeshi_Yamamoto.exec();
        MakeJump_Takeshi_Yamamoto.exec();
    }


}
