/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdk_allfighters;

import TakeshiYamamoto.MakeJump_Takeshi_Yamamoto;
import TakeshiYamamoto.MakeStance_Takeshi_Yamamoto;
import TakeshiYamamoto.MakeWalk_Takeshi_Yamamoto;
import TakeshiYamamoto.MakeY_Combo_Takeshi_Yamamoto;
import java.io.IOException;
import sdk_allfighters.fighter.AF_Frame;

/**
 *
 * @author MyMac
 */
public class SDK_AllFighters {

    private static AF_Frame frame;

    public static void main(String[] args) throws IOException {
        frame = new AF_Frame();
        frame.construire();
        frame.setVisible(true);

        //makeTakeshiYamamoto();

    }

    public static void makeTakeshiYamamoto() throws IOException {
        MakeStance_Takeshi_Yamamoto.exec();
        MakeY_Combo_Takeshi_Yamamoto.exec();
        MakeWalk_Takeshi_Yamamoto.exec();
        MakeJump_Takeshi_Yamamoto.exec();
    }


}
